//package ac.za.repository.Impl.academicResultsRepositoryImpl;
//
//import ac.za.domain.academicResults.Quiz;
//import ac.za.repository.repoInterface.academicResults.QuizRepository;
//import java.util.HashSet;
//import java.util.Set;
//
//public class QuizRepositoryImpl implements QuizRepository {
//
//
//    private static QuizRepositoryImpl repository = null;
//    private Set<Quiz> quizzes;
//
//    private QuizRepositoryImpl() {
//        this.quizzes = new HashSet<>();
//    }
//
//    private Quiz findE(String studentNum) {
//        return this.quizzes.stream()
//                .filter(quiz -> quiz.getStudentNum().trim().equals(studentNum))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static QuizRepository getRepository(){
//        if(repository == null) repository = new QuizRepositoryImpl();
//        return repository;
//    }
//
//    public Quiz create(Quiz quizzes){
//        this.quizzes.add(quizzes);
//        return quizzes;
//    }
//
//    public Quiz read(final String studentId){
//        Quiz quiz = findE(studentId);
//        return quiz;
//    }
//
//    public void delete(String studentId) {
//        Quiz quiz = findE(studentId);
//        if (quiz != null) this.quizzes.remove(quiz);
//    }
//
//    public Quiz update(Quiz quiz){
//        Quiz toDelete = findE(quiz.getStudentNum());
//        if(toDelete != null) {
//            this.quizzes.remove(toDelete);
//            return create(quiz);
//        }
//        return null;
//    }
//
//    public Set<Quiz> getAll(){
//        return this.quizzes;
//    }
//
//}
