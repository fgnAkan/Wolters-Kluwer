package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	protected WebDriver driver;

	Actions act;
	WebDriverWait wait;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void mauseOver(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void waitElementClickble(WebElement element, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitElementAttribute(WebElement element, String attribute, String value, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

}
