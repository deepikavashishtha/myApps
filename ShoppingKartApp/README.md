# ShoppingKart

ShoppingKart is simple JAVA application , which allows user to add/remove product in shopingKart. And also to get total price from shoppingKart.

## Main method

ShoppingKartMain is main entry point to run this application. It gives demo of adding , removing and getting total from ShoppingKart.


## Running the tests

ShppoingKartTest and PaymentManage is junit test class for ShoppingKart
mvn clean test


## Class Structure
This application has 2 packages
> com.ecommerce.shopping : This package contains classes for PayamentManagement, main enry class and ProductMetadata
> com.ecommerce.shopping.entity: This package contains entity classes.
 
This application has following classes:

> ShoppingKart: ShoppingKart represents ShoppingKart. It maintains a map of productId and quantity. It has customerId. So there is one to one mapping between customer and ShoppingKart class.It has method to add/remove products in ShoppingKart. 
> Customer : Represents Customer entity.
> Product : Represents Product entity.
> ShoppingKartMain : Main class for application. It also has productMetadata, which maintains available products and their price mapping.
> ProductMetaData: This class maintain metadata for Product which is available Product and Price mapping
> PaymentManager: This class manages final payment for shopping and has method buy which can be used to do buy operation.


## Authors

Deepika Vashishtha