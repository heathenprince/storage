"""Anna Tolen
IntroCS2 pd3
HW36 -- Bucket List
2015-04-20"""

#modeList(nums) returns the mode, as a single number, of the set of numeric elements in list nums. Uses the "labeled buckets" algorithm we discussed in class.
def modeList(nums):
    numsMax=max(nums)
    numsMin=min(nums)
    bL=[0]*(numsMax-numsMin+1) #creates a new list with the appropriate number of buckets/indecies
    for n in nums:
        bL[n-numsMin]+=1 #adds 1 to appropriate bucket/index
    return bL.index(max(bL))+numsMin #returns index of mode+offset, ultimately producing the mode of the data provided
print modeList( [0,5,7,3,2,3] ) # 3
print modeList( [0,5,7,3,7,3] ) # 3  ( or 7 )

#vBarGraphify(nums) takes a list of non-negative integers and prints a set of vertical bars.
def vBarGraphify(nums):
    base=0 
    thresh=max(nums) 
    while thresh>0:
        retLine=""
        while base<len(nums):
            if nums[base]>=thresh:
                retLine+="*" * (base/10+1)+" "
            else:
                retLine+=" " * (base/10+1)+" "
            base+=1
        base=0
        thresh-=1
        print retLine
    retLine=""
    base=0
    while base<len(nums):
        retLine+=str(base)+" "
        base+=1
    print retLine
vBarGraphify([0,1,2,3])
vBarGraphify([1,0,3,2])
