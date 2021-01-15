package com.kgu.www.Book.persistence;

import java.util.List;

import com.kgu.www.Book.paging.SupPaging;
import com.kgu.www.Book.vo.BookVO;



public interface BookDAO {
	void bookInsertForm(BookVO bvo) throws Exception;
	
	BookVO getBookInfo(BookVO bvo) throws Exception;
	
	BookVO getBookInfoN(int boon_num) throws Exception;
	
	void updateBook(BookVO bvo) throws Exception;
	
	void deleteBook(String book_name) throws Exception;
	
	List<BookVO> bookAll() throws Exception;
	
	/*페이징처리 test 사용*/
	List<BookVO> listPaging(int page) throws Exception;
	
	/*페이징처리*/
	List<BookVO> supPaging(SupPaging suppaging) throws Exception;
	
	
}
