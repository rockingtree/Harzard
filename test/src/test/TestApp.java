package test;

import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        System.out.println("请输入姓名: ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("你的名字是: "+ name);
    }
}
