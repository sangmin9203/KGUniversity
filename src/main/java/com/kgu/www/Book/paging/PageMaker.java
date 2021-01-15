package com.kgu.www.Book.paging;

public class PageMaker {
	private int totalCount; //게시글 전체 갯수
	private int startPage; //시작페이지 번호
	private int endPage; // 끝페이지 번호
	private boolean prev; //이전 페이지
	private boolean next; //다음페이지
	
	private int displayPageNum = 10; //하단 페이지의 번호 갯수
	
	private SupPaging supPaging;
	
	public void setSupPaging(SupPaging supPaging) {
		this.supPaging = supPaging;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	 private void calcData() {

	        endPage = (int) (Math.ceil(supPaging.getPage() / (double) displayPageNum) * displayPageNum);

	        startPage = (endPage - displayPageNum) + 1;

	        int tempEndPage = (int) (Math.ceil(totalCount / (double) supPaging.getPerPageNum()));

	        if (endPage > tempEndPage) {
	            endPage = tempEndPage;
	        }

	        prev = startPage == 1 ? false : true;

	        next = endPage * supPaging.getPerPageNum() >= totalCount ? false : true;

	    }

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public SupPaging getSupPaging() {
		return supPaging;
	}
	 
	 
}
