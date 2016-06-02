"""Anna Tolen
IntroCS2 pd3
HW12 -- Boolean Logic, Conditionals, Oh My!
2015-03-04"""

def pythTriple(a,b,c): #pythagorean triple function
    aSq = a ** 2
    bSq = b ** 2
    cSq = c ** 2
    if a<=0 or b<=0 or c<=0: #returns false falue if any value is <=0
        return "False -- you need positive integers!"
    elif (aSq + bSq == cSq) or (bSq + cSq == aSq) or (aSq + cSq == bSq): #checks all potential permutations
        return True
    else: #returns false if not a pythagorean triple
        return False

def cartDist(X1,Y1,X2,Y2): #distance formula function
    xDif = X1-X2
    yDif = Y1-Y2
    return ((xDif ** 2) + (yDif ** 2)) ** 0.5

#pythTriple test cases
print pythTriple(0,0,0) #False
print pythTriple (3,4,5) #True
print pythTriple (3,4,6) #False
print pythTriple (32,255,257) #True

#cartDist test cases
print cartDist(0,0,0,0) #should be 0
print cartDist(4,4,4,4) #should be 0
print cartDist(0,0,3,4) #should be 5

