package test;

import java.util.Random;

public class RandomChoose {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int ranNum = random.nextInt(4) + 1;
            String choice = "";
            switch (ranNum) {
                case 1:
                    choice = "A";
                    break;
                case 2:
                    choice = "B";
                    break;
                case 3:
                    choice = "C";
                    break;
                case 4:
                    choice = "D";
            }
            System.out.println("第" + (i + 1) + "题选 -- " + choice);
        }
    }
}
