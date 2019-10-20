package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.factory.schoolSubjectsFactory.GeographyFactory;
import org.junit.Assert;
import org.junit.Test;

public class GeographyFactoryTest {

    @Test
    public void getGeography() {

        String code = "GEO";
        Double pmark = 87.5;

        Geography c = GeographyFactory.getGeography(code,pmark);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectCode()+"\n"+c.getMark());
    }

}
