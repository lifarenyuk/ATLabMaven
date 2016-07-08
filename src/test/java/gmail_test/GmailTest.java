package gmail_test;

import helpers.User;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.ImportantPage;
import pages.LoginPage;

public class GmailTest {
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ImportantPage importantPage;
	WebDriverWait wait;
	User user;
	
	@BeforeClass
	public void initDriver() throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test(priority=1)
	public void testLogin(){
		user = new User("lifarenyuk123","iddqd348");
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.loginToGmail(user));
		
	}
	
	@Test(priority=2)
	public void testCheckImportant(){
		homePage = new HomePage(driver);
		homePage.markAsImportant(3, driver);
		homePage.toImportantPage();
	
	}
		
	@Test(priority=3)
	public void testImportantMess(){
		importantPage = new ImportantPage(driver);
		importantPage.getChecked();
		importantPage.checkElements(homePage.getMarkedList());
		
		//Assert.assertTrue(importantPage.deleteCheckedElements());
		//importantPage.deleteCheckedElements();
		//importantPage.toTrash();
	}
	

	@Test(priority=4)
	public void testDeletingMessages(){
		//driver.close();
	}
}

