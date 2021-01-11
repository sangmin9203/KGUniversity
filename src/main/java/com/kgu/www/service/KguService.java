package com.kgu.www.service;

import java.util.ArrayList;

import com.kgu.www.vo.BookVO;
import com.kgu.www.vo.TestVO;

public interface KguService {
	ArrayList<TestVO> testAll();
	
	void bookInsertForm(BookVO bvo);
	
	ArrayList<BookVO> BookAll() throws Exception;;
}
