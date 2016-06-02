"""Anna Tolen
IntroCS2 pd3
HW18 -- Loopy
2015-18-03"""

def sumDigits(n):
    pos = 0
    while n >= 10:
        a = n % 10 #isolates last digit
        pos += a 
        n = n // 10 #n - last digit
    return pos + n #concatenates 
    
print sumDigits(456) #15
print sumDigits(1) #1
print sumDigits(123) #6
print sumDigits(1001) #2

def squares(n):
    count = 0
    while count != n: 
        count += 1
        print count,(count **2)

squares(4)
squares(32)

def sumPerfSqs(n):
    ans = 0
    start = 1

    while start ** 2 <= n:
        ans += start ** 2
        start += 1

    print ans
    
    
sumPerfSqs(5) #5
sumPerfSqs(1) #1
sumPerfSqs(9) #14
