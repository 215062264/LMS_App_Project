package ac.za.factory.schoolSubjectsFactory;

import ac.za.domain.schoolSubjects.Registration;

public class RegistrationFactory {

    public static Registration getRegistration(String status,String regNum) {
        return new Registration.Builder()
                .regNum(regNum)
                .status(status)
                .build();
    }

}
