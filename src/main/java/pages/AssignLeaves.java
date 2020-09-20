package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AssignLeaves extends TestBase{
	
	@FindBy(id="assignleave_txtEmployee_empName")
	public WebElement empName;
	
	@FindBy(xpath="//select[@id='assignleave_txtLeaveType']")
	public WebElement leaveType;
	
	@FindBy(id="assignleave_txtFromDate")
	public WebElement fromDate;
	
	@FindBy(id="assignleave_txtToDate")
	public WebElement toDate;
	
	@FindBy(id="assignleave_txtComment")
	public WebElement comments;
	@FindBy(id="assignBtn")
	public WebElement assignButton;
		
	public AssignLeaves(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}
