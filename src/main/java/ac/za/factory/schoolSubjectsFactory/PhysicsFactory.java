package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Physics;

public class PhysicsFactory {

    public static Physics getPhysics(String subjectCode, double mark) {
        return new Physics.Builder()
                .subjectCode(subjectCode)
                .mark(mark)
                .build();
    }

}
