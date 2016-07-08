package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportantPage extends BasePage {

	private WebDriverWait wait;

	@FindBy(xpath = "//*[@class='oZ-x3 xY']/div[@role='checkbox']")
	private List<WebElement> checkboxList;

	@FindBy(xpath = "//*[@class='aeH']/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")
	private WebElement deleteButton;

	@FindBy(xpath = "//input[@id ='gbqfq']")
	private WebElement toTrush;

	@FindBy(xpath = "//*[@id='gbqfb']")
	private WebElement findInGmailButton;

	@FindBy(xpath = "//*[@class='y6']/span[1]")
	private List<WebElement> currTitles;

	public ImportantPage(WebDriver driver) {
		super(driver);
	}

	public void getChecked(){
		for(int i = 0; i<checkboxList.size(); i++){
			if (checkboxList.get(i).isDisplayed()){
				System.out.println(i);
			}
		}
	}
	
	public void checkElements(List<String>listOfMarkedElements) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.xpath("//div[@class='aAA J-KU-Jg J-KU-Jg-K9']")));
		
		for (WebElement currTitle : currTitles) {
			for (String markedTitle : listOfMarkedElements) {
				if (currTitle.isDisplayed()) {
					if (currTitle.getText().equals(markedTitle)) {
						System.out.println(currTitles.indexOf(currTitle));
					}
				}
			}
		}
	}

	public boolean deleteCheckedElements() {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			deleteButton.click();
			return true;
		} catch (Exception ex) {
		}
		return false;
	}

	public void toTrash() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(toTrush));
		
		toTrush.clear();
		toTrush.sendKeys("in:trash");
		findInGmailButton.click();
	}
}
