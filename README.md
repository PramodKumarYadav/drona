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