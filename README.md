# Automation example<br/>
Java - Cucumber solution using pageobjects <br/>
Supports Browsers: Firefox and Chrome


Supports operating systems: Windows and Mac
## System requirements
Maven

Java JDK

Preferred IDE: IntelliJ
## Installation instructions

After Maven installation run:
`mvn --version`<br/>Take note of your Java JDK version and edit the pom.xml `maven-compiler-plugin` `<target>` with your JDK version (if not on JDK 12)


## Run tests in Chrome
`mvn test -Dplatform=chrome`

## Run tests in Firefox
`mvn test -Dplatform=firefox`

## Run Sanity test suite
`mvn test -Dplatform=chrome -Dcucumber.options="--tags @sanity"`<br/>
Sanity test suite consists of a minimal amount of tests which would indicate a viable build for further testing.  In this case the happy paths for Create, Read, Update, Delete have been included.


## Run Smoke test suite
`mvn test -Dplatform=chrome -Dcucumber.options="--tags @smoke"`<br/>
Smoke test suite consists of a extended amount of tests which would determine whether the critical functionality of the system is working.  Along with the smoke test suite this would also add some error test cases.


## Run Regression suite
`mvn test -Dplatform=chrome`<br/>
Regression test suite contains all the tests within the automation framework and any tests identified as manual tests included in excel.

## Cucumber Reports
Please find the cucumber report here: `/target/cucumber-html-report/index.html`

## Future developments<br/>
1. Better solution to creating random data. 
2. Mobile device integration with Appium (if required to run on device) would need all fields to have an `id` tag<br/>
3. Jenkins integration (or other CI)
