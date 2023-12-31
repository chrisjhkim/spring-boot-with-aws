package com.chrisjhkim.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	GUEST("ROLE_GUEST", "손님"),
	USER("ROLE_USER", "일반 사용자");

	private final String key; // 스프링시큐리티에서는 권한코드 에 항상 ROLE_이 앞에 있어야만 한다.
	private final String title;
}
