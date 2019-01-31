package Harzard_1_1.test;

import Harzard_1_1.entity.Card;
import Harzard_1_1.entity.Player;

public class TestObj {
    private static void judgeClass(Object object) {
        if (object instanceof Card) {
            System.out.println(((Card) object).getName() + " 是一张卡");
        } else if (object instanceof Player) {
            System.out.println(((Player) object).getUserName() + " 是玩家");
        } else {
            System.out.println("啥都不是");
        }
    }

    public static void main(String[] args) {
        Card card = new Card();
        Player player = new Player();
        judgeClass(card);
        judgeClass(player);
    }
}
