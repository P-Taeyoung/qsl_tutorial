package com.qsl.qsl_tutorial.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsl.qsl_tutorial.user.entity.SiteUser;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
}
