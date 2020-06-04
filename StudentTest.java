package data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    Student st1;
    @Before
    public void createStudentTest(){
        st1 = new Student("Ivan");
        st1.addSubject(new Subject("Math", 4));
        st1.addSubject(new Subject("Rus", 5));
    }

    @Test
    public void getSubjectListTest() {
        List<Subject> expectedSubjectList = new ArrayList<>();
        expectedSubjectList.add(new Subject("Math", 4));
        expectedSubjectList.add(new Subject("Rus", 5));
        assertEquals(expectedSubjectList, st1.getSubjectList());
    }

    @Test
    public void getSubjectMarkTest() {
        assertEquals(4, st1.getSubjectMark("Math"));
    }

    @Test
    public void getAverageMarkTest() {
        assertEquals(4.5, st1.getAverageMark(), 0);
    }

    @Test
    public void getSmarterStudentTest() {
        Student st2 = new Student("Petr");
        st2.addSubject(new Subject("Math", 3));
        st2.addSubject(new Subject("Rus", 5));

        assertEquals(st1, st1.getSmarterStudent(st2));
    }

    @Test
    public void addSubjectTest() {
        assertEquals(2, st1.getSubjectList().size());
    }
}