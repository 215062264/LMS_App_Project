package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Mathematics {

    private String subjectCode;
    private double mark;

    private Mathematics(){}

    private Mathematics(Mathematics.Builder builder) {
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

        public Mathematics.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Mathematics.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(Mathematics mathematics){
            this.subjectCode = mathematics.subjectCode;
            this.mark = mathematics.mark;
            return this;
        }

        public Mathematics build() {
            return new Mathematics(this);
        }

    }

    @Override
    public String toString() {
        return "Mathematics{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mathematics mathematics = (Mathematics) o;
        return subjectCode.equals(mathematics.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }


}
