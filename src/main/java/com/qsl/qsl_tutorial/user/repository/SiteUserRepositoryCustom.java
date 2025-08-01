package com.qsl.qsl_tutorial.user.repository;

import java.util.List;

import com.qsl.qsl_tutorial.user.entity.SiteUser;

public interface SiteUserRepositoryCustom {
	SiteUser getQslUser(Long id);
	Long getQslCount();
	SiteUser getQslUserOrderByIdAscOne();

	List<SiteUser> getQslUsersOrderByAsc();
}
