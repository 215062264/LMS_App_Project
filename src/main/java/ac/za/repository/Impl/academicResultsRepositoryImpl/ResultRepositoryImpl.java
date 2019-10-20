//package ac.za.repository.Impl.academicResultsRepositoryImpl;
//
//import ac.za.domain.academicResults.Results;
//import ac.za.repository.repoInterface.academicResults.ResultRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class ResultRepositoryImpl implements ResultRepository {
//
//    private static ResultRepositoryImpl repository = null;
//    private Set<Results> results;
//
//    private ResultRepositoryImpl() {
//        this.results = new HashSet<>();
//    }
//
//    private Results findE(String studentNum) {
//        return this.results.stream()
//                .filter(results -> results.getStudentNum().trim().equals(studentNum))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static ResultRepository getRepository(){
//        if(repository == null) repository = new ResultRepositoryImpl();
//        return repository;
//    }
//
//    public Results create(Results results){
//        this.results.add(results);
//        return results;
//    }
//
//    public Results read(final String studentId){
//        Results results = findE(studentId);
//        return results;
//    }
//
//    public void delete(String studentId) {
//        Results results = findE(studentId);
//        if (results != null) this.results.remove(results);
//    }
//
//    public Results update(Results results){
//        Results toDelete = findE(results.getStudentNum());
//        if(toDelete != null) {
//            this.results.remove(toDelete);
//            return create(results);
//        }
//        return null;
//    }
//
//    public Set<Results> getAll(){
//        return this.results;
//    }
//
//}
