package com.chrisjhkim.book.springboot.web;


import com.chrisjhkim.book.springboot.config.auth.SecurityConfig;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**<p>
 * {@code @WebMvcTest} 는 WebSecurityConfigurerAdapter, WebMvcConfigurer 를 비롯한 @ControllerAdvice, @Controller 를 읽는다.
 *  {@code @Repository}, @Service, @Component 등은 대상이 아니다.
 * </p>
 */
@RunWith(SpringRunner.class)
@WebMvcTest(
		controllers = HelloController.class,
		excludeFilters = {
				@ComponentScan.Filter(
						type = FilterType.ASSIGNABLE_TYPE,
						classes = SecurityConfig.class)})
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	/**
	 * Hello 가 return 된다
	 */
	@WithMockUser(roles = "USER")
	@Test
	public void returnsHello() throws Exception {
		String hello = "hello";

		mvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string(hello));
	}

	@WithMockUser(roles = "USER")
	@Test
	public void returnHelloDto() throws Exception {
		String name = "hello";
		int amount = 500;

		mvc.perform(
				get("/hello/dto")
						.param("name", name)
						.param("amount", String.valueOf(amount)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", Matchers.is(name)))
				.andExpect(jsonPath("$.amount",Matchers.is(amount)));

	}

}