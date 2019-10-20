package ac.za.factory.peopleFactory;

import ac.za.domain.people.Educator;

public class EducatorFactory {

    public static Educator getEducator(String firstName, String lastName,Integer educatorId, int age) {
        return new Educator.Builder()
                .age(age)
                .educatorFirstName(firstName)
                .educatorLastName(lastName)
                .educatorId(educatorId)
                .build();
    }

}
