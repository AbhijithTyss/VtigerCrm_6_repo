package contacts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.vtiger.genericutility.BaseClass;
import com.vtiger.genericutility.ListenerUtility;
import com.vtiger.objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_001_Test extends BaseClass{
	@Test
	public void clickOnContacts() {
		hp=new HomePage(driver);
		hp.getContactsLink().click();
		Assert.assertEquals(driver.getTitle(), " Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
		
		test.log(Status.PASS, "Contacts page is displayed");
	}
}
