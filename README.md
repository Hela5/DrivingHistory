# DrivingHistory

Hello!

This was all written in Java and I used the IntelliJ IDE. 
I have created a Utility class to parse through input file, manipulate data and then send it back out in a different format. 
I tried to keep field names and method names as verbose and clearly named as possible. 
I'm also a huge fan of comments throughout code and added them liberally. 

Object Modeling:
I chose to create two seperate Objects: Driver and Trip. 
This was done with the idea that ideally there would be multiple trips per driver.
It seemed easier to iterate through all trips, collect relevant data and then set it on the Driver once it's all been computed.
To create output, I read the data off of Driver. 

Testing:
For testing, I tried to intertwine traditional and newer styles (using Mockito). 
I used Mockito to mock the methods that load the file and create the output. 
The rest directly test the methods to ensure they're working properly.

A couple quick notes regarding txt files:
- I created a sample input file "TripsToRead.txt" to help with unit testing using some of the Example Input described in the Problem Statement. 
- Output file "Trip_Downstream.txt" is created to see the output clearly.


