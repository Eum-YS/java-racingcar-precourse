package com.nextstep.precourse;

import java.util.Scanner;

public class UserInput {
	private Scanner scanner;

	private static final int MAXIMUM_CARNAME_LENGTH = 5;

	public UserInput() {
		scanner = new Scanner(System.in);
	}

	public String[] receiveCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼포(,) 기준으로 구분)");
		boolean validInput = false;
		String input = "";
		while (!validInput) {
			input = scanner.nextLine();
			validInput = validateCarNamesInput(input);
		}
		return input.split(",");
	}

	public boolean validateCarNamesInput(String input) {
		if (isNullEmpty(input)) {
			return false;
		}
		String[] carNames = input.split(",");
		boolean isValidCarName = true;
		for (int i = 0; isValidCarName && i < carNames.length; i++) {
			int carNameLength = carNames[i].length();
			isValidCarName = carNameLength > 0 && carNameLength <= MAXIMUM_CARNAME_LENGTH;
		}
		return isValidCarName && carNames.length > 0;
	}

	public int receiveTryCount() {
		System.out.println("시도할 횟수는 몇회인가요?");
		boolean validInput = false;
		String input = "";
		while (!validInput) {
			input = scanner.nextLine();
			validInput = validateTryCountInput(input);
		}
		return Integer.parseInt(input);
	}

	public boolean validateTryCountInput(String input) {
		if (isNullEmpty(input)) {
			return false;
		}
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isNullEmpty(String target) {
		return target == null || target.isEmpty();
	}

}
