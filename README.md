# Introduction

This project is for SMT 274304.01 – Data Structures and Algorithms.  The intent of the project is to utilize our collective learned knowledge to analyze, plan, implement and test competing Java based coding solutions in order to determine an effective and efficient solution to an existing problem.

### Outline of the Problem
This project is a model representing a simulation of generators which store event logs corresponding to the planned / unplanned outages of the individual units.  In the 'current' system, event data is stored in an array of a fixed length containing informational fields of the event itself, as well as pointers to the predecessor and next available free cell after the current event. The index to the next unassigned free cell is stored and as events are created they are added to that cell and each following next free cell thereafter.

Our project looks to find a more efficient and suitable data structure to store these event logs, while at the same time ensuring that the new system allows for the efficient creation, insertion and searching of event logs.

# Testing Output

Here is an example output from running the TestingApp: 
```java
****** Begining Improved Nested Array Calendar Loading Test **********

Running Initial Test on 1000000 events.
It took: 531 mS to load 1000000 events.

****** Begining Improved Nested Array Calendar Timed Tests **********

Insert 1_000 Events Test:
Inserting 1_000 Test Events
There are now: 1001000 events in the calendar.
It took: 1470 milliseconds to insert 1000 events

Find 1_000 Events Test:
Finding 1_000 Random Events
It took: 1941 microS to find a 1_000 events

Delete 1_000 Event Test:
Deleting 1_000 Random Events
There are now: 1000000 events in the calendar.
It took: 877 milliseconds to delete 1_000 events

Traverse and Generate Report of All Events Test:
*******************************************
* Calendar System Report
*******************************************
* Total Calendar Events: 1000000
* Forced Outages:        161816
* Maintenance Outages:   161913
* Unit Installations:    160257
* Unit Removals:         161739
* Random Outages:        161297
*******************************************

It took: 110949 microS to traverse calendar and generate report

****** Ending Improved Nested Array Calendar Loading Test **********


****** Begining Nested Array Calendar Loading Test **********

Running Initial Test on 1000000 events.
It took: 615 mS to load 1000000 events.

****** Begining Improved Nested Array Calendar Timed Tests **********

Insert 1_000 Events Test:
Inserting 1_000 Test Events
There are now: 1001000 events in the calendar.
It took: 1554 milliseconds to insert 1000 events

Find 1_000 Events Test:
Finding 1_000 Random Events
It took: 251800 microS to find a 1_000 events

Delete 1_000 Event Test:
Deleting 1_000 Random Events
There are now: 1000000 events in the calendar.
It took: 1253 milliseconds to delete 1_000 events

Traverse and Generate Report of All Events Test:
*******************************************
* Calendar System Report
*******************************************
* Total Calendar Events: 1000000
* Forced Outages:        161843
* Maintenance Outages:   161911
* Unit Installations:    160248
* Unit Removals:         161734
* Random Outages:        161289
*******************************************

It took: 33031 microS to traverse calendar and generate report

****** Ending Improved Nested Array Calendar Loading Test **********


****** Begining Linked List Calendar Loading Test **********

Running Initial Test on 1000000 events.
It took: 139 mS to load 1000000 events.

****** Begining Improved Nested Array Calendar Timed Tests **********

Insert 1_000 Events Test:
Inserting 1_000 Test Events
There are now: 1001000 events in the calendar.
It took: 121 milliseconds to insert 1000 events

Find 1_000 Events Test:
Finding 1_000 Random Events
It took: 123795 microS to find a 1_000 events

Delete 1_000 Event Test:
Deleting 1_000 Random Events
There are now: 1000000 events in the calendar.
It took: 126 milliseconds to delete 1_000 events

Traverse and Generate Report of All Events Test:
*******************************************
* Calendar System Report
*******************************************
* Total Calendar Events: 1000000
* Forced Outages:        161843
* Maintenance Outages:   161911
* Unit Installations:    160248
* Unit Removals:         161734
* Random Outages:        161289
*******************************************

It took: 114266 microS to traverse calendar and generate report

****** Ending Improved Nested Array Calendar Loading Test **********
```

# Contributors

* [Trevor Elwell](http://trevorelwell.me)
* Mark Walling
* David McLellan
* Marlon Roberts
* Kevin Miller
* Isaac Atwood