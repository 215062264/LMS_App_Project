package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.repository.repoInterface.schoolSubjects.SubjectRepository;
import java.util.HashSet;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository{

    private static SubjectRepositoryImpl repository = null;
    private Set<Subject> subjects;

    private SubjectRepositoryImpl() {
        this.subjects = new HashSet<>();
    }

    private Subject findP(String subjectId) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectId().trim().equals(subjectId))
                .findAny()
                .orElse(null);
    }

    public static SubjectRepository getRepository(){
        if(repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }

    public Subject create(Subject subjects){
        this.subjects.add(subjects);
        return subjects;
    }

    public Subject read(String subjectCode){
        Subject subject = findP(subjectCode);
        return subject;
    }

    public Subject update(Subject subject) {
        Subject toDelete = findP(subject.getSubjectId());
        if(toDelete != null) {
            this.subjects.remove(toDelete);
            return create(subject);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Subject subject = findP(subjectCode);
        if (subject != null) this.subjects.remove(subject);
    }

    public Set<Subject> getAll(){
        return this.subjects;
    }

}
