package testCase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.HomePage;
import elementrepository.LoginPage;

import org.testng.Assert;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "pdw" }, { "pdw", "admin" } };
	}

	@DataProvider(name = "data-provider1")
	public Object[][] dpMethod1() {
		return new Object[][] { { " ", " " }, { " ", "admin" } };
	}

	@DataProvider(name = "data-provider2")
	public Object[][] dpMethod2() {
		return new Object[][] { { "admin", " " } };
	}

	@Test(enabled = false)
	void verifyExcelLogin() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.login();
		String expected = "Admin";
		String actual = hp.readAdminTxt();
		Assert.assertEquals(actual, expected, Constant.lp_verifyExcelLogin);
	}

	@Test
	void verifyLogin() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.login("admin", "admin");
		String expected = "Admin";
		String actual = hp.readAdminTxt();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogin);
	}

	@Test(dataProvider = "data-provider")
	public void verifyLoginError(String nm, String pd) {
		lp = new LoginPage(driver);
		lp.login(nm, pd);
		String expected = "×\nAlert!\nInvalid Username/Password";
		String actual = lp.readAlert1();
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginError);
	}

	@Test(dataProvider = "data-provider1")
	public void verifyBlankUsrnameError(String nm, String pd) {
		lp = new LoginPage(driver);
		lp.login(nm, pd);
		String expected = "The username field is required.";
		String actual = lp.readAlert2();
		Assert.assertEquals(actual, expected, Constant.lp_verifyBlankUsrnameError);
	}

	@Test(dataProvider = "data-provider2")
	public void verifyBlankPwdError(String nm, String pd) {
		lp = new LoginPage(driver);
		lp.login(nm, pd);
		String expected = "The password field is required.";
		String actual = lp.readAlert2();
		Assert.assertEquals(actual, expected, Constant.lp_verifyBlankPwdError);
	}
}
