package pages;

import helpers.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	private String pageURL = "http://mail.google.com/";

	@FindBy(id = "Email")
	private WebElement login;

	@FindBy(id = "Passwd")
	private WebElement password;

	@FindBy(how = How.ID, using = "signIn")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "next")
	private WebElement nextButton;

	@FindBy(how = How.XPATH, using = "//*[@name = 'PersistentCookie']")
	private WebElement stayLoggedInCheckbox;

	public LoginPage(WebDriver driver) {
		super(driver);
		driver.get(pageURL);
	}

	public void loginUserName(String email) {
		login.clear();
		login.sendKeys(email);
	}

	public void loginUserPass(String pass) {
		password.sendKeys(pass);
	}

	public void stayLoggedInCheckbox() {
		if (stayLoggedInCheckbox.isSelected()) {
			stayLoggedInCheckbox.click();
		}
	}

	public void enterNextButton() {
		nextButton.click();
	}

	public void enterloginButton() {
		loginButton.click();
	}

	public boolean loginToGmail(User user) {
		try {
			this.loginUserName(user.login);
			this.enterNextButton();
			this.loginUserPass(user.password);
			this.stayLoggedInCheckbox();
			this.enterloginButton();
			return true;
		} catch (Exception ex) {
		}
		return false;
	}
}
