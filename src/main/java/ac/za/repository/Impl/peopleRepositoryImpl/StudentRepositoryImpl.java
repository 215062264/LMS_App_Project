//package ac.za.repository.Impl.peopleRepositoryImpl;
//
//import ac.za.domain.people.Student;
//import ac.za.repository.repoInterface.people.StudentRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository("studentRepository")
//public class StudentRepositoryImpl implements StudentRepository {
//
//    private static StudentRepositoryImpl repository = null;
//    private final Set<Student> students;
//
//    private StudentRepositoryImpl() {
//        this.students = new HashSet<>();
//    }
//
//    private Student findP(String studentsId) {
//        return this.students.stream()
//                .filter(students -> students.getStudentId().trim().equals(studentsId))
//                .findAny()
//                .orElse(null);
//    }
//
//    public static StudentRepository getRepository(){
//        if(repository == null) repository = new StudentRepositoryImpl();
//        return repository;
//    }
//
//    public Student create(Student student){
//        this.students.add(student);
//        return student;
//    }
//
//    public Student read(String studentId){
//       Student student = findP(studentId);
//       return student;
//    }
//
//    public Student update(Student student) {
//        Student toDelete = findP(student.getStudentId());
//        if(toDelete != null) {
//            this.students.remove(toDelete);
//            return create(student);
//        }
//        return null;
//    }
//
//    public void delete(String studentId) {
//        Student student = findP(studentId);
//        if (student != null) this.students.remove(student);
//    }
//
//    public Set<Student> getAll(){
//        return this.students;
//    }
//}
//
//
