package com.douzone.emaillist.test;

import java.util.List;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmailVO;

public class EmaillistDaoTest {
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}
	private static void insertTest() {
		EmailVO vo = new EmailVO();
		vo.setFirstName("또");
		vo.setLastName("치");
		vo.setEmail("ddddd@ccccc.com");
		new EmaillistDao().insert(vo);
	}
	private static void findAllTest() {
		List<EmailVO> list = new EmaillistDao().findAll();
		for(EmailVO vo : list) {
			System.out.println(vo);
		}
	}
}
