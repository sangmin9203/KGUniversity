package com.kgu.www.Book.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kgu.www.Book.vo.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	private static final String NAMESPACE = "com.kgu.www.mapper.Book.BookMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public BookDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void bookInsertForm(BookVO bvo) throws Exception{
		sqlSession.insert(NAMESPACE+".bookInsertForm", bvo);
	}
	
	@Override
	public BookVO getBookInfo(BookVO bvo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getBookInfo", bvo);
	}
	
	@Override
	public BookVO getBookInfoN(int book_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getBookInfoN", book_num);
	}
	
	@Override
	public void updateBook(BookVO bvo) throws Exception {
		sqlSession.update(NAMESPACE+".updateBook", bvo);
	}
	
	@Override
	public void deleteBook(String book_name) throws Exception {
		sqlSession.delete(NAMESPACE+".deleteBook", book_name);
	}
	
	@Override
	public List<BookVO> bookAll() throws Exception {
		return sqlSession.selectList(NAMESPACE+".bookAll");
	}
	
	@Override
	public List<BookVO> listPaging(int Page) throws Exception{
				
		Page = (Page-1)*10;
		
		if (Page<=0) {
			Page =1;
		} else {
			Page = Page+1;
		}
		
		return sqlSession.selectList(NAMESPACE+".listPaging", Page);
	}







}
