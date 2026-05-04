    🔗 - Project name - Om Biryani House - Test Automation Framework

Project Overview
This project is a Cucumber BDD (Behavior Driven Development) based automation testing framework designed to test the core functionalities of the 'Om Biryani House' web application. It is built using Selenium with Java and integrated into a CI/CD Pipeline using Jenkins.

           -  Tech Stack
    
       - Language: Java
       - Automation Tool: Selenium WebDriver
       - Framework: Cucumber BDD
       - Build Tool: Maven
       - Reporting: Cucumber HTML Reports
       - CI/CD: Jenkins (Pipeline as Code)
       - Version Control: Git & GitHub


 
            - Development & Integration Process 
         To demonstrate professional QA practices, I followed these steps to build and host this project:  
                
        - Framework Development: Built a robust Cucumber-Selenium framework in IntelliJ IDEA using Maven.
        - Version Control: Initialized a local Git repository and pushed the source code to GitHub for version tracking.
        - CI/CD Implementation: Configured a Jenkins Pipeline using a Groovy script (Jenkinsfile) to automate the testing process.
        - Automated Execution: Integrated GitHub with Jenkins so that every code update can be automatically tested through the pipeline.



             - Project Structure
    
            The framework follows a modular structure for better maintainability:
         - src/test/java/stepDefinitions: Contains the Java logic for each test step.
         - src/test/java/runner: Contains the TestRunner.java file to execute tests.
         - src/test/resources/features: Contains .feature files written in Gherkin language.
         - pom.xml: Manages all project dependencies and plugins.





             - Steps to Integrate IntelliJ Project with Jenkins (CI/CD):-

                - Step 1: Local Version Control (IntelliJ)
          - Before connecting to Jenkins, your code must be managed by Git locally:
          - Open the Terminal in IntelliJ.
          - Initialize Git: git init
          - Add files to the staging area: git add .
          - Commit your changes: git commit -m "Setup Cucumber Framework"


                 - Step 2: Push Code to GitHub
          - Jenkins needs a central place to pull your code from.
          - Create a new Public repository on GitHub.
          - Link your local project to GitHub:
            git remote add origin <your-github-repo-url>
          - Push your code: git push -u origin main


                - Step 3: Jenkins Pipeline Configuration 
          - Open Jenkins and click on New Item.
          - Enter a name (e.g., OmBiryaniHouse-CucumberAutomation) and select Pipeline, then click OK.
          - Under the General tab, you can add your project description.
          - Scroll down to the Pipeline section:
          - Select Pipeline script as the Definition.
          - Enter your Groovy script (Jenkinsfile) which tells Jenkins how to run your tests.


                - Step 4: The Execution Logic (Jenkinsfile)      
          - Your script acts as the bridge. It performs these actions automatically:
          - Checkout: Pulls the latest code from GitHub.
          - Build: Compiles the Java code.
          - Test: Runs mvn test to trigger your Cucumber scenarios.


               - Step 5: Run & Monitor      
          - Click Save.
          - Click Build Now on the left-hand menu.
          - Monitor the Stage View to see the "Checkout" and "Build & Test" blocks turn green.
          - Check Console Output to see the live execution of your Selenium tests.



               - Why this is important?
          - Automation: You don't have to manually run tests in IntelliJ every time.
          - Consistency: Jenkins provides a clean environment to ensure tests pass on every machine, not just yours.
          - CI/CD Skills: This workflow proves you understand how modern software testing works in a professional IT company.




               - How to Run the Project:-
           - On Local Machine:
             Open your terminal/command prompt in the project folder and run:
             mvn clean test

           - On Jenkins (CI/CD):
           - This project is pre-configured with a Jenkins Pipeline.
           - Click on "Build Now" in the Jenkins dashboard.
           - The pipeline will automatically pull the latest code from GitHub, compile it, and execute the test suite.




                  - Continuous Integration (CI/CD) Details
                    I have implemented a multi-stage Jenkins Pipeline that includes:
            - Checkout: Automatically pulls the latest code from the GitHub repository.
            - Build: Compiles the project using Maven.
            - Test: Executes all Cucumber scenarios and generates test results.




                   - How to add this to your GitHub: 
            - Go to your GitHub repository.
            - Click on "Add a README" or click the - - - pencil icon to edit the existing one. Paste the content above.
            - Click "Commit changes" at the bottom.
      
           
        One final reminder: Did you manage to change the repository visibility from Private to Public in the Settings? Once you do that  and run "Build Now" in Jenkins again, that red error should turn into a successful green build!

 

 🔗 - Website URL - 
   - 🌐 [Visit Om Biryani House Website]-(https://ombiryanihouse.wordpress.com/)
