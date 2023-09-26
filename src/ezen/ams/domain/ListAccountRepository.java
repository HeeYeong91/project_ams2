package ezen.ams.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 메모리(리스트)를 통해 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 이희영
 */
public class ListAccountRepository  implements AccountRepository {
		
	private List<Account> accounts;
	
	public ListAccountRepository() {
		this.accounts = new LinkedList<>();
	}
	
	/**
	 * 전체 계좌 목록 수 반환
	 * @return 목록수
	 */
	@Override
	public int getCount() {
		return accounts.size();
	}

	/**
	 * 전체 계좌 목록 조회
	 * @return 전체계좌 목록
	 */
	@Override
	public List<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * 신규계좌 등록
	 * @param account 신규계좌
	 * @return 등록 여부
	 */
	@Override
	public boolean addAccount(Account account) {
		accounts.add(account);
		return true;
	}
	
	/**
	 * 계좌번호로 계좌 검색 기능
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	@Override
	public Account searchAccount(String accountNum) {
		for (Account account : accounts) {
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}
	
	/**
	 * 예금주명으로 계좌 검색 기능
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		List<Account> searchAccounts = new ArrayList<>();
		for (Account account : accounts) {
			if(account.getAccountOwner().equals(accountOwner)) {
				searchAccounts.add(account);
			}
		}
		return searchAccounts;
	}
	
	/**
	 * 계좌번호로 계좌 삭제 기능
	 * @param accountOwner 검색 계좌번호
	 * @return 계좌 삭제 여부
	 */
	@Override
	public boolean removeAccount(String accountNum) {
		for (int i=0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.getAccountNum().equals(accountNum)) {
				accounts.remove(i);
				return true;
			}			
		}
		return false;
	}
}