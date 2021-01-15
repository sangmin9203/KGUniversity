package com.kgu.www.Book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kgu.www.Book.paging.SupPaging;
import com.kgu.www.Book.persistence.BookDAO;
import com.kgu.www.Book.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookDAO bookDAO;
	
	@Inject
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@Override
	public void bookInsertForm(BookVO bvo) throws Exception{
		bookDAO.bookInsertForm(bvo);
	}
	
	@Override
	public BookVO getBookInfo(BookVO bvo) throws Exception {
		return bookDAO.getBookInfo(bvo);
	}
	
	@Override
	public BookVO getBookInfoN(int book_num) throws Exception {
		return bookDAO.getBookInfoN(book_num);
	}
	
	@Override
	public void updateBook(BookVO bvo) throws Exception {
		bookDAO.updateBook(bvo);
	}
	
	@Override
	public void deleteBook(String book_name) throws Exception{
		bookDAO.deleteBook(book_name);
	}
	
	@Override
	public List<BookVO> bookAll() throws Exception {
		return bookDAO.bookAll();
	}
	
	@Override
	public List<BookVO> supPaging(SupPaging supPaging) throws Exception{
		return bookDAO.supPaging(supPaging);
	}
	
	@Override
	public int countBook(SupPaging supPaging) throws Exception {
		return bookDAO.countBook(supPaging);
	}

}
