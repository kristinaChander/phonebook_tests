1. Test plan is in "Test plan.txt"
2. Tests are in the src folder
3. Report for tests run are generated via Allure report

To get the report for tests run:
- Run tests
- Maven menu ->Plugins->allure->report
- See the report in the folder target->site->allure-maven-plugin->index.html - open in browser

4. To run tests:

Make sure the application is in run on uri specified in baseURI property in test.properties file(http://localhost:8080/ by default)

Run tests via terminal command line:

- All tests: mvn clean test
- Negative tests: mvn clean test -PNegative
- Positive tests: mvn clean test -PPositive

Via maven menu:

- All tests: phonebook_tests-> Lifrcycle->clean + test, then click run Maven Build
- Negative tests: Profiles - tick Negative,phonebook_tests->Lifrcycle->clean + test, then click Run Maven Build
- Positive tests:Profiles - tick Positive,phonebook_tests-> Lifrcycle->clean + test, then click Run Maven Build

5.Bug reports are in "Bug reports.txt"
