This document provides a list of all items that we need to consider in order to create a new test automation framework.


1. Application under test: Select an application that we are going to test on. (https://www.saucedemo.com/)
2. Test set: Select a set of test cases that we would like to automate
3. Test data.
    - Identify test data needed per test case
    - Ensure data is configurable and not part of the automation code
4. Configuration: ex: env variables. 
5. Containerisation: packaging and sharing the application using docker images and files
6. Process: Define a process to update and maintain the framework
7. Continuous Integration: Our framework should support impplementation of CI using tools like Jenkins or github (preferred)
8. Automation tool: Choose relevant automation tool depending on the application. Ex Selenium for web browser testing, Rest assured for API
9. API automation: Consider usage of APIs directly instead of UI for certain functions like authentication, cleaning up, etc
10. Test reporting: Write up requirements for reporting.
	- Kind of reports. 
	- html reports. 
	- reports for CI. 
11. Notifications: Implement notifications to be sent for start and finish of test runs
	- Slack
	- emails. 
12. Assertion: Identify tool to assert functionality. Ex Junit5, TestNG

13. IDE: Seledt IDE for code editing. 
	- Intellij (Java development)
	- VScode (for GIT and other stuff)
15. Debugging: Consider debugging aspects to be inclueded in the framework. This is available as part of IntelliJ
16. Logging.
	- System.out.println (but this is not configurable at levels - debug, info, error)
	- We will use Log4j (this will help us make our logging flexible). 
	- Some practical cases why this is better than System.out.println
17. Build system: Select tool for our framework.
	- maven
	- ant