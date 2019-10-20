package ac.za.factory.peopleFactoryTest;

import ac.za.domain.people.Lecture;
import ac.za.factory.peopleFactory.LectureFactory;
import org.junit.Assert;
import org.junit.Test;

public class LectureFactoryTest {

    @Test
    public void getLecture() {

        Integer id = 1;
        String prf = "Moriarty";
        int hours = 2;

        Lecture c = LectureFactory.getLecture(id,prf,hours);
        System.out.println(c);
        Assert.assertNotNull(c.getProfessor()+"\n"+c.getHours());
    }

}
