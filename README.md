# DrivingHistory

Hello!

I wrote this program in Java, the language I am most comfortable with, using the IntelliJ IDE. 
In DrivingHistory, I have created a Utility class to parse through an input file, store and manipulate data. Ultimately sending it back out in a new file and different format. 
As for naming, I tried to keep field names and method names as verbose and clearly stated as possible. 
Comments make life easier and I added them liberally throughout code. 

Object Modeling:
I chose to create two seperate Objects: Driver and Trip. 
This was done with the idea that there would be a one-to-many relationship of driver to trip to account for.
I start at the beginning of list of drivers. Then iterate through all related trips. In that iteration, I collect relevant data and set totals (i.e. total distance driven) on the Driver.
To create output, I read the data off of each Driver. 

Testing:
For testing, I used the traditional way of testing with Asserts to ensure each smaller method worked.
For overall testing I had to get a bit creative to ensure necessary methods can run successfully together, producing desired results. 
The "createOutputTest()" does that since there's no UI or other way to ensure data's being captured and processed correctly.
I also added one last "test" called 'clearOutTestData' to clean up the output file after all tests have been run. 

A couple quick notes regarding txt files:
- I created a sample input file "TripsToRead.txt" to help with unit testing using some of the 'Example Input' described in the Problem Statement. 
- Output file "Trip_Downstream.txt" is created to see the output clearly.

Thank you for taking the time to read through this and look at DrivingHistory!
Have a great day.
