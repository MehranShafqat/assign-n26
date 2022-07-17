# Monefy App #

### Tech Stack ###
* Java
* Maven
* TestNG
* Extent Reports
* Log4j
* Appium

### Project setUp ###

* Download Repo
* Open Mobile Automation Project and build project.
* Connect android device to laptop.
* Go to config.properties file and update capabilities.
* Go to testng.xml file and run the file.
* All test cases will start executing.


### Test Coverage ###
* Change Language ---- Highest Priority
* Change Currency ---- Highest Priority
* Add Account ---- Highest Priority
* Enable Budget ---- Highest Priority 
* Add Income ---- Highest Priority
* Add Expense ---- Highest Priority
* Search Expense ---- Low Priority
* Update Expense ---- High Priority
* Delete Expense ---- High Priority


### Mobile Automation Suite
* Page Object Model ---- Separate class for locators of each screen. i.e. AppHome, AppLanding etc.
* TestListeners ---- To add proper logs and reporting based to each step and each test case status.
* Test Utils ---- Store methods which are being used more than once.
* BaseTest ---- To initialize driver and capabilities.
* BasePage ---- To initialize locators using page factory.
* TestCases ---- Test Steps i.e search, delete, add, update.
* config.properties ---- To set and get all the capabilities for device.
* test_data.json ---- To get data and add assertions.