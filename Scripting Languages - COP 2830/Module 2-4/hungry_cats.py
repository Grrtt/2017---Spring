#!/usr/bin/python

# Import modules for CGI handling 
import cgi, cgitb 

# Create instance of FieldStorage 
form = cgi.FieldStorage() 

# Get data from fields
if form.getvalue('after845'):
   after845 = "Y" 
else:
   after845 = "N"

if form.getvalue('noisyCats'):
   noisyCats = "Y"
else:
   noisyCats = "N"
   
if form.getvalue('foodInBowl'):
   foodInBowl = "Y" 
else:
   foodInBowl = "N"

if form.getvalue('catReallyHungry'):
   catReallyHungry = "Y"
else:
   catReallyHungry = "N"
   
if form.getvalue('catReallyHungry'):
   sixHoursLate = "Y"
else:
   sixHoursLate = "N"
   
# Original Logic (pretty much)
if after845 == "Y" and noisyCats == "Y" and not foodInBowl == "Y" :
    decision = "Feed the beasts now"
elif catReallyHungry == "Y" and sixHoursLate == "Y" :
    decision =  "Feed cats so they will shut up"
else :
    decision = "Nothing to do yet"
 
# Build the html for the response   
print "Content-type:text/html\r\n\r\n"
print "<html>"
print "<head>"
print "<title>Cat Feeding Dilemma</title>"
print "</head>"
print "<img src=/satisfied_cats.png >"
print "<body>"
print "<h1> To feed or not to feed ...</h1>" 
print "<h2> After 8:45 is : %s</h2>" % after845
print "<h2> Cats Making Noise is : %s</h2>" % noisyCats
print "<h2> Food in Bowl is : %s</h2>" % foodInBowl
print "<h2> Cat Really Hungry is : %s</h2>" % catReallyHungry
print "<h2> Six hours since last feeding is : %s</h2>" % sixHoursLate
print ( "<h2> Decision: %s</h2>" % decision )
print "</body>"
print "</html>"
