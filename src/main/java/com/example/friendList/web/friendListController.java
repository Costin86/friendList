package com.example.friendList.web;

import com.example.friendList.domain.Student;
import com.example.friendList.form.StudentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class friendListController {

    private List<Student> students = new ArrayList<>();
    
    @GetMapping("/index")
    public String hello(Model model) {
        model.addAttribute("Message1", "My friends");
        model.addAttribute("Message2", "Add new friend to list");
        model.addAttribute("students", students);
        model.addAttribute("studentForm", new StudentForm()); // Initialize an empty form
        
        return "index";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute StudentForm studentForm) {
        // Create a new Student object and add it to the list
        students.add(new Student(studentForm.getName()));
        return "redirect:/index"; // Redirect back to the /hello page
    }
}
