package com.kgu.www;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kgu.www.service.KguService;
import com.kgu.www.vo.BookVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource(name = "KguService") //resorece 추가
	private KguService kguService;
	HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		

	}
	
	@RequestMapping("book_insert.do")
	public String bookInsert() {
		return "book_insert";
	}
	
	@RequestMapping("bookInsertForm.do")
	public String bookInsertForm(@RequestParam("book_file") MultipartFile book_file, @RequestParam HashMap<String,String> hashMap)
			throws ClassNotFoundException, SQLException, IllegalStateException, IOException	{
		
		String savepoint ="C:\\Users\\pc\\Desktop\\KG_University\\src\\main\\webapp\\resources\\img";
		File save = new File(savepoint,book_file.getOriginalFilename());
		book_file.transferTo(save);
		String book_picture = book_file.getOriginalFilename();
		String book_name = (String) hashMap.get("book_name");
		String book_writer = (String) hashMap.get("book_writer");
		int book_price = (int) Integer.parseInt(hashMap.get("book_price"));
		String book_info = (String) hashMap.get("book_info");
		String book_mokcha = (String) hashMap.get("book_mokcha");
		int book_inventory = (int) Integer.parseInt(hashMap.get("book_inventory"));
		BookVO bvo = new BookVO(book_picture, book_name, book_writer, book_price, book_info, book_mokcha, book_inventory);
		kguService.bookInsertForm(bvo);
		return "book_insert";
	}
	
	@RequestMapping("BookAll.do")
	public String BookAll(Model model)
		throws Exception {
		ArrayList<BookVO> alist = kguService.BookAll();
		
		model.addAttribute("alist", alist);
		
		return "book_list";
	}
	
	@RequestMapping("/getBookInfo.do")
	public String getBookInfo(@ModelAttribute("bvo") BookVO bvo, Model model) throws Exception  {
		model.addAttribute("bvo", kguService.getBookInfo(bvo)); //한 책에 대한 처리, 가져갈 Data
		return "book_info";
	}
	
}
