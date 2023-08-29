package sasiguides.implementations;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sasiguides.implementations.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	@FindBy(css = ".cartSection h3")
	private List<WebElement>cartProducts;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match=cartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
	
}
