"""Anna Tolen
IntroCS2 pd3
HW35 -- Stats on Stats on Stats
2014-04-19"""

#modeListA(nums) returns the mode, as a single number, of the set of numeric elements in list nums.
#ALGO: reigning champ--iterates through the list, and if the count of one element is greater than the count of the current mode, mode is set equal to the new element
def modeListA(nums):
    mode=nums[0]
    pos=0
    while pos<len(nums):
        if nums.count(nums[pos])>nums.count(mode):
            mode=nums[pos]
        pos+=1
    return mode
print modeListA([0,5,7,3,2,3]) #3
print modeListA([0,5,7,3,7,3]) #3 (or 7)

#modeListB(nums) returns the mode, as a list, of the set of numeric elements in list nums.
#ALGO: creates a list with the frequencies of each element, finds the max of that list. If the count of a number is equal to the max, adds that number to the list. One occurrence of that number is then removed from original list so that there are no repeats in the mode list.
def modeListB(nums):
    mL=[]
    cL=[]
    for n in nums:
        cL.append(nums.count(n))
    maxCount=max(cL)
    for n in nums:
        if nums.count(n)==maxCount:
            mL.append(n)
            nums.remove(n)
    return mL
print modeListB([0,5,3,7,7,3]) #3 (or 7)

#vBarGraphify(nums) takes a list of non-negative integers and prints a set of vertical bars.
#ALGO: maximum value identified as threshold.Base is used as a counter. For every iteration, threshold is lowered.
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
