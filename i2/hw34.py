"""Anna Tolen
IntroCS2 pd3
HW34 -- Stat-tastic
2015-04-16"""

#meanList(nums) returns the arithmetic mean of the numeric elements in list nums.
def meanList(nums):
    s=0.
    for n in nums:
        s+=n
    return s/len(nums)
print "--------meanList TESTS--------"
print meanList([0,1])," // expecting 0.5"
print meanList([83,97,98,-32,42.5,15.23296])," // expecting 50.62216"

#sorted() but less good probably idk -- arranges a list of numbers in ascending order and permanently modifies list, where sorted
def sortify(nums):
    rL=[]
    while len(nums)>0:
        a=min(nums)
        rL.append(a)
        nums.remove(a)
    nums[:]=rL[:] #elements in rL == elements in nums
    return nums
print "--------sortify TESTS--------"
bar=[53,-43,79000,1400,-3.1]
print sortify(bar)," // expecting [-43, -3.1, 53, 1400, 79000]"
print bar #check if list is permanently changed

#medList(nums) returns the median of the numeric elements in list nums.
def medList(nums):
    nums=sortify(nums)
    while len(nums)>2:
        nums=nums[1:-1]
    if len(nums)==2:
        return meanList(nums)
    else:
        return nums[0]
print "--------medList TESTS--------"
print medList([2,4,9,10,5])," // expecting 5"
print medList([5,4,2,3])," // expecting 3.5"
print medList([83,97,98,-32,42.5,15.23296])," // expecting 62.75"

#barGraphify(nums) takes a list of non-negative integers and prints a horizontal bar for each index, commensurate with the value at said index.
def barGraphify(nums):
    for n in nums: print nums.index(n),":","="*n
print "--------barGraphify TESTS--------"
barGraphify([0,1,2,3])
barGraphify([1,0,3,2])
