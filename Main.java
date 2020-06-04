package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.loadFromFile();
        Scanner scn = new Scanner(System.in);
        String userInput = "";
        while(!userInput.equals("7")){
            System.out.println("1. Вывести всех студентов");
            System.out.println("2. Добавить студента");
            System.out.println("3. Добавить предмет студенту");
            System.out.println("4. Удалить студента");
            System.out.println("5. Вывести средний балл студента");
            System.out.println("6. Сравнить двух студентов по среднему баллу");
            System.out.println("7. Выход");
            userInput = scn.next();
            if(userInput.equals("1")){
                studentService.printStudent();
            }
            else if(userInput.equals("2")){
                System.out.println("Введите имя студента");
                String name = scn.next();
                studentService.addStudent(new Student(name));
                System.out.println("Студент добавлен");
            }
            else if(userInput.equals("3")){
                System.out.println("Введите имя студента");
                String name = scn.next();
                System.out.println("Введите название предмета, который хотите добавить");
                String subName = scn.next();
                System.out.println("Введите оценку по предмету, который хотите добавить");
                int mark = scn.nextInt();
                studentService.addSubjectToStudent(name, new Subject(subName, mark));
                System.out.println("Предмет добавлен");
            }
            else if(userInput.equals("4")){
                System.out.println("Введите имя студента");
                String name = scn.next();
                studentService.removeStudent(name);
                System.out.println("Студент удален");
            }
            else if(userInput.equals("5")){
                System.out.println("Введите имя студента");
                String name = scn.next();
                double averageMark = studentService.getStudentAverageMark(name);
                System.out.println(averageMark);
            }
            else if(userInput.equals("6")){
                System.out.println("Введите имя первого студента для сравнения");
                String name1 = scn.next();
                System.out.println("Введите имя второго студента для сравнения");
                String name2 = scn.next();
                Student smarterStudent = studentService.compareStudentsByAverageMark(name1, name2);
                System.out.println("У студента "+smarterStudent.getName()+" средний балл выше");
            }
            else if(userInput.equals("7")){
                studentService.saveToFile();
                System.out.println("Данные сохранены");
            }
        }







//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//
//        try {
        //сериализация списка list
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\data\\students.txt"));
//            oos.writeObject(list);
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        List<Integer> list=null;
//        try {
        //десериализация списка list (считывание из файла и преобразование в объект)
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\data\\students.txt"));
//            list = (List<Integer>)ois.readObject();
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
    }
}
