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