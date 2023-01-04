package com.nuvolarworks.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.nuvolarworks.log.locators.AddProductPage;
import com.nuvolarworks.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductToCartStep extends TestBase{
	public static String Product1Title;
	public static String Product1Price;
	public static String Product2Title;
	public static String Product2Price;
	public static int Price1total;
	public static String CartProduct1Title;
	public static String CartProduct1Price;
	public static String CartProduct2Title;
	public static String CartProduct2Price;
	public static String CartProduct1total;
	public static String CartProducttotal;
	public static String CartPrice;

	AddProductPage addProductPage;
	AddProductPage addproductpage = new AddProductPage();

	@Given("^User is in amazon landing page$")
	public void userIsInAmazonLandingPage() throws Throwable {
		ReportCreateFeatureTest("Amazon Application test");	
		ReportCreateScenarioTest("User is in amazon landing page");
		try {		
			//browser launch
			selectBrowser(AddProductPage.Url);
			driverwait(8000);

			//location change
			WebElement locationname = getElement(AddProductPage.LocationName);
			if(locationname.isDisplayed()) {
				String location =locationname.getText();
				explicitwaitvisible(AddProductPage.LocationName);
				if(location != "india") 
				{ 
					explicitwaitclickable(AddProductPage.Location);
					clickelement(AddProductPage.Location);
					driverwait(2000);
					explicitwaitclickable(AddProductPage.LocationChangeIcon);
					clickelement(AddProductPage.LocationChangeIcon);
					driverwait(3000);
					dropdowncountry(AddProductPage.LocationChangeDrpdwn,"Spain");
					explicitwaitclickable(AddProductPage.DoneBtn);
					clickelement(AddProductPage.DoneBtn);	
				}}
			String s1=captureScreenshot();
			Givenlogpass("user landing to amazon website",AddProductPage.Url,s1);

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s=	captureScreenshot();
			Givenlogfail("user open url","Not redirected to amazon url",s);
			Assert.fail("Failure");
		}  
	}

	@When("^User search for the p1 (.*) and add the product to cart with q1 (.*)$")
	public void userSearchForTheProduct1AndAddTheProductToCartWithQuantity1(String product,String quantity) throws Throwable {
		ReportCreateScenarioTest("user search for the produc-1 and add the product to cart with quantity-2");
		try {
			//Search for product1
			explicitwaitvisible(AddProductPage.SearchTab);
			driverwait(3000);
			sendKeystoElement(AddProductPage.SearchTab,product);
			String s1=captureScreenshot();
			Whenlogpass("Search for product",product,s1);
			explicitwaitclickable(AddProductPage.SearchIcon);
			clickelement(AddProductPage.SearchIcon);
			driverwait(3000);
			scroll();
			driverwait(3000);
			explicitwaitpresence(AddProductPage.FirstSearchResult);
			clickelement(AddProductPage.FirstSearchResult);
			driverwait(4000);

			//product1 title
			WebElement producttitle = getElement(AddProductPage.ProductTitle);
			explicitwaitvisible(AddProductPage.ProductTitle);
			try { 
				if(producttitle.isDisplayed()) 
				{ 
					Product1Title = producttitle.getText().trim();
					System.out.println("Product-1 Title :"+Product1Title);
					s1=captureScreenshot();
					Whenlogpass("Search product-1 title",Product1Title,s1);
				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				Whenlogfail("When user search for product-1 and check it is displayed","Not able to get the product-1 title",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

			//product1 price
			driverwait(3000);
			WebElement productprice = getElement(AddProductPage.ProductWholePrice);
			explicitwaitvisible(AddProductPage.ProductWholePrice);
			WebElement productdecimal = getElement(AddProductPage.ProductDecimalPrice);
			try { 
				if(productprice.isDisplayed()) 
				{
					String ProductPrice1 = productprice.getText(); 
					String ProductPrice2 = "."+productdecimal.getText(); 
					Product1Price = "$"+ProductPrice1.concat(ProductPrice2);
					System.out.println("Product-1 Price :"+Product1Price);
					s1=captureScreenshot();
					Whenlogpass("Search product-1 price",Product1Price,s1);
				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("When user search for product-1 and check it is displayed","Not able to get the product-1 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

			//change product1 quantity
			driverwait(3000);
			scroll();
			explicitwaitclickable(AddProductPage.QuantityBtn);
			clickelement(AddProductPage.QuantityBtn);
			driverwait(3000);
			dropdowncountry(AddProductPage.AddQuantity,quantity);
			s1=captureScreenshot();
			Thenlogpass("Added product1 to cart with quantity-2","Qunatity 2",s1);

			//Addtheproducttocart
			explicitwaitclickable(AddProductPage.AddToCartBtn);
			clickelement(AddProductPage.AddToCartBtn);
			s1=captureScreenshot();
			Thenlogpass("Click the Product-1 addtocart","Added Product-1 to cart",s1);

			//cart product totalprice
			driverwait(3000);
			WebElement cartwholeprice = getElement(AddProductPage.AddCartSubtotalWholePrice);
			explicitwaitvisible(AddProductPage.AddCartSubtotalWholePrice);
			WebElement cartdecimalprice = getElement(AddProductPage.AddCartSubtotalDecimalPrice);
			try { 
				if(cartwholeprice.isDisplayed()) 
				{
					String ProductPrice1 = cartwholeprice.getText(); 
					String ProductPrice2 = "."+cartdecimalprice.getText(); 
					CartPrice = "$"+ProductPrice1.concat(ProductPrice2);
					System.out.println("Product-1 totalPrice :"+CartPrice);
					s1=captureScreenshot();
					Whenlogpass("Search product-1 totalprice",CartPrice,s1);
				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("When user search for product-1 and check it is displayed","Not able to get the product-1 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}
			System.out.println("Added the product to cart");

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s1=captureScreenshot();
			Whenlogfail("When user search for product and check it is displayed","Not able to get the search the product",s1);
			Assert.fail("Failed due to this Exception:"+e);
			Assert.fail("Failure");
		}
	}

	@And("^Goto cart and assert the p1 price and quantity$")
	public void gotoCartAndAssertTheP1PriceAndQuantity() throws Throwable {
		ReportCreateScenarioTest("Goto cart and assert the product1 price");
		try {
			//Gotocart
			explicitwaitclickable(AddProductPage.CartBasketBtn);
			clickelement(AddProductPage.CartBasketBtn);
			driverwait(2000);

			//Assertprice
			String s1;
			WebElement productprice = getElement(AddProductPage.CartProduct1Price);
			explicitwaitvisible(AddProductPage.CartProduct1Price);
			try { 
				if(productprice.isDisplayed()) 
				{
					CartProduct1Price= productprice.getText().trim(); 
					Assert.assertTrue(Product1Price.contains(CartProduct1Price));
					System.out.println("Actual CartPrice: " + Product1Price + " Expected CartPrice: " + CartProduct1Price);
					s1=captureScreenshot();
					Whenlogpass("Assert the CartPrice","Actual Price: " + Product1Price + " Expected CartPrice: " + CartProduct1Price,s1);

					WebElement totalprice = getElement(AddProductPage.CartSubTotal);
					CartProduct1total= totalprice.getText().trim();
					Assert.assertTrue(CartPrice.contains(CartProduct1total));
					System.out.println("Actual Totalcartprice: " + CartPrice + " Expected Totalcartprice: " + CartProduct1total);
					s1=captureScreenshot();
					Whenlogpass("Assert the TotalcartPrice","Actual Totalcartprice: " + CartPrice + " Expected Totalcartprice: " + CartProduct1total,s1);

				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("Goto cart and assert the product1 price","Not able to get the assert product-1 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s1=captureScreenshot();
			Andlogfail("open cart and check product-1 price and quantity","Not get see product-1 with price",s1);
			Assert.fail("Failure");
		}
	}

	@When("^User search for the p2 (.*) and add the product to cart with q2 (.*)$")
	public void userSearchForTheProduct2AndAddTheProductToCartWithQuantity2(String product,String quantity) throws Throwable {
		ReportCreateScenarioTest("user search for the product-2 and add the product to cart with quantity-1");
		try {
			//Search product2
			driverwait(2000);
			sendKeystoElement(AddProductPage.SearchTab,product);
			String s1=captureScreenshot();
			Whenlogpass("Search for product",product,s1);
			explicitwaitclickable(AddProductPage.SearchIcon);
			clickelement(AddProductPage.SearchIcon);
			driverwait(2000);
			scroll();
			driverwait(2000);
			
			explicitwaitclickable(AddProductPage.FirstSearchResult);
			clickelement(AddProductPage.FirstSearchResult);
			driverwait(2000);

			//product2 title
			WebElement producttitle = getElement(AddProductPage.ProductTitle);
			explicitwaitvisible(AddProductPage.ProductTitle);
			try { 
				if(producttitle.isDisplayed()) 
				{ 
					Product2Title = producttitle.getText().trim();
					System.out.println("Product-2 Title :"+Product2Title);
					s1=captureScreenshot();
					Whenlogpass("Search product-2 title",Product2Title,s1);

				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				Whenlogfail("When user search for product-2 and check it is displayed","Not able to get the product-2 title",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

			//product2 price
			driverwait(2000);
			WebElement productprice = getElement(AddProductPage.ProductWholePrice);
			explicitwaitvisible(AddProductPage.ProductWholePrice);
			WebElement productdecimal = getElement(AddProductPage.ProductDecimalPrice);
			try { 
				if(productprice.isDisplayed()) 
				{
					String ProductPrice1 = productprice.getText(); 
					String ProductPrice2 = "."+productdecimal.getText(); 
					Product2Price = "$"+ProductPrice1.concat(ProductPrice2);
					System.out.println("Product-2 price :"+Product2Price);
					s1=captureScreenshot();
					Whenlogpass("Search product-2 price",Product2Price,s1);		

				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("When user search for product-2 and check it is displayed","Not able to get the product-2 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

			//change product2 quantity
			driverwait(2000);
			scroll();
			explicitwaitclickable(AddProductPage.QuantityBtn);
			clickelement(AddProductPage.QuantityBtn);
			driverwait(2000);
			dropdowncountry(AddProductPage.AddQuantity,quantity);
			s1=captureScreenshot();
			Thenlogpass("Added product2 to cart with quantity-1","Qunatity 2",s1);

			//Addtheproducttocart
			driverwait(2000);
			explicitwaitclickable(AddProductPage.AddToCartBtn);
			clickelement(AddProductPage.AddToCartBtn);
			Thread.sleep(3000);
			s1=captureScreenshot();
			Thenlogpass("Click the Product-2 addtocart","Added Product-2 to cart",s1);

			//Check totalcartprice
			driverwait(2000);
			WebElement cartwholeprice = getElement(AddProductPage.AddCartSubtotalWholePrice);
			explicitwaitvisible(AddProductPage.AddCartSubtotalWholePrice);
			WebElement cartdecimalprice = getElement(AddProductPage.AddCartSubtotalDecimalPrice);
			try { 
				if(cartwholeprice.isDisplayed()) 
				{
					String ProductPrice1 = cartwholeprice.getText(); 
					String ProductPrice2 = "."+cartdecimalprice.getText(); 
					CartPrice = "$"+ProductPrice1.concat(ProductPrice2);
					System.out.println("Product-2 price in cart: "+CartPrice);
					s1=captureScreenshot();
					Whenlogpass("Search product-2 price in cart: ",CartPrice,s1);
				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("When user search for product-2 and check it is displayed","Not able to get the product-2 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}
			System.out.println("Added the product to cart");

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s1=captureScreenshot();
			Whenlogfail("When user search for product-2 and check it is displayed","Not able to get the search the product-2",s1);
			Assert.fail("Failed due to this Exception:"+e);
			Assert.fail("Failure");
		}

	}

	@And("^Check cart and assert the p2 price and quantity$")
	public void checkCartAndAssertTheP2PriceAndQuantity() throws Throwable {
		ReportCreateScenarioTest("Check cart and assert the product-2 price");
		try {
			//gotocart
			driverwait(2000);
			explicitwaitclickable(AddProductPage.CartBasketBtn);
			clickelement(AddProductPage.CartBasketBtn);
			driverwait(2000);

			//Assertprice
			String s1;
			WebElement productprice = getElement(AddProductPage.CartProduct1Price);
			explicitwaitvisible(AddProductPage.CartProduct1Price);
			try { 
				if(productprice.isDisplayed()) 
				{
					CartProduct1Price= productprice.getText().trim(); 
					System.out.println("Product-2 CartPrice: "+CartProduct1Price);
					Assert.assertTrue(Product2Price.contains(CartProduct1Price));
					System.out.println("Actual Price: " + Product2Price + " Expected Price: " + CartProduct1Price);
					s1=captureScreenshot();
					Andlogpass("Assert the Product-2 Price","Actual Price: " + Product2Price + " Expected Price: " + CartProduct1Price,s1);


					WebElement totalprice = getElement(AddProductPage.CartSubTotal);
					CartProduct1total= totalprice.getText().trim();
					Assert.assertTrue(CartPrice.contains(CartProduct1total));
					System.out.println("Actual Totalprice: " + CartPrice + " Expected Totalprice: " + CartProduct1total);
					s1=captureScreenshot();
					Andlogpass("Assert the Product-2 Price","Actual Totalprice: " + CartPrice + " Expected Totalprice: " + CartProduct1total,s1);

				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Whenlogfail("Goto cart and assert the product2 price","Not able to get the assert product-2 price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s1=captureScreenshot();
			Andlogfail("open cart and check product2 price and quantity","Not get see product2 with price and qunatity",s1);
			Assert.fail("Failure");
		}
	}

	@Then("^Change the quantity (.*) for p1 item$")
	public void changeTheQuantityForP1Item(String changequantity) throws Throwable {
		ReportCreateScenarioTest("Change the quantity for p1 item");
		try {
			driverwait(2000);
			scroll();
			explicitwaitclickable(AddProductPage.CartProduct2Qty);
			clickelement(AddProductPage.CartProduct2Qty);
			driverwait(2000);
			dropdowncountry(AddProductPage.AddQuantity,changequantity);
			String s1=captureScreenshot();
			Thenlogpass("Added product1 to cart with quantity-1","Qunatity 1",s1);

		}catch(Exception e) {
			System.out.println("Failed due to Exception:: "+e);
			String s1=captureScreenshot();
			Andlogfail("change the quantity for p1 item","Not able to change the p1 qunatity",s1);
			Assert.fail("Failure");
		}

	}

	@And("^Assert total price and quantity are changed correctly$")
	public void assertTotalPriceAndQuantityAreChangedCorrectly() throws Exception {
		ReportCreateScenarioTest("Assert total price and quantity are changed correctly");
		try {
			//Assertprice
			driverwait(2000);
			
			//price1 calculation based on quantity
			WebElement productp1 = getElement(AddProductPage.CartProduct1Price);
			String price1=productp1.getText().trim(); 
			String split1=price1.substring(1);
			float p1=Float.parseFloat(split1); 
			WebElement productquantity1 = getElement(AddProductPage.Cartp1QtyText);
			String qty1=productquantity1.getText().trim();
			int q1=Integer.parseInt(qty1); 
			float priceval1 = p1*q1;
			System.out.println(priceval1);
			
			//price2 calculation based on quantity
			WebElement productp2 = getElement(AddProductPage.CartProduct2Price);
			String price2=productp2.getText().trim(); 
			String split2=price2.substring(1);
			float p2=Float.parseFloat(split2); 
			WebElement productquantity2 = getElement(AddProductPage.Cartp2QtyText);
			String qty2=productquantity2.getText().trim(); 
			int q2=Integer.parseInt(qty2); 
			float priceval2 = p2*q2;
			System.out.println(priceval2);
			
			//total price calcultaion on cart
			float total1= priceval1 + priceval2;
			float tot= Math.round(total1);
			System.out.println(tot);
			String total2 =String.valueOf(total1);
			System.out.println(total2);
			String total= "$"+total2;
			System.out.println(total);
			
			//Validation for total price 
			String s1;
			WebElement totalprice = getElement(AddProductPage.CartSubTotal);
			explicitwaitvisible(AddProductPage.CartSubTotal);
			try { 
				if(totalprice.isDisplayed()) 
				{
					CartProduct1total= totalprice.getText().trim();
					Assert.assertTrue(total.contains(CartProduct1total));
					System.out.println("Actual CartTotalprice: " + total + " Expected CartTotalprice: " + CartProduct1total);
					s1=captureScreenshot();
					Andlogpass("Assert the TotalPrice in cart","Actual Totalprice: " + total + " Expected Totalprice: " + CartProduct1total,s1);

				} else{ 
					System.out.println("Element not found"); 
				} } 
			catch (Exception e) {
				s1=captureScreenshot();
				Andlogfail("Assert total price and quantity are changed correctly","Not able to assert price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}}catch (Exception e) {
				String s1=captureScreenshot();
				Andlogfail("Assert total price and quantity are changed correctly","Not able to assert price",s1);
				Assert.fail("Failed due to this Exception:"+e);
				e.printStackTrace();
			}

		System.out.println("successfully completed code"); 
		close();
	}
}
