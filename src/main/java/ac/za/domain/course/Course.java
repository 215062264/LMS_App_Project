package ac.za.domain.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String courseName;
    private String description;

    public Course(){}

    public Course(String courseName, String description) {
        this( null,courseName,description);
    }

    public Course(Integer courseId, String courseName, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
    }

    private Course(Builder builder){
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.description = builder.description;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{

        private Integer courseId;
        private String courseName;
        private String description;

        public Builder courseId(Integer courseId){
            this.courseId = courseId;
            return this;
        }

        public Builder courseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder copy(Course course){
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.description = course.description;
            return this;

        }

        public Course build(){return new Course(this);}


    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
