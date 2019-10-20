package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.InformationTech;

public class InformationTechFactory {

    public static InformationTech getInfoTech(String subjectCode, double mark) {
        return new InformationTech.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
