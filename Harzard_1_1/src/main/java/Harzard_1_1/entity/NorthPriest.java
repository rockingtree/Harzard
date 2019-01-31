package Harzard_1_1.entity;

public class NorthPriest extends Creature {
    public NorthPriest() {
        name = "北郡牧师";
        attack = 1;
        totalDefence = 3;
    }

    public void method(int defenceBefore, int defenceAfter) {
        if (defenceAfter > defenceBefore) {
            this.controller.drawCard(1);
        }
    }
}
