package ac.za.domain.academicResults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentNum;
    private double mark;

    private Results(){}

    public Results(double mark) {
        this(null,mark);
    }

    public Results(Integer studentNum, double mark) {
        this.studentNum = studentNum;
        this.mark = mark;
    }

    private Results(Results.Builder builder) {
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public double getFinalMark() {
        return mark;
    }


    public static class Builder {

        private Integer studentNum;
        private double mark;

        public Results.Builder studentNum(Integer studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Results.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Results results){
            this.studentNum = results.studentNum;
            this.mark = results.mark;
            return this;
        }

        public Results build() {
            return new Results(this);
        }

    }

    @Override
    public String toString() {
        return "Results{" +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return studentNum.equals(results.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
