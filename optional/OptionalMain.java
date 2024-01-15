
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        List<StudentAttendance1> studentAttendance1s = new ArrayList<>();
        studentAttendance1s.add(new StudentAttendance1(1L, "구XX", true));
        studentAttendance1s.add(new StudentAttendance1(2L, "김XX", false));
        studentAttendance1s.add(new StudentAttendance1(3L, "차XX", true));
        studentAttendance1s.add(new StudentAttendance1(4L, "이XX", false));

        Optional<StudentAttendance1> studentAttendance = studentAttendance1s.stream()
                .filter(st -> st.getName().startsWith("김"))
                .findFirst();

        boolean present = studentAttendance.isPresent();
        System.out.println("present = " + present);

        boolean empty = studentAttendance.isEmpty();
        System.out.println("empty = " + empty);

        // 사용을 권장하지 않는다.
        StudentAttendance1 student = studentAttendance.get();
        System.out.println("student = " + student.getName());

        studentAttendance.ifPresent(st -> System.out.println("st = " + st.getName()));

        Optional<StudentAttendance1> studentAttendance2 = studentAttendance1s.stream()
                .filter(st -> st.getName().startsWith("사"))
                .findFirst();

        StudentAttendance1 student2 = studentAttendance2.orElse(createdNewStudentAttendance());
        System.out.println("student2 = " + student2.getName());

        StudentAttendance1 student3 = studentAttendance.orElse(createdNewStudentAttendance());
        System.out.println("student3 = " + student3.getName());

        StudentAttendance1 student4 = studentAttendance.orElseGet(OptionalMain::createdNewStudentAttendance);
        System.out.println("student4 = " + student4.getName());

        Optional<StudentAttendance1> optionalStudent1 = studentAttendance.filter(st -> st.getName().startsWith("김"));
        if (optionalStudent1.isPresent()) {
            System.out.println("optionalStudent1 = " + optionalStudent1.get().getName());
        } else {
            System.out.println("empty");
        }
        
        Optional<StudentAttendance1> optionalStudent2 = studentAttendance.filter(st -> st.getName().startsWith("추"));
        if (optionalStudent2.isPresent()) {
            System.out.println("optionalStudent1 = " + optionalStudent2.get().getName());
        } else {
            System.out.println("empty");
        }

        Optional<String> stName = studentAttendance.map(StudentAttendance1::getName);
        System.out.println("stName = " + stName.get());

        // 주의해야할 점
        Optional<Optional<Progress>> progress = studentAttendance.map(StudentAttendance1::getProgress);
        Optional<Progress> progress1 = progress.orElseGet(() -> Optional.of(new Progress()));
        Progress progress2 = progress1.orElseGet(Progress::new);

        // 위의 경우 flatMap 사용 - Optional을 한번 벗겨준다.
        Optional<Progress> progress3 = studentAttendance.flatMap(StudentAttendance1::getProgress);
    }

    private static StudentAttendance1 createdNewStudentAttendance() {
        System.out.println("실행됨");
        return new StudentAttendance1(5L, "하XX", false);
    }
}
