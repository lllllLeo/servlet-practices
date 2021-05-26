package com.douzone.guestbook.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVO;

public class GuestBookDaoTest {
	
	public static void main(String[] args) {
		List<GuestBookVO> list = new GuestBookDao().findAll();
		for (GuestBookVO vo : list ) {
			System.out.println(vo);
		}
	}
}
