package com.nuvolarworks.log.locators;

import org.openqa.selenium.support.PageFactory;
import com.nuvolarworks.testbase.TestBase;

public class AddProductPage extends TestBase{
	public AddProductPage() {

		PageFactory.initElements(driver, this);
	}

	public static final String SearchTab= "xpath==//input[@id='twotabsearchtextbox']";
	public static final String LocationName= "xpath==//span[@class='nav-line-2 nav-progressive-content']";
	public static final String Location= "xpath==//a[@id='nav-global-location-popover-link']";
	public static final String LocationChangeIcon= "xpath==//div[@class=' a-declarative']";
	public static final String LocationChangeDrpdwn= "xpath==//ul[@class='a-nostyle a-list-link']//li";
	public static final String DoneBtn= "xpath==//button[contains(text(),'Done')]";
	public static final String SearchIcon= "xpath==//input[@id='nav-search-submit-button']";
	public static final String FirstSearchResult= "xpath==//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']";
	public static final String ProductTitle= "xpath==//span[@id='productTitle']";
	public static final String ProductWholePrice= "xpath==//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']";
	public static final String ProductDecimalPrice= "xpath==//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-fraction']";
	public static final String QuantityBtn= "xpath==//span[contains(text(),'Qty')]";
	public static final String AddQuantity= "xpath==//ul[@class='a-nostyle a-list-link']//li";
	public static final String AddToCartBtn= "xpath==//input[@id='add-to-cart-button']";
	public static final String CartBasketBtn= "xpath==//span[@id='nav-cart-count']";
	public static final String Cartp1QtyText= "xpath==(//span[@class='a-dropdown-prompt'])[1]";
	public static final String Cartp2QtyText= "xpath==(//span[@class='a-dropdown-prompt'])[2]";
	public static final String AddCartSubtotalWholePrice= "xpath==(//span[contains(@class,'a-price-whole')])[1]";
	public static final String AddCartSubtotalDecimalPrice= "xpath==(//span[contains(@class,'a-price-fraction')])[1]";
	public static final	String CartProduct1Title= "xpath==(//li//span[@class='a-size-medium a-color-base sc-product-title'])[1]";
	public static final	String CartProduct2Title= "xpath==(//li//span[@class='a-size-medium a-color-base sc-product-title'])[2]";
	public static final	String CartProduct1Price= "xpath==(//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold')])[1]";
	public static final	String CartProduct2Price= "xpath==(//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold')])[2]";
	public static final	String CartProduct1Qty= "xpath==(//span[@class='a-dropdown-label'][contains(.,'Qty:')])[1]";
	public static final	String CartProduct2Qty= "xpath==(//span[@class='a-dropdown-label'][contains(.,'Qty:')])[2]";
	public static final	String CartSubTotal= "xpath==//span[@id='sc-subtotal-amount-activecart']";
	
	public static final String Url="https://www.amazon.com";
	
}
