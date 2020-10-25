# termiNus User Guide

## Introduction

```
     _                           _  _   _
    | |                         (_)| \ | |
    | |_   ___  _ __  _ __ ___   _ |  \| | _   _  ___
    | __| / _ \| '__|| '_ ` _ \ | || . ` || | | |/ __|
    | |_ |  __/| |   | | | | | || || |\  || |_| |\__ \
     \__| \___||_|   |_| |_| |_||_|\_| \_/ \__,_||___/

    ____________________________________________________________
     Hello! I'm termiNus.
     What can I do for you?
    ____________________________________________________________
```

termiNus is an interactive task manager for students in NUS.

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `termiNus` from [here](http://link.to/duke).
1. Navigate to the folder containing `termiNus.jar` in the terminal.
1. Run termiNus by using `java -jar termiNus.jar`.

## Features 

### Adding a task: `add`
Adds a new item to the list of todo items.

Format: `add <description> <optional arguments>`

List of `<optional arguments>`:
- `p/<number>` sets the priority of the task.
- `c/<category>` sets the category of the task.
- `date/<dd-MM-yyyy>` sets the date of the task.

:triangular_flag_on_post: By default, there is no category and date, and the priority is set to 0.

Example of usage: 

`add tP meeting`

`add tP meeting c/cs2113`

`add tP meeting c/cs2113 p/1 date/13-05-2020`

Output:

```
    ____________________________________________________________
     Got it. I've added this task:
       [T][N] tP meeting (p:1) (category: cs2113) (date: 13 May 2020)
     Now you have 4 tasks in the list.
    ____________________________________________________________
```

### Listing: `list`
Lists everything.

Format: `list all`

Example of usage:

`list all`

Output:

```
    ____________________________________________________________
     Here are the tasks in your list:
     1.[T][N] tP meeting (p:1) (category: cs2113)
     2.[T][N] iP meeting (p:2) (category: cs2113)
     3.[T][N] assignment submission (p:2) (category: cg2028)
    ____________________________________________________________
```

### Listing tasks: `list`
Lists all the tasks.

Format: `list tasks`

Example of usage:

`list tasks`

Output:

```
    ____________________________________________________________
     Here are the tasks in your list:
     1.[T][N] tP meeting (p:1) (category: cs2113)
     2.[T][N] iP meeting (p:2) (category: cs2113)
     3.[T][N] assignment submission (p:2) (category: cg2028)
    ____________________________________________________________
```

### Listing tasks with given priority: `list`
Lists all the tasks with the given priority.

Format: `list tasks p/<priority>`

Example of usage:

`list tasks p/2`

Output:

```
    ____________________________________________________________
     Here are the tasks of this priority in your list:
     1.[T][N] iP meeting (p:2) (category: cs2113)
     2.[T][N] assignment submission (p:2) (category: cg2028)
    ____________________________________________________________
```

### Listing tasks with given category: `list`
Lists all the tasks with the given category.

Format: `list tasks c/<category>`

Example of usage:

`list tasks c/cs2113`

Output:

```
    ____________________________________________________________
     Here are the tasks of this category in your list:
     1.[T][N] iP meeting (p:2) (category: cs2113)
     2.[T][N] lecture quiz (p:2) (category: cs2113)
    ____________________________________________________________
```

### Setting priority of task: `set`
Sets the priority of an existing task.

Format: `set <taskIndexNumber> p/<priority>`

:triangular_flag_on_post: `<taskIndexNumber>` corresponds to the index given on `list` command output.

Example of usage:

`set 1 p/3`

`set 2 p/4`

Output:

```
    ____________________________________________________________
     Nice! I've set the priority of this task to: 4
    ____________________________________________________________
```

### Setting category of a task: `category`
Sets the category of an existing task.

Format: `category <taskIndexNumber> c/<category>`

:triangular_flag_on_post: `<taskIndexNumber>` corresponds to the index given on `list` command output.

Example of usage:

`category 1 c/CCA`

Output:

```
    ____________________________________________________________
     Nice! I have set the category of this task:
       [T][N] tP meeting (p:0) (category: CCA)
    ____________________________________________________________
```

### Setting date of a task: `date`
Sets the date of an existing task.

Format: `date <taskIndexNumber> date/<dd-MM-yyyy>`

:triangular_flag_on_post: `<taskIndexNumber>` corresponds to the index given on `list` command output.

Example of usage:

`date 1 date/11-11-2020`

Output:

```
    ____________________________________________________________
     Nice! I have set the date of this task:
       [T][N] study for finals (p:0) (category: st2334) (date: 11 Nov 2020)
    ____________________________________________________________
```

### Mark task as done: `done`
Marks a given task as done.

Format: `done <taskIndexNumber>`

:triangular_flag_on_post: `<taskIndexNumber>` corresponds to the index given on `list` command output.

Example of usage:

`done 1`

Output:

```
    ____________________________________________________________
     Nice! I've marked this task as done:
       [Y] tP meeting
    ____________________________________________________________
```

### Deleting a task: `delete`
Deletes a task from the list

Format: `delete <taskIndexNumber>`

:triangular_flag_on_post: `<taskIndexNumber>` corresponds to the index given on `list` command output.

Example of usage:

`delete 2`

Output: 

```
    ____________________________________________________________
     Noted. I've removed this task:
       [T][N] iP meeting (p:2)
     Now you have 5 tasks in the list.
    ____________________________________________________________

```

### Deleting all tasks of a certain priority: `delete`
Delete tasks of the same priority

Format: `delete p/<priority>`

Example of usage:

`delete p/2`

Output:

```    
    ____________________________________________________________
     Noted. I've removed all these task(s) with the same priority:
    ____________________________________________________________
     [T][N] tP meeting (p:2)
     [T][N] iP meeting (p:2)
     
     Now you have 3 tasks in the list.
    ____________________________________________________________

```
### Deleting all tasks of a certain category: `delete`
Delete tasks of the same category

Format: `delete c/<category>`

Example of usage:

`delete c/cs2113`

Output:

```    
    ____________________________________________________________
     Noted. I've removed all these task(s) with the same category:
    ____________________________________________________________
     [T][Y] tP meeting (p:0) (category: cs2113)
     [T][N] iP meeting (p:0) (category: cs2113)
     
     Now you have 3 tasks in the list.
    ____________________________________________________________

```

### Clearing all tasks: `clear`
Clears all tasks from the list 

Format: `clear`

Example of usage:

`clear`

Output:

```
    ____________________________________________________________
     Noted. I've cleared all your tasks.
    ____________________________________________________________

```

### Searching tasks: `find`
Finds all tasks with matching description (case-insensitive).

Format: `find <keyword>`

Example of usage:

`find meeting`

Output:

```
    ____________________________________________________________
     Here are the matching tasks in your list:
     1.[T][Y] tP meeting (p:1) (category: cs2113)
     2.[T][N] iP meeting (p:2) (category: cs2113)
    ____________________________________________________________
```

### Getting help: `help`
Prints the help message for commands.

Format: `help`

Example of usage:

`help`

Output:

```
    ____________________________________________________________
     add: Adds a task to the task list.
     Parameters: TASK_NAME <optional arguments>
     Example: add example_task <optional arguments>

     bye: Exits the program.
     Example: bye

     category: Sets the category of a task identified by the task index number in the task list
     Parameters: INDEX c/CATEGORY
     Example: category 1 c/Academics

     clear: Clears all tasks in the task list.
     Example: clear

     delete: Deletes the task identified by the index number used in the task listing.
     Parameters: INDEX
     Example: delete 1
          Optional parameter 1: p/PRIORITY
          Deletes all the tasks with PRIORITY.
          Example: delete p/1
          Optional parameter 2: c/CATEGORY
          Deletes all the tasks with CATEGORY.
          Example: delete c/cs2113

     done: Marks the task identified by the index number used in the task listing as done.
     Parameters: INDEX
     Example: done 1

     find: Finds all tasks whose descriptions contain any of the specified keywords (case-insensitive) and displays them as a list with index numbers.
     Parameters: KEYWORDS
     Example: find book

     help: Shows program usage instructions.
     Example: help

     list: Displays all tasks in the task list as a list with index numbers.
     Example: list
          Optional parameter 1: tasks p/PRIORITY
          Displays all the tasks with PRIORITY as a list.
          Example: list tasks p/1
          Optional parameter 2: tasks c/CATEGORY
          Displays all the tasks with CATEGORY as a list.
          Example: list tasks c/cs2113

     set: Sets the task identified by the index number used in the task listing to the new priority.
     Parameters: INDEX p/PRIORITY
     Example: set 1 p/2
    ____________________________________________________________
```

### Exiting the program: `bye`
Terminates the program.

Format: `bye`

Example of usage:

`bye`

Output:

```
    ____________________________________________________________
     Bye. Hope to see you again soon!
    ____________________________________________________________
```

## Frequently Asked Questions

**Q**: How do I transfer my data to another computer? 

**A**: `./tasks.txt` stores the user data, which can be transferred to another computer or instance of the program by
putting it in the same folder as `termiNus.jar`.

## Quick Command Reference

Action | Command | Example
----- | ------ | ------
Add task | `add <description> <optional arguments>` | `add tP meeting c/cs2113`
List tasks | `list` | `list`
List tasks with priority | `list p/<priority>` | `list p/2`
Set priority of task | `set <taskIndexNumber> p/<priority>` | `set 1 p/2`
Set category of task | `category <taskIndexNumber> c/<category>` | `category 1 c/CCA`
Set date of task | `date <taskIndexNumber> date/<dd-MM-yyyy>` | `date 1 date/11-11-2020`
Mark task as done | `done <taskIndexNumber>` | `done 1`
Delete task | `delete <taskIndexNumber>` | `delete 2`
Delete tasks by priority | `delete p/<priority>` | `delete p/2`
Delete tasks by category  | `delete c/<category>` | `delete c/cs2113`
Clear all tasks | `clear` | `clear`
Find tasks matching keyword | `find <keyword>` | `find meeting`
Getting help | `help` | `help`
Exiting the program | `bye` | `bye`
