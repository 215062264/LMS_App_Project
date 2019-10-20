package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.CivilEngineering;

public class CivilEngineeringFactory {

    public static CivilEngineering getCivilEngineering(String subjectCode, double mark) {
        return new CivilEngineering.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
