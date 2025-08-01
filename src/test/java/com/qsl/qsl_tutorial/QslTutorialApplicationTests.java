package com.qsl.qsl_tutorial;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.qsl.qsl_tutorial.user.entity.SiteUser;
import com.qsl.qsl_tutorial.user.repository.SiteUserRepository;

@SpringBootTest
@Transactional // 각 테스트 케이스에 전부 @Transactional을 붙인 것과 같은 효과
class QslTutorialApplicationTests {

	@Autowired
	private SiteUserRepository siteUserRepository;

	@BeforeEach
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

	@Test
	@DisplayName("전체 회원 수")
	void t3() {

		Long count = siteUserRepository.getQslCount();

		assertThat(count).isGreaterThan(0);
	}

	@Test
	@DisplayName("가장 오래된 회원")
	void t4() {

		SiteUser user = siteUserRepository.getQslUserOrderByIdAscOne();

		assertThat(user.getEmail()).isEqualTo("qwe123@naver.com");

	}

	@Test
	@DisplayName("전체 회원 조회, 오래된 순으로 정렬")
	void t5() {

		List<SiteUser> users = siteUserRepository.getQslUsersOrderByAsc();

		assertThat(users.size()).isEqualTo(2);
		assertThat(users.get(0).getEmail()).isEqualTo("qwe123@naver.com");
		assertThat(users.get(1).getEmail()).isEqualTo("asd123@naver.com");
	}

}
