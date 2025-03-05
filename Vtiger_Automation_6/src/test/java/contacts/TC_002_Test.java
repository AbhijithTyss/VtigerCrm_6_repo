package contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.vtiger.genericutility.BaseClass;
import com.vtiger.genericutility.ListenerUtility;
import com.vtiger.objectrepository.ContactsPage;
import com.vtiger.objectrepository.CreateContactPage;
import com.vtiger.objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_002_Test extends BaseClass{
	@Test
	public void createContact() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateIcon().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnameTextField().sendKeys(eUtil.getStringDataFromExcel("Contacts", 1, 0));
		
		ccp.getSaveButton().click();
		
		Assert.assertEquals(ccp.getHeaderText().getText().contains(eUtil.getStringDataFromExcel("Contacts", 1, 1)),true ,"Contact is not created");
		test.log(Status.PASS, "Contact is created");
	}
}
