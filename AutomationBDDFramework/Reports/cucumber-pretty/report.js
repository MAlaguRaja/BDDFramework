$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/main/java/Features/cartAndCheckout.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author:rajamurugeshk@gmail.com"
    }
  ],
  "line": 2,
  "name": "Cart and Checkout to validate product details",
  "description": "",
  "id": "cart-and-checkout-to-validate-product-details",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verify Products Add to Cart test scenario",
  "description": "",
  "id": "cart-and-checkout-to-validate-product-details;verify-products-add-to-cart-test-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Verify home page is displayed on the screen",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "User tap on \"Best sellers\" option in home screen",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User tap on See more Best Sellers in Camera \u0026 Photo in best sellers page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User select fifth product in product list page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User select \"8\" product quantity in product details page",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User tap on \"Add to cart\" to add the product in cart",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Verify product name and total amount is displayed correctly on cart screen",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User close the browser",
  "keyword": "When "
});
formatter.match({
  "location": "LaunchStepDefinition.launch_application()"
});
formatter.result({
  "duration": 51465529528,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.home_page()"
});
formatter.result({
  "duration": 169964369,
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
  "duration": 88676568325,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.more_best_seller_products()"
});
formatter.result({
  "duration": 3756748869,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.product_list_page()"
});
formatter.result({
  "duration": 2861552294,
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
  "duration": 10513414294,
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
  "duration": 55810152588,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.cart_page()"
});
formatter.result({
  "duration": 142399950,
  "status": "passed"
});
formatter.match({
  "location": "LaunchStepDefinition.close_browser()"
});
formatter.result({
  "duration": 5727645409,
  "status": "passed"
});
});