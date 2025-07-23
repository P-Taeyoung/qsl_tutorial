package com.qsl.qsl_tutorial.user.repository;

import com.qsl.qsl_tutorial.user.entity.SiteUser;

public interface SiteUserRepositoryCustom {
	SiteUser getQslUser(Long id);
}
