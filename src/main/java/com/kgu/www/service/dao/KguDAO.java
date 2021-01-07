package com.kgu.www.service.dao;

import java.util.ArrayList;

import com.kgu.www.vo.BookVO;
import com.kgu.www.vo.TestVO;

public interface KguDAO {
	ArrayList<TestVO> testAll();
	
	void bookInsertForm(BookVO bvo);
}
