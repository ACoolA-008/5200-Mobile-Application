---
layout: post
title: "A4-SQLite-DB-Version"
date: 2021-11-03
---

Overview:

Based on last assignment, this task is focused on storing data into SQLite Database (off the record, I've been studying DS so SQL is what 
I am more comfortable of using. I will want to apply Mobile App Dev. skillsets to DS so UI friendly operations can be introduced)
by using Cursor class. I will find time to use Room Persistance Library to redo the assignment.

Step1: Created a database helper class that interacts with SQL server by sending SQL queries. I used CREATE
TABLE clause to create my_task table and insert data into the table in SQLite Database. Once the database table is set up,
cursor class will help me to read through all the data that's stored in this database table.

![Database Helper Class](https://user-images.githubusercontent.com/71044804/140257492-a0753635-d996-45fb-b807-d1d4092fc5e8.png)

Step2: In order to interact with my application. I then added this processdata() method to add all the values I had entered as data
to my database table. The process is shown as below.

![Main Activity Store Data](https://user-images.githubusercontent.com/71044804/140257516-d0711106-dee5-4240-84f3-4603ca99856d.png)

My Application looks like:

Empty Main Page:

![Empty Main](https://user-images.githubusercontent.com/71044804/140257659-9bf7da13-c2a7-437d-9352-b2d23a1565d9.png)

Add Task1:

![add task1](https://user-images.githubusercontent.com/71044804/140257689-c0372762-2ac8-48b9-ac99-dec499dbb406.png)

Show Task1 in Main Page:

![show task 1](https://user-images.githubusercontent.com/71044804/140257711-af668cbf-b821-48ad-a90c-448f3987be41.png)

Add Task2:

![add task2](https://user-images.githubusercontent.com/71044804/140257728-2d09040c-0c29-4d8b-a69a-1d03fd29db5d.png)

Show Task2:

![Show Task2](https://user-images.githubusercontent.com/71044804/140257740-9dd81d30-bef2-4238-8771-eec6482ee68f.png)

Show SQLite Database:

![Stores in SQLite Database](https://user-images.githubusercontent.com/71044804/140257774-1b12455c-ff3e-45f1-bd65-67c81e855f8a.png)

To Work ON: Delete data and use Room.

Thanks for reading!
