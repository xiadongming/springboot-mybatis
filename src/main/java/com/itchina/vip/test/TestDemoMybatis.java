package com.itchina.vip.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itchina.vip.dao.StudentDao;
import com.itchina.vip.entity.Student;

public class TestDemoMybatis {
	
	@Test
	public void getTest() {
		
		InputStream is = TestDemoMybatis.class.getResourceAsStream("/SqlMapConfig.xml");
		SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory build = factoryBuilder.build(is);
		SqlSession session = build.openSession();
		StudentDao mapperDao = session.getMapper(StudentDao.class);
		List<Student> queryStudent = mapperDao.queryStudent();
		System.out.println(queryStudent);
	}

}
