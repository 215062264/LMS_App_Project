package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class ConsumerStudies {

    private String subjectCode;
    private double mark;

    private ConsumerStudies(){}

    private ConsumerStudies(ConsumerStudies.Builder builder) {
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

        public ConsumerStudies.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public ConsumerStudies.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(ConsumerStudies consumerStudies){
            this.subjectCode = consumerStudies.subjectCode;
            this.mark = consumerStudies.mark;
            return this;
        }

        public ConsumerStudies build() {
            return new ConsumerStudies(this);
        }

    }

    @Override
    public String toString() {
        return "Consumer Studies{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerStudies consumerStudies = (ConsumerStudies) o;
        return subjectCode.equals(consumerStudies.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
