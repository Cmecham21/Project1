# Project1

Project 1 is a programming assignment given to create a class registration system at Jacksonville State University.


## Overview
This program utilizes abstract classes, classes, ArrayLists, as well as other basic programming practices. The program takes an excel spreadsheet, reads the data, and outputs results based on your choices. One of the most diffucult parts of this assignment was understanding how to use the built in LocalTime library in java.

## Usage
This program is very practical and could easily be adapted into an actual college or school's registrar system. It is very easy to read, understand, and follow the logic. Once the program is ran, it will prompt the user with four choices. Choice one will allow the user to search for courses. Choice two will allow the user to register for a course. Choice three allows the user to view their current schedule. Choice four will close the program. Overall the program was challenging to make, but is very user-friendly, logically designed, and fun.


### Specifics
This program takes full advantage of abstract classes, ArrayLists, inheritance, and encapsulation. The two child classes, OnlineCourse and TraditionalClass, inherit most of their functions from the parent class, Course. Once the excel sheet is read in, it is seperated using the tab delimitered sequence. The data is then read into its respective class ArrayList, and stored correctly. When the user searches for a course, the data is pulled from the ArrayList and displayed to the screen. When the user registers for a class, they enter the CRN. That CRN is then added to the schedule. Finally, the user can display their current schedule by choosing choice three. 
