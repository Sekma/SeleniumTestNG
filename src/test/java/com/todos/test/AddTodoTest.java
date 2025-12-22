package com.todos.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.todos.pages.TodoPage;
import com.todos.utils.Setup;

public class AddTodoTest extends Setup {

	public AddTodoTest() throws IOException {
		super();
	}

	TodoPage todopage;

	@Test(priority = 1)
	public void IcanAddTodo() throws IOException {
		todopage = new TodoPage();
		
		boolean todoField = todopage.isElementDisplayed(TodoPage.inputText);
		Assert.assertTrue(todoField);
		// enter todo 1
		todopage.submitTodo(1);
		String elementTodo = todopage.checkElementContaint(1);
		Assert.assertTrue(elementTodo.contains(todopage.todoToSubmit(1)));
		// verify is it not checked by default
		boolean checkBox = todopage.isCheckBoxSelected(todopage.checkBox(1));
		Assert.assertFalse(checkBox);
		
		// enter todo 2 and todo 3
		todopage.submitTodo(2);
		todopage.submitTodo(3);
		// delete todo 2
		todopage.destroyElement(2).click();
	}

}