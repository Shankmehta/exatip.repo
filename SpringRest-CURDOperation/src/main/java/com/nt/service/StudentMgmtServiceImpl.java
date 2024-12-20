package com.nt.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Student;
import com.nt.repo.IStudentRepository;

@Service("studentService")
public class StudentMgmtServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentrepo;

   

    // Get all students
    @Override
    public Iterable<Student> getAllStudent() {
        return studentrepo.findAll();
    }

    // Register a new student
    @Override
    public String registerStudent(Student student) {
        Student savedStudent = studentrepo.save(student);
        return "Student saved with ID: " + savedStudent.getSno();
    }

    // Get student by ID
    @Override
    public Student getStudentByNo(int no) {
        return studentrepo.findById(no)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + no + " not found"));
    }

    // Update student
    @Override
    public String updateStudent(Student student) {
        if (!studentrepo.existsById(student.getSno())) {
            throw new IllegalArgumentException("Student with ID " + student.getSno() + " not found");
        }
        Student updatedStudent = studentrepo.save(student);
        return "Student updated with ID: " + updatedStudent.getSno();
    }

    // Delete student by ID
    @Override
    public String deleteStudentById(int no) {
        if (!studentrepo.existsById(no)) {
            throw new IllegalArgumentException("Student with ID " + no + " not found");
        }
        studentrepo.deleteById(no);
        return "Student with ID " + no + " has been deleted";
    }

    // Validate user login
    private static final Map<String, String> USERS = Map.of(
            "ADMIN", "ADMIN", 
            "USER1", "USERPASS"
        );

        @Override
        public boolean validateUser(String username, String password) {
            // Check if user exists and password matches
            return USERS.containsKey(username) && USERS.get(username).equals(password);
        }

    // Filter students
    @Override
    public List<Student> filterStudents(Integer filterBySno, String filterBySname) {
        if (filterBySno == null && (filterBySname == null || filterBySname.isEmpty())) {
            return studentrepo.findAll(); // Return all if no filters
        }
        if (filterBySno != null && filterBySname != null && !filterBySname.isEmpty()) {
            return studentrepo.findBySnoAndSnameContaining(filterBySno, filterBySname);
        }
        if (filterBySno != null) {
            return studentrepo.findBySno(filterBySno);
        }
        if (filterBySname != null && !filterBySname.isEmpty()) {
            return studentrepo.findBySnameContaining(filterBySname);
        }
        return studentrepo.findAll(); // Default return all
    }

    // Sort students
    @Override
    public List<Student> getSortedStudents(String sortBy, String order) {
        List<Student> students = (List<Student>) studentrepo.findAll();
        if (sortBy != null) {
            Comparator<Student> comparator = switch (sortBy) {
                case "sno" -> Comparator.comparing(Student::getSno);
                case "sname" -> Comparator.comparing(student -> student.getSname().toLowerCase());
                case "saddress" -> Comparator.comparing(student -> student.getSaddress().toLowerCase());
                case "fees" -> Comparator.comparing(Student::getFees);
                default -> throw new IllegalArgumentException("Invalid sortBy parameter");
            };

            if ("desc".equalsIgnoreCase(order)) {
                comparator = comparator.reversed();
            }
            students = students.stream().sorted(comparator).collect(Collectors.toList());
        }
        return students;
    }
}

