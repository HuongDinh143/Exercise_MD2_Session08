package ra.exercise04;

import java.util.*;

public class StudentManagement {
    public static List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {

        Student student1 = new Student(101, "Nguyen Van A", 8.5);
        Student student2 = new Student(102, "Nguyen Van D", 7);
        Student student3 = new Student(103, "Nguyen Van C", 9.5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******Student Management******");
            System.out.println("1. Hiện thị danh sách sinh viên");
            System.out.println("2. Thêm một sinh viên vào danh sách");
            System.out.println("3. Xóa sinh viên theo id");
            System.out.println("4. Tìm sinh viên theo id");
            System.out.println("5. Điểm trung bình của tất cả các sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo điểm tăng dần");
            System.out.println("7. Thoát chương trình");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayDataStudents(students);
                    break;
                case 2:
                    inputStudent(sc);
                    break;
                case 3:
                    deleteStudentById(sc);
                    break;
                case 4:
                    searchStudentById(sc);
                    break;
                case 5:
                    calAverageScore();
                    break;
                case 6:
                    sortScore();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-7 ");
            }
        } while (true);

    }

    public static void displayDataStudents(List<Student> students) {
        students.forEach(Student::displayData);
    }

    public static void inputStudent(Scanner sc) {
        Student student = new Student();
        student.inputData(sc);
        students.add(student);
    }

    public static void deleteStudentById(Scanner sc) {
        System.out.println("Nhập vào mã sinh viên cần xóa");
        int deleteId = Integer.parseInt(sc.nextLine());
        int indexDelete = getIndexStudentId(deleteId);
        if (indexDelete != -1) {
            students.remove(indexDelete);
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }

    }

    public static int getIndexStudentId(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                return i;
            }
        }
        return -1;
    }

    public static void searchStudentById(Scanner sc) {
        System.out.println("Nhập mã sinh viên cần tìm");
        int searchId = Integer.parseInt(sc.nextLine());
        int indexSearch = getIndexStudentId(searchId);
        if (indexSearch != -1) {
            System.out.println(students.get(indexSearch).getStudentName());
        }else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }
    public static void calAverageScore(){
        double avg = 0;
        if(!students.isEmpty()){
            for (Student student : students) {
                avg += student.getAverageScore()/students.size();
            }
            System.out.println("Điểm trung bình của tất cả sinh viên là: "+avg);
        }else {
            System.out.println("Điểm trung bình: 0");
        }
    }
    public static void sortStudentByScore(){
        for (int i = 0; i < students.size()-1; i++) {
            for (int j = i+1; j < students.size(); j++) {
                if (students.get(i).getAverageScore() > students.get(j).getAverageScore()) {
                    Student temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
    }
    public static void sortScore() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageScore(), o2.getAverageScore());
            }
        });
    }


}
