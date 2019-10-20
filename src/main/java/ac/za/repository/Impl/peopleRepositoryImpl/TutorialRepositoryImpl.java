//package ac.za.repository.Impl.peopleRepositoryImpl;
//
//
//import ac.za.domain.people.Tutorial;
//import ac.za.repository.repoInterface.people.TutorialRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//@Repository("tutorRepository")
//public class TutorialRepositoryImpl implements TutorialRepository {
//
//    private static TutorialRepositoryImpl repository = null;
//    private Set<Tutorial> tutorials;
//
//    private TutorialRepositoryImpl() {
//        this.tutorials = new HashSet<>();
//    }
//
//    private Tutorial findTut(String tutId) {
//        return this.tutorials.stream()
//                .filter(tutorial -> tutorial.getTutorId().trim().equals(tutId))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static TutorialRepository getRepository(){
//        if(repository == null) repository = new TutorialRepositoryImpl();
//        return repository;
//    }
//
//    public Tutorial create(Tutorial tutorials){
//        this.tutorials.add(tutorials);
//        return tutorials;
//    }
//
//    public Tutorial read(final String tutId){
//        Tutorial tutorial = findTut(tutId);
//        return tutorial;
//    }
//
//    public void delete(String tutId) {
//        Tutorial tutorial = findTut(tutId);
//        if (tutorial != null) this.tutorials.remove(tutorial);
//    }
//
//    public Tutorial update(Tutorial tutorial){
//        Tutorial toDelete = findTut(tutorial.getTutorId());
//        if(toDelete != null) {
//            this.tutorials.remove(toDelete);
//            return create(tutorial);
//        }
//        return null;
//    }
//
//    public Set<Tutorial> getAll(){
//        return this.tutorials;
//    }
//
//}
