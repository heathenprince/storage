"""Team Annakin and Obaowan - Anna Tolen, Eric Bao
IntroCS2 pd3
HW39 -- Put Your Plan Into Action
2015-04-23"""

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
'''


import random
nouns=["spaceship","dragon","elephant","venus fly trap","hobbit","nun"]
verbs=["runs","eats","flies","babbles","cajoles","flaps","postulates","snorts"]
adjs=["adorkable","intelligent","exquisite","arcadian","fergalicious","extraterrestrial"]
advs=["beautifully","quietly","carelessly","jubilantly","jaggedly","paradoxically"]

def randElement(L):
    return L[random.randrange(len(L))]

def fillBlanks(story):
    while story.count("<") > 0:
        if story.find("<ADJECTIVE>") != -1:
            story = story.replace("<ADJECTIVE>", randElement(adjs))
        elif story.find("<NOUN>") != -1:
            story = story.replace("<NOUN>", randElement(nouns))
        elif story.find("<VERB>") != -1:
            story = story.replace("<VERB>", randElement(verbs))
        else:
            story = story.replace("<ADVERB>", randElement(advs))
    return story

    
print fillBlanks("The <ADJECTIVE> <NOUN> <VERB> <ADVERB> upside down.")
print fillBlanks("A <NOUN> <VERB>")
