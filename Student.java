package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private List<Subject> subjectList = new ArrayList<>();
    private static final int serialVersionUID = 1;

    public Student(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    //возвращает оценку по названию предмета
    public int getSubjectMark(String subjectName){
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = subjectList.get(i);
            if(subject.getName().equals(subjectName)){
                return subject.getMark();
            }
        }
        return -1;
    }

    //средний балл
    public double getAverageMark(){
        double sum=0;
        for (int i = 0; i < subjectList.size(); i++) {
            sum+=subjectList.get(i).getMark();
        }

        return sum / subjectList.size();
    }

    //возвращает более успешного студента по среднему баллу
    public Student getSmarterStudent(Student student){
        double averMark1 = getAverageMark();
        double averMark2 = student.getAverageMark();
        if(averMark1>averMark2){
            return this;
        }else {
            return student;
        }
    }

    public void addSubject(Subject subject){
        subjectList.add(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(subjectList, student.subjectList);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
