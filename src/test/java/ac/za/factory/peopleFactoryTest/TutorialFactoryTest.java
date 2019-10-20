package ac.za.factory.peopleFactoryTest;

import ac.za.domain.people.Tutorial;
import ac.za.factory.peopleFactory.TutorialFactory;
import org.junit.Assert;
import org.junit.Test;

public class TutorialFactoryTest {

    @Test
    public void getTutorial() {

        String fname = "Tony";
        String lname = "Stark";
        Integer tId = 1;

        Tutorial c = TutorialFactory.getTutorial(tId,fname,lname);
        System.out.println(c);
        Assert.assertNotNull(c.getTutorFirstName()+"\n"+c.getTutorLastName()+"\n"+c.getTutorId());
    }

}
