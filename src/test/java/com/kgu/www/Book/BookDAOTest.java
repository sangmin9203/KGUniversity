package com.kgu.www.Book;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgu.www.Book.paging.SupPaging;
import com.kgu.www.Book.persistence.BookDAO;
import com.kgu.www.Book.vo.BookVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BookDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BookDAOTest.class);
	
	@Autowired
	private BookDAO bdao;
	
	/*//db 입력 테스트
	@Test
	public void testCreate() throws Exception {
		BookVO bvo = new BookVO();
		for(int i = 0; i<=100; i++) {
		bvo.setBook_picture(i+"번째글");
		bvo.setBook_name(i+"번째글");
		bvo.setBook_writer("글쓴이");
		bvo.setBook_price(100);
		bvo.setBook_info("1");
		bvo.setBook_mokcha("1");
		bvo.setBook_inventory(20);
		
		bdao.bookInsertForm(bvo);
		}
	}*/
	
	//페이징 처리 테스트
	/*@Test
	public void testlistPaging() throws Exception {
		int Page = 3;
		List<BookVO> list = bdao.listPaging(Page);
		
		for(BookVO bvo : list) {
			logger.info(bvo.getBook_name());
		}
	}*/
	
	@Test
	public void testsupPaging() throws Exception {
		SupPaging supPaging = new SupPaging();
		supPaging.setPage(3);
		supPaging.setPerPageNum(10);
		List<BookVO> list = bdao.supPaging(supPaging);
		
		for(BookVO bvo : list) {
			logger.info(bvo.getBook_name());
		}
	}
}
