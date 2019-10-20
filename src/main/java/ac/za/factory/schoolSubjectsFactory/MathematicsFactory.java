package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Mathematics;

public class MathematicsFactory {

    public static Mathematics getMath(String subjectCode, double mark) {
        return new Mathematics.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
