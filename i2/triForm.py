#!/usr/bin/python
# ========= HASHBANG LINE ABOVE IS MAGIC! =========
# ========= (Must be first line of file.) =========
import cgi
import cgitb
import math
#cgitb.enable()  #diag info --- comment out once full functionality achieved

# ~~~~~~~~~~~~~~~ support functions ~~~~~~~~~~~~~~~
def FStoD():
    '''
    Converts cgi.FieldStorage() return value into a standard dictionary
    '''
    d = {}
    formData = cgi.FieldStorage()
    for k in formData.keys():
        d[k] = formData[k].value
    return d

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

def pythTriple(a,b,c): #returns True if values are a Pythagorean triple                                                  
    aSq = a ** 2
    bSq = b ** 2
    cSq = c ** 2
    if aSq + bSq == cSq:
        return True
    elif aSq + cSq == bSq:
        return True
    elif bSq + cSq == aSq:
        return True
    else:
        return False

def isTriangle(L): #returns True if values in list make a triangle
    if len(L) != 3: #if more or less than three sides given
        return 'three sides plz'
    elif (L[0] + L[1] <= L[2]) or (L[0] + L[2] <= L[1]) or (L[1] + L[2] <= L[0]): #if sides cannot make a triangle                                                                                                                  
        return 'sides don\'t make a triangle'
    else:
        return True

def getNums():
    d=FStoD()
    L=[d['sideA'],d['sideB'],d['sideC']]
    for i in range(len(L)):
        L[i]=float(L[i])
    return L

def perimArea(): #returns sides, perimeter, and area of triangle      
    L=getNums()
    perim=float(sum(L)) #perimeter                                                                                     
    base=min(L)
    if pythTriple(L[0],L[1],L[2]): #if triangle is a right triangle                                                    
        L.remove(base)
        height=min(L) #use second longest side as height
        area=(base*height)*0.5
    else:
        semi=perim/2
        area=math.sqrt(semi * (semi - L[0]) * (semi - L[1]) * (semi-L[2])) #if not a right triangle, use Heron's formula                                  
        height=(area*2)/base
        L.remove(base)
    retStr="<b>Side lengths: </b>"+str(base)+", "+str(min(L))+", "+str(max(L))+"<br><b>Perimiter: </b>"+str(perim)+"<b\
r><b>Area: </b>"+str(area)
    return retStr

def returnValue():
    L=getNums()
    if isTriangle(L)==True:
        return perimArea() #returns perimeter and area and sidelengths                                                 
    else:
        return isTriangle(L) #returns error message from isTriangle()

# ========= CONTENT-TYPE LINE REQUIRED. ===========
# ======= Must be beginning of HTML string ======== 
htmlStr = "Content-Type: text/html\n\n" #NOTE there are 2 '\n's !!! 
htmlStr += "<html><head><title>&#9651; &#9651; &#9651;</title></head></html>\n"
htmlStr += "<body>"

# ~~~~~~~~~~~~~ HTML-generating code ~~~~~~~~~~~~~~
htmlStr += returnValue()
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

htmlStr += "</body></html>"

print htmlStr
