package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.BusinessStudies;

public class BusinessStudiesFactory {


    public static BusinessStudies getBusinessStudies(String subjectCode, double mark) {
        return new BusinessStudies.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
