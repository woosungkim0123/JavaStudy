package builder.sub.effective;

public class Student {
    private int id;
    private String name;
    private String grade;
    private String phoneNumber;

    public Student(int id, String name, String grade, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", phoneNumber=" + phoneNumber + "]";
    }
}
