//package ac.za.repository.Impl.peopleRepositoryImpl;
//
//import ac.za.domain.people.Lecture;
//import ac.za.repository.repoInterface.people.LectureRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//@Repository("lectureRepository")
//public class LectureRepositoryImpl implements LectureRepository {
//
//    private static LectureRepositoryImpl repository = null;
//    private Set<Lecture> lectures;
//
//    private LectureRepositoryImpl() {
//        this.lectures = new HashSet<>();
//    }
//
//    private Lecture findS(String lecturerId) {
//        return this.lectures.stream()
//                .filter(lecture -> lecture.getLecturerId().trim().equals(lecturerId))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static LectureRepository getRepository(){
//        if(repository == null) repository = new LectureRepositoryImpl();
//        return repository;
//    }
//
//    public Lecture create(Lecture lectures){
//        this.lectures.add(lectures);
//        return lectures;
//    }
//
//    public Lecture read(final String lecturerId){
//        Lecture lecture = findS(lecturerId);
//        return lecture;
//    }
//
//    public void delete(String lecturerId) {
//        Lecture lecture = findS(lecturerId);
//        if (lecture != null) this.lectures.remove(lecture);
//    }
//
//    public Lecture update(Lecture lecture){
//        Lecture toDelete = findS(lecture.getLecturerId());
//        if(toDelete != null) {
//            this.lectures.remove(toDelete);
//            return create(lecture);
//        }
//        return null;
//    }
//
//    public Set<Lecture> getAll(){
//        return this.lectures;
//    }
//
//}
