package com.chrisjhkim.book.springboot.web.dto;

import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest extends TestCase {


	@Test
	public void test_Lombok(){
		// Test # Given
		String name = "test";
		int amount = 1000;

		// Test # When
		HelloResponseDto dto = new HelloResponseDto(name, amount);

		// Test # Then
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}

}