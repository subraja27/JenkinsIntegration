Feature: Purchase HairProduct functionality of netilfy application

Scenario: Verify order id on placing the order
When Click on ShopNow button
And Click Products under HairProducts
And Click HairBeautyPath link
And Click Addtocart button
And Click on the cart button
And Click Checkout button
And Select a shipping method
And Click Make Payment button
Then verify the order id and print in the console

