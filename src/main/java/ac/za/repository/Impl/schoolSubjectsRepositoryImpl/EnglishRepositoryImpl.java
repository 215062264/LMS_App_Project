package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.English;
import ac.za.repository.repoInterface.schoolSubjects.EnglishRepository;
import java.util.HashSet;
import java.util.Set;

public class EnglishRepositoryImpl implements EnglishRepository{

    private static EnglishRepositoryImpl repository = null;
    private Set<English> englishes;

    private EnglishRepositoryImpl() {
        this.englishes = new HashSet<>();
    }

    private English findEng(String subjectCode) {
        return this.englishes.stream()
                .filter(english -> english.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static EnglishRepository getRepository(){
        if(repository == null) repository = new EnglishRepositoryImpl();
        return repository;
    }

    public English create(English englishes){
        this.englishes.add(englishes);
        return englishes;
    }

    public English read(String subjectCode){
        English english = findEng(subjectCode);
        return english;
    }

    public English update(English english) {
        English toDelete = findEng(english.getSubjectCode());
        if(toDelete != null) {
            this.englishes.remove(toDelete);
            return create(english);
        }
        return null;
    }

    public void delete(String subjectCode) {
        English english = findEng(subjectCode);
        if (englishes != null) this.englishes.remove(english);
    }

    public Set<English> getAll(){
        return this.englishes;
    }


}
