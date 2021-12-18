
---
layout: post
title: "Final Project Proposal"
date: 2021-11-19
---

Final Project Proposal

General Ideas:
Changed from using SQLite Database to using Room Database since I found it’s not efficient and more hard coding that are required on the queries than Room. 
As the ToDo app project grows larger, I had encountered several times of running the project on the simulator which did not run as expected. In order to avoid much time spending on finding the errors, I decided to start a new project called the Alarm Reminder app. This app will include the reminder feature(so I can add this feature that’s supposed to be written in the ToDo app) and also the voice command feature. Details are listed in the sections below.



ToDo App Project
* descriptions: ToDo app will allow users to write every single task down with details of choosing the priority, picking a deadline for the task to be completed, updating the original task, and also deleting a task.
* Target users: Students and professionals who are working around the clock to complete tasks on a daily basis. It’s designed to help manage people’s tasks and increase productivity.
* Features included:
    * Storing data information by using Room Database.
    * Updating and modifying the data information on a task that’s already added to the ToDo list.
    * Choosing a deadline from the Calendar.
    * Setting up priority for each task.

Alarm Reminder App Project
* descriptions: Alarm Reminder App is based on the ToDo app. The major difference is that in alarm reminder app, to allow users writing down the task by recording the converting the words they spoke into text that will be displayed on the text view. This app will also include the unfinished reminder feature as well.
* Target users: English-speaking students and professionals who intend to increase productivity to complete tasks. 
* Features included:
    * Broadcast receiver to receive a notification from the alarm manager. It helps respond to the broadcast messages from the alarm manager.   In Class: AlarmBroadCast 
    * In order to convert the speech In Class: Create event that has a Method: recordSpeech() : RecognizerIntent.ACTION_RECOGNIZE_SPEECH, it detects the english language and convert the words into texts that could show up on the textview.
    * Date and time picker: In Class: Create event selectTime() selectDate() methods,  before that I did the work to format the time so the time entered by the datePickerDialog is recognized in 12hr instead of 24hr formats
    * setAlarm() method in create event will help me to autogenerate the notifications to remind. It works at the real time clock alarm.

Challenges:
* Shifting from SQLite Database to Room Database
* Using voice in the app.
