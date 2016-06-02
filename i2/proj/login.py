#!/usr/bin/python
# ========= HASHBANG LINE ABOVE IS MAGIC! =========
# ========= (Must be first line of file.) =========

import os
import random
import cgi
import cgitb
#cgitb.enable()  #diag info --- comment out once full functionality achieved

 #####################################################
 ## Back-End Script for USER ACCOUNT AUTHENTICATION
 ## by
 ##   ___|  |             |                            
 ##  |      |  |   |   _` |   _ \                      
 ##  |      |  |   |  (   |   __/                      
 ## \____| _| \__, | \__,_| \___|                      
 ##  | ) __ __|__|/     |          _|   _|         | ) 
 ## V V     |    __ \   |  |   |  |    |    |   | V V  
 ##         |    | | |  |  |   |  __|  __|  |   |      
 ##        _|   _| |_| _| \__,_| _|   _|   \__, |      
 ##   ___|  _)               |        _)   ____/       
 ## \___ \   |  __ \    __|  |   _` |  |   __|         
 ##       |  |  |   |  (     |  (   |  |  |            
 ## _____/  _| _|  _| \___| _| \__,_| _| _|            
 #####################################################

# ~~~~~~~~~~~~~~~ auxiliary files ~~~~~~~~~~~~~~~~~
#file to store users and their passwords:
userfile="users.csv"

#file to store users currently logged in:
currentUsersFile="loggedin.csv" 

#page to link to upon successful login:
nextPage="interior1.py"
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


# ~~~~~~~~~~~~~~~ support functions ~~~~~~~~~~~~~~~
def FStoD():
    '''
    Converts cgi.FieldStorage() return value into a standard dictionary
    '''
    d = {}
    formData = cgi.FieldStorage()
    for k in formData.keys():
        d[k] = formData[k].value
    return d
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

#store querystring var/val pairs in dictionary
fsd=FStoD()


#validate user input
def valid():
    if not ('uname' in fsd) or not ('upass' in fsd):
        return False
    if fsd['uname'] == '':
        return False
    if fsd['upass'] == '':
        return False
    return True


#check for existence of a user in CSV file
def userExists(u):
    try:
        userlist = open(userfile,'r').readlines()
    except:
        return False
    for row in userlist:
        if row.strip().split(',')[0]==u:
            return True
    return False


#return True if a matching u/p combo exists in user file, False otherwise
def authenticate(u,p):
    try:
        userlist = open(userfile,'r').readlines()
    except:
        return False
    if not userExists(u):
        return False
    for row in userlist:
        if row.strip().split(',')[0]==u:
            if row.strip().split(',')[1]==p:
                return True
    return False                 


#write an entry to logged-in-users file
#returns True if success, False otherwise
def addToLoggedIn(u,uKey,uIP):
    remFrLoggedIn(u) #close any open sessions
    currUserList=[]
    outTxt = u + ',' + uKey + ',' + uIP + '\n'
    try:
        outStream=open(currentUsersFile, 'a')
        outStream.write(outTxt)
        outStream.close()
    except:
        return False        
    return True


#remove an entry from logged-in-users file
#returns True if success, False otherwise
def remFrLoggedIn(u):
    currUserList=[]
    try:
        inStream=open(currentUsersFile, 'r')
        currUserList=inStream.readlines()
        inStream.close()
    except:
        return False
    outTxt=''
    for row in currUserList:
        if row.strip().split(',')[0] != u:
            outTxt += row
    try:
        outStream=open('loggedin.csv', 'w')
        outStream.write(outTxt)
        outStream.close()
    except:
        return False    
    return True


# ========= CONTENT-TYPE LINE REQUIRED. ===========
# ======= Must be beginning of HTML string ======== 
htmlStr = "Content-Type: text/html\n\n" #NOTE there are 2 '\n's !!! 
htmlStr += "<html><head><title> Login Results </title></head></html>\n"
htmlStr += "<body>"

# ~~~~~~~~~~~~~ HTML-generating code ~~~~~~~~~~~~~~
if not valid():
    htmlStr += "invalid input"
else:
    validated = authenticate( fsd['uname'], fsd['upass'] )
    ################################
    #diag HTML...
    #htmlStr += "<h4>Dictionary of form data:</h4>"
    #htmlStr += str( fsd )
    #htmlStr += "<br><br>"
    #htmlStr += "<br><br>" + "username entered: " + str( fsd['uname'] )
    #htmlStr += "<br>" + "password entered: " + str( fsd['upass'] )
    #htmlStr += "<br>user exists? --> " + str( userExists( fsd['uname'] ) )
    #htmlStr += "<br>pass matches?  "
    #htmlStr += str(validated)
    ################################
    if validated:
        #gen 9-digit number for this user for this session
        secretNum = str( random.randrange(100000000,1000000000) )

        #record visitor's IP address
        if "REMOTE_ADDR" in os.environ:
            userIP = os.environ["REMOTE_ADDR"]
        else:
            userIP = "999.999.999.999"

        #write user record to logged-in-users file
        addToLoggedIn( fsd['uname'], secretNum, userIP )

        htmlStr += "<h3>Success!</h3>"
        htmlStr += "Proceed by clicking "

        #build link w querystring (username+"secret"num+IP)
        htmlStr += '<a href="' + nextPage
        htmlStr += "?uname=" + fsd['uname'] 
        htmlStr += "&usecret=" + secretNum
        htmlStr += "&uip=" + userIP
        htmlStr += '">here.</a>'
                
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


htmlStr += "</body></html>"


print htmlStr
