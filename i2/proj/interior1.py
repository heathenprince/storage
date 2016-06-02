#!/usr/bin/python
# ========= HASHBANG LINE ABOVE IS MAGIC! =========
# ========= (Must be first line of file.) =========

import cgi
import cgitb
#cgitb.enable()  #diag info --- comment out once full functionality achieved

 #####################################################
 ## Sample Interior Page
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


# ~~~~~~~~~~~~~~~ auxiliary files ~~~~~~~~~~~~~~~~~
#file to store users and their passwords:
userfile="users.csv"

#file to store users currently logged in:
currentUsersFile="loggedin.csv" 

#login page:
loginPage="login.html" 

#page to load to logout:
logoutPage="logout.py" 
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


#store querystring var/val pairs in dictionary
fsd=FStoD()


#validate form input
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


#if user logged in, return session string, otherwise empty string
def sessionStr():
    if not(valid()):
        return ''
    u=fsd['uname']
    s=fsd['usecret']
    i=fsd['uip']
    return '?uname='+u+'&usecret='+s+'&uip='+i


#build an HTML hyperlink containing this user's session string
#destination: dst, display text: visText
def sessionLinkify(dst,visText):
    retStr = '<a href="'+ dst
    retStr += sessionStr()
    retStr += '">'
    retStr += visText
    retStr += "</a>"
    return retStr


# ========= CONTENT-TYPE LINE REQUIRED. ===========
# ======= Must be beginning of HTML string ======== 
htmlStr = "Content-Type: text/html\n\n" #NOTE there are 2 '\n's !!! 
htmlStr += "<html><head><title> Interior Page 1 </title></head></html>\n"
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
        htmlStr += "<h3>Well done. You have made it in.</h3>"
        htmlStr += "Proceed by clicking "
        htmlStr += sessionLinkify("interior2.py","another page")
    else:
        htmlStr += "<br>Logged in you are not. Click"
        htmlStr += '<a href="'+ loginPage + '">'
        htmlStr += "here</a> to remedy."

    #~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    htmlStr += "<br>" + sessionLinkify(logoutPage,'Logout')
    
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


htmlStr += "</body></html>"


print htmlStr
