Server was implemented as SOAP WebService
Client was implemented as SOAP Client (wsimport was used to generated cleint. You can also use SoapUI or any other tools you like)
To make both applications as simple as possible I decided not to use any libraries, frameworks, application servers or containers.
Technologies:
 - JDK 8
 - JAX-WS
 - JUnit4
 - maven

1. Tasks estimations:  
1.1 System investigation (read business requirements) (30 minutes) 
1.2	System analysis (define limitations of system, high level approach) (10 minutes)
2.3	Design (dfine a stack of technologies and architecture approach) (90 minutes)
2.4	Environment(no servers and containers) (30 minutes)
2.5	Testing (I did not follow TDD, because design was frerquently updated) (50 minutes)
2.6 Maintenance (running on ,my local machine, manual testing, bug fixing) (10 minutes)
2.7	Evaluation (writing of documentation) (30 minutes)
Totally:  4h 10 min
 
 
1. To start Server do next:
	a. go to simple-search-engine and run:
		mvn clean install
	b. go to target folder and run:
		java -jar simple-search-engine-server.jar
	
You should to see in console:
-----------SERVER STARTED-----------------------
-----------http://127.0.0.1:8083/engine?WSDL-----------------------

To check correctnes please go to any browser on your computer and type 	http://127.0.0.1:8083/engine?WSDL.


1. To start Client do next:
	a. go to simple-search-engine-client and run:
		mvn clean install
	b. go to target folder and run:
		java -jar simple-search-engine-client.jar
	
You should to see in console:
---------------Making SOAP call-------------
get('data1')=Test content
get('data2')=Application data example
--------------------------------------------------------
Test content
Application data example
--------------------------------------------------------
this is a
this is b
it is good
--------------------------------
this is a
it is good
this is b
------------------------------------------------------------------------

Also, you can point client to another WSDL location by adding arguments from command line:
java -jar simple-search-engine-client.jar http://host:port/engine?WSDL.
		
