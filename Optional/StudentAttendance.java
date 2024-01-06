import java.util.Optional;

public class StudentAttendance {

    private Long id;

    private String name;

    private boolean attendance;

    private Progress progress;

    public StudentAttendance(Long id, String name, boolean attendance) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public boolean isAttendance() {
        return attendance;
    }
}
