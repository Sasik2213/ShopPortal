package sasiguides.implementations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sasiguides.implementations.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement>productNames;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match=productNames.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return match;
	}
//	
//	public CheckoutPage goToCheckOut() {
//		checkoutEle.click();
//		return new CheckoutPage(driver);
//	}
	
}
