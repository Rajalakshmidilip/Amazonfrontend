Feature: Search products and Add to cart
 
  Scenario Outline: Verify user can search the product and add the product to cart
    Given User is in amazon landing page
    When  User search for the p1 <product1> and add the product to cart with q1 <quantity1>
    And   Goto cart and assert the p1 price and quantity
    When  User search for the p2 <product2> and add the product to cart with q2 <quantity2>
    And   Check cart and assert the p2 price and quantity
    Then  Change the quantity <changequantity> for p1 item
		And   Assert total price and quantity are changed correctly
    
        
    Examples:
    |product1       | quantity1 |product2       | quantity2 | changequantity |
    |womens hats | 2         |hat          | 1         | 1							 |
    

