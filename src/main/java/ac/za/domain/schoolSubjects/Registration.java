package ac.za.domain.schoolSubjects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Registration {

    private String regNum, status;

    private Registration(){}

    private Registration(Registration.Builder builder) {
        this.regNum = builder.regNum;
        this.status = builder.status;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getStatuse() {
        return status;
    }

    public static class Builder{

        private String regNum, status;

        public Registration.Builder regNum(String regNum) {
            this.regNum = regNum;
            return this;
        }

        public Registration.Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Registration registration){
            this.regNum = registration.regNum;
            this.status = registration.status;
            return this;
        }

        public Registration build() {
            return new Registration(this);
        }

    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNum='" + regNum + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration registration = (Registration) o;
        return regNum.equals(registration.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNum);
    }

}
