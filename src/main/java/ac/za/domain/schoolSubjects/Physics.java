package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Physics {

    private String subjectCode;
    private double mark;

    private Physics(){}

    private Physics(Physics.Builder builder) {
        this.subjectCode = builder.subjectCode;
        this.mark = builder.mark;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public Double getMark() {
        return mark;
    }


    public static class Builder{

        private String subjectCode;
        private double mark;

        public Physics.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Physics.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Physics physics){
            this.subjectCode = physics.subjectCode;
            this.mark = physics.mark;
            return this;
        }

        public Physics build() {
            return new Physics(this);
        }

    }

    @Override
    public String toString() {
        return "Physics{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Physics physics = (Physics) o;
        return subjectCode.equals(physics.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
