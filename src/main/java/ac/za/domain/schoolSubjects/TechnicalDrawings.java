package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class TechnicalDrawings {

    private String subjectCode;
    private double mark;

    private TechnicalDrawings(){}

    private TechnicalDrawings(TechnicalDrawings.Builder builder) {
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

        public TechnicalDrawings.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public TechnicalDrawings.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(TechnicalDrawings technicalDrawings){
            this.subjectCode = technicalDrawings.subjectCode;
            this.mark = technicalDrawings.mark;
            return this;
        }

        public TechnicalDrawings build() {
            return new TechnicalDrawings(this);
        }

    }

    @Override
    public String toString() {
        return "Technical Drawings{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalDrawings technicalDrawings = (TechnicalDrawings) o;
        return subjectCode.equals(technicalDrawings.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
