package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import elementrepository.LoginPage;
import elementrepository.ManageProducts;

public class ManageProductsTest extends BaseClass {
	LoginPage lp;
	ManageProducts mp;

	@Test(enabled = false)
	public void verifyMangePdtPage() {
		lp = new LoginPage(driver);
		mp = new ManageProducts(driver);
		lp.login("admin", "admin");
		mp.clickManagePdt();
		String expected = "List Products";
		String actual = mp.readListPdt();
		Assert.assertEquals(actual, expected, ":Manage Product not navigated");
	}

	@Test
	public void verifyStockUpdate() {
		lp = new LoginPage(driver);
		mp = new ManageProducts(driver);
		lp.login("admin", "admin");
		mp.clickManagePdt();
		String stockBefore = mp.readPdtStkAvliblty("P1164");
		mp.editPdtStkAvliblty();
		String stockAfter = mp.readPdtStkAvliblty("P1164");
		if (stockBefore == "Yes") {
			Assert.assertEquals(stockAfter, "No", ":Stock availability not updated to No from Yes");
		} else if (stockBefore == "No") {
			Assert.assertEquals(stockAfter, "Yes", ":Stock availability not updated to Yes from No");
		}
		String expected = "×\nAlert!\nProduct Status Changed Successfully";
		String actual = mp.readEditStkAvliblty();
		Assert.assertEquals(actual, expected, ":Stock availability edit error");
	}
}
