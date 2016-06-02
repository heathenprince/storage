"""Anna Tolen
IntroCS2 pd3
HW14 -- Letters & Numbers
2015-03-09"""

#converts number grades to letter grades
def gradeConv(g):
    if 90 <= g:
        return "A"
    elif 80 <= g:
        return "B"
    elif 70 <= g:
        return "C"
    elif 65 <= g:
        return "D"
    else:
        return "F"

#gradeConv test cases
gradeConv(100) #should be A
gradeConv(79.5) #should be C
gradeConv(67.2) #should be D
gradeConv(65) #should be D
gradeConv(64.4) #should be F
gradeConv(315) #should be A
gradeConv(-4667) #should be F

#returns comment on letter grade
def passJudgement(letterGrade):
    if letterGrade == "A" or letterGrade == "a":
        print "You are one astonishing azurill!"
    elif letterGrade == "B" or letterGrade == "b":
        print "You are one bright bulbasaur!"
    elif letterGrade == "C" or letterGrade == "c":
        print "You are one crummy caterpie!"
    elif letterGrade == "D" or letterGrade == "d":
        print "You are one disappointing diglett!"
    elif letterGrade == "F" or letterGrade == "f":
        print "FFFFFFOOOOOOOOOL!"
    else:
        print "letter grades pls! If you don't know which letter your number grade corresponds to, check out the gradeConv function."

#passJudgement test cases
passJudgement("C") 
passJudgement("f") 
passJudgement("cheerio") 
passJudgement(123)
