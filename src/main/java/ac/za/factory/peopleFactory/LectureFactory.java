package ac.za.factory.peopleFactory;

import ac.za.domain.people.Lecture;

public class LectureFactory {

    public static Lecture getLecture(Integer lecturerId,String professor, int hrs) {
        return new Lecture.Builder()
                .lecturerId(lecturerId)
                .professor(professor)
                .hours(hrs)
                .build();
    }

}
