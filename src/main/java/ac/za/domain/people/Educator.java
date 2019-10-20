package ac.za.domain.people;


import javax.persistence.*;
import java.util.Objects;
@Entity
public class Educator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer educatorId;
    private String educatorFirstName;
    private String educatorLastName;
    private int age;

    public Educator() {
    }

     public Educator(String educatorFirstName, String educatorLastName, int age) {
            this(null,educatorFirstName,educatorLastName,age);
    }

    public Educator(Integer educatorId, String educatorFirstName, String educatorLastName, int age) {
        this.educatorId = educatorId;
        this.educatorFirstName = educatorFirstName;
        this.educatorLastName = educatorLastName;
        this.age = age;
    }

    private Educator(Builder builder) {
        this.educatorId = builder.educatorId;
        this.age = builder.age;
        this.educatorFirstName = builder.educatorFirstName;
        this.educatorLastName = builder.educatorLastName;
    }

    public Integer getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(Integer educatorId){
        this.educatorId = educatorId;
    }

    public String getEducatorFirstName() {
        return educatorFirstName;
    }

    public String getEducatorLastName() {
        return educatorLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private Integer educatorId;
        private String educatorFirstName, educatorLastName;
        private int age;

        public Builder educatorId( Integer educatorId) {
            this.educatorId = educatorId;
            return this;
        }

        public Builder educatorFirstName( String educatorFirstName) {
            this.educatorFirstName = educatorFirstName;
            return this;
        }

        public Builder educatorLastName( String educatorLastName) {
            this.educatorLastName = educatorLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Builder copy(Educator educator){
            this.educatorId = educator.educatorId;
            this.educatorFirstName = educator.educatorFirstName;
            this.educatorLastName = educator.educatorLastName;
            return this;
        }

        public Educator build() {
            return new Educator(this);
        }

    }

    @Override
    public String toString() {
        return "Educator{" +
                "educatorId='" + educatorId + '\'' +
                ", EducatorFirstName='" + educatorFirstName + '\'' +
                ", EducatorLastName='" + educatorLastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Educator educator = (Educator) o;
        return educatorId.equals(educator.educatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educatorId);
    }

}
