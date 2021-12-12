package com.example.studentenrollment.enrollment.web;
import com.example.studentenrollment.enrollment.business.EnrollmentService;
import com.example.studentenrollment.enrollment.model.api.StudentDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/enrollment")
public class StudentEnrollmentController {

    @Autowired
    private  EnrollmentService service;

    @PostMapping
    public Mono<Void> createStudent(@RequestBody StudentDataRequest request){
        return service.enrollStudent(request);
    }


}
