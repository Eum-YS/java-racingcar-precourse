package com.nextstep.precourse;

public class CarRacingApp {
	public static void main(String[] args) {
		UserInput userInput = new UserInput();
		String[] carNames = userInput.receiveCarNames();
		int tryCount = userInput.receiveTryCount();

		CarRacing carRacing = new CarRacing(tryCount, carNames);
		carRacing.startRacing();
	}
}
