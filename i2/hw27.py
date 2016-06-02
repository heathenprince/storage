"""Team PhatstaxZ -- Darren Tha, Anna Tolen, Andy Wang
IntroCS2 pd3
HW27 -- Anslatingtray Englishway intoway Igpay Atinlay
2015-03-26"""

"""
PIG LATIN RULES:
1. words starting with a consonant or with multiple consonants have those consonants moved to the end of the word with "-ay" stuck on there.
2. words starting with a vowel remain the same with "-way" affixed onto the end.
3. y is a consonant.


OUTLINE:
1. helper functions isAlpha() and isVowel() respectively determine whether the character being passed as an argument is in the alphabet and is one of the letters a, e, i, o, or u.
2. translate() consists of a conditional within a while loop within a conditional within a while loop. There are five local variables: pos = 0, pos2 = 0, start = phrase[:pos], hold = "", word = ""
    -initial while loop functions under the condition that "pos" is less than the length of "phrase".
    -initial conditional checks for isAlpha() being False. If isAlpha returns False, the char in question is appended to "hold". "Pos" is then increased by 1.
    -if isAlpha() returns True, a secondary while loop functioning under that condition will be run. In this loop a conditional for isVowel() is contained.
    -if isVowel() returns True, another while loop "while isAlpha()" is run, with "pos2" incrementing by 1. This is used to get the location of the word, so that slicing can be used to isolate it. Once the word is isolated, word += "way". Word is added to "hold".
    -if isVowel() returns False, word = phrase[pos:] + start + "ay", pos is incremented by 1.

    Hopefully this works.


DEVELOPMENT PLAN:
1. write isAlpha (done!)
2. write isVowel
3. begin to write translate(phrase)
4. pray, debug, debug some more, angry screaming, hair-pulling-out, praying and debugging
5. ???
6. profit!


DEVELOPMENT LOG:

2015-03-24 19:30
Anna: wrote isAlpha

2015-03-26 18:37 -- 2015-03-27 07:10
Anna, Darren: Rules, Outline, Devplan, Devlog

2015-03-27 09:15
Anna: wrote isVowel
"""
