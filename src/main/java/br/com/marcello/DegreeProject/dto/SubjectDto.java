package br.com.marcello.DegreeProject.dto;

import javax.validation.constraints.*;

public class SubjectDto {

    @NotNull
    @Size(min = 8, max = 50, message = "Student name must is between 8 and 50 characters.")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "Only letters allowed")
    private String subject;

    @NotNull
    @DecimalMin(value = "0.0", message = "Note must is between 0 and 10")
    @DecimalMax(value = "10.0", message = "Note must is between 0 and 10")
    private Double note;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
