package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.factory.schoolSubjectsFactory.AccountingFactory;
import org.junit.Assert;
import org.junit.Test;

public class AccountingFactoryTest {

    @Test
    public void getAccounting() {

        String code = "ACT";
        Double pmark = 80.0;

        Accounting c = AccountingFactory.getAccounting(code,pmark);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectCode()+"\n"+c.getMark());
    }

}
