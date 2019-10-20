package ac.za.domain.academicResults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Assignments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer assId;
    private String dueDate, studentNum;
    private double mark;

    private Assignments(){}

    public Assignments(String dueDate, String studentNum, double mark) {
        this(null,dueDate,studentNum,mark);
    }

    public Assignments(Integer assId, String dueDate, String studentNum, double mark) {
        this.assId = assId;
        this.dueDate = dueDate;
        this.studentNum = studentNum;
        this.mark = mark;
    }

    private Assignments(Assignments.Builder builder) {
        this.dueDate = builder.dueDate;
        this.studentNum = builder.studentNum;
        this.mark = builder.mark;
        this.assId = builder.assId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public double getAssignmentMark() {
        return mark;
    }

    public Integer getAssId(){return assId;}

    public static class Builder {
        private Integer assId;
        private String dueDate, studentNum;
        private double mark;

        public Assignments.Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Assignments.Builder assId(Integer assId){
            this.assId = assId;
            return this;
        }

        public Assignments.Builder studentNum(String studentNum) {
            this.studentNum = studentNum;
            return this;
        }

        public Assignments.Builder mark(double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Assignments assignments){
            this.studentNum = assignments.studentNum;
            this.dueDate = assignments.dueDate;
            this.assId = assignments.assId;
            return this;
        }

        public Assignments build() {
            return new Assignments(this);
        }

    }

    @Override
    public String toString() {
        return "Assignments{" +
                "assignmentId= '" + assId+ '\''+
                "dueDate='" + dueDate + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", Mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignments assignments = (Assignments) o;
        return studentNum.equals(assignments.studentNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

}
