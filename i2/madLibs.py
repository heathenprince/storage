nouns=["door","computer science teacher","thinker","elephant","Norman","spaceship"]
adjs=["blue","green","swaggy","brown","fast","clever","eloquent","pretentious"]
verbs=["runs","sleeps","works","flies","craps"]
advs=["slowly","deeply","swaggily","intelligently","sadly"]
import random
def madLibs():
    retStr="The "
    noun=nouns[random.randrange(len(nouns))]
    adj=adjs[random.randrange(len(adjs))]
    verb=verbs[random.randrange(len(verbs))]
    adv=advs[random.randrange(len(advs))]
    retStr+="%s %s %s %s upside down." %(adj,noun,verb,adv)
    return retStr
print madLibs()
