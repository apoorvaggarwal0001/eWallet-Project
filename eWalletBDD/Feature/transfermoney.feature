Feature: Transfer Money

@validtransfer
Scenario: Successful transfer of money with valid credentials
Given User is on transfer money page
When User enters both the account numbers
Then message displayed Your transaction was successful!

@invalidtransferduetowrongaccountnumber
Scenario: Test transfer when account number is wrong
Given User is on money transfer page
When User enters invalid account number and other things correct
Then invalid account message is displayed

@invalidtransferduetoinsufficientbalance
Scenario: Try money transfer when account has insufficient money
Given User is at the transfer your money here page
When person enters correct account numbers but has insufficient money
Then error message is displayed saying insufficient balance