# setu-mad1-assignment-one

# Student Information/Setup Instructions

* Student Number: 20093147
* Name: Georgina Walsh
* GitHub username: GeorginaWalsh (https://github.com/GeorginaWalsh/mobileApp-asgn1)


# App Overview

For this assignment a basic application that records student information:
* The student's ID number
* The students name
* The name of the student's course
* The current year the student is in
* If the student has completed their course or not.

Students can be added and listed. 
If the student's ID is known then the student can be searched for, updated, 
and deleted from the records.


While there is no restriction on the information added initially for a student, 
if a student's record were to be updated, certain criteria would have to be followed:
* Student IDs cannot be changed.
* The name cannot contain numbers, or a majority of commonly used special characters.
* The name of the course cannot contain numbers, or a majority of commonly used special characters.
* The student's year can only be from 1 to 4.
* As before, the student's completion status can only be true or false.

When updating a student, users are provided with two attempts: the initial value that the user is attempting
to update to, and then a second try, where the restrictions enforced on the inputs are mentioned.



The menu being run by the application is hard coded with ANSI escape codes to provide an alternative/updated interface:
* Blue for the menu.
* Green for successful responses to inputs.
* Red for negative responses to inputs.


# Future Versions

* The restrictions placed on updating would have been applied to adding students.
* Student ID's could be a randomly generated number from 1 to 1000, this number would be 
checked for duplicates within the already recorded student IDs.
* A list of modules could be added to each student's records. Capable of CRUDL.
* Issues with unit testing would be resolved.
* Issues with Pico Cli would be resolved.

