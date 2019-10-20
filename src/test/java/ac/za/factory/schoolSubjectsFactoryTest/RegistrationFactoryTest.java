package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.factory.schoolSubjectsFactory.RegistrationFactory;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationFactoryTest {

    @Test
    public void getRegistration() {

        String status = "Registered";
        String RegNum = "12345ABC";

        Registration c = RegistrationFactory.getRegistration(status,RegNum);
        System.out.println(c);
        Assert.assertNotNull(c.getStatuse()+"\n"+c.getRegNum());
    }

}
