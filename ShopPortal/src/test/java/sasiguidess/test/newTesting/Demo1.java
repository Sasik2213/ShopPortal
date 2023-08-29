package sasiguidess.test.newTesting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sasiguides.implementations.CartPage;
import sasiguides.implementations.CheckoutPage;
import sasiguides.implementations.ConfirmationPage;
import sasiguides.implementations.OrderPage;
import sasiguides.implementations.ProductCataloguePage;
import sasiguidess.implementations.testcomponents.BaseTest;

public class Demo1 extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String, String>input) throws IOException, InterruptedException, FileNotFoundException {

//		LoginLandingPage landingPage = launchApplication();
		ProductCataloguePage productCataloguePage = landingPage.loginActions(input.get("email"), input.get("password"));
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
//		
//		Actions actions = new Actions(driver);
//	actions.click(driver.findElement(By.xpath("//input[@id='userEmail']"))).sendKeys("sasikiran2213@gmail.com")
//				.build().perform();
//		actions.click(driver.findElement(By.xpath("//input[@id='userPassword']"))).sendKeys("Sasikiran@2213").build()
//			.perform();
//		actions.click(driver.findElement(By.xpath("//input[@id='login']"))).build().perform();
//		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
//		LoginLandingPage landingPage = new LoginLandingPage(driver);
//		landingPage.goToSite();
//		ProductCataloguePage productCataloguePage = landingPage.loginActions("sasikiran2213@gmail.com",
//				"Sasikiran@2213");
		List<WebElement> products = productCataloguePage.getProductList();
		productCataloguePage.addProductToCart(input.get("product"));

//		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod = products.stream()
//				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
//				.orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		waits.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		productCataloguePage.gotoCartPage();
//		

		CartPage cartPage = productCataloguePage.gotoCartPage();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build()
//				.perform();
//		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistroyTest() {

		ProductCataloguePage productCataloguePage = landingPage.loginActions("sasikirank@gmail.com", "Sasikiran@123");
		OrderPage orderPage = productCataloguePage.gotoOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String>map = new HashMap<String,String>();
//		map.put("email", "sasikiran2213@gmail.com");
//		map.put("password", "Sasikiran@2213");
//		map.put("product", "ZARA COAT 3");
//		HashMap<String,String>map1 = new HashMap<String,String>();
//		map1.put("email", "sasikiran2213@gmail.com");
//		map1.put("password", "Sasikiran@2213");
//		map1.put("product", "ZARA COAT 3");
	List<HashMap<String, String>>data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//org//data//jsonfiles//PurchaseOrder.json");
	return	new Object[][]{{data.get(0)},{data.get(1)}};
//	
//	
	}
}