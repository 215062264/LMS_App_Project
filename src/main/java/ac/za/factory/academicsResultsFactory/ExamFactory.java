package ac.za.factory.academicsResultsFactory;

import ac.za.domain.academicResults.Exam;

public class ExamFactory {

    public static Exam getExam(Integer examNum, String studentNum, double mark) {
        return new Exam.Builder()
                .examNum(examNum)
                .studentNum(studentNum)
                .mark(mark)
                .build();
    }

}
