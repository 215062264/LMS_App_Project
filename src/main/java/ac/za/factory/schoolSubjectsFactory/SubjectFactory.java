package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.util.Misc;

public class SubjectFactory {

    public static Subject getSubjectID(String subjectName) {
        return new Subject.Builder().subjectId(Misc.generateId())
                .subjectName(subjectName)
                .build();
    }

}
