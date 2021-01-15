package com.kgu.www.Book.service;

import java.util.List;

import com.kgu.www.Book.paging.SupPaging;
import com.kgu.www.Book.vo.BookVO;

public interface BookService {
	
	void bookInsertForm(BookVO bvo) throws Exception;
	
	BookVO getBookInfo(BookVO bvo) throws Exception;
	
	BookVO getBookInfoN(int book_num) throws Exception;
	
	void updateBook(BookVO bvo) throws Exception;
	
	void deleteBook(String book_name) throws Exception;
	
	List<BookVO> bookAll() throws Exception;
	
	List<BookVO> supPaging(SupPaging supPaging) throws Exception;
	
	int countBook(SupPaging supPaging) throws Exception;
	
}
