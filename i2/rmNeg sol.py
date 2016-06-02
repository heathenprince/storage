def rmNegatives(L):
    index=0
    while index<len(L):
        e=L[index]
        if e<0:
            L[index:index+1] = []
            index-=1
        index +=1
foo = [5,-4, -2, 3,6,-2,1]

rmNegatives( foo ) # [5,6,3,1]
print foo
