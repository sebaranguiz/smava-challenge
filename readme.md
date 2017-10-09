
# Assignment for the Manual Software Quality Engineer position at smava

The goal of this project is the test automation of two stories:
1. A previously registered user wants to login but with invalid credentials. The expected result is that the user is not able to login and a fail message is displayed.
2. A user wants to ask for a loan of 2.750 Euros to be payed during 24 months for living purposes. The expected result is that the user is taken to another page for filling out a form that should include the same loan's parameters previously selected.

## Technologies used:

- Java SE 1.8
- Selenium
- JUnit
- Hamcrest
- Maven (dependencies included in pom.xml)

## Getting Started

This project was designed for being run with Firefox browser. As it was indicated that the program will be tested on Linux OS, a version of the geckodriver for Linux 64 bits was included in the folder /src/test/resources/linux64. If the project is run on a different OS, download the right geckodriver version from the Selenium's Website and update the class BrowserLauncher in the Utility package.

## Running the tests

Execution from command line:

mvn clean test


## Project Structure

One test/class in the UserStories package was developed for each user story:

**InvalidLoginTest**
Invalid credentials are entered on the login form. As a result, the user is not able to login and a fail message is displayed. A verification is performed to ensure that the message indicates the user entered not valid credentials. 

**LoanSelectionTest** 
Specific loan parameters are selected by a user that wants to perform a loan comparison. As a result, the user is taken to a results page that displays the previous parameters selected by the user. A verification is performed to ensure that the results page shows the correct loan selection that the user wants.

The test actions were wrapped on the previous classes and the structure of the webpages is represented using Page Object Model pattern in the following classes in the WebPages package:

- *HomePage*
- *LoanSelectionResultPage*
- *LoginFailedPage*

The *BrowserLauncher* class in the Utility package launches the Selenium driver and it is used by the UserStories classes.

For further details refer directly to the code comments.

## Author

Sebastian Aranguiz