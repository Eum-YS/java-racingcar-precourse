package com.nextstep.precourse;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator {
	private static RandomNumberGenerator instance = new RandomNumberGenerator();

	private static Random random;

	public RandomNumberGenerator getInstance() {
		return instance;
	}

	private RandomNumberGenerator() {
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			random = new Random();
		}
	}

	/**
	 * 0 ~ maximum 사이의 난수를 생성한다
	 * @param maximum 최대 값. 양수만 허용
	 * @return 0 ~ maximum 사이의 난수
	 * @throws IllegalArgumentException if bound is not positive
	 */
	public static int getRandomNumber(int maximum) {
		return random.nextInt(maximum);
	}
}
