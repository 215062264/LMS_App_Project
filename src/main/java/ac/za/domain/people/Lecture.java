package ac.za.domain.people;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer lecturerId;
    private String  professor;
    private int hours;

    private Lecture(){}

    public Lecture(String professor, int hours) {
        this(null,professor,hours);
    }

    public Lecture(Integer lecturerId, String professor, int hours) {
        this.lecturerId = lecturerId;
        this.professor = professor;
        this.hours = hours;
    }

    private Lecture(Lecture.Builder builder) {
        this.professor = builder.professor;
        this.hours = builder.hours;
        this.lecturerId = builder.lecturerId;
    }


    public Integer getLecturerId(){return lecturerId;}

    public String getProfessor() {
        return professor;
    }

    public int getHours() {
        return hours;
    }


    public static class Builder{
        private Integer lecturerId;
        private String professor;
        private int hours;

        public Lecture.Builder lecturerId(Integer lecturerId){
            this.lecturerId = lecturerId;
            return this;
        }

        public Lecture.Builder professor(String professor) {
            this.professor = professor;
            return this;
        }

        public Lecture.Builder hours(int hours) {
            this.hours = hours;
            return this;
        }

        public Builder copy(Lecture lecture){
            this.professor = lecture.professor;
            this.hours = lecture.hours;
            this.lecturerId = lecture.lecturerId;
            return this;
        }

        public Lecture build() {
            return new Lecture(this);
        }

    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lecturerId='" + lecturerId+'\''+
                "professor='" + professor + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return professor.equals(lecture.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor);
    }

}
