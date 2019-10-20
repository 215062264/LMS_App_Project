package ac.za.domain.people;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tutorId;
    private String tutorFirstName, tutorLastName;

    private Tutorial(){}

    public Tutorial(String tutorFirstName, String tutorLastName) {
        this(null,tutorFirstName,tutorLastName);
    }

    public Tutorial(Integer tutorId, String tutorFirstName, String tutorLastName) {
        this.tutorId = tutorId;
        this.tutorFirstName = tutorFirstName;
        this.tutorLastName = tutorLastName;
    }

    private Tutorial(Tutorial.Builder builder) {
        this.tutorId = builder.tutorId;
        this.tutorFirstName = builder.tutorFirstName;
        this.tutorLastName = builder.tutorLastName;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public String getTutorFirstName() {
        return tutorFirstName;
    }

    public String getTutorLastName() {
        return tutorLastName;
    }


    public static class Builder {
        private Integer tutorId;
        private String tutorFirstName, tutorLastName;

        public Tutorial.Builder tutorId(Integer tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public Tutorial.Builder tutorFirstName(String tutorFirstName) {
            this.tutorFirstName = tutorFirstName;
            return this;
        }

        public Tutorial.Builder tutorLastName(String tutorLastName) {
            this.tutorLastName = tutorLastName;
            return this;
        }

        public Builder copy(Tutorial tutorial){
            this.tutorId = tutorial.tutorId;
            this.tutorFirstName = tutorial.tutorFirstName;
            return this;
        }



        public Tutorial build() {
            return new Tutorial(this);
        }

    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "tutorId='" + tutorId + '\'' +
                ", Tutor First Name='" + tutorFirstName + '\'' +
                ", Tutor Last Name='" + tutorLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutorial tutorial = (Tutorial) o;
        return tutorId.equals(tutorial.tutorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutorId);
    }

}
