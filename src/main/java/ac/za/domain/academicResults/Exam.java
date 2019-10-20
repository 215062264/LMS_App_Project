package ac.za.domain.academicResults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer examNum;
    private String studentNum;
    private double mark;

    private Exam(){}

    public Exam(String studentNum, double mark) {
        this(null,studentNum,mark);
    }

    public Exam(Integer examNum, String studentNum, double mark) {
        this.examNum = examNum;
        this.studentNum = studentNum;
        this.mark = mark;
    }

    private Exam(Exam.Builder builder) {
        this.examNum = builder.examNum;
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public Integer getExamNum() {
        return examNum;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public double getExamMark() {
        return mark;
    }


    public static class Builder {
        private  Integer examNum;
        private String studentNum;
        private double mark;

        public Exam.Builder examNum(Integer examNum) {
            this.examNum = examNum;
            return this;
        }

        public Exam.Builder studentNum(String studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Exam.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Exam exam){
            this.studentNum = exam.studentNum;
            this.examNum = exam.examNum;
            return this;
        }

        public Exam build() {
            return new Exam(this);
        }

    }

    @Override
    public String toString() {
        return "Exam{" +
                "examNum='" + examNum + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return studentNum.equals(exam.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
