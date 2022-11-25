package uz.tfi.test_rttm.web.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tfi.test_rttm.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L,"Aziz","Esonov","3-kurs");
        Student student1 = new Student(1L,"Zafar","Zafarov","3-kurs");
        Student student2 = new Student(1L,"Hasan","Hasanov","3-kurs");

        List<Student> students =  new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(
            @PathVariable Long id
    ){
        return ResponseEntity.ok("Malumot o'chirildi");
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(
            @PathVariable Long id
    ){
        Student student = new Student(id,"Aziz","Esonov","3-kurs");
        return ResponseEntity.ok(student);

    }

    @PostMapping("/students")
    public ResponseEntity create(
            @RequestBody
            String student
    ){
        return ResponseEntity.ok(student);
    }


    @GetMapping("/students")
    public ResponseEntity getOne(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam String course
    ){
        Student student = new Student(id,name,lastName,course);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity update(
            @PathVariable
            Long id,
            @RequestBody
            Student newStudent
    ){
        Student student = new Student(1L,"Jahongir","Esonov","3-kurs");
        student.setId(id);
        student.setName(newStudent.getName());
        student.setLastName(newStudent.getLastName());
        student.setCourse(newStudent.getCourse());
        return ResponseEntity.ok(student);

    }
}
