@Feature1
Feature: To validate the account creation of fb application

Scenario:
To create a new account
Given To Launch the browser and maximise window
When To launch url of Fb application
And To click the Create new accountButton
And To pass First name in first name text box
And To pass Second name in Second name text box
And To pass mobile number or email in email text box
And To create a new password
Then To Close the browser