package com.example.studentdb.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentdb.model.Student;
import com.example.studentdb.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService services;

    @RequestMapping("/uploadData")
    public String uploadStudentData(){
        return "uploadData";
    }

    @RequestMapping("/students/list")
    public String showStudentsList(Model model){
        if (services.isListEmpty())
        {
            return "error";
        }
        else{
            List<Student> students = services.findAllStudents();
            System.out.println(students);
            model.addAttribute("students", students);
            return "studentsList";
        }        
    }

    @RequestMapping("/addStudent")
    public String addStudentToDB(@ModelAttribute("student") Student student){
        return "addStudent";
    }

    @RequestMapping(value= "/uploadDoc")
	public String validateFiles(@ModelAttribute MultipartFile file, Model model) {
		if (file.isEmpty()) {
			System.out.println("file is empty, going to error file");
			return "error";
		}
		try {
			String content = file.getContentType();
			System.out.println("file content: " + content);
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			System.out.println(path);
			Files.write(path, bytes);
		}
		catch(Exception e) {
			return "error";
		}
		return "uploadsuccess";
	}

    @RequestMapping(value = "/processForm")
    public String addStudentData(@ModelAttribute Student student){
        System.out.println("entered into the function");
        System.out.println(student);
        services.save(student);
        return "index";
    }

    @RequestMapping(value = "/showUpdateForm")
    public String showUpdateForm(@RequestParam("id") Long id, Model model){
        System.out.println("hello entered to showupdate");
        Optional<Student> student = services.findStudentbyId(id);
        if (student.isPresent()){
            System.out.println(student);
            model.addAttribute("student", student);
            return "updateStudent";
        }
        else{
            return "index";
        }
    }

    @RequestMapping(value = "/showStudentsAboveMe")
    public String showStudentsAboveMyMarks(@RequestParam("id") Long id, Model model){
        Optional<Student> student  = services.findStudentbyId(id);
        List<Student>     students = services.findAllStudents(); 
        if (student.isPresent()){
            System.out.println(student);
            Student stud = student.get();
            List<Student> studs = students.stream().filter(std -> std.getMark() > stud.getMark()).collect(Collectors.toList());
            model.addAttribute("students", studs);
            if (studs.isEmpty()){
                return "index";
            }
            else{
                return "studentEditList";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/updateOthersData")
    public String updateOtherDetails(@RequestParam("id") Long id, @ModelAttribute Student student, Model model){
        Optional<Student> stud = services.findStudentbyId(id);
        System.out.println(student);
        System.out.println(stud);
        List<Student> students = services.findAllStudents();
        model.addAttribute("students", students);
        return "studentsList";
    }
}
