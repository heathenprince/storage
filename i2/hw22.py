"""Anna Tolen
IntroCS2 pd3
HW22 -- Slice, Dice, Replace
2015-03-19"""

"""tablefyASCII() returns a string of valid HTML code
which will generate a 2-column, 53-row table. Each non-heading row
will show a letter of the alphabet and its corresponding ASCII value.
Letters on the left, numbers on the right."""

def tablefyASCII():
    start = """<!DOCTYPE html> \n
        <body> \n
        <table border = "1"> \n
                    <tr> \n
                    <th>Char</th> \n
                    <th>ASCII value</th> \n""" #string before table
    end = "</table>" #string after table
    return start + ASCII_upper() + ASCII_lower() + end

def ASCII_upper(): #gets uppercase portion of table
    num = 64 #uppercase ASCII values range from 65-90
    x="" #table text stored in x
    while 64 <= num <= 89:
        num += 1
        x = x + """</tr> \n
	    <tr> \n
	    <td>"""+ chr(num) +  """</td> \n
            <td>""" + str(num) + """</td> \n"""
    return x
        
def ASCII_lower(): #gets lowercase portion of table
    num = 96 #lowercase ASCII values range from 97-122
    y="" #table text stored in y
    while 96 <= num <= 121:
        num += 1
        y = y + """</tr> \n
            <tr> \n
	    <td>"""+ chr(num) +  """</td> \n
            <td>""" + str(num) + """</td> \n"""
    return y

print tablefyASCII()


"""replace(s,q,r) takes 3 string inputs and replaces any
occurrences of q in s with r. If there is no occurrence of
q in s, then s is returned unchanged."""

def replace(s,q,r):
    while s.find(q) != -1: #while string q is in string s
        pos = s.find(q) #index
        s = s[0:pos] + r + s[pos + len(q):]
    return s


print replace("Winter is coming", "Winter", "Spring") # Spring is coming
print replace("Dolphins run this planet", "dolphins", "mice") # Dolphins run this planet
print replace("Here comes the sun, doo doo doo", "doo", "dee") # Here comes the sun, dee dee dee 
