package com.qsl.qsl_tutorial.user.repository;

import static com.qsl.qsl_tutorial.user.entity.QSiteUser.*;

import com.qsl.qsl_tutorial.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SiteUserRepositoryImpl implements SiteUserRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public SiteUser getQslUser(Long id) {
		/*
		SELECT * FROM site_user WHERE id = 1
		*/
		// QSiteUser siteUser = QSiteUser.siteUser; // Q클래스가 있기 때문에 사용 가능 -> import로 대체


		return jpaQueryFactory
			.selectFrom(siteUser) // SELECT * FROM site_user
			.where(siteUser.id.eq(id)) // WHERE id = 1
			.fetchOne(); // 단일 결과를 반환, 결과가 없으면 null 반환
	}
}
