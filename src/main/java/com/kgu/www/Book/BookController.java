package com.kgu.www.Book;

import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kgu.www.Book.paging.PageMaker;
import com.kgu.www.Book.paging.SupPaging;
import com.kgu.www.Book.service.BookService;
import com.kgu.www.Book.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	private final BookService bookService;
	
	@Inject
	public BookController(BookService bookService) {
		this.bookService = bookService;
	} //컨트롤러 클래스 선언부에 book경로를 추가해서 공통의 경로를 book으로 인식하게 만듬
	
	//등록페이지 이동
	@RequestMapping(value = "/bookInsertForm.do", method = RequestMethod.GET)
	public String bookInsertFormGet() {
		logger.info("등록 페이지 이동");
		return "/book/bookInsertForm";
	}
	
	//등록 처리
	@RequestMapping(value = "/bookInsertForm.do", method = RequestMethod.POST)
	public String bookInsertFormPOST(@RequestParam("book_file") MultipartFile book_file, @RequestParam HashMap<String,String> hashMap, RedirectAttributes rda)
			throws Exception {
		logger.info("등록...");
		String savepoint ="C:\\Users\\pc\\Desktop\\KG_University\\src\\main\\webapp\\WEB-INF\\img";
		File save = new File(savepoint,book_file.getOriginalFilename());
		book_file.transferTo(save);
		String book_picture = book_file.getOriginalFilename();
		String book_name = (String) hashMap.get("book_name");
		String book_writer = (String) hashMap.get("book_writer");
		int book_price = (int) Integer.parseInt(hashMap.get("book_price"));
		String book_info = (String) hashMap.get("book_info");
		String book_mokcha = (String) hashMap.get("book_mokcha");
		int book_inventory = (int) Integer.parseInt(hashMap.get("book_inventory"));
		BookVO bvo = new BookVO();
		bvo.InsertVO(book_picture, book_name, book_writer, book_price, book_info, book_mokcha, book_inventory);
		bookService.bookInsertForm(bvo);
		rda.addFlashAttribute("msg", "입력완료"); //입력 완료
		return "redirect:/book/bookAll.do";
	}
	
	//목록 페이지 이동
	@RequestMapping(value = "/bookAll.do", method = RequestMethod.GET)
	public String SupPaging(Model model, SupPaging supPaging) throws Exception {
		logger.info("목록 페이지..");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setSupPaging(supPaging);
		pageMaker.setTotalCount(bookService.countBook(supPaging)); //일단 임의로 값을 넣음
		System.out.println("제발");
		model.addAttribute("supPaging", bookService.supPaging(supPaging));
		model.addAttribute("pageMaker", pageMaker);
		
		return "/book/bookAll";
	}
	
	//상세보기
	@RequestMapping(value = "/getBookInfo.do", method = RequestMethod.GET)
	public String getBookInfo(@ModelAttribute("bvo") BookVO bvo, Model model) throws Exception {
		logger.info("글 상세보기...");
		model.addAttribute("bvo", bookService.getBookInfo(bvo));
		return "/book/getBookInfo";
	}
	
	//수정 페이지 이동
	@RequestMapping(value="/updateBook.do", method = RequestMethod.GET)
	public String updateBookGET(@ModelAttribute("bvo") BookVO bvo, Model model) throws Exception {
		logger.info("수정 처리 페이지 이동");
		model.addAttribute("bvo", bookService.getBookInfo(bvo));
		return "/book/updateBook";
	}
	
	//수정처리
	@RequestMapping(value="/updateBook.do", method = RequestMethod.POST)
	public String updateBookPOST(@RequestParam(value = "book_file", required = false) MultipartFile book_file, @RequestParam HashMap<String,String> hashMap, RedirectAttributes rda
			, @ModelAttribute("bvo") BookVO bvo) throws Exception {
		logger.info("수정처리..");
		String book_picture = "";
		String savepoint ="C:\\Users\\pc\\Desktop\\KG_University\\src\\main\\webapp\\resources\\img";
		int book_num = (int) Integer.parseInt(hashMap.get("book_num"));
		System.out.println();
		BookVO bvo2 = bookService.getBookInfoN(book_num);
		if(!book_file.getOriginalFilename().equals("")) {
			File save = new File(savepoint, book_file.getOriginalFilename());
			book_file.transferTo(save);
			book_picture = book_file.getOriginalFilename();
			File OriginFile = new File(savepoint+"\\"+bvo2.getBook_picture());
			if(OriginFile.exists())
				if(OriginFile.delete())
					System.out.println("파일 삭제 성공");
				else
					System.out.println("파일 삭제 실패");
		} else {
			book_picture = bvo2.getBook_picture();
		}
		System.out.println(book_picture);
		String book_name = (String) hashMap.get("book_name");
		String book_writer = (String) hashMap.get("book_writer");
		int book_price = (int) Integer.parseInt(hashMap.get("book_price"));
		String book_info = (String) hashMap.get("book_info");
		String book_mokcha = (String) hashMap.get("book_mokcha");
		int book_inventory = (int) Integer.parseInt(hashMap.get("book_inventory"));
		bvo = new BookVO();
		bvo.UpdateVO(book_num, book_picture, book_name, book_writer, book_price, book_info, book_mokcha, book_inventory);
		bookService.updateBook(bvo);
		return "redirect:/book/bookAll.do";
	}
	
	//삭제처리
	@RequestMapping(value="/deleteBook.do", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("book_name") String book_name, RedirectAttributes rda) throws Exception {
		logger.info("삭제처리..");
		bookService.deleteBook(book_name);
		rda.addFlashAttribute("msg", "delete 성공");
		return "redirect:/book/bookAll.do";
	}
}
