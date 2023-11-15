package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageContent;

public class ManageContentTest extends BaseClass {
	ManageContent mc;
	LoginPage lp;

	@Test
	public void verifyAddPage() {
		lp = new LoginPage(driver);
		mc = new ManageContent(driver);
		lp.login("admin", "admin");
		mc.manageContentClick();
		mc.managePagesClick();
		mc.newBtnClick();
		mc.newPageTiltle();
		mc.enterFontDetails();
		mc.enterDescription("Hello World");
		mc.enterPageDetails("TestPg1");
		mc.saveDetails();
		mc.previousPage();
		String expected = "×\nAlert!\nPage Created Successfully";
		String actual = mc.readPageCreatedMsg();
		Assert.assertEquals(actual, expected, Constant.mc_verifyAddPage);
	}

	@Test
	public void verifyInvalidImageUpload() {
		lp = new LoginPage(driver);
		mc = new ManageContent(driver);
		lp.login("admin", "admin");
		mc.manageContentClick();
		mc.managePagesClick();
		mc.editAddInvalidImage();
		mc.uploadImage();
		mc.updateDetail();
		String expected = "×\nAlert!\nImage does not have a valid mime type.";
		String actual = mc.readAlertFailMsg();
		Assert.assertEquals(actual, expected, Constant.mc_verifyInvalidImageUpload);
	}
}
