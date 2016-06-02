"""Anna Tolen
IntroCS2 pd3
HW21 -- 000 000 111, v10
2015-03-18"""

#bondify, revamped: with slicing!

def bondify(name):
    pos = 0
    while name[pos] != " ":
        pos += 1
        
    sur = name[pos:]
    print sur + ", " + name

bondify("James Bond")
bondify("Anna Tolen")


"""s[a:b] -- returns char string from a (inclusive) to b (exclusive)
s[:b] -- returns everything before b
s[a:] -- returns everything after a
s[-1] -- returns last char
s[:-1] -- returns everything except last char
s[-2] -- returns penultimate char
s[:-2] -- returns everything up to penultimate char (exclusive)"""
