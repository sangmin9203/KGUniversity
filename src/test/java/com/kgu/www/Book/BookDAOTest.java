package com.kgu.www.Book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgu.www.Book.persistence.BookDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BookDAOTest.class);
	
	@Autowired
	private BookDAO bdao;
	
	@Test
	public void testDelete() throws Exception {
		String book_name = "1";
		bdao.deleteBook(book_name);
	}
}
