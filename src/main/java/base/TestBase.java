package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	protected static WebDriver driver;
	protected static Properties prop;

	protected static final String PROPERTIES_FILE_PATH = "./OrangeHRM.properties";
	protected static final String PROPERTIES_FILE_URL = "URL";
	protected static final String CHROME_PATH = "chrome";
	protected static final String USERNAME = "username";
	protected static final String PASSWORD = "password";

	public TestBase() {

		// System.out.println(new File(".").getAbsolutePath());
		
		try {
			InputStream file = new FileInputStream(new File(PROPERTIES_FILE_PATH));
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

	public void initialisation() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty(CHROME_PATH));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty(PROPERTIES_FILE_URL));
	}

	public String getuserName() {
		return prop.getProperty(USERNAME);
	}

	public String getPassword() {
		return prop.getProperty(PASSWORD);
	}

	public void pausePage(int durationInMillis) {
		try {
			Thread.sleep(durationInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
