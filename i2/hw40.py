#!/usr/bin/python
# -*- coding: utf-8 -*-
print ""

"""Team For the WINdex -- Eric Bao, Anna Tolen
IntroCS2 pd3
HW40 -- Tune Your Engine
2015-04-26"""

'''
(Outdated) Mechanism for Madlibification
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. obtain libraries (lists of words for each part of speech (nouns, adjectives, verbs, and adverbs))
2. make a helper function to get a random word from a list
3. make a helper function to check for punctuation
4. split story string up into list of words
5. iterates through list of word types and list of words in the story, replacing each word type as it goes along
6. check to make sure articles match up
7. check to make sure all sentences are capitalized
8. re-join word list
9. print modified string
10. ???
42. profit!

New Features in Version 2:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. accounts for capitalization, punctuation, and articles!
2. more tenses!

'''
story="""The house stood on a slight rise just on the edge of the village. It stood on its own and looked over a <ADJECTIVE> spread of <NOUN-PLURAL>. Not a
<ADJECTIVE> house by any means – it was about thirty years old, <ADJECTIVE>,
<ADJECTIVE>, made of <NOUN-PLURAL>, and had four windows set in the front of a size and
proportion which more or less exactly failed to please the <NOUN-PLURAL>. \n
The only <NOUN-SINGULAR> for whom the house was in any way <ADJECTIVE> was <NAME>, and that was only because it happened to be the one he <VERB-PAST> in. He
had <VERB-PAST> in it for about three years, ever since he had moved out of <PLACE>
because it made him <ADJECTIVE> and <ADJECTIVE>. He was about thirty as well,
dark haired and never quite at ease with himself. The thing that used to
worry him most was the fact that people always used to ask him what he
was looking so worried about. He worked in local radio which he always used
to tell his friends was a lot more interesting than they probably thought. It
was, too – most of his friends worked in advertising. \n
On Wednesday night it had rained very heavily, the lane was wet and
muddy, but the Thursday morning sun was bright and clear as it shone on
Arthur Dent’s house for what was to be the last time. \n
It hadn’t properly registered with Arthur that the council wanted to
knock down his house and build an bypass instead."""

import string
import random
placeholders=["<NOUN-SINGULAR>","<NOUN-PLURAL>","<ADJECTIVE>","<ADVERB>","<VERB-PRESENT-SINGULAR>","<VERB-PRESENT-PLURAL>","<VERB-PAST>"]
nounSing=["spaceship","dragon","elephant","venus fly trap","hobbit","honey badger","nun","metaphor"]
nounPl=["magic wands","cheerios","snowboards","platypods","kangaroos","monks","computer programmers"]
adjs=["squattish","squarish","exquisite","nervous","irratable","extraterrestrial"]
advs=["beautifully","quietly","carelessly","jubilantly","jaggedly","paradoxically"]
verbsPresSing=["runs","eats","flies","babbles","flaps","postulates","snorts","shouts"]
verbsPresPl=["flood","write","sing","extrapolate","eat","wander","wonder","hex","yelp"]
verbsPast=["ate","consumed","wandered","hiked","stumbled","cajoled","swerved"]
wordtype = [nounSing, nounPl, adjs, advs, verbsPresSing, verbsPresPl,verbsPast]
vowels="aeiouAEIOU"

#hasPunc(word) returns negative indecies if a word has punctuation at the end of it. If a word doesn't, it will return the length of the word.
def hasPunc(word): #punk isn't dead B-)
    string.ascii_letters+=">"
    if word[-1] not in string.ascii_letters:
        i=-1
        while abs(i) < len(word):
            if word[i] not in string.ascii_letters:
                i-=1
            else:
                return i+1
    else:
        return len(word)

#oneOf(L) returns a random element from the list passed as a parameter.
def oneOf(L):
    return L[random.randrange(len(L))]

#madlibify(story) takes a string containing placeholders (<NOUN>, <VERB>, ...and whatever other placeholders you devise) and returns a string where all placeholders have been replaced with a random string from the appropriate list of strings. 
def madlibify(story):
    storyList=story.split(" ")
    typedex=0
    while typedex<len(placeholders): #this bit does all of the replacing
        windex=0 #keep your functions clean!
        lindex=0
        while windex<len(storyList):
            lindex=windex
            if storyList[windex].find("<") != -1:
                lindex=windex
                puncRun=hasPunc(storyList[lindex])
                if storyList[windex][:puncRun] == placeholders[typedex]:
                    storyList[windex]=storyList[windex].replace(storyList[windex][:puncRun],oneOf(wordtype[typedex]))
                if windex==0:
                    storyList[windex]=storyList[windex].capitalize()
            windex+=1
        typedex+=1

    #this bit iterates through the list and checks for any articles--if one doesn't match up, it'll change the "a" to "an"
    windex=0
    while windex<len(storyList):
        if storyList[windex].lower() == "a":
            if storyList[windex+1][0] in vowels:
                if windex==0:
                    storyList[windex] = "An"
                else:
                    storyList[windex] = "an"
        windex+=1

    #this bit makes sure sentences are capitalized
    windex=1
    while windex<len(storyList):  
        if hasPunc(storyList[windex-1])<0:
            storyList[windex]=storyList[windex].capitalize()
        windex+=1
  
    story=" ".join(storyList)
    return story

print madlibify("")

