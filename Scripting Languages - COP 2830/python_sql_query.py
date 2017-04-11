#!/usr/bin/python

# from: http://www.mysqltutorial.org/python-mysql-query

import mysql.connector
import re

# Open connection.  My database is named planes.  If you named yours something else
# then change the database= here. 
db = mysql.connector.connect(host='192.168.33.10',database='planes',user='root',password='root')

# prepare a cursor "SELECT * from planes.acars limit 10")
cursor = db.cursor ( )

# Do the query -- the limit is just to keep this small, you will not need it
cursor.execute('SELECT msg_text '
               'FROM planes.acars '
               'WHERE date_dd_mm_yyyy LIKE "%%/05/2016"'
               ';')

# f = open('E:\\Desktop\\regexData.txt', "a+")

# Fetch rows
data = cursor.fetchone ( )
f = open("E:\\Desktop\\regData.txt", "a+")
while data is not None:
    msg_code = re.findall("(?<=[\s|,])K.{3}[\s|,]", str(data))
    if msg_code is not None:
        print(str(data))
        for code in msg_code:
            f.write(str(data) + "\n")
            print(code.replace(",", "").strip())
            f.write(code.replace(",", "").strip() + "\n")
            '''
            if code is not "[]":
                print(str(data))
            print(code.replace(",","").strip())
            '''
    #f.write(str(msg_code) + "\n")
    data = cursor.fetchone()

# close cursor
cursor.close ( )

# close connection
db.close ( )
