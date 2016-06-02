'''Team Annakin, The Chosen Yuan -- Anna Tolen, Andra Yuan
IntroCS2 pd3
Hw45 -- Four de Toid Thyme
2015-05-04'''

#modeLB(nums) returns the mode of the set of numeric elements in list nums. Uses a dictionary to implement the "labeled buckets"
def modeLB(nums):
    d={} #initializes empty dictionary
    for n in nums:
        d[n]=nums.count(n) #each dict element is "num:frequency"
    val=d.values() #list of values
    i=val.index(max(val)) #finds the index of the maximum value
    return d.keys()[i] #returns the corresponding key

#v2 is more bucket-y...wasn't sure if we could use L.count() or not
def modeLB2(nums):
    d={}
    for n in nums:
        if n in d: #if num is already in dict, adds 1 to value
           d[n]+=1
        else: 
           d[n]=1
    val=d.values()
    i=val.index(max(val))
    return d.keys()[i]

print modeLB( [0,5,7,3,2,3] ) #3
print modeLB( [0,5,7,3,7,3] ) #3  ( or 7 )
print modeLB2( [0,5,7,3,2,3] ) #3
print modeLB2( [0,5,7,3,7,3] ) #3  ( or 7 )
