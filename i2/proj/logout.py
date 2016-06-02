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
#file to store users currently logged in:
currentUsersFile="loggedin.csv"

#login page:
loginPage="login.html" 
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
    if not ('uname' in fsd):
        return False
    if not ('usecret' in fsd):
        return False
    if not ('uip' in fsd):
        return False
    if fsd['uname'] == '':
        return False
    return True


#return True if user valid, False otherwise
def authSession():
    if not( valid() ):
        return False
    try:
        userlist = open(currentUsersFile,'r').readlines()
    except:
        return False
    for row in userlist:
        rowList=row.strip().split(',')
        if rowList[0]==fsd['uname']:
            if rowList[1]==fsd['usecret']:
                if rowList[2]==fsd['uip']:
                    return True
    return False                 


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
    htmlStr += "session string problem?"
else:
    validated = authSession()
    #~~~~~~~~~~~~~~~~~~~ diag HTML... ~~~~~~~~~~~~~
    #htmlStr += "<h4>Dictionary of form data:</h4>"
    #htmlStr += str( fsd )
    #~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    if validated:
        htmlStr += "<h4>User was indeed logged in. <br>Logging out...</h4>"
        if remFrLoggedIn( fsd['uname'] ):
            htmlStr += "<h3>HuzzaaH! You have logged out.</h3>"
            htmlStr += '<br>Click <a href="'+ loginPage + '">'
            htmlStr += "here</a> to log in again."
    else:
        htmlStr += "<br>Logged in you were not. Click"
        htmlStr += '<a href="'+ loginPage + '">'
        htmlStr += "here</a> to remedy."        
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


htmlStr += "</body></html>"


print htmlStr
