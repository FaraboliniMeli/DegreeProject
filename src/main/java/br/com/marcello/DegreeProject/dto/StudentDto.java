package br.com.marcello.DegreeProject.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDto {

    @Size(min = 8, max = 50, message = "Student name must is between 8 and 50 characters.")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Only letters allowed in name field")
    private String name;

    @Valid
    private List<SubjectDto> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }
}
