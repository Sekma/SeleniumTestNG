package com.todos.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.SeleniumUtils;
import com.todos.utils.Setup;


public class RemoveTodo extends Setup {
	
	public SeleniumUtils utils;
	TodoPage todopage;
	
	public RemoveTodo() throws IOException {
		super();
		utils = new SeleniumUtils();
	}
	@Test
	public void IcanRemoveTodo() throws IOException, InterruptedException {
		todopage = new TodoPage();
		utils.submitTodo(TodoPage.inputText, prop.getProperty("todos1"));
		
		utils.click(TodoPage.checkBox);
		//Thread.sleep(3000);
		utils.click(TodoPage.removeBtn);
		
		String pageSource = todopage.getPageSource();
		Assert.assertFalse(pageSource.contains(prop.getProperty("todos1")));
		System.out.println("input removed");
	}
	

}
