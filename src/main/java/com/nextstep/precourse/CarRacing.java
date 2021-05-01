package com.nextstep.precourse;

import java.util.Arrays;
import java.util.Collection;

public class CarRacing {
	private CarStorage carStorage;
	private int tryCount = 0;

	public CarRacing(int tryCount, String... carNames) {
		this.tryCount = tryCount;
		carStorage = new CarStorage(Arrays.asList(carNames));
	}

	public CarStorage getCarStorage() {
		return carStorage;
	}

	public void startRacing() {
		System.out.println("실행 결과");

		int currentTryCount = 0;
		while (currentTryCount++ < tryCount) {
			carStorage.moveCars();
			printCarDistance(carStorage.getCars());
		}
		printWinners(carStorage.getFarthestMovedCarNames());
	}

	private void printCarDistance(Car[] cars) {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(String.format("%s : ", car.getName()));
			for (int i = 0; i < car.getDistance(); i++) {
				sb.append('-');
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	private void printWinners(Collection<String> winners) {
		System.out.println(String.format("%s가 최종 우승했습니다.", String.join(", ", winners)));
	}
}
