package com.team4.bigtower.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.bigtower.member.service.Member;
import com.team4.bigtower.member.service.MemberDao;
import com.team4.bigtower.member.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int memberAdd(Member member) {
		memberDao.memberInsert(member);
		return 0;
	}

}
