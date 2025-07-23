package com.qsl.qsl_tutorial;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qsl.qsl_tutorial.user.entity.SiteUser;
import com.qsl.qsl_tutorial.user.repository.SiteUserRepository;

@SpringBootTest
class QslTutorialApplicationTests {

	@Autowired
	private SiteUserRepository siteUserRepository;

	@Test
	@DisplayName("회원 생성")
	void t1() {
		// {noop} : 비밀번호를 암호화하지 않고 그대로 사용
		SiteUser siteUser1= new SiteUser(null, "qwe123@naver.com", "{noop}1234", "이순신");
		SiteUser siteUser2 = new SiteUser(null, "asd123@naver.com", "{noop}1234", "홍길동");

		siteUserRepository.saveAll(Arrays.asList(siteUser1, siteUser2));
	}

}
