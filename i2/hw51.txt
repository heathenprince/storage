#!/usr/bin/python
print "Content-Type: text/html\n"

'''Anna Tolen
IntroCS2 pd3
HW51 -- How Many Numbers Could a Thinker Crunch, if a Thinker Could Crunch Numbers?
2015-05-13''' 

#readFrom() reads files, returns a list of lines of file
def readFrom(): 
    inStream=open('data_SAT2014.csv','r')
    a=inStream.readlines()
    inStream.close()
    return a

#fixerUpper() "cleans up" the lines
def fixerUpper(maxLen):
    lines=readFrom()
    for i in range(len(lines)):
       lines[i]=lines[i].strip('\n').split(',') #removes newline markers, splits lines into lists
       if len(lines[i]) > maxLen:
           j=1
           while j<len(lines[i]): #accounts for items that already have commas in them by merging split elements together
               if len(lines[i]) == maxLen+1: #things with 1 extra comma
                    if lines[i][j-1][0]=='"' and lines[i][j][-1]=='"':
                       lines[i][j-1]=lines[i][j-1]+lines[i][j]
                       lines[i][j-1]=lines[i][j-1].strip('"')
                       del lines[i][j]
                       j-=1
               elif len(lines[i]) == maxLen+2: #things with 2 extra commas
                   if lines[i][j-2][0]=='"' and lines[i][j][-1]=='"':
                       lines[i][j-2]=lines[i][j-2]+lines[i][j-1]+lines[i][j]
                       lines[i][j-2]=lines[i][j-2].strip('"')
                       del lines[i][j]
                       del lines[i][j-1]
                       j-=1
               j+=1
    return lines

#getNums() extracts all numerical data, adds numbers to a new list
def getNums(): 
    data=fixerUpper(6)
    nums=[]
    for sub in data:
        for element in sub:
            if element.isdigit():
                nums.append(int(element))
    return nums

#subjScores returns a list of numerical data from a desired column (ex. reading scores)
def subjScores(subj):
    data=getNums()
    if subj.lower()=='n': ##of SAT takers in 2014
       data=data[::4]
    elif subj.lower()=='r': #Avg SAT Critical Reading Scores
       data=data[1::4]
    elif subj.lower()=='m': #Avg SAT Math Scores
       data=data[2::4]
    elif subj.lower()=='w': #Avg SAT Writing Scores
        data=data[3::4]
    return data

#findMean() returns the mean of a list of numbers
def findMean(L):
    s=0.
    for n in L:
        s+=n
    return s/len(L)

#findMed() returns the median of a list of numbers
def findMed(L):
    nL=L[:]
    while len(nL) > 2:
       nL.remove(min(nL))
       nL.remove(max(nL))
    if len(nL)==2:
        return findMean(nL)
    else:
        return nL[0]

#findMode() returns the mode of a list of numbers
def findMode(L):
    d={}
    for n in L:
        if n in d:
            d[n]+=1 #yay buckets!
        else:
            d[n]=1
    val=d.values()
    i=val.index(max(val))
    return d.keys()[i]

#quartiles() can return either the upper or lower quartile from a list of numbers
def quartiles(L,choice):
    L=sorted(L)
    half=len(L)/2
    if choice.lower()=="lower":
          return findMed(L[:half])
    elif choice.lower()=="upper":
          return findMed(L[half:])

#findRange() returns the range of a list of numbers
def findRange(L):
    return max(L)-min(L)

#statTable() takes all of that^^ information and compiles it into a table, giving the statistics for each part of SAT data
def statTable():
    n=subjScores('n')
    r=subjScores('r')
    m=subjScores('m')
    w=subjScores('w')
    begStr="<table border='1'>\n<tr>\n<th colspan='5'>Statistics</th>\n</tr>"
    endStr="</table>"
    subjTitles=['','# of SAT Takers in 2014','Critical Reading','Mathematics','Writing']
    stats=['Mean','Mode','Lower Quartile','Median','Upper Quartile','Lowest','Highest',',Range']
    
    #all statistical data from each column
    statFxns=[[str(findMean(n)),str(findMean(r)),str(findMean(m)),str(findMean(w))],[str(findMode(n)),str(findMode(r)),str(findMode(m)),str(findMode(w))],[str(quartiles(n,'lower')),str(quartiles(r,'lower')),str(quartiles(m,'lower')),str(quartiles(w,'lower'))],[str(findMed(n)),str(findMed(r)),str(findMed(m)),str(findMed(w))],[str(quartiles(n,'upper')),str(quartiles(r,'upper')),str(quartiles(m,'upper')),str(quartiles(w,'upper'))],[str(min(n)),str(min(r)),str(min(m)),str(min(w))],[str(max(n)),str(max(r)),str(max(m)),str(max(w))],[str(findRange(n)),str(findRange(r)),str(findRange(m)),str(findRange(w))]] #SO MUCH STUFF (formally apologizing to the reader of this code)

    #tablefies
    newStr="<tr>"
    for t in subjTitles:
        newStr+="<th>"+t+"</th>\n"
    i=1
    statCount=0
    for fxn in statFxns: 
        newStr+="<tr>\n<th>"+stats[statCount]+"</th>\n<td><center>\n"+"</td>\n<td><center>\n".join(fxn)
        statCount+=1
        newStr+="</td>\n</tr>\n"
    return begStr+newStr+endStr

#tablefy() tablefies (tabulates?) the avg SAT scores of each school along with school name and code
def tablefy():
    data=fixerUpper(6)
    newStr="<table border='1'>\n<tr>\n<th colspan='6'>Scores</th>\n</tr>\n"
    for subList in data:
        newStr+="<tr>\n"
        for element in subList:
            newStr+="<td>"+element+"</td>\n"
        newStr+="</tr>\n"
    newStr+="</table>"
    return newStr

spiel="This webpage displays the average SAT scores across New York City high schools in 2014. It was generated using an HTML-generating Python script. The average school-wide score for each part of the SAT (critical reading, mathematics, and writing) is shown, along with statistical data. If an 's' is shown instead of a test score, data was unable to be retrieved from that school. Data was collected by the <a href='http://schools.nyc.gov/Accountability/data/TestResults/default.htm'>New York City Department of Education.</a></p>" 

improvements="""<br><b>Changes in V2:</b></center>
    <ul>
    <li>HTML incorporated</li>
    <li>Stat functions written</li>
    <li>Stat table added</li>
    <li>Explanatory paragraph written</li>
    </ul>"""

#allTogether() throws all of that stuff^^ together!
def allTogether():
    begStr="<!DOCTYPE html>\n<html>\n<head><title>2014 SAT Scores NYC</title></head>\n<body>\n<h1><center>2014 SAT Scores NYC</h1><p align='center'>"+spiel+improvements+"</p>\n<center>"
    tables="\n<center>"+statTable()+"<p>\n<center>"+tablefy()
    endStr="</html>"
    return begStr+tables+endStr

#writeTo() copies what allTogether() produces and writes it to a file called statsSAT.html
def writeTo():
    outStream=open('statsSAT.html','w')
    outStream.write(allTogether())
    outStream.close()

writeTo()
#.....aaaaaaaaand we're done!
#praise the cs gods
