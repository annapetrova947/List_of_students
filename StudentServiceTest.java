package data;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {

    StudentService studentService;
    @Before
    public void createStudentService(){
        studentService = new StudentService();
    }

    @Test
    public void addStudentTest() {
        studentService.addStudent(new Student("Ivan"));
        studentService.addStudent(new Student("Petr"));
        assertEquals(2, studentService.getStudentList().size());
    }

    @Test
    public void addSubjectToStudentTest() {
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Petr");
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addSubjectToStudent("Petr", new Subject("Math", 4));
        assertEquals(1, student2.getSubjectList().size());
        assertEquals("Math", student2.getSubjectList().get(0).getName());
    }

    @Test
    public void getStudentAverageMarkTest() {
        Student student1 = new Student("Ivan");
        studentService.addStudent(student1);
        studentService.addSubjectToStudent("Ivan", new Subject("Math", 4));
        studentService.addSubjectToStudent("Ivan", new Subject("Rus", 3));
        assertEquals(3.5, studentService.getStudentAverageMark("Ivan"), 0);
    }

    @Test
    public void compareStudentsByAverageMarkTest() {
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Petr");
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addSubjectToStudent("Ivan", new Subject("Math", 4));
        studentService.addSubjectToStudent("Ivan", new Subject("Rus", 3));
        studentService.addSubjectToStudent("Petr", new Subject("Math", 3));
        studentService.addSubjectToStudent("Petr", new Subject("Rus", 5));
        assertEquals("Petr", studentService.compareStudentsByAverageMark("Ivan", "Petr").getName());
    }

    @Test
    public void removeStudentTest() {
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Petr");
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.removeStudent("Petr");
        assertEquals(1, studentService.getStudentList().size());
    }

    @Test
    public void saveAndLoadToFileTest() {
        String testFile = "src\\data\\testStudents.txt";
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Petr");
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.saveToFile(testFile);

        List<Student> actualStudentList=null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFile));
            actualStudentList = (List<Student>)ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(studentService.getStudentList(), actualStudentList);
    }

}