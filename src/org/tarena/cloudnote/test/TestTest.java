package org.tarena.cloudnote.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.cloudnote.dao.AssociationDAO;
import org.tarena.cloudnote.entity.NoteBook;

public class TestTest {

	@Test
	public void Test01(){
		ApplicationContext ac=
			new ClassPathXmlApplicationContext("applicationContext.xml");
		AssociationDAO dao=ac.getBean("associationDAO", AssociationDAO.class);
		List<NoteBook> noteBooks=dao.findNoteBooksAndUser2();
		for (NoteBook noteBook : noteBooks) {
			System.out.print(noteBook.getCn_notebook_name()+"==>");
			System.out.println(noteBook.getUser().getCn_user_name());
			System.out.println("-----------");
		}
	}
}