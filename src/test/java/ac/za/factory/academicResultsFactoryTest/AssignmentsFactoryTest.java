package ac.za.factory.academicResultsFactoryTest;

import ac.za.domain.academicResults.Assignments;
import ac.za.factory.academicsResultsFactory.AssignmentsFactory;
import org.junit.Assert;
import org.junit.Test;

public class AssignmentsFactoryTest {

    @Test
    public void getTutorial() {

        Integer assId = 1;
        String ddate = "17/07/2019";
        String studNum = "215062264";
        double asMark = 100;

        Assignments c = AssignmentsFactory.getAssignments(assId,ddate,studNum,asMark);
        System.out.println(c);
        Assert.assertNotNull(c.getDueDate()+"\n"+c.getStudentNum()+"\n"+c.getAssignmentMark());
    }

}
