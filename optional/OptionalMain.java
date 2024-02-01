
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        List<StudentAttendance> studentAttendance1s = new ArrayList<>();
        studentAttendance1s.add(new StudentAttendance(1L, "구XX", true));
        studentAttendance1s.add(new StudentAttendance(2L, "김XX", false));
        studentAttendance1s.add(new StudentAttendance(3L, "차XX", true));
        studentAttendance1s.add(new StudentAttendance(4L, "이XX", false));

        Optional<StudentAttendance> studentAttendance = studentAttendance1s.stream()
                .filter(st -> st.getName().startsWith("김"))
                .findFirst();

        boolean present = studentAttendance.isPresent();
        System.out.println("present = " + present);

        boolean empty = studentAttendance.isEmpty();
        System.out.println("empty = " + empty);

        // 사용을 권장하지 않는다.
        StudentAttendance student = studentAttendance.get();
        System.out.println("student = " + student.getName());

        studentAttendance.ifPresent(st -> System.out.println("st = " + st.getName()));

        Optional<StudentAttendance> studentAttendance2 = studentAttendance1s.stream()
                .filter(st -> st.getName().startsWith("사"))
                .findFirst();

        StudentAttendance student2 = studentAttendance2.orElse(createdNewStudentAttendance());
        System.out.println("student2 = " + student2.getName());

        StudentAttendance student3 = studentAttendance.orElse(createdNewStudentAttendance());
        System.out.println("student3 = " + student3.getName());

        StudentAttendance student4 = studentAttendance.orElseGet(OptionalMain::createdNewStudentAttendance);
        System.out.println("student4 = " + student4.getName());

        Optional<StudentAttendance> optionalStudent1 = studentAttendance.filter(st -> st.getName().startsWith("김"));
        if (optionalStudent1.isPresent()) {
            System.out.println("optionalStudent1 = " + optionalStudent1.get().getName());
        } else {
            System.out.println("empty");
        }
        
        Optional<StudentAttendance> optionalStudent2 = studentAttendance.filter(st -> st.getName().startsWith("추"));
        if (optionalStudent2.isPresent()) {
            System.out.println("optionalStudent1 = " + optionalStudent2.get().getName());
        } else {
            System.out.println("empty");
        }

        Optional<String> stName = studentAttendance.map(StudentAttendance::getName);
        System.out.println("stName = " + stName.get());

        // 주의해야할 점
        Optional<Optional<Progress>> progress = studentAttendance.map(StudentAttendance::getProgress);
        Optional<Progress> progress1 = progress.orElseGet(() -> Optional.of(new Progress()));
        Progress progress2 = progress1.orElseGet(Progress::new);

        // 위의 경우 flatMap 사용 - Optional을 한번 벗겨준다.
        Optional<Progress> progress3 = studentAttendance.flatMap(StudentAttendance::getProgress);
    }

    private static StudentAttendance createdNewStudentAttendance() {
        System.out.println("실행됨");
        return new StudentAttendance(5L, "하XX", false);
    }
}
