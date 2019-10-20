package ac.za.factory.academicResultsFactoryTest;

import ac.za.domain.academicResults.Exam;
import ac.za.factory.academicsResultsFactory.ExamFactory;
import org.junit.Assert;
import org.junit.Test;

public class ExamFactoryTest {

    @Test
    public void getTutorial() {

        Integer exNum = 212;
        String stdNum = "215062264";
        double exMark = 100;

        Exam c = ExamFactory.getExam(exNum,stdNum,exMark);
        System.out.println(c);
        Assert.assertNotNull(c.getExamNum()+"\n"+c.getStudentNum()+"\n"+c.getExamMark());
    }

}
