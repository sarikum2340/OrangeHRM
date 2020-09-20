package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//span[contains(text(),'Assign Leave')]")
	public WebElement assignLeaves;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public boolean clickOnElement(WebElement element) {
		try {
			element.click();

		} catch (NoSuchElementException e) {
			System.out.println("Element not present");
		}
		return false;

	}
}