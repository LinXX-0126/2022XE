import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private double grade;
    private boolean isOff;

    public static void main(String[] args) {
        //create student items
        Student x1 = new Student("222100201","学生1",96,false);
        Student x2 = new Student("222100200","学生2",60,true);
        Student x3 = new Student("222100209","学生3",43,false);

        //test toString()
        System.out.println(x1);
        System.out.println();

        //test getters
        System.out.println(x2.getName()+"'s grade is"+x2.getGrade()+" with id:"+x2.getId());
        System.out.println();

        //test setters
        Student x4 = new Student();
        System.out.println("x4:"+x4);
        x4.setId("222100205");
        x4.setName("学生4");
        x4.setGrade(63);
        x4.setOff(false);
        System.out.println();

        //test isPassed()
        System.out.println(x4);
        System.out.println("x4 pass the exam:"+x4.isPassed());
        System.out.println();

        //test unpassedList()
        Student[] studentList = {x1,x2,x3,x4};

        System.out.println(unpassedList(studentList));
        update(x3,98);
        System.out.println(unpassedList(studentList));
        System.out.println();

        //Using user input
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Do you want to upload student information? (Y/N)");
            String s = sc.next();
            if (s.equals("Y")){
                createStudent();
            }else if (s.equals("N")){
                sc.close();
                return;
            }else {
                System.out.println("Wrong react.");
                return;
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isOff() {
        return isOff;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setOff(boolean off) {
        isOff = off;
    }


    public String toString() {
        return "[name]: " + name  +
                ", [id]: " + id  +
                ", [grade]: " + grade +
                ", [isOff]: " + isOff +".";
    }

    public Student(){

    }

    public Student(String ID,String Name,double MathGrade,boolean Off){
        this.id = ID;
        this.name = Name;
        this.grade = MathGrade;
        this.isOff = Off;
    }

    public static void update(Student student,double grade){
        if ((student.grade>Integer.MIN_VALUE) && (student.grade<Integer.MAX_VALUE)) {
            if (!student.isOff()){
                student.grade = grade;
                if ((student.grade<=100)){
                    student.grade += grade;
                    System.out.println("Success.");
                    System.out.println("Student "+student.name+"'s grade is updated: "+student.grade);
                }else {
                    System.out.println("Failed.The grade should not greater than 100.");
                }
            }else {
                System.out.println("Failed.This student is off.");
            }
        }else {
            System.out.println("Failed.This student's grade is invalid.");
        }
    }

    public boolean isPassed(){
        return this.grade >= 60;
    }

    public static String unpassedList(Student[] students){
        StringBuilder off = new StringBuilder("退学名单：");
        StringBuilder unpassed = new StringBuilder("挂科名单： ");
        for (Student student : students) {
            if (student.isOff) {
                off.append(student);
            }
            if ((student.grade < 60) && (!student.isOff)) {
                unpassed.append(student);
            }
        }
        return off.toString() +'\n'+unpassed;
    }


    //Using Scanner to create student constant.
    public static void createStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many student?");
        int listLength = sc.nextInt();
        Student[] studentList2 = new Student[listLength];
        for (int i = 0; i < listLength; i++) {
            System.out.println("Type the student's id:");
            String id = sc.next();
            System.out.println("Type the student's name:");
            String name = sc.next();
            System.out.println("Type the student's grade:");
            double grade = sc.nextDouble();
            System.out.println("Type the student's isOff(true/false):");
            String Off = sc.next();
            boolean isOff = Off.equals("true");
            Student student = new Student(id,name,grade,isOff);
            studentList2[i]=student;
        }

        for (Student student : studentList2) {
            System.out.println(student);
        }
    }
}
