package com.kgu.www.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgu.www.service.KguService;
import com.kgu.www.service.dao.KguDAO;
import com.kgu.www.vo.BookVO;
import com.kgu.www.vo.TestVO;

@Service("KguService")
public class KguServiceImpl implements KguService {
	
	@Autowired
	private KguDAO kguDAO;

	@Override
	@Transactional
	public ArrayList<TestVO> testAll() {
		return kguDAO.testAll();
	}
	
	public void bookInsertForm(BookVO bvo) {
		kguDAO.bookInsertForm(bvo);
	}
}
