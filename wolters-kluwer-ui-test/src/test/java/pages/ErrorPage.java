package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends PageObject {

	public ErrorPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='container']/h1")
	private WebElement header;

	public String getHeader() {
		return header.getText();
	}

}
