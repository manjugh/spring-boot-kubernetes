package com.learn.boot.bookmarker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class BookmarkerApiApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Test
	void contextLoads() {
		Assertions.assertThat(webApplicationContext).isNotNull();
	}

}
