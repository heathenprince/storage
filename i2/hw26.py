"""Team PhatstaxZ -- Darren Tha, Anna Tolen, Andy Wang
IntroCS2 pd3
HW26 -- Further Explorations in Toy Encryption
2015-03-24"""

#rot13Chr(ch) takes a single-letter string input and returns its rot13 equivalent.

a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
b = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm" #alph rot13

def rot13Chr(ch):
    x = a.find(ch)
    return b[x]

def is_alpha(ch):
    if ord('A') <= ord(ch) <= ord('Z') or ord('a') <= ord(ch) <= ord('z'):
        return True
    else:
        return False

#rot13(phrase) takes a string input -- potentially including spaces, punctuation and a mixture of upper- and lowercase letters -- and returns its rot13 encoding.

def rot13(s):
    hold = ""
    pos = 0
    while pos < len(s):
        q = s[pos]
        if is_alpha(q):
            hold += rot13Chr(q)
        else:
            hold += q
        pos += 1
    return hold

    

print rot13("Justin Bieber") # "Whfgva Ovrore"
print rot13("Justin Bieber? Like, OMG!!! He's my hero!") #"Whfgva Ovrore? Yvxr, BZT!!! Ur'f zl ureb!"

#--------------------------------------------------------------------------------------------------------------------------------------
"""rotNChr(c,n) returns a char c rotated n spaces in the alphabet.
This is called in rotN(s,n), which encrypts an entire string.
decode(s) takes a string and rotates it around the whole alphabet, returning each variation. The user can then pick out whichever they'd like. Hooray!"""

def rotNChr(c,n):
    if c.upper()==c:
        offset=ord("A")
    else:
        offset=ord("a")
    return chr((ord(c)+n -offset)% 26 +offset)

def rotN(s,n):
    hold = ""
    pos = 0
    while pos < len(s):
        q = s[pos]
        if a.find(q) != -1:
            hold += rotNChr(q,n)
        else:
            hold += q
        pos += 1
    return hold

def decode(s):
    hold = ""
    pos = 1
    while pos < 26:
        hold += "rot" + str(pos) + ": " + rotN(s,pos) + "\n"
        pos += 1
    return hold

print decode("deoh") #able
print decode("ufwyd") #party
print decode("udm") #fox
print decode("Cppkg ctg aqw QM?") #Annie are you OK?
print decode("Abzqdqvo nwz xmznmkbqwv mdmz aqvkm Q eia i avwbvwam") #Striving for perfection ever since I was a snotnose
print decode("Apnly nva av obua, ipyk nva av msf; Thu nva av zpa huk dvukly, 'Dof, dof, dof?' Apnly nva av zsllw, ipyk nva av shuk; Thu nva av alss optzlsm ol buklyzahuk.") #Tiger got to hunt, bird got to fly; Man got to sit and wonder, 'Why, why, why?' Tiger got to sleep, bird got to land; Man got to tell himself he understand.
print decode("Roi! Roi ry! Cyzr-Pbycr CSXQ! tecd cdyvo dro cryg!") #Hey! Hey ho! Soph-Frosh SING! just stole the show!


