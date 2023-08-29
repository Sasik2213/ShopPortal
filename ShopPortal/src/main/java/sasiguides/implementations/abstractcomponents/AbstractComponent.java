package sasiguides.implementations.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		waits.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		waits.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(3));
		waits.until(ExpectedConditions.visibilityOf(findBy));
	}

}
