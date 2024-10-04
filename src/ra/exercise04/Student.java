package ra.exercise04;

import java.util.Scanner;

import static ra.exercise04.StudentManagement.students;

public class Student implements Comparable<Student> {
    private int studentId;
    private String studentName;
    private double averageScore;

    public Student() {
    }
    public Student(int studentId, String studentName, double averageScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.averageScore = averageScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    public void inputData(Scanner sc) {
        this.studentId = inputStudentId(sc);
        System.out.println("Nhập tên sinh viên: ");
        this.studentName = sc.nextLine();
        System.out.println("Nhập điểm trung bình");
        this.averageScore = Double.parseDouble(sc.nextLine());

    }
    public int inputStudentId(Scanner sc) {
        System.out.println("Nhập mã sinh viên: ");
        do{
            studentId = Integer.parseInt(sc.nextLine());
            boolean isExist = false;
            for(int i = 0; i<students.size();i++){
                if(students.get(i).getStudentId() == studentId){
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                return studentId;
            }else {
                System.err.println("Mã sinh viên đã tồn tại vui lòng nhập lại");
            }
        }while (true);
    }
    public void displayData() {
        System.out.println("Mã sinh viên: " + studentId + " - Tên sinh viên: " + studentName +" - Điểm trung bình: " + averageScore);
    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
