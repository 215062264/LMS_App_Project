package ac.za.domain.people;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String studentFirstName, studentLastName;
    private int age;

    private Student(){}

    public Student(String studentFirstName, String studentLastName, int age) {
        this(null,studentFirstName,studentLastName,age);
    }

    public Student(Integer studentId, String studentFirstName, String studentLastName, int age) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.age = age;
    }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.age = builder.age;
        this.studentFirstName = builder.studentFirstName;
        this.studentLastName = builder.studentLastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        private Integer studentId;
        private String studentFirstName, studentLastName;
        private int age;

        public Builder studentId( Integer studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder studentFirstName( String studentFirstName) {
            this.studentFirstName = studentFirstName;
            return this;
        }

        public Builder studentLastName( String studentLastName) {
            this.studentLastName = studentLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.studentFirstName = student.studentFirstName;
            this.studentLastName = student.studentLastName;
            this.age = student.age;

            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", StudentFirstName='" + studentFirstName + '\'' +
                ", StudentLastName='" + studentLastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

}
