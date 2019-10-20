package ac.za.factory.academicResultsFactoryTest;

import ac.za.domain.academicResults.Results;
import ac.za.factory.academicsResultsFactory.ResultsFactory;
import org.junit.Assert;
import org.junit.Test;

public class ResultsFactoryTest {

    @Test
    public void getResults() {

        Integer studentNum = 215062264;
        double finalMark = 100;

        Results c = ResultsFactory.getResults(studentNum,finalMark);
        System.out.println(c);
        Assert.assertNotNull(c.getStudentNum()+"\n"+c.getFinalMark());
    }

}
