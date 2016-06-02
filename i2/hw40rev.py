"""Team Annakin and Obaowan -- Eric Bao, Anna Tolen
IntroCS2 pd3
HW40 -- Tune Your Engine
2015-04-26"""

'''
Mechanism for Madlibification
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. obtain libraries (lists of words for each part of speech (nouns, adjectives, verbs, and adverbs))
2. make a helper function to get a random word from a list
3. check to see if there are any more "<" to replace
4. replaces all "<" and the word it encloses with a random word from the respective list. 
5. print modified string
6. ???
42. profit!

New Features in Version 2:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1.
2.
3.

'''
import string
import random
placeholders=["<NOUN>","<ADJECTIVE>","<ADVERB>","<VERB>"]
nouns=["spaceship","dragon","elephant","venus fly trap","hobbit","honey badger","nun"]
verbs=["runs","eats","flies","babbles","cajoles","flaps","postulates","snorts"]
adjs=["adorkable","intelligent","exquisite","arcadian","fergalicious","extraterrestrial"]
advs=["beautifully","quietly","carelessly","jubilantly","jaggedly","paradoxically"]
wordtype = [nouns, adjs, advs, verbs]

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
        return len(word)+1

def randWord(L):
    return L[random.randrange(len(L))]

def madlibify(story):
    storyList=story.split(" ")
    for p in placeholders:
        i=0
        while i<len(storyList):
            typedex=0 
            puncVal=hasPunc(storyList[i])
            if puncVal == False:
                if storyList[i]==p:
                    while typedex<len(placeholders):
                        if placeholders[typedex]==storyList[i]:
                            storyList[i]=storyList[i].replace(p,randWord(wordtype[typedex]))
                        else:
                            typedex+=1
            else:
                if storyList[i][:puncVal] == p:
                    while typedex<len(placeholders):
                        if placeholders[typedex]==storyList[i][:puncVal]:
                            storyList[i]=storyList[i].replace(p,randWord(wordtype[typedex]))
                        else:
                            typedex+=1
            i+=1
    story=" ".join(storyList)
    return story.capitalize()

print madlibify("The <ADJECTIVE> <NOUN> <VERB> <ADVERB> upside down.")
print madlibify("<NOUN>! <NOUN>")
 
def madlibs(story):
    storyList=story.split(" ")
    typedex=0
    while typedex<len(placeholders):
        windex=0 #keep your functions clean!
        while windex<len(storyList):
            puncRun=hasPunc(storyList[windex])
            if storyList[windex][:puncRun] == placeholders[typedex]:
                storyList[windex]=storyList[windex][:puncRun].replace(storyList[windex],randWord(wordtype[typedex]))
            windex+=1
        typedex+=1
    story=" ".join(storyList)
    return story.capitalize()
