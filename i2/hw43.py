'''Team T-Square -- Darren Tha, Anna Tolen
IntroCS2 pd3
HW43 -- ASCIIng About Your Visage
2015-04-29'''

#!/usr/bin/python
print "Content-Type: text/html\n"

#common(L1,L2) takes 2 lists as input and returns a new list containing values common to both. Assumes no repeated values in either list.
def common(L1,L2):
    retList=[]
    for n in L1:
        if n in L2:
            retList.append(n)
    return sorted(retList)

print common( [1,5,4,3,2] , [4,5,10,15] ) #[4,5]


#minOrd(L) returns the element in a list that comes first alphabetically
def minOrd(L):
    hold=L[0]
    pos=1
    loopCount=0
    while pos<len(L):
        name=L[pos]
        if ord(name[0])<ord(hold[0]):
            hold=name
        elif ord(name[0])==ord(hold[0]): #accounts for things starting with the same letter
            while ord(name[loopCount])==ord(hold[loopCount]):
                loopCount+=1
            if ord(name[loopCount])<ord(hold[loopCount]):
                hold=name
        pos+=1
    return hold

#alphabetize(names) takes a string of names, assumed to be in Last-First pairings, separated by commas, and returns an alphabetized list of names with line breaks in string form.
'''
ALGO:
1. split string of names into a list
2. changes list so that list elements are Last Name-First Name (as opposed to either one individually)
3. finds element with minimum first letter ord value using minOrd(L)
4. appends that element to a return list
5. deletes that element from original list
6. repeat
7. join new list of names in a return string
'''
def alphabetize(names):
    L=names.split(",")
    pos=0
    rL=[]
    while pos < len(L)-1:
        L[pos]=L[pos]+" "+L[pos+1]
        del L[pos+1]
        pos+=1
    while len(L)>0:
        j=minOrd(L)
        rL.append(j)
        L.remove(j)
    s="\n".join(rL)
    return s

print alphabetize("Wayne,Bruce,Kent,Clark,Parker,Peter" ) #"Kent Clark\nParker Peter\nWayne Bruce"
dw="Pond,Amy,Jones,Martha,Tyler,Rose,Doctor,The,Pond,Rory,Noble,Donna,Harkness,Jack,Song,River" #dooweeooooo
print alphabetize(dw)

#face() generates a random face out of the stuff in the list below whoo!!!
hairs=["|||||","ooooo","#####","*****"]
eyes=[" o o "," x x "," - - "," * * ","[]-[]"," ^ ^ "]
noses=["  v  ","  o  ","  >  "]
mouths=[" --- "," )-- ","  ~  ","  (O)"," === "]

import random

def oneOf(L):
    return L[random.randrange(len(L))]

def face():
    print oneOf(hairs)+"\n"+oneOf(eyes)+"\n"+oneOf(noses)+"\n"+oneOf(mouths)+"\n"

face()


