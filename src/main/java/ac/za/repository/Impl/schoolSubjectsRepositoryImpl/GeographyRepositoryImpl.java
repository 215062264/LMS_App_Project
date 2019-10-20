package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.repository.repoInterface.schoolSubjects.GeographyRepository;
import java.util.HashSet;
import java.util.Set;

public class GeographyRepositoryImpl implements GeographyRepository {

    private static GeographyRepositoryImpl repository = null;
    private Set<Geography> geographies;

    private GeographyRepositoryImpl() {
        this.geographies = new HashSet<>();
    }

    private Geography findGeo(String subjectCode) {
        return this.geographies.stream()
                .filter(geography -> geography.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static GeographyRepository getRepository(){
        if(repository == null) repository = new GeographyRepositoryImpl();
        return repository;
    }

    public Geography create(Geography geographies){
        this.geographies.add(geographies);
        return geographies;
    }

    public Geography read(String subjectCode){
        Geography english = findGeo(subjectCode);
        return english;
    }

    public Geography update(Geography geography) {
        Geography toDelete = findGeo(geography.getSubjectCode());
        if(toDelete != null) {
            this.geographies.remove(toDelete);
            return create(geography);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Geography geography = findGeo(subjectCode);
        if (geographies != null) this.geographies.remove(geography);
    }

    public Set<Geography> getAll(){
        return this.geographies;
    }


}
