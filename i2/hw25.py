"""Team PhatstaxZ -- Darren Tha, Anna Tolen, Andy Wang
IntroCS2 pd3
HW25 -- Cereal-Grade Encryption
2015-03-24"""

a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
b = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm" #alph rot13

"""rot13Chr(ch) takes a single-letter string input and returns its rot13
equivalent."""

def rot13Chr(ch):
    x = a.find(ch)
    return b[x]

"""string a contains alphabet, string b contains alph rot13.
x has the value of the index of ch. that index is then found in string b."""

def rot13Chr2(ch): 
    if ord('A') <= ord(ch) <= ord('M') or ord('a') <= ord(ch) <= ord('m'):
        return chr(ord(ch) + 13)
    elif ord('N') <= ord(ch) <= ord('Z') or ord('n') <= ord(ch) <= ord('z'):
        return chr(ord(ch) - 13)

"""rot13 alph ends at M/m. if ord(ch) is in first halp of alph, adds 13.
if in second half, subtracts 13."""

print rot13Chr('C') # P
print rot13Chr('c') # p
print rot13Chr('m') # z

print rot13Chr2('C') # P
print rot13Chr2('c') # p
print rot13Chr2('m') # z


"""printEmAll() prints all letters of the alphabet along with the rot13
equivalent of each."""

def printEmAll():
    hold = ""
    pos = 0
    while pos <= 51:
        hold += a[pos] + " <-> " + b[pos] + "\n"
        pos += 1
    print hold
    
printEmAll()

"""rot13Wrd(word) takes a string input (all caps, no spaces) and returns
its rot13 encoding."""

def rot13Wrd(word):
    hold = ""
    pos = 0
    while pos < len(word):
        hold += rot13Chr(word[pos])
        pos += 1
    return hold

print rot13Wrd("JABBERWOCKY") #WNOOREJBPXL
print rot13Wrd("ZHFRQEBARF") #MUSEDRONES
