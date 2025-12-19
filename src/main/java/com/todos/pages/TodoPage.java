package com.todos.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.todos.utils.BasePage;

public class TodoPage extends BasePage {

	@FindBy(how = How.ID, using = "todo-input")
	public static WebElement inputText;
	@FindBy(how = How.CSS, using = "label[data-testid='todo-item-label'] ")
	public static WebElement todosText;
	@FindBy(how = How.XPATH, using = "//input[@class=\"toggle\"]")
	public static WebElement checkBox;

	public TodoPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void submitTodo(String todos) {
		inputText.clear();
		inputText.sendKeys(todos);
		inputText.sendKeys(Keys.ENTER);
	}

	public boolean iselementdisplayed(WebElement element) {
		boolean iselementdisplayed = element.isDisplayed();
		return iselementdisplayed;

	}

	public String checkElemenTContain(WebElement element) {
		String elementtodo = element.getText();
		return elementtodo;

	}

	public boolean ischeckboxselected(WebElement element) {
		boolean ischeckboxselected = element.isSelected();
		return ischeckboxselected;

	}
}
