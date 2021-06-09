package br.com.marcello.DegreeProject.utils;

import br.com.marcello.DegreeProject.dto.SubjectDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DegreeUtilsImpl implements DegreeUtils {

    private final double averageForHonors = 9.;

    @Override
    public Double getAverage(List<SubjectDto> subjects) {

        return subjects.stream()
                .mapToDouble(SubjectDto::getNote)
                .average()
                .getAsDouble();

    }

    @Override
    public String getMessage(Double average) {
        if(average > this.averageForHonors)
            return "Congratulations, approved with merits and average " + average;
        return "Student approved with average " + average;
    }
}
