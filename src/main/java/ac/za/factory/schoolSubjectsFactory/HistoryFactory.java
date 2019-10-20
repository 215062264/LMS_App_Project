package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.History;

public class HistoryFactory {

    public static History getHistory(String subjectCode, double mark) {
        return new History.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
