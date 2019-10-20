package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.factory.schoolSubjectsFactory.CivilEngineeringFactory;
import org.junit.Assert;
import org.junit.Test;

public class CivilEngineeringFactoryTest {

    @Test
    public void getCivilEngineering() {

        String code = "CEN";
        Double pmark = 77.5;

        CivilEngineering c = CivilEngineeringFactory.getCivilEngineering(code,pmark);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectCode()+"\n"+c.getMark());
    }

}
