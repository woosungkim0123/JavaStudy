
import common.Dish;
import common.StudentAttendance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExampleA {
    public static void main(String[] args) {
        // 스트림 구성 요소 동작 출력 테스트
        basicStreamPrint();

        // 쇼트 서킷과 루프 퓨전 테스트
        shortCircuitAndLoopFusion();

        // 스트림 슬라이싱
        streamSlice();

        // 출석부를 활용하여 스트림 출력 테스트
        studentAttendanceStream();
    }

    private static void basicStreamPrint() {
        System.out.println("================= 중개, 종료 연산 출력 여부 확인 =================");
        List<String> names = List.of("a", "b", "c", "d");

        // 중개 연산 (Lazy해서 출력 안됨)
        System.out.println("================= 중개 연산 =================");

        names.stream()
            .map((s) -> {
                System.out.println(s + " " + Thread.currentThread().getName());
                return s.toUpperCase();
            });

        System.out.println("================= 종료 연산 =================");
        // 종료 연산
        names.stream()
            .forEach(System.out::println);

        System.out.println("================= 중개, 종료 연산 출력 확인 =================");

        names.stream()
            .map((s) -> s.toUpperCase())
            .forEach(System.out::println);
        
        System.out.println("================= 병렬 처리 출력 확인 =================");

        // Thread - main
        System.out.println("기본 스트림 처리");
        names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(toList());

        // 병렬, Thread - ForkJoinPool.commonPool-worker-1
        // main만 사용될 수도 있고 ForkJoinPool.commonPool-worker-1 등 여러 스레드가 사용될 수도 있습니다.
        System.out.println("병렬 스트림 처리");
        names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(toList());
    }

    private static void shortCircuitAndLoopFusion() {
        System.out.println("================= 쇼트 서킷 =================");

        List<Dish> dishes = makeDishes();
        /**
         * 루프 퓨전
         * 서로 다른 연산을 하나의 단일 루프에서 처리하는 것처럼 병합하는 기법입니다.
         * - filter와 map은 서로 다른 연산이지만 하나의 과정으로 병합되었습니다.
         *
         * 쇼트 서킷
         * 결과가 확실한 경우 뒤의 연산을 수행하지 않고 결과를 반환하는 기법입니다.
         * - 칼로리 200이 넘는 요리는 많지만 2개만 출력되었습니다.
         */
        dishes.stream()
                .filter(dish -> { // 루프 퓨전: filter, map
                    System.out.println("filter: " + dish.getName());
                    return dish.getCalories() >= 200;
                })
                .map(dish -> {
                    System.out.println("map: " + dish.getName());
                    return dish.getName();
                })
                .limit(2) // 쇼트 서킷
                .toList(); // JDK 17지원 collect(Collectors.toList()) -> toList()로 변경

    }

    private static void streamSlice() {
        /**
         * 스트림 슬라이싱 (JDK 9)
         * - takeWhile: 조건을 만족하는 요소만 추출
         * - dropWhile: 조건을 만족하지 않는 요소만 추출
         * - limit: 스트림을 축소
         */
        System.out.println("================= 스트림 슬라이싱 =================");
        List<Dish> dishes = makeDishes();
        dishes.sort(Comparator.comparing(Dish::getCalories));

        System.out.println("filter 사용");
        dishes.stream()
                .filter(dish -> {
                    System.out.println("filter: " + dish.getName());
                    return dish.getCalories() < 350;
                })
                .collect(toList());

        /**
         * 조건에 맞으면 계속 추출하다가 조건에 맞지 않으면 중단 (정렬 후 사용)
         */
        System.out.println("takeWhile 사용");
        dishes.stream()
                .takeWhile(dish -> {
                    System.out.println("takeWhile: " + dish.getName());
                    return dish.getCalories() < 350;
                })
                .collect(toList());

        /**
         * 조건에 맞지 않으면 계속 추출하다가 조건에 맞으면 중단 (정렬 후 사용)
         * - takeWhile과 반대로 동작합니다.
         */
        System.out.println("dropWhile 사용");
        dishes.stream()
                .dropWhile(dish -> {
                    System.out.println("dropWhile in: " + dish.getName());
                    return dish.getCalories() < 350;
                })
                .forEach(x -> System.out.println("dropWhile out: " + x.getName()));

        /**
         * limit: 스트림을 축소
         */
        System.out.println("limit 사용");
        dishes.stream()
                .filter(dish -> dish.getCalories() > 350)
                .limit(3)
                .forEach(x -> System.out.println("limit: " + x.getName()));

        /**
         * skip: 스트림을 건너뜀
         */
        System.out.println("skip 사용");
        dishes.stream()
                .filter(dish -> dish.getCalories() > 350)
                .skip(2)
                .forEach(x -> System.out.println("skip: " + x.getName()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림에서 앞에 10개를 빼고 최대 10개까지만 출력");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void studentAttendanceStream() {
        System.out.println("================= 학생 출석부 예시 =================");

        List<StudentAttendance> notSameNameStudentList = new ArrayList<>();
        notSameNameStudentList.add(new StudentAttendance(1L, "구XX", true));
        notSameNameStudentList.add(new StudentAttendance(2L, "김XX", false));
        notSameNameStudentList.add(new StudentAttendance(3L, "차XX", true));
        notSameNameStudentList.add(new StudentAttendance(4L, "이XX", false));

        List<StudentAttendance> sameNameStudentList = new ArrayList<>();
        sameNameStudentList.add(new StudentAttendance(5L, "김XX", true));
        sameNameStudentList.add(new StudentAttendance(6L, "김XX", false));
        sameNameStudentList.add(new StudentAttendance(7L, "김XX", true));

        System.out.println("'김'으로 시작하는 학생 이름 출력하기");
        notSameNameStudentList.stream()
                .map(StudentAttendance::getName)
                .filter(name -> name.startsWith("김"))
                .forEach(System.out::println);

        System.out.println("출석한 학생 이름 출력하기");
        notSameNameStudentList.stream()
                .filter(StudentAttendance::isAttendance)
                .map(StudentAttendance::getName)
                .forEach(System.out::println);

        System.out.println("결석한 학생 이름만 출력");
        notSameNameStudentList.stream()
                .filter(Predicate.not(StudentAttendance::isAttendance))
                .map(StudentAttendance::getName)
                .forEach(System.out::println);

        /**
         * flatMap
         */
        System.out.println("2개의 출석부에 있는 학생들의 id를 출력하기 (flatMap 사용)");

        List<List<StudentAttendance>> allStudentList = new ArrayList<>();
        allStudentList.add(notSameNameStudentList);
        allStudentList.add(sameNameStudentList);

        allStudentList.stream()
                .flatMap(Collection::stream) // 리스트를 스트림으로 변경
                .map(StudentAttendance::getId)
                .forEach(System.out::println);

        System.out.println("2개의 출석부에 있는 학생들 중 성이 '김'인 학생 ID 리스트 만들고 출력");
        // JDK 17지원 collect(Collectors.toList()) -> toList()로 변경
        List<Long> kimIdList = allStudentList.stream()
                .flatMap(Collection::stream)
                .filter(s -> s.getName().contains("김"))
                .map(StudentAttendance::getId)
                .toList();
        kimIdList.forEach(System.out::println);
    }

    private static List<Dish> makeDishes() {
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork", 800));
        menu.add(new Dish("beef", 700));
        menu.add(new Dish("chicken", 400));
        menu.add(new Dish("french fries", 530));
        menu.add(new Dish("rice", 350));
        menu.add(new Dish("season fruit", 120));
        menu.add(new Dish("pizza", 550));
        menu.add(new Dish("prawns", 100));
        return menu;
    }
}
