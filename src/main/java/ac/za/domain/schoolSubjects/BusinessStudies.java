package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class BusinessStudies {

    private String subjectCode;
    private double mark;

    private BusinessStudies(){}

    private BusinessStudies(BusinessStudies.Builder builder) {
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

        public BusinessStudies.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public BusinessStudies.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(BusinessStudies businessStudies){
            this.subjectCode = businessStudies.subjectCode;
            this.mark = businessStudies.mark;
            return this;
        }

        public BusinessStudies build() {
            return new BusinessStudies(this);
        }

    }

    @Override
    public String toString() {
        return "Business Studies{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessStudies businessStudies = (BusinessStudies) o;
        return subjectCode.equals(businessStudies.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
