"""Anna Tolen
IntroCS2 pd3
HW17 -- Repetition, Two Ways
2015-03-11"""

def factR(n):
    if n <= 0: 
        return 1
    else:
        return n * factR(n-1)

#if n <= 0, returns 1. otherwise (if n >0) runs factR recursively, multiplying n by (n-1)

print factR(0) #1
print factR(1) #1
print factR(2) #2
print factR(3) #6
print factR(4) #24

def factW(n):
    while n > 1:
        return n * factW(n-1)
    while n <= 1:
        return 1

#when n <= 0, returns 1. when n > 0, returns n * (n-1), runs factW again on new value.

print factW(0) #1
print factW(1) #1
print factW(2) #2
print factW(3) #6
print factW(4) #24
print factW(13) #6227020800
