package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Science {

    private String subjectCode;
    private double mark;

    private Science(){}

    private Science(Science.Builder builder) {
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

        public Science.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Science.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Science science){
            this.subjectCode = science.subjectCode;
            this.mark = science.mark;
            return this;
        }

        public Science build() {
            return new Science(this);
        }

    }

    @Override
    public String toString() {
        return "Science{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Science science = (Science) o;
        return subjectCode.equals(science.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
