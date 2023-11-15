package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementrepository.LoginPage;
import elementrepository.ManageSlider;

public class ManageSliderTest extends BaseClass {
	LoginPage lp;
	ManageSlider ms;
	String path1 = " C:\\Users\\SANDEEP\\Downloads\\OIPAirpod.jpg";
	String link1 = "https://airpodimagetesting";

	@Test(enabled = false)
	public void verifyManageSlider() {
		lp = new LoginPage(driver);
		ms = new ManageSlider(driver);
		lp.login("admin", "admin");
		ms.manageSlider();
	}

	@Test
	public void verifyEditElement() {
		lp = new LoginPage(driver);
		ms = new ManageSlider(driver);

		lp.login("admin", "admin");
		ms.manageSlider();
		ms.editElement();
		ms.imageUpload(path1);
		ms.deleteExistngImage();
		ms.acceptAlert();
		ms.updateLink(link1);
		ms.updateElement();
		String actual = ms.readAlertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Update clider ider error");
	}
}
