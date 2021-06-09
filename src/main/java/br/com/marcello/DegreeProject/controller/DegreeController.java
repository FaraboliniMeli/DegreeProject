package br.com.marcello.DegreeProject.controller;

import br.com.marcello.DegreeProject.dto.DegreeDto;
import br.com.marcello.DegreeProject.dto.StudentDto;
import br.com.marcello.DegreeProject.utils.DegreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/degree")
public class DegreeController {

    @Autowired
    private DegreeUtils degreeUtils;

    @PostMapping("/receiveDegree")
    public ResponseEntity<?> getDegree(@RequestBody @Valid StudentDto studentDto) {

        Double average = this.degreeUtils.getAverage(studentDto.getSubjects());
        String message = this.degreeUtils.getMessage(average);

        DegreeDto degreeDto = new DegreeDto();
        degreeDto.setStudentDto(studentDto);
        degreeDto.setMessage(message);
        degreeDto.setAverage(average);

        return new ResponseEntity<>(degreeDto, HttpStatus.OK);
    }

}
