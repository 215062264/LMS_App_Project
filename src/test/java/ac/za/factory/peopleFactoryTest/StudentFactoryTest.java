package ac.za.factory.peopleFactoryTest;

import ac.za.domain.people.Student;
import ac.za.factory.peopleFactory.StudentFactory;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {

    @Test
    public void getStudent() {

        String fname = "Kyle";
        String lname = "Josias";
        Integer id = 1;
        int eAge = 25;

        Student c = StudentFactory.getStudent(id,fname,lname,eAge);
        System.out.println(c);
        Assert.assertNotNull(c.getStudentFirstName()+"\n"+c.getStudentLastName()+"\n"+c.getAge());
    }

}
