package ra.exercise02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào chuỗi");
        String input = sc.nextLine();
        List<String> list = new ArrayList<>(Arrays.asList(input.split(" ")));
        System.out.println("Các chuỗi có độ dài lớn hơn 3 ký tự là: ");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).length() > 3){
                System.out.println(list.get(i));
            }
        }


    }
}
