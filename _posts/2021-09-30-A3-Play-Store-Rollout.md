---
layout: post
title: "A3"
date: 2021-09-23 - 2021-11-03
---

Overview:
I took this assignment as a great practice to first attempt the use of the recycler view, utilizing fragments, and hardcode simple data to see the application actually works. It is interesting to work around new methods embeded in this Android Studio such as Fragment Class, FragmentManager, Adapter, Viewholder. I'm sure with such practice, I will be able to refactor ToDo App to a better application. Let's start with this simple app first.

1. First, I created the RecyclerView layout and a ListAdapter Layout as such:
![RecyclerView Layout](https://user-images.githubusercontent.com/71044804/140247840-111b77a2-6bce-41d1-9002-63f489500a80.png)
![ListAdapter Layout](https://user-images.githubusercontent.com/71044804/140247842-c08505ef-be54-425e-8e73-944432026760.png)

2.Second, I wrote a fragment1 class to extend Fragment parent class and also instatiate a name list given values 1,2,3 as string values. Then, with the imported RecyclerView class, I'm able to set this adapter to be seen in the app by using setLayoutManger and setAdapter. 
![ListAdapter RecyclerView Class](https://user-images.githubusercontent.com/71044804/140248183-202d67ce-2cc8-4cc8-badb-6651578f38c4.png)

3.Lastly, I edited Main Activity by using getSupportFragmentManager to create transaction that adds the fragment layout so the recyclerview's single fragment layout is able to show up on the screen in the main activity. Note fragment has to be used with an activity!
![Main Activity](https://user-images.githubusercontent.com/71044804/140248495-5643237b-54e9-4312-ae2f-1f418bc59641.png)

Result:
Everything works fine and I will be using this practice as a bare bone to build the real ToDo application later on.
![RecyclerView Works](https://user-images.githubusercontent.com/71044804/140248508-72a3affd-6859-4b43-8eeb-a3959a1a92f1.png)


First publish on 9/27 was not successful, it took a few more days for Google's team to review.
![Screen Shot 2021-10-14 at 3 52 34 PM](https://user-images.githubusercontent.com/71044804/137406262-75791ced-fc2b-419a-960b-6c8195d4878e.png)

I fell behind the schedule, but at the same time decided to redo the whole ToDo project, and also released the new version to Play Store. 
Working on the project while waiting for Google's team to approve the release.
![Screen Shot 2021-10-14 at 3 54 48 PM](https://user-images.githubusercontent.com/71044804/137406485-187eb1f7-25bc-4167-a0dd-90fc17d636e1.png)

Thanks for reading, I will continue showing progress.
