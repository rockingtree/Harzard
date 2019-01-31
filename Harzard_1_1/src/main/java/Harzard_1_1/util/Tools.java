package Harzard_1_1.util;

import java.util.Scanner;

public class Tools {
    private Scanner input = new Scanner(System.in);

    public int setRange(int range1, int range2) {
        int choice;
        while (true) {
            while (true) {
                try {
                    String str = input.next();
                    choice = Integer.valueOf(str);
                    break;
                } catch (Exception e) {
                    //System.out.println("ERROR!");
                    System.out.print("请正确输入：");
                }
            }
            try {
                setRange1(choice, range1, range2);
                break;
            } catch (Exception e) {
                System.out.print("请正确输入: ");
            }
        }
        return choice;
    }

    private void setRange1(int choice, int range1, int range2) throws Exception {
        if (!(choice >= range1 && choice <= range2)) {
            throw new Exception("什么什么");
        }
    }
}
