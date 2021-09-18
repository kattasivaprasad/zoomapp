# zoomapp
This repository is to automate zoom app on android using Appium and extent reporting

# CodeGuidelines
Code should be clean and kept to the same standard as production code - make sure unused variables and methods are removed, code is correctly formatted, with no random newlines and whitespaces.

# Installations

You should have Java, node.js, npm, android stuido, appium server installed in your system and must set environment variables for JAVA_HOME, ANDROID_HOME

# How To Run the Tests

1. Clone the Project
2. Import the project to your IDE
3. Go to terminal on your IDE
4. Run "mvn clean install" command and make sure the build is successful
5. Open MyTestRunner.java file
6. Make sure Appium server is not running, make sure your device is connected and listed in adb devices
7. Right click on MyTestRunner.java
8. Click on run "MyTestRunner"

Note:
This will run the whole feature file. If need the execution of particular scenario then
add tags="@tagNameofScenario" after the , of plugin or glue.
Open MyTestRunner.java file
Right Click and select Run MyTestRunner


