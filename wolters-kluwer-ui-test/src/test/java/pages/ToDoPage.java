package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ToDoPage extends PageObject {

	public ToDoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@class='header']/h1")
	private WebElement header;

	@FindBy(xpath = "//*[contains(@class,'new-todo')]")
	private WebElement textBox;

	@FindBy(xpath = "//*[@class='toggle']")
	private WebElement checkbox;

	@FindBys(@FindBy(xpath = "//li"))
	private List<WebElement> labelList;

	@FindBy(xpath = "//*[@class='destroy']")
	private WebElement deleteButton;

	@FindBy(xpath = "//*[@class='clear-completed']")
	private WebElement clearCompletedButton;

	@FindBy(xpath = "//*[@class='todo-count']/strong")
	private WebElement todoCount;

	public void addToDo(String txt) {
		textBox.sendKeys(txt);
		textBox.sendKeys(Keys.ENTER);
	}

	public void selectToDo(int order) {
		labelList.get(order).findElement(By.cssSelector("div input")).click();
	}

	public void deleteToDo(int order) {
		mauseOver(labelList.get(order));
		waitElementClickble(labelList.get(order).findElement(By.cssSelector("div button")), 30);
		labelList.get(order).findElement(By.cssSelector("div button")).click();
	}

	public void clearToDoList(int order) {
		selectToDo(order);
		clearCompletedButton.click();
	}

	public String getToDoCount() {
		return todoCount.getText();
	}

	public String getHeader() {
		return header.getText();
	}

	public void addMultiToDos(List<String> toDosList) {
		for (int i = 0; i < toDosList.size(); i++) {
			addToDo(toDosList.get(i));
		}
	}

	public void checkToDoList(List<String> toDosList) {
		for (int i = 0; i < toDosList.size(); i++) {
			Assert.assertEquals(toDosList.get(i), labelList.get(i).findElement(By.cssSelector("div label")).getText());
		}
	}

	public void checkToDoCount(String count) {
		Assert.assertEquals(count, todoCount.getText());
	}

	public void updateToDo(int order, String text) {
		WebElement label = labelList.get(order).findElement(By.cssSelector("div label"));
		waitElementClickble(label, 30);
		doubleClick(label);
		WebElement input = labelList.get(order).findElement(By.xpath("//input[@class='edit']"));
		input.clear();
		doubleClick(label);
		input.sendKeys(text);
		input.sendKeys(Keys.ENTER);

	}

	public String getToDoText(int order) {
		
		return labelList.get(order).findElement(By.cssSelector("div label")).getText();
	}
	public int getToDoListSize() {
		return labelList.size();
	}
	
	public boolean checkClearButton() {
		boolean flag=false;
		
		if(driver.findElements(By.className("clear-completed")).size() != 0) {
			flag=true;
		}
		
		return flag;	
	}
	
}
