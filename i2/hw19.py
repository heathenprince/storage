"""Anna Tolen
IntroCS2 pd3
HW19 -- Stringy Loops
2015-03-16"""

def addMultPrint(a,b):
    print "the sum of " + str(a) + " and " + str(b) + " is " + str(a+b)
    print "their product is " + str(a*b)

#prints "the sum of a and b is a+b, their product is ab
    

addMultPrint(3,6) #the sum of 3 and 6 is 9, their product is 18
addMultPrint(9,12) #the sum of 9 and 12 is 21, their product is 108

def addMultHTML(a,b):
    print """<!DOCTYPE html> \n
    <p>the <i>sum</i> of """ + str(a) + " and " + str(b) + " is <b>" + str(a+b) + "</b></p> \n"
    "<br>their <i>product is</i> <b>" + str(a*b) + " </b>"
    
#prints phrase "the sum of a and b is a+b, their product is ab" in HTML (with sum/product italicized and sum/product bolded), substituting a and b for arguments given
    
addMultHTML(3,6) 
addMultHTML(9,12) 

def sumDigits(n):
    pos = 0
    while n >= 10:
        a = n % 10 #isolates last digit
        pos += a 
        n = n // 10 #n - last digit
    return pos + n #concatenates 
    
def tablefy(n):
    print """<!DOCTYPE html> \n
        <table border = "1">
                    <tr> \n
                    <th>n</th> \n
                    <th>n^2</th> \n
                    <th>sumDigits</th> \n"""
    rowNum = 0
    while rowNum != n:
        rowNum += 1
        print """</tr> \n
	    <tr> \n
	    <td>"""+ str(rowNum) +  """</td> \n
                    <td>""" + str(rowNum**2) + """</td> \n
                    <td>""" + str(sumDigits(rowNum)) + """</td> \n"""
    print "</table>"
		
tablefy(12)
