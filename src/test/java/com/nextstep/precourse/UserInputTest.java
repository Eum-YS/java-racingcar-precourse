package com.nextstep.precourse;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserInputTest {
	private static UserInput userInput;

	@BeforeAll
	public static void createTestInput() {
		userInput = new UserInput();
	}

	@Test
	public void testCarNamesInput() {
		String[] inputs = {"", null, "1,,1", ",가,a,1", "1,2,", "가나,r,1"};
		boolean[] result = {false, false, false, false, true, true};

		boolean[] actualResults = new boolean[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			actualResults[i] = userInput.validateCarNamesInput(inputs[i]);
		}

		assertThat(actualResults).isEqualTo(result);
	}

	@Test
	public void testTryCountInput() {
		String[] inputs = {"r", null, "ㄱ", "1"};
		boolean[] result = {false, false, false, true};

		boolean[] actualResults = new boolean[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			actualResults[i] = userInput.validateTryCountInput(inputs[i]);
		}

		assertThat(actualResults).isEqualTo(result);
	}
}
