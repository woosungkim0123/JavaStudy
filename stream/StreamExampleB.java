import common.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExampleB {
    public static void main(String[] args) {
        // 스트림 요소 검색과 매칭
        streamSearchAndMatching();

        // 리듀싱
        streamReducing();

        // 숫자 범위 스트림
        numberStream();

        // makeStream
        makeStream();
    }

    private static void streamSearchAndMatching() {
        List<Dish> dishes = makeDishes();

        /**
         * anyMatch, allMatch, noneMatch
         * - 스트림 쇼트서킷 기법(&&, ||)와 같은 연산을 활용합니다.
         */
        System.out.println("================= anyMatch, allMatch, noneMatch =================");

        System.out.println("칼로리가 800 이상인 요리가 있는지 여부 (anyMatch)");
        // anyMatch - 하나라도 조건에 맞으면 true
        boolean anyMatch = dishes.stream()
                .anyMatch(s -> s.getCalories() > 800);
        System.out.println(anyMatch);

        System.out.println("칼로리가 800 이상인 요리가 모두 있는지 여부 (allMatch)");
        // allMatch - 모두 조건에 맞으면 true
        boolean allMatch = dishes.stream()
                .allMatch(s -> s.getCalories() > 800);
        System.out.println(allMatch);

        System.out.println("칼로리가 5000 이상인 요리가 없는지 여부 (noneMatch)");
        // noneMatch - 모두 조건에 맞지 않으면 true
        boolean noneMatch = dishes.stream()
                .noneMatch(s -> s.getCalories() > 5000);
        System.out.println(noneMatch);

        /**
         * findAny
         * - 스트림에서 임의의 요소를 반환합니다.
         * - Optional 반환, 병렬 스트림에서는 첫번째 요소를 찾기 어렵기 때문에 반환 순서가 상관없다면 findAny를 사용하는 것이 좋다.
         * findFirst
         * - 스트림에서 첫 번째 요소를 반환합니다.
         */
        System.out.println("================= findAny, findFirst =================");

        System.out.println("칼로리가 300 미만 요리 중 임의의 요리를 반환 (findAny)");
        dishes.stream()
                .filter(s -> s.getCalories() < 300)
                .findAny()
                .ifPresent(x -> System.out.println(x.getName())); // 값이 있으면 출력, 없으면 출력 안함

        System.out.println("칼로리가 300 미만 요리 중 첫 번째 요리를 반환 (findFirst)");
        dishes.stream()
                .filter(s -> s.getCalories() < 300)
                .findFirst()
                .ifPresent(x -> System.out.println(x.getName()));
    }

    private static void streamReducing() {
        /**
         * 리듀싱 연산
         * - 스트림의 모든 요소를 처리해서 값으로 도출하는 것입니다.
         * - 두개의 인자를 가짐 (초기값, BinaryOperator<T>로 람다식을 받음)
         * - 함수형 프로그래밍에서는 종이(스트림)를 작은 조각이 될 때까지 접는 것과 비슷해서 폴드(fold)라고 부릅니다.
         * - 만약 초기값을 받지않는 오버로드 reduce가 있는데 이는 Optional<T>를 반환합니다. (아무 요소도 없으면 값을 반환할 수 없기 때문에 Optional로 감싸서 반환)
         */
        System.out.println("================= 리듀싱 연산 =================");

        /**
         * 처음에 0(초기값) + 첫번째 값 = 첫번째 누적 합계
         * 첫번째 누적 합계 + 두번째 값 = 두번째 누적 합계
         * ...
         */
        List<Dish> dishes = makeDishes();
        // 맵과 리듀스를 연결하는 기법을 맵 리듀스 패턴이라고 부릅니다. (쉽게 병렬화하는 특징 때문에 유용합니다)
        Integer reduce = dishes.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println("모든 칼로리 합계: " + reduce);

        /**
         * 일반 반복문에 비해 reduce의 장점
         * - 내부 반복을 사용하기 때문에 병렬로 처리할 수 있습니다.
         */
        Integer reduceParallel = dishes.parallelStream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("모든 칼로리 합계 (병렬): " + reduceParallel);

        /*
            Stateful operation
            - map, filter 등은 내부 상태를 갖지 않는 연산(stateless operation)입니다.

            Stateless operation
            - reduce, sum, max, min 등은 결과를 누적할 내부 상태가 필요하고 내부 상태의 크기는 한정(Bounded)되어 있습니다.
            - sorted, distinct 등은 과거 요소를 기억하고 있어야 합니다.
            - 이렇게 내부 상태를 갖는 연산을 상태 보유 연산(stateful operation)이라고 부릅니다.
        */

        /**
         * 기본형 특화 스트림
         * - map의 반환 타입이 Stream<T>라서 sum을 사용할 수 없습니다.
         * - IntStream, LongStream, DoubleStream을 사용하면 기본형 특화 스트림으로 변환할 수 있습니다.
         * - 기본형 특화 스트림은 박싱과 언박싱을 피할 수 있어서 성능상 이점이 있습니다. (박싱: 기본형을 참조형으로 변환, 언박싱: 참조형을 기본형으로 변환)
         */
        int mapToInt = dishes.stream()
                .mapToInt(Dish::getCalories) // IntStream 반환
                .sum();
        System.out.println("모든 칼로리 합계 (기본형 특화 스트림): " + mapToInt);

        // 객체 스트림으로 다시 변환
        Integer boxed = dishes.stream()
                .mapToInt(Dish::getCalories)
                .boxed() // IntStream -> Stream<Integer>
                .reduce(0, Integer::sum);
        System.out.println("모든 칼로리 합계 (기본형 특화 스트림 -> 객체 스트림): " + boxed);

        // OptionalInt
        OptionalInt optionalInt = dishes.stream()
                .mapToInt(Dish::getCalories)
                .max();// OptionalInt 반환
        System.out.println("최대 칼로리: " + optionalInt.orElse(3)); // 값이 없으면 3을 반환
    }

    private static void numberStream() {
        /**
         * 숫자 범위 스트림
         * 기본형 특화 스트림 IntStream, LongStream은 range, rangeClosed를 사용할 수 있습니다.
         * - 인수: 시작값, 종료값
         * - range: 시작값은 포함, 종료값은 포함하지 않음
         * - rangeClosed: 시작값과 종료값을 포함
         */
        System.out.println("================= 숫자 범위 스트림 =================");
        //
        long range = IntStream.range(1, 100)
                .count();
        System.out.println("1부터 100까지의 숫자 개수 (range): " + range);

        long rangeClosed = IntStream.rangeClosed(1, 100)
                .count();
        System.out.println("1부터 100까지의 숫자 개수 (rangeClosed): " + rangeClosed);
    }

    private static void makeStream() {
        /**
         * 스트림 만들기
         */
        System.out.println("================= 스트림 만들기 =================");

        // Stream.of: 값으로 스트림 만들기
        System.out.println("Stream.of 사용");
        Stream<String> stringStream = Stream.of("Java", "Scala", "Groovy");
        stringStream.forEach(System.out::println);

        // Stream.ofNullable: null이 될 수 있는 객체로 스트림 만들기 (JDK 9)
        System.out.println("Stream.ofNullable 사용");
        Stream<String> nullable = Stream.ofNullable(System.getProperty("test"));
        nullable.forEach(System.out::println); // 값이 없으면 출력 안함

        // flatMap과 함께 사용하는 패턴에 유용
        Stream<String> flatMapOfNullable = Stream.of("java", "python", "scala")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        // Arrays.stream: 배열로 스트림 만들기
        System.out.println("Arrays.stream 사용");
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("배열의 합계: " + sum);

        // 무한 스트림
        // Stream.iterate: 초깃값(seed)과 람다를 인수로 받아서 새로운 요소를 생산하는 무한 스트림을 만듭니다.
        // 초기 요소를 기반으로 하여 순차적으로 요소를 생성하는 무한 스트림을 생성합니다.
        // 예시: 피보나치 수열 등
        System.out.println("Stream.iterate 사용");
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        // Stream.generate: Supplier<T>를 인수로 받아서 새로운 요소를 생산하는 무한 스트림을 만듭니다.
        System.out.println("Stream.generate 사용");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        /*
            iterate와 generate의 차이
            - iterate는 일반적으로 연속적이거나 순차적인 값을 생성할 때 사용되며, generate는 주로 동일하거나 상태가 없는 객체를 반복적으로 생성할 때 사용됩니다.
            - 상태가 필요한 경우 iterate를 사용하고 상태가 필요하지 않은 경우(병렬 스트림) generate를 사용합니다.
         */
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
