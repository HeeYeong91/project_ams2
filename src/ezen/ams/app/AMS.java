package ezen.ams.app;
 
import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.view.AMSFrame;

/**
 * 은행 계좌 관리 애플리케이션 
 * @author 이희영
 */
public class AMS {

	public static AccountRepository repository = new ListAccountRepository();

	public static void main(String[] args) {
		
		// 더미데이터 입력
		repository.addAccount(new Account("홍길동", 1111, 10000000));
		repository.addAccount(new Account("홍길순", 1111, 20000000));
		repository.addAccount(new MinusAccount("김대출", 1111, 0, 10000000));
		repository.addAccount(new MinusAccount("우대출", 1111, 0, 20000000));
		
		AMSFrame frame = new AMSFrame("HY_BANK_AMS");
		
		frame.init();
		frame.setSize(600, 450);
		frame.setResizable(false);
		frame.addEventListner();
		frame.setVisible(true);
	}	
}