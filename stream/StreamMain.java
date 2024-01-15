
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        // 스트림 구성 요소 동작 출력 테스트
        basicStreamPrint();

        // 출석부를 활용하여 스트림 출력 테스트
        studentAttendanceStream();
    }

    private static void basicStreamPrint() {
        System.out.println("================= 중개, 종료 연산 출력 여부 확인 =================");
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        // 중개 연산 (Lazy해서 출력 안됨)
        System.out.println("================= 중개 연산 =================");
        names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println("================= 종료 연산 =================");
        // 종료 연산
        names.stream().forEach(System.out::println);

        System.out.println("================= 병렬 처리 =================");

        // Thread - main
        names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        // 병렬, Thread - ForkJoinPool.commonPool-worker-1
        names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        
    }

    private static void studentAttendanceStream() {
        List<StudentAttendance1> studentAttendance1s = new ArrayList<>();
        studentAttendance1s.add(new StudentAttendance1(1L, "구XX", true));
        studentAttendance1s.add(new StudentAttendance1(2L, "김XX", false));
        studentAttendance1s.add(new StudentAttendance1(3L, "차XX", true));
        studentAttendance1s.add(new StudentAttendance1(4L, "이XX", false));

        // 김으로 시작하는 학생들의 이름만 출력
        System.out.println("================= 김으로 시작하는 학생 =================");
        
        studentAttendance1s.stream()
                .map(StudentAttendance1::getName)
                .filter(name -> name.startsWith("김"))
                .forEach(System.out::println);

        System.out.println("================= 출석한 학생 =================");

        // 출석한 학생들의 이름만 출력
        studentAttendance1s.stream()
                        .filter(StudentAttendance1::isAttendance)
                        .map(StudentAttendance1::getName)
                        .forEach(System.out::println);

        System.out.println("================= 결석한 학생 =================");

        // 결석한 학생들의 이름만 출력
        studentAttendance1s.stream()
                .filter(Predicate.not(StudentAttendance1::isAttendance))
                .map(StudentAttendance1::getName)
                .forEach(System.out::println);

        System.out.println("================= 2개의 출석부에 있는 학생들의 id를 출력하기 (데이터 추가) =================");

        List<StudentAttendance1> studentAttendances21 = new ArrayList<>();

        studentAttendances21.add(new StudentAttendance1(5L, "김XX", true));
        studentAttendances21.add(new StudentAttendance1(6L, "김XX", false));
        studentAttendances21.add(new StudentAttendance1(7L, "김XX", true));

        List<List<StudentAttendance1>> studentAttendancesList = new ArrayList<>();
        studentAttendancesList.add(studentAttendance1s);
        studentAttendancesList.add(studentAttendances21);

        studentAttendancesList.stream()
                .flatMap(Collection::stream) // 리스트를 스트림으로 변경
                .map(StudentAttendance1::getId)
                .forEach(System.out::println);

        System.out.println("================= 10부터 1씩 증가하는 무제한 스트림에서 앞에 10개를 빼고 최대 10개까지만 출력 =================");

        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("================= 출석부1번에서 성이 김인 학생이 존재하는지 여부 =================");

        boolean test1 = studentAttendance1s.stream()
                .anyMatch(s -> s.getName().contains("김"));

        System.out.println(test1);


        System.out.println("================= 출석부1번에서 성이 김인 학생만 있는지 여부 =================");

        boolean test2 = studentAttendance1s.stream()
                .allMatch(s -> s.getName().contains("김"));

        System.out.println(test2);

        System.out.println("================= 2개의 출석부에 있는 학생들 중 성이 김인 학생 ID 리스트 만들고 출력 =================");

        List<Long> kimIdList = studentAttendancesList.stream()
                .flatMap(Collection::stream)
                .filter(s -> s.getName().contains("김"))
                .map(StudentAttendance1::getId)
                .toList(); // JDK 17지원 collect(Collectors.toList()) -> toList()로 변경

        kimIdList.forEach(System.out::println);
    }
}
