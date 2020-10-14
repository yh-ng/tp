# termiNus User Guide

## Introduction

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
- `p/<number>` sets the priority of the task
- `c/<classficiation>` sets the classification of the task

:triangular_flag_on_post: By default, there is no classification, and the priority is set to 0.

Example of usage: 

`add tP meeting`

`add tP meeting c/cs2113 p/1`

Output:

```
    ____________________________________________________________
     Got it. I've added this task:
       [T][N] tP meeting (p:1) (category: cs2113)
     Now you have 4 tasks in the list.
    ____________________________________________________________
```

### Setting priority of task: `set`
Sets the priority of an existing task.

Format: `set <index> p/<priority>`

Example of usage:

`set 1 p/3`

`set 2 p/4`

Output:

```
    ____________________________________________________________
     Nice! I've set the priority of this task to: 4
    ____________________________________________________________
```

### Deleting a task: `delete`
Deletes a task from the list

Format `delete <taskIndexNumber>`

Example of usage:

'delete 2'

Output: 

```
    ____________________________________________________________
     Noted. I've removed this task:
       [T][N] meeting (p:2)
     Now you have 5 tasks in the list.
    ____________________________________________________________

```

### Deleting all tasks of a certain priority: `delete`
Delete tasks of the same priority

Format `delete p/<number>`

Example of usage:

`delete p/2`

Output:

```    
    ____________________________________________________________
     Noted. I've removed all these task(s) from the same priority:
    ____________________________________________________________
     [T][N] bottle (p:2)
     [T][N] whatever (p:2)
     
     Now you have 3 tasks in the list.
    ____________________________________________________________

```

### Deleting all tasks of a certain priority: `clear`
Clears all tasks from the list 

Format `clear`

Example of usage:

`clear`

Output:

```
    ____________________________________________________________
     Noted. I've cleared all your tasks.
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
Set priority | `set <index> p/<priority>` | `set 1 p/2`
