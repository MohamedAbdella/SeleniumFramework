Feature: USer Registration
   I wanna check that the user can register in our e-commerce website.


Scenario Outline: User Registration 
Given the user in the home page
When I click on the register link
And I enterd "<firstname>","<lastname>","<email>","<pass>"
Then the registration page displayed successully 

Examples:
   | firstname  |  lastanme  |  email  |  pass  |
   |  ahmed  |  mohaed  |  ahmed1211@test.com  |  00000000  |
   |  bebo   |   afmsd  | ldqlmd2101@yahoo.com | 012345678  |

