package br.com.marcello.DegreeProject.dto;

import br.com.marcello.DegreeProject.entities.Student;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class DegreeDto {

    @Valid
    private StudentDto studentDto;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double average;

    @Size(min = 8, max = 50, message = "Student name must is between 8 and 50 characters.")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Only letters allowed")
    private String message;

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
