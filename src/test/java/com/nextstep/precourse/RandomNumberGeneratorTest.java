package com.nextstep.precourse;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomNumberGeneratorTest {
	@DisplayName("랜덤 수 생성 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 9})
	public void getandomNumberTest(int maximumNumber) {
		assertThat(RandomNumberGenerator.getRandomNumber(maximumNumber))
			.isBetween(0, maximumNumber);
	}
}
