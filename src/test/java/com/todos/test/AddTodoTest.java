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
		boolean todofield = todopage.iselementdisplayed(TodoPage.inputText);
		Assert.assertTrue(todofield);
		todopage.submitTodo(prop.getProperty("todos1"));
		String elementtodo = todopage.checkElemenTContain(TodoPage.todosText);
		Assert.assertTrue(elementtodo.contains(prop.getProperty("todos1")));
		boolean checkbox = todopage.ischeckboxselected(TodoPage.checkBox);
		Assert.assertFalse(checkbox);

	}

}