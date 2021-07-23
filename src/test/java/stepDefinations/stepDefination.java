package stepDefinations;

import actions.SearchProduct;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

public class stepDefination extends Base{

	SearchProduct sobj = new SearchProduct();
	
@Given("^I Open FlipKart URL$")
public void i_Open_FlipKart_URL() throws Throwable {
    sobj.openURL();
}

@Given("^Search for Mobile Phone$")
public void search_for_Mobile_Phone() throws Throwable {
	sobj.mobileSearch();
}

@When("^I Found the expected open$")
public void i_Found_the_expected_open() throws Throwable {
    System.out.println("I Found the expected open");
}

@When("^Added to Cart$")
public void added_to_Cart() throws Throwable {
	sobj.addding_to_cart();
	  System.out.println("added to cart");
	
}

@When("^check If correct Product Added$")
public void check_If_correct_Product_Added() throws Throwable {
	sobj.validateCart();  
}

@Then("^I validate the outcomes$")
public void i_validate_the_outcomes() throws Throwable {
	System.out.println("Successfully Validated");
}

@Then("^I close the bowser$")
public void i_close_the_bowser() throws Throwable {
	sobj.closeBrowser();
}

}
