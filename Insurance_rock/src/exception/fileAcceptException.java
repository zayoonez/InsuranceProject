package exception;

@SuppressWarnings("serial")
public class fileAcceptException extends RuntimeException {
	public fileAcceptException() {
		super("파일 접근 중 문제가 생겨 정보를 불러오지 못했습니다. 잠시후 다시 실행 해주십시오. 해당 문제가 계속 발생할 시에는 사내 시스템 관리팀(1234-5678)에게 문의 주시기 바랍니다.");
		
	}
}
