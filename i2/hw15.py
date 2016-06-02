"""Anna Tolen
IntroCS2 pd3
HW15 -- The Handoff
2015-03-10"""

import cmath

def numRealRoots(a,b,c):
    discrim = (b ** 2) - (4 * a * c)
    if discrim > 0:
        return 2
    elif discrim < 0:
        return 0
    else:
        return 1

#numRealRoots test cases
print numRealRoots(1,2,3) #expecting 0
print numRealRoots(2,4,2) #expecting 1
print numRealRoots(1,3,2) #expecting 2
print numRealRoots(-5,12,3) #expecting 2
print numRealRoots(0.5,0.3,0.765) #expecting 0


def quadSolver(a,b,c):
    
    discrim = (b ** 2) - (4 * a * c)
    plusQuadForm = (-b + cmath.sqrt(discrim)) / (2 * a)
    minQuadForm = (-b - cmath.sqrt(discrim)) / (2 * a)
    
    if numRealRoots(a,b,c) == 0:
        print "no real roots"
    elif numRealRoots(a,b,c) == 1:
        print plusQuadForm
    else:
        print plusQuadForm,minQuadForm

#quadSolver test cases
quadSolver(1,2,3) #expecting 'no real roots'
quadSolver(1,4,4) #expecting -2
quadSolver(1,-2,-15) #expecting -3,5
