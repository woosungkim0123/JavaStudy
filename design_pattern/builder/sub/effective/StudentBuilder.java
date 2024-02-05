package builder.sub.effective;

public class StudentBuilder {
    private int id;
    private String name;
    private String grade;
    private String phoneNumber;

    public StudentBuilder(int id) {
        this.id = id;
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder grade(String grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder phoneNumber(String phoneNumber) {
        // 010으로 시작
        if (!phoneNumber.startsWith("010")) {
            throw new IllegalArgumentException("휴대폰 번호는 010으로 시작해야 합니다.");
        }
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Student build() {
        return new Student(id, name, grade, phoneNumber);
    }
}
