package ra.exercise01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyList {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();
        int size = rand.nextInt(10) + 1;
        for (int i = 0; i < size; i++) {
            numberList.add(rand.nextInt(100));
        }
        System.out.println("Danh sách ngẫu nhiên: "+numberList);
        int max = Collections.max(numberList);
        System.out.println("Phần tử lớn nhất trong danh sách: " + max);



    }
}
