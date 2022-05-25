Feature: Automated End@End Tests
  Description: The purpose of this feature is to test End 2 End integration
  
  Scenario Outline: customer place an order by purchasing an item from search
     Given user is on home page
     When he search from "<productName>"
     And choose to buy two item
     And moves to checkout cart and ente personal details on checkout page nd place the order
     Then he can view the order and download the invoice
     
     
     Examples:
         |   productName   |
         | Apple MacBook Pro 13-inch |
   

