package common;

public class StudentAttendance {

    private Long id;

    private String name;

    private boolean attendance;

    private String club;

    public StudentAttendance(Long id, String name, boolean attendance) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
    }

    public StudentAttendance(Long id, String name, boolean attendance, String club) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public String getClub() {
        return club;
    }
}
