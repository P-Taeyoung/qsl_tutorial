package com.qsl.qsl_tutorial;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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
		// SiteUser siteUser1= new SiteUser(null, "qwe123@naver.com", "{noop}1234", "이순신");
		// SiteUser siteUser2 = new SiteUser(null, "asd123@naver.com", "{noop}1234", "홍길동");

		SiteUser siteUser1 = SiteUser.builder()
			.userName("이순신")
			.password("{noop}1234")
			.email("qwe123@naver.com")
			.build();

		SiteUser siteUser2 = SiteUser.builder()
			.userName("홍길동")
			.password("{noop}1234")
			.email("asd123@naver.com")
			.build();


		siteUserRepository.saveAll(Arrays.asList(siteUser1, siteUser2));
	}

	@Test
	@DisplayName("1번 회원을 Qsl로 가져오기")
	void t2() {
		SiteUser u1 = siteUserRepository.getQslUser(1L);
		SiteUser u2 = siteUserRepository.getQslUser(2L);

		assertThat(u1.getEmail()).isEqualTo("qwe123@naver.com");
		assertThat(u2.getEmail()).isEqualTo("asd123@naver.com");
	}

}
