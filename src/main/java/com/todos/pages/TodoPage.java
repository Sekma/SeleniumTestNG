package com.todos.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.todos.utils.BasePage;

public class TodoPage extends BasePage {

    /**Elements**/
	@FindBy(how = How.ID, using = "todo-input")
	public static WebElement inputText;
	
	/**Methods**/
	public TodoPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	// Method to generate todos
	public String todoToSubmit(int num) {
		String todo = prop.getProperty("todos."+num);
		return todo;
	}
	
	// Method to find todo By Text
	public WebElement todoText(int num) {		
	    return driver.findElement(By.xpath("//li//label[text()='"+todoToSubmit(num)+"']")
	    );
	}
	// Method to find checkBox By Text
	public WebElement checkBox(int num) {
	    return driver.findElement(By.xpath("//label[text()='"+todoToSubmit(num)+"']/preceding-sibling::input[@type='checkbox']")
	    );
	}
	// Method to find destroyButton By Text
	public WebElement destroyButton(int num) {
	    return driver.findElement(By.xpath("//label[text()='"+todoToSubmit(num)+"']/following-sibling::button[contains(@class,'destroy')]")
	    );
	}
	
	
	// Method to verify if the input is displayed
	public boolean isElementDisplayed(WebElement element) {
		boolean iselementdisplayed = element.isDisplayed();
		return iselementdisplayed;
	}
	// Method to enter a new todo
	public void submitTodo(int num) {
		inputText.clear();
		inputText.sendKeys(todoToSubmit(num));
		inputText.sendKeys(Keys.ENTER);
	}

    // Method to get text for todo element
	public String checkElementContaint(int num) {
		String elementTodo = todoText(num).getText();
		return elementTodo;
	}
	// Method to verify checkbox of todo
	public boolean isCheckBoxSelected(WebElement element) {
		boolean isCheckBoxSelected = element.isSelected();
		return isCheckBoxSelected;
	}
	
	public WebElement destroyElement(int num) {
		// hover on element todosText to display the destroyButton.
		Actions action = new Actions(driver);
		action.moveToElement(todoText(num)).perform();
		// find the button
		 return destroyButton(num);
	}

}
