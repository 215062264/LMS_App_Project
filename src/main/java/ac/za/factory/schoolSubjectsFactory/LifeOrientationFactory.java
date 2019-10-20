package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.LifeOrientation;

public class LifeOrientationFactory {


    public static LifeOrientation getLifeOrientation(String subjectCode, double mark) {
        return new LifeOrientation.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
