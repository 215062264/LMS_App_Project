package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.repository.repoInterface.schoolSubjects.EconomicsRepository;
import java.util.HashSet;
import java.util.Set;

public class EconomicsRepositoryImpl implements EconomicsRepository {

    private static EconomicsRepositoryImpl repository = null;
    private Set<Economics> economics;

    private EconomicsRepositoryImpl() {
        this.economics = new HashSet<>();
    }

    private Economics findEco(String subjectCode) {
        return this.economics.stream()
                .filter(economics -> economics.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static EconomicsRepository getRepository(){
        if(repository == null) repository = new EconomicsRepositoryImpl();
        return repository;
    }

    public Economics create(Economics economics){
        this.economics.add(economics);
        return economics;
    }

    public Economics read(String subjectCode){
        Economics economics = findEco(subjectCode);
        return economics;
    }

    public Economics update(Economics economics) {
        Economics toDelete = findEco(economics.getSubjectCode());
        if(toDelete != null) {
            this.economics.remove(toDelete);
            return create(economics);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Economics economics = findEco(subjectCode);
        if (economics != null) this.economics.remove(economics);
    }

    public Set<Economics> getAll(){
        return this.economics;
    }


}
