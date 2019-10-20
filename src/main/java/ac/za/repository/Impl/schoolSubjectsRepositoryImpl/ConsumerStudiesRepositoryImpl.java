package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.repository.repoInterface.schoolSubjects.ConsumerStudiesRepository;
import java.util.HashSet;
import java.util.Set;

public class ConsumerStudiesRepositoryImpl implements ConsumerStudiesRepository {

    private static ConsumerStudiesRepositoryImpl repository = null;
    private Set<ConsumerStudies> consumerStudies;

    private ConsumerStudiesRepositoryImpl() {
        this.consumerStudies = new HashSet<>();
    }

    private ConsumerStudies findCon(String subjectCode) {
        return this.consumerStudies.stream()
                .filter(consumerStudies -> consumerStudies.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static ConsumerStudiesRepository getRepository(){
        if(repository == null) repository = new ConsumerStudiesRepositoryImpl();
        return repository;
    }

    public ConsumerStudies create(ConsumerStudies consumerStudies){
        this.consumerStudies.add(consumerStudies);
        return consumerStudies;
    }

    public ConsumerStudies read(String subjectCode){
        ConsumerStudies consumerStudies = findCon(subjectCode);
        return consumerStudies;
    }

    public ConsumerStudies update(ConsumerStudies consumerStudies) {
        ConsumerStudies toDelete = findCon(consumerStudies.getSubjectCode());
        if(toDelete != null) {
            this.consumerStudies.remove(toDelete);
            return create(consumerStudies);
        }
        return null;
    }

    public void delete(String subjectCode) {
        ConsumerStudies consumerStudies = findCon(subjectCode);
        if (consumerStudies != null) this.consumerStudies.remove(consumerStudies);
    }

    public Set<ConsumerStudies> getAll(){
        return this.consumerStudies;
    }


}
