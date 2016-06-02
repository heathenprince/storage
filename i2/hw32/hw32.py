# -*- coding: utf-8 -*-
"""Team SCAT -- Stephanie Chang and Anna Tolen
IntroCS2 pd3
HW32 -- Come Together
2015-04-14"""

#1. We used a while loop because a new list is being returned, and nothing is being found. 
#2. We used a while loop because listFib is supposed to return a list, but its parameter is a positive integer. 
#To use a for loop, we need an existing list and existing elements.
#3. We used a for loop because we want to execute an instruction on each element of a list.

#1.rmNegatives(L) removes the negative numbers from list L, assumed to contain only numeric elements. (Modifies L; does not create a new list.)
def rmNegatives(L):
    pos = 0
    while pos<len(L):
        e = L[pos]
        if e<0:
           L = L[:pos] + L[pos+1:]
        pos += 1
    return L
print rmNegatives( [5,4,3,2,1] ) # [5,4,3,2,1]
print rmNegatives( [5,-4,3,-2,1] ) # [5,3,1]

#2. listFib(n) returns a list of the first n Fibonacci numbers, starting with 0 as the 0th term, 1 as the 1st term, 1 as the 2nd term, and so on.
def listFib(n):
    retList = [0]
    ctr = 2
    if n>1:
       retList.append(1)
    while n>2:
         retList.append(retList[ctr-1] + retList[ctr-2])
         ctr+=1
         n-=1
    return retList        

print listFib(1) # [0]
print listFib(2) # [0,1]
print listFib(3) # [0,1,1]
print listFib(4) # [0,1,1,2]
print listFib(6) # [0,1,1,2,3,5]

#3:sentify(L) returns a string comprised of list Lâ€™s elements, in order, with spaces between. Assumes L contains only string elements.
def sentify(L):
    hold = ""
    pos = 0
    for e in L:
        x = L[pos]
        if x != L[-1]:
            hold+= e + " "
        else:
            hold+=e
        pos+=1
    return hold

print sentify(["this","is","how","we","do"])
print sentify(["Based","God","Mr.","Brown"])
