package sasiguidess.implementations.testcomponents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import sasiguides.implementations.ProductCataloguePage;

public class ErrorValidations extends BaseTest{
//	,retryAnalyzer = Retry.class
	@Test(groups = {"ErrorHandling"})
	public void Submit() throws IOException,InterruptedException{
		landingPage.loginActions("sasikiran2213@gmail.com", "Sasikiran@2213");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
		
	}
	
	public void LoginErrorValidation() throws IOException,InterruptedException{
		String productName = "ZARA COAT 3";
		ProductCataloguePage cataloguePage = landingPage.loginActions("sasikiran2213@gmail.com","Sasikiran@2213");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
	
		
	}

}