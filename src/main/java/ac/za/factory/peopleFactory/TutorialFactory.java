package ac.za.factory.peopleFactory;

import ac.za.domain.people.Tutorial;
import ac.za.util.Misc;

public class TutorialFactory {

    public static Tutorial getTutorial(Integer tutorId,String firstName, String lastName) {
        return new Tutorial.Builder()
                .tutorFirstName(firstName)
                .tutorLastName(lastName)
                .tutorId(tutorId)
                .build();
    }

}
