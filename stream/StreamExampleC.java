import common.StudentAttendance;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamExampleC {
    public static void main(String[] args) {
        // 컬렉터 사용
        /**
         * Collector에서 제공하는 메서드의 기능은 크게 세 가지로 구분할 수 있다.
         * - 스트림 요소를 하나의 값을 리듀스하고 요약
         * - 요소를 그룹화
         * - 요소를 분할
         */
        
        // 리듀스와 요약
        reducingAndSummary();

        // 그룹화
        grouping();
    }

    private static void reducingAndSummary() {
        /**
         * 스트림 요소를 하나의 값으로 reduce하고 요약
         */

        List<StudentAttendance> list = makeStudentAttendances();

        // counting - 스트림의 요소 개수를 계산합니다.
        System.out.println("== counting ==");

        Long counting = list.stream()
                .collect(Collectors.counting());

        System.out.println("counting = " + counting);
        System.out.println();

        // maxBy, minBy - 스트림의 최대, 최소 요소를 찾습니다.
        System.out.println("== maxBy, minBy ==");

        Optional<StudentAttendance> maxBy = list.stream()
                .collect(Collectors.maxBy(Comparator.comparing(StudentAttendance::getId)));

        Optional<StudentAttendance> minBy = list.stream()
                .collect(Collectors.minBy(Comparator.comparing(StudentAttendance::getId)));

        System.out.println("maxBy = " + maxBy.get().getId());
        System.out.println("minBy = " + minBy.get().getId());
        System.out.println();

        // summingInt, summingLong, summingDouble - 스트림의 합계를 계산합니다.
        System.out.println("== summingInt, summingLong, summingDouble ==");

        Long summingLong = list.stream()
                .collect(Collectors.summingLong(StudentAttendance::getId));

        System.out.println("summingLong = " + summingLong);
        System.out.println();

        // averagingInt, averagingLong, averagingDouble - 스트림의 평균을 계산합니다.
        System.out.println("== averagingInt, averagingLong, averagingDouble ==");

        Double averagingDouble = list.stream()
                .collect(Collectors.averagingDouble(StudentAttendance::getId));

        System.out.println("averagingDouble = " + averagingDouble);
        System.out.println();

        // summarizingInt, summarizingLong, summarizingDouble - 스트림의 요약 통계를 계산합니다.
        System.out.println("== summarizingInt, summarizingLong, summarizingDouble ==");

        LongSummaryStatistics longSummaryStatistics = list.stream()
                .collect(Collectors.summarizingLong(StudentAttendance::getId));

        System.out.println("summarizingLong = " + longSummaryStatistics); // {count=10, sum=55, min=1, average=5.500000, max=10}
        System.out.println();

        // joining - 스트림의 모든 요소를 하나의 문자열로 연결합니다. (toString 메소드로 추출)
        System.out.println("== joining ==");

        String joining = list.stream()
                .map(StudentAttendance::getName)
                .collect(Collectors.joining(", "));

        System.out.println("joining = " + joining);
        System.out.println();

        // 범용 리듀싱 요약 연산
        // reducing - 스트림의 요소를 리듀스합니다.
        // 이전의 모든 컬렉터는 리듀싱 팩토리 메서드로 정의할 수 있습니다. 그러나 특화된 컬렉션을 사용하는 이유는 편의성과 가독성 때문입니다.
        System.out.println("== reducing ==");

        // 범용 리듀싱으로 총 합계를 구하는 방법(summingLong과 같은 기능)
        Long reducing = list.stream()
                .collect(reducing(0L, StudentAttendance::getId, (i, j) -> i + j)); // (초기값, 매핑 함수, BinaryOperator<T>)

        System.out.println("reducing = " + reducing);
        System.out.println();








        // toList - 스트림의 모든 요소를 리스트로 수집
        System.out.println("toList");

        List<StudentAttendance> toList = list.stream()
                .filter(StudentAttendance::isAttendance)
                .collect(Collectors.toList());
    }

    private static void grouping() {
        List<StudentAttendance> list = makeStudentAttendances();
        // groupingBy - 스트림의 요소를 그룹화합니다.
        System.out.print("== groupingBy ==");

        Map<String, List<StudentAttendance>> groupingBy = list.stream()
                .collect(groupingBy(StudentAttendance::getClub));

        groupingBy.forEach((k, v) -> {
            System.out.println();
            System.out.println("key = " + k);
            v.forEach(x -> System.out.print(x.getName() + " "));
        });
        System.out.println();

        // 필터링 그룹화 1
        // 프레디케이트를 사용해서 그룹화된 요소를 필터링 하게되면 축구에 해당하는 결과가 없다면 맵에서 해당 키 자체가 사라짐
        System.out.println("== filtering ==");
        System.out.println("filtering이 아닌 Predicate를 사용한 필터링");
        
        Map<String, List<StudentAttendance>> groupingBy1 = list.stream()
                .filter(StudentAttendance::isAttendance)
                .collect(groupingBy(StudentAttendance::getClub));

        groupingBy1.forEach((k, v) -> {
            System.out.println();
            System.out.println("key = " + k);
            v.forEach(x -> System.out.print(x.getName() + " "));
        });
        System.out.println();
        System.out.println();

        // 필터링 그룹화 2
        // 필터링된 결과가 없더라도 키를 유지하고 싶다면 filtering을 사용합니다.
        System.out.println("filtering 사용");
        Map<String, List<String>> groupingBy2 = list.stream()
                .collect(groupingBy(StudentAttendance::getClub,filtering(StudentAttendance::isAttendance, mapping(StudentAttendance::getName, toList()))));

        groupingBy2.forEach((k, v) -> {
            System.out.println();
            System.out.println("key = " + k);
            v.forEach(x -> System.out.print(x + " "));
        });
        System.out.println();
    }

    private static List<StudentAttendance> makeStudentAttendances() {
        return List.of(
                new StudentAttendance(1L, "홍길동", false, "축구"),
                new StudentAttendance(2L, "김길동", false, "축구"),
                new StudentAttendance(3L, "박길동", true, "농구"),
                new StudentAttendance(4L, "이길동", false, "농구"),
                new StudentAttendance(5L, "최길동", false, "축구"),
                new StudentAttendance(6L, "정길동", false, "축구"),
                new StudentAttendance(7L, "윤길동", true, "농구"),
                new StudentAttendance(8L, "장길동", false, "농구"),
                new StudentAttendance(9L, "임길동", false, "축구"),
                new StudentAttendance(10L, "한길동", false, "축구")
        );
    }
}
