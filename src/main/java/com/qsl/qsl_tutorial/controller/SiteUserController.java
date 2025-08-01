package com.qsl.qsl_tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qsl.qsl_tutorial.user.entity.SiteUser;
import com.qsl.qsl_tutorial.user.repository.SiteUserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SiteUserController {

	private final SiteUserRepository siteUserRepository;

	@RequestMapping("/user/{id}")
	public ResponseEntity<SiteUser> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(siteUserRepository.getQslUser(id));
	}
}
