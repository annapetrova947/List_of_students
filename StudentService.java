package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList = new ArrayList<>();
    private final String filePath = "src\\data\\students.txt";

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void addSubjectToStudent(String studentName, Subject subject){
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if(student.getName().equals(studentName)){
                student.addSubject(subject);
            }
        }
    }

    public double getStudentAverageMark(String studentName){
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if(student.getName().equals(studentName)){
                return student.getAverageMark();
            }
        }
        return -1;
    }

    public Student compareStudentsByAverageMark(String studentName1, String studentName2){
        Student student1=null;
        Student student2=null;
        //ищем первого студента
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if(student.getName().equals(studentName1)){
                student1 = student;
            }
        }
        //ищем второго студента
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if(student.getName().equals(studentName2)){
                student2 = student;
            }
        }
        return student1.getSmarterStudent(student2);
    }

    public void removeStudent(String studentName){
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if(student.getName().equals(studentName)){
                studentList.remove(student);
            }
        }
    }



    public void printStudent(){
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    public void saveToFile(String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(studentList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(){
       saveToFile(filePath);
    }

    public void loadFromFile(String path){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            studentList = (List<Student>)ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        loadFromFile(filePath);
    }
}
