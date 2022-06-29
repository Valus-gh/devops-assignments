package supsi.cloud.assignment.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supsi.cloud.assignment.demo.model.Course;
import supsi.cloud.assignment.demo.model.Exam;
import supsi.cloud.assignment.demo.model.Student;
import supsi.cloud.assignment.demo.service.CourseService;
import supsi.cloud.assignment.demo.service.ExamService;
import supsi.cloud.assignment.demo.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    ExamService examService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(){
        return "Hello world";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> students = new ArrayList<>(studentService.read());

            if (students.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(students, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            List<Course> courses = new ArrayList<>(courseService.read());

            if (courses.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(courses, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    public ResponseEntity<List<Exam>> getAllExams() {
        try {
            List<Exam> exams = new ArrayList<>(examService.read());

            if (exams.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(exams, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name) {
        try {
            Student student = studentService.read(name);

            if (student == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/courses/{title}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourseByTitle(@PathVariable("title") String title) {
        try {
            Course course = courseService.read(title);

            if (course == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(course, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/exams/{subject}", method = RequestMethod.GET)
    public ResponseEntity<Exam> getExamBySubject(@PathVariable("subject") String subject) {
        try {
            Exam exam = examService.read(subject);

            if (exam == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(exam, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            Student createdStudent = studentService.create(new Student(student.getName(), student.getEmail()));
            return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        try {
            Course createdCourse = courseService.create(new Course(course.getTitle()));
            return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/exams", method = RequestMethod.POST)
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        try {
            Exam createdExam = examService.create(new Exam(exam.getSubject(), exam.getAttendants()));
            return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
