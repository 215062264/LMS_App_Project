package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.factory.schoolSubjectsFactory.SubjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class SubjectFactoryTest {

    @Test
    public void getSubjectID() {

        String name = "ADP 3";
        Subject c = SubjectFactory.getSubjectID(name);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectId());
    }

}
