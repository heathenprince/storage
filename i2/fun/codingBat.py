#codingbat warmup 0 > sleep_in
def sleep_in(weekday,vacation):
    if weekday==True:
        if vacation==False:
            return False
        else:
            return True
    else:
        if vacation==True:
            return True
        else:
            return True

#codingbat warmup 1 > monkey_trouble
def monkey_trouble(a_smile,b_smile):
    if a_smile==b_smile:
        return True
    else:
        return False
    
#codingbat warmup 2 > diff 21
def diff21(n):
  if n<=21:
      return abs(21-n)
  elif n>21:
      return abs(21-n)*2


#codingbat warmup 3 > sum_double
def sum_double(a,b):
    if a==b:
        return (a+b)*2
    else:
        return a+b

#codingbat warmup 4 > parrot_trouble
def parrot_trouble(talking,hour):
    return talking and (hour<7 or hour>20):
         return True
    else:
         return False


#codingbat warmup 5 > makes 10
def makes10(a,b):
    if a+b==10 or (a==10 or b==10):
        return True
    else:
        return False

#codingbat warmup 6 > near_hundred
def near_hundred(n):
    if abs(100-n) <= 10 or abs(200-n) <= 10:
        return True
    else:
        return False

#codingbat warmup 7 > pos_neg
def pos_neg(a,b,negative):
    if negative==True:
        if a<0 and b<0:
            return True
        else:
            return False
    else:
        if (a<0 and b>0) or (a>0 and b<0):
            return True
        else:
            return False

#codingbat warmup 8 > not_string
def not_string(str):
    if (str.startswith("not") == True):
        return str
    else:
        return "not " + str


