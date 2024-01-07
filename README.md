# Tutorial Selenium
The project is written for learning purposes based on the lessons included in the 'Selenium Java course from scratch'. This is the essence of basic commands for Selenium in Java.
## Sources
This app is inspired by Tester oprogramowania and his course on the Udemy platform: [Kurs Selenium Java od podstaw](https://www.udemy.com/course/kurs-selenium-java/)
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
## General info
To be completed.
## Technologies
* Java 18.0.1.1 2022-04-22
* Apache Maven 3.8.6
* Selenium 4.16.1
* Google Chrome 120.0.6099.200
## Webdriver
To run a browser (Chrome, Edge, Firefox, etc.) you need to install a dedicated driver for a specific browser. For example, for Google Chrome it will be [chromedriver](https://googlechromelabs.github.io/chrome-for-testing/).
You must install a driver compatible with the browser version. To check it, you need to go to your browser settings and information.
After installation, you can perform the first test to check whether the Webdriver interface opens the selected browser correctly. Below is an example:
```
String path = "path\\to\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver", path);
WebDriver driver = new ChromeDriver();
```