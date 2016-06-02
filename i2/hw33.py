"""Team Duende -- Darren Tha, Anna Tolen
IntroCS2 pd3
HW33 -- Removal Three Ways
2015-04-15"""

"""
POP:
syntax: L.pop([index]); argument taken is the index of item to be removed. List in question must be specified beforehand.
behavior: permanently modifies list and returns the item being removed. If no argument is given, the last element of the list is returned.

REMOVE:
syntax: L.remove(value), where value is the element to be removed
behavior: doesn't return anything, if argument given is not found in list returns ValueError. TypeError returned if no argument is given. List permanently modified.

DEL:
syntax: del L[index]
behavior: doesn't return anything, permanently modifies list. If a sole variable is passed as an argument, the value bound to that variable ceases to exist. This applies to lists as well as literals. Can remove the value of a single index or in a range of indecies (using slicing). del L[::2] will delete every second element; stepping works as well.

Team Duende prefers del for use in rmNegatives() because it modifies the list taking an index as an argument (as opposed to a value) without returning anything. If nothing is found, it returns an error as opposed to a value the user would have no use for.

"""

"""rmNegatives(L) removes the negative numbers from list L, assumed to contain only numeric elements. (Modifies L; does not create a new list.)"""
L=[1,-2,-3,4,5,-6]
def rmNegatives(L):
    pos=0 
    while pos<len(L): 
        e=L[pos] 
        if e<0: #if number is negative
            del L[pos]
            pos-=1
        pos+=1
        
rmNegatives(L)
print L #[1,4,5]

