package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Science;

public class ScienceFactory {

    public static Science getScience(String subjectCode, double mark) {
        return new Science.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
