package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageDelhiveryBoy;

public class ManageDelhiveryBoyTest extends BaseClass {
	LoginPage lp;
	ManageDelhiveryBoy mdb;

	@Test
	public void verifyAddDboy() {
		lp = new LoginPage(driver);
		mdb = new ManageDelhiveryBoy(driver);
		lp.login("admin", "admin");
		mdb.clickManageDelhiveryBoy();
		mdb.addNewDBoy();
		String expectedName = mdb.enterName();
		String expectedEmail = mdb.enterEmail();
		String expectedPhone = mdb.enterPhone();
		String expectedUName = mdb.enterUserName();
		String expectedPwd = mdb.enterPwd();
		mdb.saveDBoyAdded();
		String actualName = mdb.readName();
		String actualEmail = mdb.readEmail();
		String actualPhone = mdb.readPhone();
		String actualUName = mdb.readUserName();
		String actualPwd = mdb.readPwd();
		Assert.assertEquals(actualName, expectedName, Constant.mdb_verifyAddDboy);
		Assert.assertEquals(actualEmail, expectedEmail, Constant.mdb_verifyAddDboy1);
		Assert.assertEquals(actualPhone, expectedPhone, Constant.mdb_verifyAddDboy2);
		Assert.assertEquals(actualUName, expectedUName, Constant.mdb_verifyAddDboy3);
		Assert.assertEquals(actualPwd, expectedPwd, Constant.mdb_verifyAddDboy4);
	}

	@Test()
	public void verifyEditDboy() {
		lp = new LoginPage(driver);
		mdb = new ManageDelhiveryBoy(driver);
		lp.login("admin", "admin");
		mdb.clickManageDelhiveryBoy();
		mdb.getEditLocator();
		String pwdBefore = mdb.readEditPwd();
		mdb.editDboy();
		String expectedPwd = mdb.editPwd();
		mdb.updateChanges();
		String actualPwd = mdb.readEditPwd();
		Assert.assertNotEquals(actualPwd, pwdBefore, Constant.mdb_verifyEditDboy);
		Assert.assertEquals(actualPwd, expectedPwd, Constant.mdb_verifyEditDboy1);
	}
}
