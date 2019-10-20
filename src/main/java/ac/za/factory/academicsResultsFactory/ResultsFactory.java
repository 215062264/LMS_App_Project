package ac.za.factory.academicsResultsFactory;

import ac.za.domain.academicResults.Results;

public class ResultsFactory {

    public static Results getResults(Integer studentNum, double mark) {
        return new Results.Builder()
                .studentNum(studentNum)
                .mark(mark)
                .build();
    }

}
