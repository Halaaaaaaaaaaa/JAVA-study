package utils;

//페이징에 관련된 버튼을 만드는 기능을 하는 클래스
public class PageMaker {
	
	private Criteria cri; 		// 현재 페이지 정보
	private int totalCount;		// 총 게시글의 수
	private int startPage;		// 화면에 보여질 첫번째 페이지 번호
	private int endPage; 		// 화면에 보여질 마지막 페이지 번호
	private boolean prev;		// <이전> 버튼 표시 여부 
	private boolean next;		// <다음> 버튼 표시 여부 
	private int cntPageNum = 10; // 화면에 보이는 페이지번호 수
	private int realEndPage;	// 실제 끝 페이지 번호
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		// 멤버 변수 초기화
		fieldInit();
	}
	
	public void fieldInit() {
		/* 1) 끝페이지 번호 = (정수)(올림(현재 페이지 번호 / (실수)화면당 페이지 버튼의 수) * 화면당 페이지 버튼 수)
		예시1) 현재 페이지 3페이지
		   3/10(페이지 버튼의 수) = 0.xxx => 이 값을 올림 => 1
		   1 * 10(페이지 버튼의 수) = 10
		예시2)현재 페이지 12페이지
		   13/10 = 1.xxx => 올림 => 2
		   2 * 10 = 20 	*/
		endPage = (int)(Math.ceil(cri.getPageNum() / (double)cntPageNum) * cntPageNum);
		
		// 2) 시작 페이지 번호 계산
		// 시작 페이지 = 끝 페이지 번호 - 화면당 페이지 번호 수 + 1
		startPage = endPage - cntPageNum + 1;
		
		// 3) 끝 페이지 번호 계산
		// 실제 끝 페이지 번호 = 총 게시글의 수 / 페이지당 게시글의 개수
		//	  예시) 77 / (double)10 = 7.7 =>(올림) 8
		realEndPage = (int)Math.ceil(totalCount / (double)cri.getRowsPerPage());
		
		// 4) 실제 끝 페이지 번호 값 수정
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		// 5) 이전, 다음 버튼 표시 여부 결정
		//시작 페이지 번호가 '1'일 경우, '이전' 버튼 필요X
		//다음 페이지 번호가 '10' 미만일 경우, '다음' 버튼 필요 X
		prev = (startPage == 1 ? false : true);
		next = (endPage < 10 ? false : true);
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
	public int getCntPageNum() {
		return cntPageNum;
	}
	public void setCntPageNum(int cntPageNum) {
		this.cntPageNum = cntPageNum;
	}
	public int getRealEndPage() {
		return realEndPage;
	}
	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}
	
	@Override
	public String toString() {
		return "PageMaker [cri=" + cri + ", totalCount=" + totalCount + ", startPage="
				+ startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" 
				+ next + ", cntPageNum=" + cntPageNum + ", realEndPage=" + realEndPage + "]";
	}
	
	
	
	

}
