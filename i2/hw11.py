"""Anna Tolen
IntroCS2 pd3
HW11 -- Visiting Old Friends
2015-03-03"""

pi = 3.14159265359

def areaCirc(r):
    return (pi * (r ** 2)) #squares radius, then multiplies by pi, prints area

#tests -- areaCirc
print areaCirc(1) #should be 3.14159265359"
print areaCirc(3) #should be 28.2743338823"
print areaCirc(5) #should be 78.5398163397"


def areaWasher(radInner,radOuter):
    return (areaCirc(radOuter) - areaCirc(radInner)) #finds area of two circles w/given radii, subrats smaller from larger

#tests -- areaWasher 
print areaWasher(0,2) #should be 12.5663706144
print areaWasher(3,5) #should be 50.2654824574
print areaWasher(6,10)#should be 201.06192983

def sumOfSquares(a,b):
    return (a ** 2) + (b ** 2) #squares arguments, returns sum
    
#tests -- sumOfSquares 
print sumOfSquares(0,0) #should be 0
print sumOfSquares(1,2) #should be 5
print sumOfSquares(4,5) #should be 41
