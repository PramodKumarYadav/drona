# drona

Goal of this repo is to help Rashmi learn automation by doing it. Approach is:
- Need based learning (so learn a concept when the need arise for it).
- And the philosophy to, "first make it work and then make it better"

As a result of the philosophy first we will come up with some ugly solutions and then will improvise from there to make them better. 

#Warning
As a result of above approach, expect to see a lot of bad intermittent code examples here. This repo thus, is not meant to be used as a reference since it is meant to start with some bad practices and from them move to better practices.

Idea is going from a bad solution to a better one will help remember why certain solutions are better than the bad ones. 

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

- For using all its awesome features to work with Java. VScode (always open source)
- To work with GitHub/Databases/FileTypes Powershell
- As the command line tool to work with Git and automating env deployment. Other tools
- As the need arises.

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
7. Continuous Integration: Our framework should support impplementation of CI using tools like Jenkins or github (
   preferred)
8. Automation tool: Choose relevant automation tool depending on the application. Ex Selenium for web browser testing,
   Rest assured for API
9. API automation: Consider usage of APIs directly instead of UI for certain functions like authentication, cleaning up,
   etc
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

Here is a list of objectivess that we expect our test framework to fulfill. As and when we prohress with the creation
and update of frameowrk, we will check these items from below.

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

- [] Tests should be agnostic of browser. i.e. Tests should only have context about tseting the app (no reference to
  browser).
- [] Driver should be agnostic of browser choice. i.e. the choice of browser should be outside driver class. It should
  just provide a driver that it asked.
- [] Choice of browser is to be made outside tests (either via CI or command line). In case if you dont want to do that,
  there should be a option for user to define a default driver with which all tests could be run.
- [] Tests should be atomic and independent of each other (to allow running in parallel)
- [] Tests should run in parallel (to keep test feedback fast and to encourage more tests)
- [] se of docker files to setup test environment
- [] To allow tests to run distributed on a grid (not same as parrallel)
- [] To allow a consistent setup across test machines.
- [] To create a test container to also run tests from container (entrypoint) -not just from localhost -GRID (which
  needs local setup)
- [] Use of CI to run tests with each merge in master
- [] Use of reports (html) & CI parceable

# Files that matters:

## Readme files

- to explain what your framework does and how. It helps new joines onboard and can define rules of the game for teams.

## editor-config file

- so that when you start colloborating with others you use the same styling rules, so that git hub only show application
  changes and changes and not styling changes as changes which will happen if you use different editor configuation (say
  in IntelliJ)

## gitignore file

- because you dont want to version control everything. There are things that you want to avoid from version control such
  as say local test run results, compiled files etc all.

## Docker files (compose and dockerfiles)

- so that your framework can run from any machine anywhere, without any issues.

## pom file

- to have a automated build system for your framework.

## app-config files.

- to have configurabilty in your test framework to make it run the same in multiple test environments (local, cloud,
  develop, master).

## log files

# Setup steps/ learning approach

-
    01. Create an empty repository.

    - Now we need a place to document our project and intentions.
    - A place where we can share our approach, design, goals, objectives and everything related on "how to with this
      project"
    - Basically we need something that we can share with someone who wants to look at this repo few months down the line
      and understand how everything works.A way of knowledge transfer.
    - This is where a readme.md file comes to our rescue.
    - Create a readme.md file and add placeholders for your intentions.
        - Test design
        - Test goals
        - Test objectives
        - Test env setup
        - Framework goals
        - Test execution modes
        - Test reports
        - Sharing your project.
        - Tools
        - Important files
            - add readme.md to the list.

-
    02. Now you have something that is worth versioning and backing up.

    - add git version control to your project on local.
    - make a remote repository for this project in your favorite client (say github)
    - add remote to your local project.
    - push changes from your local to remote.

-
    03. Now git will show you all the files that are in the repository.

    - You don't want to version control any dynamically generated files on run time.
    - neither do you want to see these files for version control.
    - You only want to version control files of your interest (source code and supporting files)
    - This is where .gitignore file comes for your rescue.
    - ignore all files that you are not interested in .gitignore file.
    - add mention of .gitignore in readme.md -> Important files list.
    - Commit for .gitignore and .readme and push to remote.

-
    04. Now so far you have been working alone. Unless you want to work solo (which is not too good for your and your
        projects health), before you learn anything else, you want to learn how to collaborate together with others on
        your project on github.

    - Step01:
        - This is where you first want to share some theory about how git works on local and remote.
        - How a normal project setup looks like with different branches (main, develop and feature branches)
        - How people can collaborate using feature branches on git.
    - Step02:
        - After the theory is done, you want to do a combined session with a friend (preferably someone who is new to
          this)
        - Ask him/her to clone the project.
        - Ask to install vscode and intellij.
            - now you can ask your friend to make a change in the project (say update the readme file for tools used and
              collaborator names).
        - let them make a branch and commit changes and push to their branch in remote.
        -

-
    05. Now there was a risk in the last exercise. You both are working on develop and even though you have a set
        process to collaborate using pull requests, there is nothing that is stoping one of you to directly push code on
        develop or main. you want to protect your project from such accidental changes.
        - you also want to make sure that the default branch to merge code is develop so that you dont accidentally
          merge code on the main branch.
        - you also don't want your remote branch to be hanging around there after it is merged. o
        - you would want to clean up.
        - to do all these things, let us got to github and put some settings.

-
    06. So far we have learned how to create an empty project and how to collaborate together with other people in
        project. Now before we start building an automation framework, lets take a look at how a normal end to end test
        automation process looks like.
        - This is going to be a longer video compared to rest of others.

    - Share the presentation and upload the file in github.

-
    07. Now with a fair understanding of how different parts of end to end automation looks like, lets start with a
        plain vanilla project and build our first "test" based on one of the examples present online. We are picking up
        frontend automation example here but the end to end process is exactly the same if you switch this framework
        from frontend to say rest api or any other backend framework.

- xx. When trying to run in docker container, there are few troubleshootings that I had to do to make tests run in
  container. These are:
    - The jdk version mentioned in the dockerfile and the one in POM file should match. if not,you will see funny
      errors. To fix this, when I tried with jdk8 in both places, I still had errors. Those I guess were due to pom
      using dependencies higher than jdk8.
        - jdk 10 doesnt exist in docker image. So i put in pom jdk 11 and also in dockerfile, FROM maven:3.8.1-jdk-11 .
          This gave one final error about crashing vm.
            - I could resolve this by running tests in headless mode in container.
    - so when you start covering this area, these are some points to remember.
    - also note that now you need jdk 11 downloaded for your test project. else the project will not run in local
      exeuction mode (since you only have jdk10 installed)
        - also the test ran fine with firefox but not chrome. so in container, this is a issue. either download firefox
          or fix the issues.

## to be continued..

# Reference

- [convert-a-regular-project-into-a-maven-project](https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support)
- [link issue to a pull request](https://docs.github.com/en/issues/tracking-your-work-with-issues/creating-issues/linking-a-pull-request-to-an-issue)