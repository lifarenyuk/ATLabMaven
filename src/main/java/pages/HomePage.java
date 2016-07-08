package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	private List<String>titles;
	
	@FindAll(@FindBy(xpath = "//*[@class='y6']/span[1]"))
	public List<WebElement> listOfTitles;

	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#imp']")
	private WebElement toImportantPage;

	@FindAll(@FindBy(xpath = "//div[@class='pG']/div[@class='pH-A7 a9q']"))
	private List<WebElement> notMarkedMails;

	public HomePage(WebDriver driver) {
		super(driver);
	}	
	
	public void markAsImportant(int numberOf, WebDriver driver) {
		List<WebElement> notMarkedMails = driver.findElements(By
				.cssSelector(".pH-A7.a9q"));
		for (int i = 0; i < numberOf; i++) {
			notMarkedMails.get(i).click();
		}
		updateMarkedLists(numberOf);
	}

	private void updateMarkedLists(int numberOf){
		titles = new ArrayList<String>();
		listOfTitles = listOfTitles.subList(0, numberOf);
		for(WebElement el: listOfTitles){
			titles.add(el.getText());
		}
	}
	
	public List<String>getMarkedList(){
		return titles;
	}
	
	public void toImportantPage() {
		toImportantPage.click();
	}
}
