# CucumberFrameworkAssessment

# Technical Assessment

# Framework Highlights/Tool/Libraries.

**** Screenshot can be found in test-output directory once test finished

**** Cucucmber-Java

**** Hamcrest-all

**** Webdriver

**** WebDriver Manager

**** Cucumber

**** Page-object

**** Page-factory

**** Ability to take screen shot on scenario failure

**** Maven as build tool

**** Cross browser

**** Extent Report

**** Browser should be selected from command line as explained below

**** Scenarios are tag and can be run at tag level using IDE or command line (ex: -Dcucumber.options="--tags @tag")

# via Intellj IDE

**** A Cucumber runner class is defined in below package (src/test/java/runners/TestRunner.java)

**** Run configuration can also be set to override in vm options -ea -Durl={browser_url} -Dbrowser={browser_choice}

**** via Command Line to override -Dbrowser & -Durl

**** mvn clean -Durl={browser_url} -Dbrowser={browser_choice}
