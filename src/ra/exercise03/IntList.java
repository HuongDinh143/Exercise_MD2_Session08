package ra.exercise03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class IntList {
    public static void main(String[] args) {
        List<Integer> numbersList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của list: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần từ thứ: " +(i+1));
            numbersList.add(Integer.parseInt(sc.nextLine()));
        }
        System.out.println("Dãy số nguyên: ");
        numbersList.forEach(number -> System.out.print(number + " "));
        AtomicInteger sum = new AtomicInteger();
        numbersList.forEach(sum::addAndGet);
        System.out.println();
        System.out.println("Tổng các số nguyên trong list: "+sum);
    }
}
