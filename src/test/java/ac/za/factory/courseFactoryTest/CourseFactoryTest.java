package ac.za.factory.courseFactoryTest;

import ac.za.domain.course.Course;
import ac.za.factory.course.CourseFactory;
import org.junit.Assert;
import org.junit.Test;

public class CourseFactoryTest {

    @Test
    public void getCourse(){

    String desc = "Diploma in Information & Communication Technology";
    String name = "IT Course";
    Integer id = 1;

    Course course = CourseFactory.getCourse(id,name,desc);
    System.out.println(course);
    Assert.assertNotNull(course.getCourseId()+"\n"+course.getCourseName());
}

}
