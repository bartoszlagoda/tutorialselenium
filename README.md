# Tutorial Selenium
The project is written for learning purposes based on the lessons included in the 'Selenium Java course from scratch'. This is the essence of basic commands for Selenium in Java.
## Sources
This app is inspired by Tester oprogramowania and his course on the Udemy platform: [Kurs Selenium Java od podstaw](https://www.udemy.com/course/kurs-selenium-java/)
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Useful maven commands](#useful-maven-commands)
* [Setup](#setup)
  * [Webdriver](#webdriver)
  * [WebDriverManager](#webdrivermanager)
  * [Setting the screen size](#setting-the-screen-size)
## General info
The repository presents selenium tests in Java on the [seleniumdemo website](http://www.seleniumdemo.com).
## Technologies
* Java 18.0.1.1 2022-04-22
* Apache Maven 3.8.6
* Selenium 4.16.1
* Google Chrome 120.0.6099.200
## Useful maven commands
* mvn compile - compiles the source code
* mvn test - runs tests
* mvn package - packs the compiled code into e.g. jar
* mvn install - installing the package to our local repository
* mvn clean - cleans the target file

[Maven repository](https://mvnrepository.com/) is a page that contains all Maven dependencies, which you can copy and paste into your dependencies in the pom.xml file.
## Setup
### Webdriver
To run a browser (Chrome, Edge, Firefox, etc.) you need to install a dedicated driver for a specific browser. For example, for Google Chrome it will be [chromedriver](https://googlechromelabs.github.io/chrome-for-testing/).
You must install a driver compatible with the browser version. To check it, you need to go to your browser settings and information.
After installation, you can perform the first test to check whether the Webdriver interface opens the selected browser correctly. Below is an example:
```
String path = "path\\to\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver", path);
WebDriver driver = new ChromeDriver();
```
However, the suggested solution is to add these variables to your environment variables. Everything can be done in 'cmd'.
However, the suggested solution is to add these variables to your environment variables. Go to advanced system settings. 
Then go to environment variables. In system variables, select the 'path' variable to edit. Then click on 'New' and add the paths to all installed drivers.
Thanks to this solution, you can remove the line in the code containing setProperty().
### WebDriverManager
As written in the source: [WebDriverManager](https://github.com/bonigarcia/webdrivermanager?tab=readme-ov-file) is an open-source Java library that carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver (e.g., chromedriver, geckodriver, msedgedriver, etc.) in a fully automated manner. 
In addition, WebDriverManager provides other relevant features, such as the capability to discover browsers installed in the local system, building WebDriver objects (such as ChromeDriver, FirefoxDriver, EdgeDriver, etc.), and running browsers in Docker containers seamlessly.
You need add this into your pom.xml file:
```
<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.3</version>
</dependency>
```
This will make it easier to set up the driver and run the selected browser. You can test this as follows:
```
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
```
### Setting the screen size
```
driver.manage().window().maximize();
Dimension dimension = new Dimension(200,200);
driver.manage().window().setSize(dimension);
```
### Closing the browser
There are two methods to close a browser window: quit and close.
#### quit
```
driver.quit();
```
Will close all invoked windows.
#### close
```
driver.close();
```
It will only close the first invoked window in the test.
### Javascript Executor
It is used to invoke javascript commands inside selenium. Example of use:
```
// create javascript executor
JavascriptExecutor executor = (JavascriptExecutor) driver;
// open testeroprogramowania page and set window size to 200x200 with naming page blank
executor.executeScript("window.open('https://www.testeroprogramowania.pl','blank','height=200','width=200')");
```
### Inspect option in Google Chrome Browser
The Google Chrome browser offers us a page inspection function. 
This is a development tool that will allow us to determine the structure of the page 
being examined and how a specific element is presented on it. To use this option, 
right-click on the selected website and select the Inspect option. Developer options 
with html&css code should appear. To quickly inspect the structure of a specific field, 
click the arrow button pointing to the square and point to the selected element on the page.