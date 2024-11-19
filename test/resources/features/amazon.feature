Feature: Amazon Bestseller module validation

  Background: 
    Given Launch browser and navigate to amazon web page and sign in
    When Login into amazon

  @Test1
  Scenario Outline: Validate Product page in Bestseller(Electronics)
    And Enter Search prompt <prompt> in search bar and click search
    And Select any three brands in category
      | Redmi   |
      | realme  |
      | Samsung |
    And Select Display type as "AMOLED"
    And Click minimum price mobile from search results
    Then Navigate to products page
    When Click add to Cart
    And Click proceed to checkout from Nav bar
    And Click Add new address
    And Fill out new address form and click Use address button
    Then Verify Payment method button was visible

    Examples: 
      | prompt  |
      | mobiles |

  @Test2
  Scenario: Verify links under nav bar in accounts
    When Hover on nav bar in Accounts & Lists
    And verify all links under your accounts
      
