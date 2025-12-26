package com.todos.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



/**
 * This class contains all the methods required by selenium to perform actions
 * on webelement. It is a repository so that same code need not to be written
 * again.
 */
public class SeleniumUtils extends BasePage {

	/** properties. */
	protected Properties properties;

	/** config fis. */
	protected FileInputStream configFis;

	/** driver. */
	private WebDriver driver;

	/**
	 * Instanciation de common utils.
	 * @param driver2 
	 * @throws IOException 
	 */
	public SeleniumUtils() throws IOException {
		super();
		this.driver = Setup.getDriver();
	}
	/**
	 * methode Wait for element to be clickable
	 *
	 * @param locator
	 */
	public void waitForElementToBeClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	/**
	 * Methode click on element.
	 *
	 * @param elementAttr
	 */
	public void click(WebElement elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			waitForElementToBeClickable(elementAttr);
			driver.findElement((By) elementAttr).click();
		} else {
			
elementAttr.click
();
		}
	}

	/**
	 * Accesseur de l attribut page source.
	 *
	 * @return page source
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}


	/**
	 * method to open specified url.
	 *
	 * @param url to open
	 */
	public void get(String url) {
		driver.get(url);
	}

	/**
	 * method to navigate to specified page.
	 *
	 * @param url navigation url
	 */
	public void navigate(String url) {
		driver.navigate().to(url);
	}
	
	public  String getCurrentUrl() {
		//System.out.println
		getDriver().getCurrentUrl();
        return getDriver().getCurrentUrl();       
    }

	

	public void submitTodo(WebElement element, String todo) {
	    element.clear();
	    element.sendKeys(todo);
	    element.sendKeys(Keys.ENTER);
	}

	
	public Boolean isElementDisplayed(WebElement element) {
		
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}
	public String checkElementContain(WebElement element) {
		String elementTodo = element.getText();
		return elementTodo;
	}
	
	public boolean isCheckboxSelected(WebElement element) {
		Boolean isCheckboxSelected = element.isSelected();
		return isCheckboxSelected;
	}
	public void assertTrue(WebElement element, String text) {
		String text1 = element.getText();
		Assert.assertTrue(text1.contains(text));

	}
	public void assertFalse(Boolean condition) {
		Assert.assertFalse(condition);
	}
	/**
	 * method to click on an element with action class.
	 *
	 * @param element to be clicked
	 */
	public void clickOnElementUsingActions (WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		
actions.click
().perform();
	}
	} 