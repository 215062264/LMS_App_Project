package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.ConsumerStudies;

public class ConsumerStudiesFactory {

    public static ConsumerStudies getConsumerStudies(String subjectCode, double mark) {
        return new ConsumerStudies.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
