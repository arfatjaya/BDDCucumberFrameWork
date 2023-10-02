 
Feature: Search place the order for product
@OffersPage
Scenario Outline: search for product in home and offers page

Given User is on GreenCart landing page
When User search with short name <Name> and extracting actual name of product
Then User search for <Name> shortname in offers page to chek if product is exist
And validating offer page and landing page product name
 
 
 Examples:
 | Name |
 | Tom  |
 | Straw |
 | astr |