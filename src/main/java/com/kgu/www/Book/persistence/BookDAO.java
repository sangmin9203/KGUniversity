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
	
	List<BookVO> supPaging(SupPaging supPaging) throws Exception; //페이징처리
	
	int countBook(SupPaging supPaging) throws Exception; //책 목록 총 갯수
	
	
	
	
	
	
}
