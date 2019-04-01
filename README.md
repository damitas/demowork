# Automation example<br/>

## Solution
Java-Cucumber-Selenium solution using the PageObject model <br/>

## System requirements
Supports Browsers: Firefox and Chrome<br>
Supports operating systems: Windows and Mac

Maven:<br/>
-install on MAC with `brew install maven`<br/>
-install on Windows by following instructions here: https://maven.apache.org/install.html


Java JDK - at least 1.7+


Preferred IDE: IntelliJ

## Installation instructions

After Maven installation run:
`mvn --version`<br/>Take note of your Java JDK version and edit the pom.xml `maven-compiler-plugin` `<target>` and `<source>` with your JDK version


## Run tests in Chrome
`cd` to the root where the pom.xml is and run the command `mvn test -Dplatform=chrome`

## Run tests in Firefox
`cd` to the root where the pom.xml is and run the command `mvn test -Dplatform=firefox`

## Run Sanity test suite
`cd` to the root where the pom.xml is and run the command `mvn test -Dplatform=chrome -Dcucumber.options="--tags @sanity"`<br/>
Sanity test suite consists of a minimal amount of tests which would indicate a viable build for further testing.  In this case the happy paths for Create, Read, Update, Delete have been included.


## Run Smoke test suite
`cd` to the root where the pom.xml is and run the command `mvn test -Dplatform=chrome -Dcucumber.options="--tags @smoke"`<br/>
Smoke test suite consists of a extended amount of tests which would determine whether the critical functionality of the system is working.  Along with the smoke test suite this would also add some error test cases.


## Run Regression suite
`cd` to the root where the pom.xml is and run the command `mvn test -Dplatform=chrome`<br/>
Regression test suite contains all the tests within the automation framework and any tests identified as manual tests included in excel.

## Cucumber Reports
Please find the cucumber report here: `/target/cucumber-html-report/index.html` use right click and 'Open in browser'

## Future developments<br/>
1. Better solution for creating random data 
2. Mobile device integration (if required) with Appium
3. Jenkins integration (or other CI integration)
