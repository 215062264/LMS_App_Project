package ac.za.factory.peopleFactory;

import ac.za.domain.people.Student;
import ac.za.util.Misc;

public class StudentFactory {

    public static Student getStudent(Integer studentId,String firstName, String lastName, int age) {
        return new Student.Builder()
                .age(age)
                .studentId(studentId)
                .studentFirstName(firstName)
                .studentLastName(lastName)
                .build();
    }

}
