"""Anna Tolen
IntroCS2 pd3
HW31 -- Back in the [Co]Driver's Seat, Looping FTW
2015-04-13"""

#listSum(L) takes a list L containing only numbers, and returns the sum of L's elements
def listSum(L):
    hold = 0
    for n in L:
        hold += n
    return hold
print listSum( [0,1,2,3] ) #6

#minVal(L) takes a list L containing only numeric elements, and returns the least value
def minVal(L):
    hold = L[0]
    for minVal in L:
        if minVal < hold:
            hold = minVal
    return hold

print minVal( [3] ) # 3
print minVal( [5,4,3,2,1] ) # 1

#listFind(L,q) takes a list of L and a query q and returns the first index where q occurs in the L. Returns -1 if q is not found in L.
def listFind(L,q):
    count = 0
    for e in L:
        if e == q:
            return count
        count += 1
    return -1

print listFind([5,4,3,2,1], 2) # 3
print listFind([5,4,3,2,1], 6) # -1
print listFind([5,4,'cat','dog','cat'], 'cat') # 2

#minPos(L) takes a list L containing only numeric elements, and returns the position (index) of the least value.
def minPos(L):
    return listFind(L,minVal(L))

print minPos( [3] ) # 0
print minPos( [5,4,3,2,1] ) # 4
