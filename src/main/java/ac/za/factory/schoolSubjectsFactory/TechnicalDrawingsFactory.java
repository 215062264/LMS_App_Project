package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.TechnicalDrawings;

public class TechnicalDrawingsFactory {

    public static TechnicalDrawings getTechnicalDrawings(String subjectCode, double mark) {
        return new TechnicalDrawings.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
