Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart landing page

When User search with short name <Name> and extracting actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order
And User select country "China" and agree terms and condition and proceed

Examples:
| Name  |
| Tom 	|

