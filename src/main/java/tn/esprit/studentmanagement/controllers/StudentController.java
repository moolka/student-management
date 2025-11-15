package tn.esprit.studentmanagement.controllers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.studentmanagement.entities.Student;
import tn.esprit.studentmanagement.services.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class StudentController {
IStudentService studentService;
 private static final Logger logger = LogManager.getLogger(StudentController.class);

  

    @GetMapping("/getAllStudents")
public List<Student> getAllStudents() {
    logger.info("Récupération de tous les étudiants");
    return studentService.getAllStudents();
}

@GetMapping("/getStudent/{id}")
public Student getStudent(@PathVariable Long id) {
    logger.info("Récupération de l'étudiant avec id = {}", id);
    return studentService.getStudentById(id);
}

@PostMapping("/createStudent")
public Student createStudent(@RequestBody Student student) {
    logger.info("Création d'un nouvel étudiant : {}", student);
    return studentService.saveStudent(student);
}

@PutMapping("/updateStudent")
public Student updateStudent(@RequestBody Student student) {
    logger.info("Mise à jour de l'étudiant : {}", student);
    return studentService.saveStudent(student);
}

@DeleteMapping("/deleteStudent/{id}")
public void deleteStudent(@PathVariable Long id) {
    logger.info("Suppression de l'étudiant avec id = {}", id);
    studentService.deleteStudent(id);
}

}
