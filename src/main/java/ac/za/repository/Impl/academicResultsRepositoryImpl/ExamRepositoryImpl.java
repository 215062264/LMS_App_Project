//package ac.za.repository.Impl.academicResultsRepositoryImpl;
//
//import ac.za.domain.academicResults.Exam;
//import ac.za.repository.repoInterface.academicResults.ExamRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class ExamRepositoryImpl implements ExamRepository {
//
//    private static ExamRepositoryImpl repository = null;
//    private Set<Exam> exams;
//
//    private ExamRepositoryImpl() {
//        this.exams = new HashSet<>();
//    }
//
//    private Exam findE(String studentNum) {
//        return this.exams.stream()
//                .filter(exam -> exam.getStudentNum().trim().equals(studentNum))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static ExamRepository getRepository(){
//        if(repository == null) repository = new ExamRepositoryImpl();
//        return repository;
//    }
//
//    public Exam create(Exam exams){
//        this.exams.add(exams);
//        return exams;
//    }
//
//    public Exam read(final String studentId){
//        Exam exam = findE(studentId);
//        return exam;
//    }
//
//    public void delete(String studentId) {
//        Exam exam = findE(studentId);
//        if (exam != null) this.exams.remove(exam);
//    }
//
//    public Exam update(Exam exam){
//        Exam toDelete = findE(exam.getStudentNum());
//        if(toDelete != null) {
//            this.exams.remove(toDelete);
//            return create(exam);
//        }
//        return null;
//    }
//
//    public Set<Exam> getAll(){
//        return this.exams;
//    }
//
//}
