package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.AdminUsers;
import elementrepository.LoginPage;

public class AdminUsersTest extends BaseClass {
	LoginPage lp;
	AdminUsers au;

	@Test
	public void verifyAdminUsers() {
		lp = new LoginPage(driver);
		au = new AdminUsers(driver);
		lp.login("admin", "admin");
		au.clickAdminUsers();
		au.getColumnSize();
		String oldPwd = au.getPassword();
		au.editAdminUser();
		au.enterPassword();
		au.updateChanges();
		String newPwd = au.getPassword();
		String expected = "\u00D7\nAlert!\nUser Updated Successfully";
		String actual = au.readUpdateSuccessMsg();
		Assert.assertEquals(actual, expected, Constant.au_verifyAdminUsers);
		Assert.assertNotEquals(oldPwd, newPwd, Constant.au_verifyAdminUsers1);
	}
}
