package ac.za.factory.academicsResultsFactory;

import ac.za.domain.academicResults.Quiz;

public class QuizFactory {

    public static Quiz getQuiz(String dueDate, Integer studentNum, double mark) {
        return new Quiz.Builder()
                .dueDate(dueDate)
                .studentNum(studentNum)
                .mark(mark)
                .build();
    }

}
