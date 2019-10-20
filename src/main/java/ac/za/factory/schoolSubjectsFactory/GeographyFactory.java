package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Geography;

public class GeographyFactory {

    public static Geography getGeography(String subjectCode, double mark) {
        return new Geography.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
