@assignLeaves
Feature: Test Assign leaves
This Feature will test if we abe able to assign leaves
1.Login to Application
2.Click on Assign leaves
3.Fill the form
4.Click on Assign leaves button

Background:
Given  User is logged in successfully
@Positive
Scenario Outline:
When Click on Assign leaves
And Enter Employee name "<emp>"
And Enter Leave Type "<LeaveType>"
And Enter From date "<fromDate>"
And Enter To date "<toDate>"
#And Enter From date "<Partialdays>"
And Select duration  "<DurationDay>"
#And Enter From date "<DurationTime>"
And Enter Cooment "<Comment>"
And click on Assign button 
Then Verify if the leave is failed or pass

Examples:
|emp           |LeaveType|fromDate|toDate|Partialdays|DurationDay|DurationTime|Comment|
|Linda Anderson|Vacation US|2020-09-16|2020-09-17|Full Day|Half Day|Afternoon|Testing ORG|
|Steven Edwards|FMLA US|2020-09-16|2020-09-17|Full Day|Half Day|Morning|Testing ORG|

