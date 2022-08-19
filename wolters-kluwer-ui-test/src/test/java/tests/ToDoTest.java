package tests;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.ErrorPage;
import pages.ToDoPage;
import utils.BrowserType;
import utils.Common;
import utils.Driver;

public class ToDoTest extends Driver {

	public ToDoTest() {
		super(BrowserType.firefox);
	}

	public ToDoPage page;
	public ErrorPage error;
	Common cmn = new Common();

	@Test(priority = 0)
	public void addToDo() {
		this.page = new ToDoPage(driver);
		Assert.assertEquals(page.getHeader(), "todos");
		List<String> lst = cmn.generateList(5);
		page.addMultiToDos(lst);
		page.checkToDoList(lst);
		page.checkToDoCount("5");

	}

	@Test(priority = 1)
	public void deleteToDo() {
		page.deleteToDo(0);
		page.checkToDoCount("4");
	}

	@Test(priority = 2)
	public void updateToDo() {
		page.updateToDo(0, "figen");
		Assert.assertEquals("figen", page.getToDoText(0));
		page.checkToDoCount("4");
	}

	@Test(priority = 3)
	public void clearToDo() {
		page.clearToDoList(1);
		page.checkToDoCount("3");
	}

	@Test(priority = 4)
	public void checkLongSpace() {
		page.addToDo("figen        akan");
		Assert.assertEquals("figen akan", page.getToDoText(page.getToDoListSize()-1));
	}
	@Test(priority = 5)
	public void checkClearCompletedButton() {
		Assert.assertFalse(page.checkClearButton());
		page.selectToDo(2);
		Assert.assertTrue(page.checkClearButton());
	}
	
	@Test(priority = 6)
	public void updateToDoWithNull() {
		page.addToDo("test test");
		Assert.assertEquals("test test", page.getToDoText(page.getToDoListSize()-1));
		page.updateToDo(page.getToDoListSize()-1, "   ");
		Assert.assertNotEquals(page.getToDoListSize()-1, "test test");

	}

	@Test(priority = 7)
	public void getInvalidUrl() {
		getUrl("https://todomvc.com/examples/angular2/22");
		this.error = new ErrorPage(driver);
		Assert.assertEquals("404", error.getHeader());
	}

}
