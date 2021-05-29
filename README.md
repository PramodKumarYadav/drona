# drona
A test repo to play around with automation

# collaborators
- Rashmi PB
- Pramod
- Mahesh 

# Make some changes
## Learning to use VS code 
  Learning to use git client and git local in the right way

# Test workflow
- [Test workflow is described here](./test-workflow.drawio)
- [A generic workflow to work with git is explained here](./git-workflow.drawio)

# todo (for rashmi): format below code 
Tools:
IntelliJ open source version (latest)
 - For using all its awesome features to work with Java. 
VScode (always open source)
 - To work with GitHub/Databases/FileTypes
Powershell
 - As the command line tool to work with Git and automating env deployment.
Other tools
 - As the need arises. 
 
Files that matters:
 - Readme files
	- to explain what your framework does and how. It helps new joines onboard and can define
	rules of the game for teams. 
 - editor-config file
	- so that when you start colloborating with others you use the same styling rules, so 
	that git hub only show application changes and changes and not styling changes as changes
	which will happen if you use different editor configuation (say in IntelliJ)
 - gitignore file
	- because you dont want to version control everything. There are things that you want to avoid
	from version control such as say local test run results, compiled files etc all. 
 - Docker files (compose and dockerfiles)
	- so that your framework can run from any machine anywhere, without any issues. 
 - pom file 
	- to have a automated build system for your framework. 
 - app-config files. 
	- to have configurabilty in your test framework to make it run the same 
	in multiple test environments (local, cloud, develop, master). 



	### Framework Requirements:


	This is a list of all items that we need to consider in order to create a new test automation framework.


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

### Test Objectives

Here is a list of objectivess that we expect our test framework to fulfill. As and when we prohress with the creation and update of frameowrk, we will check these items from below.

- [] Tests should be atomic and not dependent on other tests.
- [] To increase speed of execution.
- [] To allow parrallel execution of tests.
- [] To improve test coverage (failing end to end tests, results in non-tested code).
- [] Test design should be clean and readable.
- [] To improve readability and maintenance.
- [] Should eliminate duplication.

        - by seperating intent from implementation (intent in controller/test classes vs implementation in tools/pageobject classes)
        - by using page object model.
        - by seperating tests from general purpose code.

- [] Tests should be quick to run.
- [] This should allow quick feedback to dev/test teams.
- [] Tests should be scaleable without impacting overall execution time.

        - One way is to run tests in parrallel to achieve this.
- [] This should encourage users to add more tests and not discourage.

- [] Tests should be agnostic of browser. i.e. Tests should only have context about tseting the app (no reference to browser).
- [] Driver should be agnostic of browser choice. i.e. the choice of browser should be outside driver class. It should just provide a driver that it asked.
- [] Choice of browser is to be made outside tests (either via CI or command line). In case if you dont want to do that, there should be a option for user to define a default driver with which all tests could be run.
- [] Tests should be atomic and independent of each other (to allow running in parallel)
- [] Tests should run in parallel (to keep test feedback fast and to encourage more tests)
- [] se of docker files to setup test environment
- [] To allow tests to run distributed on a grid (not same as parrallel)
- [] To allow a consistent setup across test machines.
- [] To create a test container to also run tests from container (entrypoint) -not just from localhost -GRID (which needs local setup)
- [] Use of CI to run tests with each merge in master
- [] Use of reports (html) & CI parceable