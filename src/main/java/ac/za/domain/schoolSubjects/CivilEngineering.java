package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class CivilEngineering {

    private String subjectCode;
    private double mark;

    private CivilEngineering(){}

    private CivilEngineering(CivilEngineering.Builder builder) {
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

        public CivilEngineering.Builder subjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public CivilEngineering.Builder mark(Double mark) {
            this.mark = mark;
            return this;
        }

        public Builder copy(CivilEngineering civilEngineering){
            this.subjectCode = civilEngineering.subjectCode;
            this.mark = civilEngineering.mark;
            return this;
        }

        public CivilEngineering build() {
            return new CivilEngineering(this);
        }

    }

    @Override
    public String toString() {
        return "Civil Engineering{" +
                "subjectCode='" + subjectCode + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CivilEngineering civilEngineering = (CivilEngineering) o;
        return subjectCode.equals(civilEngineering.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }

}
