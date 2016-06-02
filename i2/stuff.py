def rmNegatives(L): 
    pos = 0 # keeps track of the current index
    while pos < len(L):
        if L[pos] < 0:
            L[pos:] = L[pos+ 1:] # modifies individual elements
        else:
            pos += 1 # if no neg number found, move to next pos

# list initialization
listB = [5,-4,-3,-2,1,6]
print listB

# runs rmNegatives on listA and listB
rmNegatives(listB)

# prints the modified lists
print listB

"""rmNegatives(L) removes the negative numbers from list L, assumed to contain only numeric elements. (Modifies L; does not create
a new list.)"""
L=[1,-2,3,-4,5]
def rmNegatives2(L):
    pos=0 
    while pos<len(L): 
        e=L[pos] 
        if e<0: #if number is negative
            del L[pos]
            pos-=1
        pos+=1
        
rmNegatives(L)
print L

# list initialization
listB = [5,-4,-3,-2,1,6]
print listB

# runs rmNegatives on listA and listB
rmNegatives2(listB)

# prints the modified lists
print listB
