package kr.co.mvcboard.beans;

public class PageBean {
	
	// 최소 페이지 번호
	private int min;
	// 최대 페이지 번호
	private int max;
	// 이전 버튼의 페이지 번호
	private int prevPage;
	// 다음 버튼의 페이지 번호
	private int nextPage;
	// 전체 페이지 개수
	private int pageCnt;
	// 현재 페이지 번호
	private int currentPage;
	
	//필드값들을 주인한다
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		this.currentPage=currentPage;
		
		//총 몇 페이지나 되는지
		pageCnt = contentCnt/contentPageCnt;
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;//나머지 있으면 버튼이 paginationCnt만큼 안 찼으니 +1해줌
		}
		
		min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		max = min + paginationCnt - 1;
		
		if(max > pageCnt) {
			max=pageCnt;
		}
		
		prevPage=min-1;
		nextPage=max+1;

		if(nextPage > pageCnt) {
			nextPage=pageCnt;
		}
		
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}