package com.cos.blog.test;

import org.junit.jupiter.api.Test;

public class EncTest {
	@Test
	public void 해쉬_암호화() {
		String encPassword = new BCryptPasswordEncoder().encode("1234");
	}
}
