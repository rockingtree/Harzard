package Harzard_1_1.entity;

import Harzard_1_1.util.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String userName;
    private int health;
    private boolean isConcede;
    private int mana;
    private int noDeckCount;
    public List<Card> deck = new ArrayList<>();
    public List<Card> handKeep = new ArrayList<>();
    public List<Card> btField = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isConcede() {
        return isConcede;
    }

    public void setConcede(boolean concede) {
        isConcede = concede;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void drawCard(int drewCardNumber) {
        if (deck.size() > 0) {
            for (int i = 0; i < drewCardNumber; i++) {
                Random random = new Random();
                int ranNum = random.nextInt(deck.size());
                handKeep.add(deck.get(ranNum));
                deck.remove(ranNum);       //从deck中移除抓到的卡
            }
        } else {
            System.out.println("你的牌库已经没有卡牌了");
            health -= noDeckCount;
            noDeckCount++;
        }
    }

    public void viewCards(List<Card> list) {
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(i + ". " + list.get(i - 1).getName() + "\t");
        }
        System.out.println();
    }

    public void playCard() {
        viewCards(handKeep);
        System.out.print("请选择要打出的卡牌(编号): ");
        Tools tools = new Tools();
        int choice = tools.setRange(1, handKeep.size()) - 1;       //list集合对应的下标 减1
        Card playedCard = handKeep.get(choice);
        if (playedCard.getCost() <= mana) {
            System.out.println(userName + "打出了一张" + playedCard.getName());
            btField.add(handKeep.get(choice));
            handKeep.remove(choice);        //最后再移除
            mana -= playedCard.getCost();
            //检查是否有战吼效果
            if (playedCard.getDescription() != null &&
                    playedCard.getDescription().contains("战吼")) {
                //TODO:执行战吼效果
                //此处以精灵弓箭手为例, 她的战吼效果为:
                //战吼：造成1点伤害。
                System.out.print("请选择一个对象, 对其造成一点伤害");
            }
        } else {
            System.out.println("您的费用不足！");
        }
        playedCard.setStatement(0);
    }

    public void showBattleField() {
        for (Card card : btField) {
            System.out.print(card.getCost() + "\t\t\t\t");
        }
        System.out.println();

        for (Card card : btField) {
            System.out.print(card.getName() + "\t");
        }
        System.out.println();

        for (Card card : btField) {
            System.out.print(card.getDescription() + "\t\t");
        }
        System.out.println();

        for (Card card : btField) {
            System.out.print(card.getAttack() + "\t\t" + card.getDefence() + "\t\t");
        }
        System.out.println();

        for (Card card : btField) {
            if (card.getStatement() == 0) {
                System.out.print("召唤失调\t\t\t");
            } else if (card.getStatement() == 1) {
                System.out.print("可以攻击\t\t\t");
            }
        }
        System.out.println();
    }
}
