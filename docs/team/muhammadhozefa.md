# Muhammad Hozefa - Project Portfolio 


## Overview

We were assigned a task to develop a program which would benefit our target audience. We decided to further improve on Duke and renamed our program, termiNus. From it's name we can infer that it is a one-stop Command Line Interface (CLI) based solution for NUS undergraduate students to manage their school curriculum, keep track of their daily expenses and be reminded of any library loans.

termiNus is using Java and Object-Oriented Programming (OOP). My role was to implement the entire loan system as well as certain subtasks such as ensuring deletion of items were done correctly, clearing of all data and finding tasks. The following sections will provide a detailed explanation on my enchancements as well as my contributions towards the User Guide and Developer Guide. 

## Summary of Contributions
This section gives a summary of my contributions towards our project.

**Code contributed** [RepoSense](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=muhammadhoze&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=MuhammadHoze&tabRepo=AY2021S1-CS2113-T14-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other) 

##### Enhancement implemented:
1. Added the loan system (BookList and Book class)
    * *what it does*: Allow students to keep track of their loan items from the library which will reduce overdue cases.  
    [BorrowCommand](https://github.com/AY2021S1-CS2113-T14-3/tp/blob/master/src/main/java/seedu/duke/commands/BorrowCommand.java)
    , [ReturnCommand](https://github.com/AY2021S1-CS2113-T14-3/tp/blob/master/src/main/java/seedu/duke/commands/ReturnCommand.java)

2. Deletion of tasks based on priority and category (DeleteCommand class)
    * *what it does*: Initially students could only delete their task one at a time. Now they are able to delete all **tasks** with the same priority and category in just one command. 
    [DeleteCommand](https://github.com/AY2021S1-CS2113-T14-3/tp/blob/master/src/main/java/seedu/duke/commands/DeleteCommand.java)

3. Finding **tasks** based on a keyword (FindCommand class)
    * *what it does*: Allow students to find their tasks easily with the help of this command rather than manually searching through the list.
    [FindCommand](https://github.com/AY2021S1-CS2113-T14-3/tp/blob/master/src/main/java/seedu/duke/commands/FindCommand.java)

4. Clearing **all** data which includes tasks, modules, web links, books (ClearCommand class)
    * *what it does*: Allow students to clear everything and start afresh every new semester.
    [ClearCommand](https://github.com/AY2021S1-CS2113-T14-3/tp/blob/master/src/main/java/seedu/duke/commands/ClearCommand.java)

##### Contributions to User Guide:
These are the following sections I contributed to which will be elaborated in the User Guide (Extracts).

1. Table of Contents
2. Quick Start
3. Borrowing a book
4. Returning a book
5. Deleting a task
6. Deleting tasks with same priority or category
7. Searching for tasks using a keyword
8. Clearing all data 
9. Quick Command Summary

##### Contributions to Developer Guide:
These are the following sections I contributed to:

1. Product Scope
2. User stories

##### Contributions to Team-based tasks:
These are the following team-tasks done by me:
1. Did smoke-tests on our program to ensure all commands were working as expected and the intended messages printed were correct. 
2. Added and assigned issues to my teammates.
3. Added non-feature related details such as Quick start, FAQ and a brief introduction of our program.


##### Review/mentoring contributions: 
1. Instances of reviewing my teammates PR and commenting appropriately.
[#95](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/95) [#160](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/160)
2. Ensure PRs are created with detailed description of the changes made so that the team is aware and updated.
[#40](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/40) [#60](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/60) [#93](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/93) [#155](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/155)              [#158](https://github.com/AY2021S1-CS2113-T14-3/tp/pull/158)

##### Contributions beyond the project team:
Beyond the scope of my team, I believe I reported several legitimate bugs as well as suggested solutions to fix those bugs to the team which was given to me during the dry run Pratical Exam.  

### Contributions to the User Guide (Extracts)
I have made several contributions to the User Guide besides just adding the relevant documentations for my enhancement. Below are the sections of the User Guide I added: 

1. Table of Contents
2. Quick Start
3. Borrowing a book: `borrow`
This command allow students to add the books loaned from the library. The book title and the loan date is compulsory. 

    *Example*: 
    A student just borrowed a book from the library and has a tendency of forgetting the due date and if the book has already been returned. Therefore, the student can enter this command:
         **borrow Java for dummies date/10-11-2020**
    
        Format: 
        borrow <book name> <date/DD-MM-YYYY>
         <book name> refers to the title of the book.
         <date/DD-MM-YYYY> refers to the when the book was loaned.
4. Returning a book: `return`
This command allow students to mark those books as returned.

    *Example*: 
    A student finished reading the book and returns it back to the library. Therefore, the student can enter this command to mark that book as returned:
         **return 2**
    
        Format: 
        return <bookIndexNumber>
         <bookIndexNumber> corresponds to the index given on list command output
5. Deleting a task from the list: `delete`
This command allow students to delete a specific task from the list. 

    *Example*: 
    The student can enter this command:
         **delete task 2**
    
        Format: 
        return <taskIndexNumber>
         <taskIndexNumber> corresponds to the index given on list command output
6. Deleting tasks based on priority and category: `delete`
This command allow students to delete several tasks with the same priority and category in one go. A task with no priority will have a priority value set as (0) by default. 

     *Example*
     The student wants to delete all tasks with highest priority (1) and all tasks under the category CS2113. The student can enter this commands:
     **delete tasks p/1**,   **delete tasks c/CS2113**
     
         Format: 
            delete tasks <p/priorityNumber>
             <p/priorityNumber> refers to the priority given to each task
         Format: 
            delete tasks <c/categoryr>
             <c/category> refers to the category (if assigned) to a task. 
7. Searching tasks by keyword: `find`
This command allow students to narrow down their search for a specific task. The keyword has to be a **whole word**. 
 
    *Example*
         The student can enter this command to find only those task associated with the keyword:
         **find meeting**

        Format: 
            find <keyword>
             <keyword> refers to the word to be matched with the tasks description.
8. Clearing all data from system: `clear` 
This command allow students to wipe off all their data.

    *Example*
             After the semester ends, the student can enter this command to clean all files from the previous semester.
             **clear all**
    
            Format: 
                clear all
9. Quick Command Summary
