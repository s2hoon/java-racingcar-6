package racingcar;

import java.util.List;

public class Output {


    // 커맨드 출력
    public void startOutput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    // 시도할 횟수 출력
    public void timeOutput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    // 상황 출력
    public void printNow(List<Car> cars) {
        cars.stream()
                .forEach(car -> {
                    int dashesCount = car.getCurrentPlace();
                    String dashes = "-".repeat(dashesCount);
                    System.out.println(car.getName() + " : " + dashes);
                });
        System.out.println("\n");
    }

    // 최종 우승자 출력
    public void printWinner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getCurrentPlace)
                .max()
                .orElse(0);
        StringBuilder sb = new StringBuilder();
        cars.stream()
                .forEach(car -> {
                    if (car.getCurrentPlace() == maxDistance) {
                        if (sb.length() > 0) {
                            sb.append(",\n   ");  // 들여쓰기 3 추가
                        }
                        sb.append(car.getName());
                    }
                });
        System.out.println("최종 우승자 : " + sb);
    }


}
