# -*- coding: utf-8 -*-
"""
Created on Sun Feb  9 22:00:53 2020

@author: Disha
"""

import mysql.connector
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="",
  database="classwork"
)
mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM books")

myresult = mycursor.fetchall()

for x in myresult:
  print(x)
      
import csv
with open('file2.csv','w',newline='') as f:
    writer=csv.writer(f)
    writer.writerows(myresult)