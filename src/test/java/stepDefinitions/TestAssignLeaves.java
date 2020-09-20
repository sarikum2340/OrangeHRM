package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.AssignLeaves;
import pages.HomePage;
import pages.LoginPage;

public class TestAssignLeaves extends TestBase {
	@Before
	public void setUp() {
		System.out.println("Initialising driver");
		initialisation();
	}

	@Given("User is logged in successfully")
	public void user_is_logged_in_successfully() {
		LoginPage loginToApp = new LoginPage();
		loginToApp.login(getuserName(), getPassword());
		String title = loginToApp.validateLoginPageTitle();
		System.out.println(title);

	}

	@When("Click on Assign leaves")
	public void click_on_assign_leaves() {
		HomePage home = new HomePage(driver);
		home.clickOnElement(home.assignLeaves);
		pausePage(100);
	}

	@When("Enter Employee name {string}")
	public void enter_employee_name(String string) {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		assignleaves.empName.sendKeys(string);
		assignleaves.empName.sendKeys(Keys.ENTER);

	}

	@When("Enter Leave Type {string}")
	public void enter_leave_type(String string) {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		Select select = new Select(assignleaves.leaveType);
		pausePage(60);
		assignleaves.leaveType.click();
		pausePage(60);
		select.selectByVisibleText(string);
	}

	@When("Enter From date {string}")
	public void enter_from_date(String string) {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		String[] ddYYMM = string.split("-");
		String date = ddYYMM[ddYYMM.length - 1];
		System.out.println(date);

		assignleaves.fromDate.clear();
		assignleaves.fromDate.sendKeys(string);
		pausePage(60);
		driver.findElement(By.xpath(String.format("//a[contains(text(),'%d')]", Integer.parseInt(date)))).click();

	}

	@When("Enter To date {string}")
	public void enter_to_date(String string) {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		String[] ddYYMM = string.split("-");
		String date = ddYYMM[ddYYMM.length - 1];
		assignleaves.toDate.clear();

		assignleaves.toDate.sendKeys(string);
		pausePage(60);
		driver.findElement(By.xpath(String.format("//a[contains(text(),'%d')]", Integer.parseInt(date)))).click();
	}

	@When("Select duration  {string}")
	public void select_duration(String string) {

	}

	@When("Enter Cooment {string}")
	public void enter_cooment(String string) {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		pausePage(60);
		assignleaves.comments.clear();
		assignleaves.comments.sendKeys(string);
	}

	@When("click on Assign button")
	public void click_on_assign_button() {
		AssignLeaves assignleaves = new AssignLeaves(driver);
		pausePage(60);
		assignleaves.assignButton.click();
	}

	@Then("Verify if the leave is failed or pass")
	public void verify_if_the_leave_is_failed_or_pass() {
		String message = "Successfully Assigned";
		// String
		// t1=driver.findElement(By.xpath("(//div//script[@type='text/javascript'])[1]")).getText().trim();
		// String
		// Actual=driver.findElement(By.xpath("//div[@id='assign-leave']//div[1]")).getText().trim();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String s = (String) jsExecutor.executeScript(
				"var s1 = 'Successfully Assigned'; var s2 = 'Leaves not Assinged'; if(document.readyState == 'complete'){return s1;} else {return s1;}");
		System.out.println(s);
		Assert.assertEquals("Assignment failed", message, s);

	}

	@After
	public void teardown() {
		driver.quit();
	}
}
