"""Team PhatstaxZ -- Darren Tha, Anna Tolen
IntroCS2 pd3
HW28 -- Ealizeray Ouryay Isionvay
2015-03-28"""

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'"
def isAlpha(c):
    if alpha.find(c) != -1:
        return True
    else:
        return False
    
def stringAlpha(s):
    pos = 0
    while pos < len(s):
        if isAlpha(s[pos]) == False:
            return False
        else:
            pos += 1
    return True

def isNoAlpha(s):
    pos = 0
    while pos < len(s):
        if isAlpha(s[pos]) == False:
            pos += 1
        else:
            return False
    return True


def isVowel(c):
    v = "AEIOUYaeiouy"
    if v.find(c) != -1:
        return True
    else:
        return False

def buffr(s):
    pos = 0
    if stringAlpha == False:
        return ""
    else:
        while pos < len(s):
            while isAlpha(s[pos]):
                pos += 1
            pos1 = pos
            if pos == len(s) - 1:
                return ""
            else:
                while isAlpha(s[pos]) == False:
                    pos += 1
                pos2 = pos
                return s[pos1:pos2]
    
def prefix(s):
    pos = 0
    suff = "ay"
    hold = ""
    if stringAlpha(s) == False:
        hold += s[pos]
        return hold
    else:
        if s.count("'") >= 1: #removes all apostrophes from string
            s = s.replace(s[s.find("'")], "")
        while pos < len(s):
            if isAlpha(s[pos]):
                ch = s[pos]
                if isVowel(ch):
                    pre = s[:s.find(ch)] #pre is everything before the first vowel
                    stem = s[s.find(pre) + len(pre):] #stem is everything after the first vowel
                    if len(pre) == 0 and (stem[0] == "Y" or stem[0] == "y"): #if word starts with y
                        pre += stem[0]
                        stem = stem[1:]
                        word = stem + pre #flipped (dog --> ogd)
                        if word == word.upper(): #if word is all uppercase, maintains uppercaseness, appends suffix
                            hold += word.upper() + suff.upper()
                            break
                        elif pre == pre.capitalize(): #if word is capitalized, maintains capitalization, appends suffix
                            hold += word.capitalize() + suff
                            break
                        else: #returns word + suffix in lowercase
                            hold += word.lower() + suff
                            break
                        
                    elif len(pre) == 0: #if word starts with a vowel
                        word = stem
                        suff = "way"
                        if len(word) == 1:
                            hold += word + suff
                            break
                        elif word == word.upper(): #if word is all uppercase, maintains uppercaseness, appends suffix
                            hold += word.upper() + suff.upper()
                            break
                        elif word == word.capitalize(): #if word is capitalized, maintains capitalization, appends suffix
                            hold += word.capitalize() + suff
                            break
                        else: #returns word + suffix in lowercase
                            hold += word.lower() + suff
                            break

                    else: #if word starts with a consonant
                        if pre == "Q" or pre == "q": #if word starts with q
                            pre += s[s.find(pre) + 1]
                            stem = stem[1:]
                        word = stem + pre #flipped (dog --> ogd)
                        if word == word.upper(): #if word is all uppercase, maintains uppercaseness, appends suffix
                            hold += word.upper() + suff.upper()
                            break
                        elif pre == pre.capitalize(): #if word is capitalized, maintains capitalization, appends suffix
                            hold += word.capitalize() + suff
                            break
                        else: #returns word + suffix in lowercase
                            hold += word.lower() + suff
                            break
                else:
                    if len(s) == 1:
                        return s
                    else:
                        pos += 1
            else:
                hold += s[pos]
        else:
            return hold
        return hold

def translate(s):
    pos = 0
    full = ""
    hold = ""
    sen = ""
    if stringAlpha(s) == False:
        buff = buffr(s)
        while pos < len(s):
            if isAlpha(s[pos]):
                pos += 1
            else:
                word = s[:pos]
                hold = s.replace(word + buff,"", 1)
                sen += prefix(word) + buff
                if len(hold) > 0:
                    if isNoAlpha(hold):
                        full += sen + hold
                        return full
                    elif s.count(hold) > 1:
                        return sen + translate(hold)
                    else:
                        full += sen + translate(hold)
                        return full
                else:
                    full += sen + translate(hold)
                    return full
    else:
        full += prefix(s)
        return full
       
            
#tests
print translate("MUSE DRONES")
print translate("What are the rules of Pig Latin?") #Atwhay areway ethay ulesray ofway Igpay Atinlay?
print translate("the pope rocks red kicks") #ethay opepay ocksray edray ickskay
print translate("""Now, this is a story all about how
My life got flipped-turned upside-down
And I'd like to take a minute
Just sit right there
I'll tell you how I became the prince of a town called Bel Air

In west Philadelphia born and raised
On the playground was where I spent most of my days
Chillin' out maxin' relaxin' all cool
And all shootin some b-ball outside of the school
When a couple of guys who were up to no good
Started making trouble in my neighborhood
I got in one little fight and my mom got scared
She said 'You're movin' with your auntie and uncle in Bel Air'

I begged and pleaded with her day after day
But she packed my suit case and sent me on my way
She gave me a kiss and then she gave me my ticket.
I put my Walkman on and said, 'I might as well kick it'.

First class, yo this is bad
Drinking orange juice out of a champagne glass.
Is this what the people of Bel-Air living like?
Hmmmmm this might be alright.

But wait I hear they're prissy, bourgeois, all that
Is this the type of place that they just send this cool cat?
I don't think so
I'll see when I get there
I hope they're prepared for the prince of Bel-Air

Well, the plane landed and when I came out
There was a dude who looked like a cop standing there with my name out
I ain't trying to get arrested yet
I just got here
I sprang with the quickness like lightning, disappeared

I whistled for a cab and when it came near
The license plate said fresh and it had dice in the mirror
If anything I could say that this cab was rare
But I thought 'Nah, forget it' - 'Yo, homes to Bel Air'

I pulled up to the house about 7 or 8
And I yelled to the cabbie 'Yo homes smell ya later'
I looked at my kingdom
I was finally there
To sit on my throne as the Prince of Bel Air""") #stay fresh
