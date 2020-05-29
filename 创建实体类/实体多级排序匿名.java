
import java.util.ArrayList;
import java.util.*;

/**
*   学生类
*/
class Student {

    String name;
    int age;
    int score;

    public Student(String name, int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
public class test4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("大铭", 19, 89));
        students.add(new Student("来福", 26, 90));
        students.add(new Student("仓颉", 23, 70));
        students.add(new Student("王磊", 18, 80));

        System.out.println("排序前:");
        for (Student student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }

        Collections.sort(students,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return o1.age-o2.age;
            }
        });

        System.out.println("排序后:");
        for (Student student : students) {
            System.out.println("姓名："+student.name+" 年龄："+student.age+" 成绩："+student.score);
        }
    }
