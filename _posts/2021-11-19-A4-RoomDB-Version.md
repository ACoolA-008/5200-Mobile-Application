---
layout: post
title: "A4-RoomDB-Version"
date: 2021-11-19
---

Overview: Changing to RoomDB after realizing the objective for this assignment is to use Room rather than SQLiteHelper. So I took a while to change the whole architecture.

Now the packages look like this:
![Screen Shot 2021-11-19 at 7 27 25 PM](https://user-images.githubusercontent.com/71044804/142713002-4d140571-2be1-4a74-9f4c-cb012b4ad5a9.png)

Interesting fact:
I encountered situation where the created database is closed and some IllegalException related to migration problem arose. This is the place where I had to adopt fallbackToDestructiveMigration() method to keep the emulator functioning without crashing.
![Screen Shot 2021-11-19 at 7 28 27 PM](https://user-images.githubusercontent.com/71044804/142713083-2376dded-9728-4168-a9cf-0a11f07b769f.png)

Also I optimized the components to better fit the assignment requirements as the picture shows below.
![Screen Shot 2021-11-19 at 7 31 55 PM](https://user-images.githubusercontent.com/71044804/142713103-737d333b-a23b-48d8-b274-e2454f075cab.png)

Next, I will use calendar view to allow user to be able to choose a specific deadline date for the task duedates to work.
