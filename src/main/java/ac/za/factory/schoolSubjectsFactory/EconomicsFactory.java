package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Economics;

public class EconomicsFactory {

    public static Economics getEconomics(String subjectCode, double mark) {
        return new Economics.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
