package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.Mathematics;
import ac.za.factory.schoolSubjectsFactory.MathematicsFactory;
import org.junit.Assert;
import org.junit.Test;

public class MathematicsFactoryTest {

    @Test
    public void getMath() {

        String code = "MAT";
        Double pmark = 96.7;

        Mathematics c = MathematicsFactory.getMath(code,pmark);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectCode()+"\n"+c.getMark());
    }

}
