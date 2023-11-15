package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageLocation;

public class ManageLocationTest extends BaseClass {
	LoginPage lp;
	ManageLocation ml;

	@Test
	public void verifyCancelEdit() {
		lp = new LoginPage(driver);
		ml = new ManageLocation(driver);
		lp.login("admin", "admin");
		ml.manageLocation();
		String urlBefore = ml.getUrl();
		ml.editLocation();
		ml.editState();
		ml.cancelEdit();
		String urlAfter = ml.getUrl();
		Assert.assertEquals(urlBefore, urlAfter, Constant.ml_verifyCancelEdit);
	}
}
