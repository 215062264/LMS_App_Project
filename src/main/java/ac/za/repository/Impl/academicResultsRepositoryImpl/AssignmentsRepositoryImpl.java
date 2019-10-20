//package ac.za.repository.Impl.academicResultsRepositoryImpl;
//
//import ac.za.domain.academicResults.Assignments;
//import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//@Repository("assignmentRepository")
//public class AssignmentsRepositoryImpl implements AssignmentsRepository {
//
//    private static AssignmentsRepositoryImpl repository = null;
//    private Set<Assignments> assignments;
//
//    private AssignmentsRepositoryImpl() {
//        this.assignments = new HashSet<>();
//    }
//
//    private Assignments findE(String assId) {
//        return this.assignments.stream()
//                .filter(assignments -> assignments.getAssId().trim().equals(assId))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static AssignmentsRepository getRepository(){
//        if(repository == null) repository = new AssignmentsRepositoryImpl();
//        return repository;
//    }
//
//    public Assignments create(Assignments assignments){
//        this.assignments.add(assignments);
//        return assignments;
//    }
//
//    public Assignments read(final String assId){
//        Assignments assignments = findE(assId);
//        return assignments;
//    }
//
//    public void delete(String assId) {
//        Assignments assignments = findE(assId);
//        if (assignments != null) this.assignments.remove(assignments);
//    }
//
//    public Assignments update(Assignments assignments){
//        Assignments toDelete = findE(assignments.getAssId());
//        if(toDelete != null) {
//            this.assignments.remove(toDelete);
//            return create(assignments);
//        }
//        return null;
//    }
//
//    public Set<Assignments> getAll(){
//        return this.assignments;
//    }
//
//}
