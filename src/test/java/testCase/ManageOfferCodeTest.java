package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageOfferCode;

public class ManageOfferCodeTest extends BaseClass {
	LoginPage lp;
	ManageOfferCode moc;

	
  @Test
  public void verifyEditOfferCode() {
	  lp=new LoginPage(driver);
	  moc=new ManageOfferCode(driver);
	  lp.login("admin", "admin");
	  moc.clickManageOfferCode();
	  moc.editManageOffer();
	  String expectedOfferCode=moc.editOfferCode();
	  moc.enterRBtn();
	  moc.enterPercentage();
	  moc.enterAmount();
	  moc.enterDescription();
	  moc.enterLinkText("Test");
	  moc.enterLinkUrl("www.google.com");
	  moc.insertLink();
	  moc.updateChanges();
	  String actualOfferCode=moc.getOfferCode();
	  String actual=moc.readAlert();
	  String expected="×\nAlert!\nOffer Code Updated Successfully";
	  Assert.assertEquals(actual,expected,Constant.moc_verifyEditOfferCode);	
	  Assert.assertEquals(actualOfferCode,expectedOfferCode,Constant.moc_verifyEditOfferCode1);	  
  }
}
