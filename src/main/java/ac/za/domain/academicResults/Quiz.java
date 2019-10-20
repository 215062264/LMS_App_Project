package ac.za.domain.academicResults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentNum;
    private String dueDate;
    private double mark;

    private Quiz(){}

    public Quiz(String dueDate, double mark) {
        this(null,dueDate,mark);
    }

    public Quiz(Integer studentNum, String dueDate, double mark) {
        this.studentNum = studentNum;
        this.dueDate = dueDate;
        this.mark = mark;
    }

    private Quiz(Quiz.Builder builder) {
        this.dueDate = builder.dueDate;
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public double getQuizMark() {
        return mark;
    }


    public static class Builder {
        private Integer studentNum;
        private String dueDate;
        private double mark;

        public Quiz.Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Quiz.Builder studentNum(Integer studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Quiz.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Quiz quiz){
            this.studentNum = quiz.studentNum;
            this.mark = quiz.mark;
            return this;
        }

        public Quiz build() {
            return new Quiz(this);
        }

    }

    @Override
    public String toString() {
        return "Quiz{" +
                "dueDate='" + dueDate + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return studentNum.equals(quiz.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
