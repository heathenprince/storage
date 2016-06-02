"""Anna Tolen
IntroCS2 pd3
HW30 -- Float Like a Butterfly, Sting Like a Bee
2015-03-31"""

def findMin(L): #helper function, min()
    pos = 0
    hold = 0
    if len(L) == 1:
        return L[0]
    elif len(L) == 0:
        return L
    else:
        while pos + 1 < len(L):
            if L[pos] > L[pos + 1]:
                pos += 1
                hold = L[pos]
            else:
                pos += 1
        return hold

def findIndex(L,e): #helper function, list.index
    pos = 0
    while pos < len(L):
        if L[pos] == e:
            return pos
            break
        else:
            pos += 1
    return -1
# tests yaya
print findMin( [3] ) #3
print findMin( [5,4,3,2,1] ) # 1
print findMin( [42,987,315,-487,1.0] ) # -487
print findMin([]) 

print findIndex( [3], 3 ) #0
print findIndex( [5,4,3,2,1], 1 ) # 4
print findIndex( [42,987,315,-487,1.0], -3 ) # -1

# minPos(L) takes a list L containing only numeric elements, and returns the position (index) of the least value.
def minPos(L):
    return findIndex(L,findMin(L))

print minPos( [3] ) #0
print minPos( [5,4,3,2,1] ) # 4
print minPos( [42,987,315,-487,1.0] ) # 3
