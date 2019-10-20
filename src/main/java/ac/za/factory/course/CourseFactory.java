package ac.za.factory.course;

import ac.za.domain.course.Course;

public class CourseFactory {
    public static Course getCourse(Integer courseId,String courseName,String description){
        return new Course.Builder().courseId(courseId)
                .courseName(courseName)
                .description(description)
                .build();

    }

}
