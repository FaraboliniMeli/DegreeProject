package br.com.marcello.DegreeProject.utils;

import br.com.marcello.DegreeProject.dto.SubjectDto;

import java.util.List;

public interface DegreeUtils {

    Double getAverage(List<SubjectDto> subjects);

    String getMessage(Double average);

}
