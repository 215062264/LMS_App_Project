package ac.za.factory.schoolSubjectsFactoryTest;

import ac.za.domain.schoolSubjects.History;
import ac.za.factory.schoolSubjectsFactory.HistoryFactory;
import org.junit.Assert;
import org.junit.Test;

public class HistoryFactoryTest {

    @Test
    public void getHistory() {

        String code = "HIST";
        Double pmark = 87.5;

        History c = HistoryFactory.getHistory(code,pmark);
        System.out.println(c);
        Assert.assertNotNull(c.getSubjectCode()+"\n"+c.getMark());
    }

}
