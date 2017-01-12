package com.team4.bigtower.member.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team4.bigtower.member.service.Member;
import com.team4.bigtower.member.service.MemberDao;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int memberInsert(Member member) {
		sqlSessionTemplate.insert("Member.memberAdd", member);
		return 0;
	}

}
