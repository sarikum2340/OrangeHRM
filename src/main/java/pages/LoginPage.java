package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;
	@FindBy(id = "btnLogin")
	public WebElement btnLogin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public void login(String Username, String Password) {
		try {
			username.clear();
			username.sendKeys(Username);
			password.clear();
			password.sendKeys(Password);
			btnLogin.click();
		}

		catch (NoSuchElementException e) {
			System.out.println("Login fail");
		}

	}
}
