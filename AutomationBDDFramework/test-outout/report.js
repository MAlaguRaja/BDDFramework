$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("F:/eclipsesetup/AutomationBDDFramework/src/main/java/Features/cartAndCheckout.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author:rajamurugeshk@gmail.com"
    }
  ],
  "line": 4,
  "name": "Cart and Checkout to validate product details",
  "description": "",
  "id": "cart-and-checkout-to-validate-product-details",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Verify Products Add to Cart test scenario",
  "description": "",
  "id": "cart-and-checkout-to-validate-product-details;verify-products-add-to-cart-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User is on home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "Verify home page is displayed on the screen",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "User tap on \"Best sellers\" option in home screen",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User tap on See more Best Sellers in Camera \u0026 Photo in best sellers page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User select fifth product in product list page",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "User select \"8\" product quantity in product details page",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User tap on \"Add to cart\" to add the product in cart",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "Verify product name and total amount is displayed correctly on cart screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LaunchStepDefinition.launch_application()"
});
formatter.result({
  "duration": 23255862300,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.home_page()"
});
formatter.result({
  "duration": 279979300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Best sellers",
      "offset": 13
    }
  ],
  "location": "LaunchStepDefinition.select_catagory(String)"
});
formatter.result({
  "duration": 10282752300,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.more_best_seller_products()"
});
formatter.result({
  "duration": 731864800,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.product_list_page()"
});
formatter.result({
  "duration": 2380166000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 13
    }
  ],
  "location": "LaunchStepDefinition.select_product_quantity(int)"
});
formatter.result({
  "duration": 11454233500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Add to cart",
      "offset": 13
    }
  ],
  "location": "LaunchStepDefinition.add_to_cart(String)"
});
formatter.result({
  "duration": 13318491700,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.cart_page()"
});
formatter.result({
  "duration": 156592700,
  "status": "passed"
});
});