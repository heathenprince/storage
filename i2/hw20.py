"""Anna Tolen
IntroCS2 pd3
HW20 -- 000 000 111
2015-03-19"""

"""bondify(name) takes a name written in 'First Last' format, and returns the
sassy version, as shown below.
bondify("James Bond") -> "Bond, James Bond""""

def bondify(name):
    pos = 0 #position
    last = "" #last name var, currently empty
    spaceBool = False #"have we reached a space?"
    
    while pos < len(name): 
        if name[pos] == " ":
            spaceBool = True 
        elif spaceBool == True:
            last += name[pos]         
        pos += 1
        
    print last + ", " + name 

bondify("James Bond") #Bond, James Bond
bondify("Anna Tolen") #Tolen, Anna Tolen
bondify("Phillip Kucher") #he gets helping credz
