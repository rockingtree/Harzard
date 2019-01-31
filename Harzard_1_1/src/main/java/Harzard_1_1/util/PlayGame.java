package Harzard_1_1.util;

import Harzard_1_1.dao.DeckDao;
import Harzard_1_1.dao.impl.DeckDaoImpl;
import Harzard_1_1.entity.Card;
import Harzard_1_1.entity.Player;
import Harzard_1_1.entity.StonePlayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    private Player playerA = new StonePlayer();
    private Player playerB = new StonePlayer();
    private Player player = playerA;
    private Player opponent = playerB;
    private Tools tools = new Tools();
    private int round = 1;

    public void play() {
        //宣布游戏开始
        playerA.setUserName("大魔王");
        System.out.println("\n游戏开始!\n");

        //初始抓牌,
        //从数据库读取数据,存入deck
        DeckDao deckDao = new DeckDaoImpl();
        try {
            playerA.deck = deckDao.getDeck();
            playerB.deck = deckDao.getDeck();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //playerA抓4张牌
        playerA.drawCard(4);
        //playerB抓4张牌
        playerB.drawCard(4);

        while (player.getHealth() > 0 && opponent.getHealth() > 0 && !opponent.isConcede()) {
            //A的回合开始
            round++;
            System.out.println(player.getUserName() + "的回合开始");
            //player法力增加1
            player.setMana((round + 1) / 2);
            if (player.getMana() >= 10) {
                player.setMana(10);
            }

            goTurn(player);

            if (player == playerA) {
                player = playerB;
                opponent = playerA;
            } else {
                player = playerA;
                opponent = playerB;
            }
        }
    }

    public void announceResult() {
        showBoardField(playerA, playerB);
        //宣布游戏结果
        if (playerA.getHealth() <= 0 || playerA.isConcede()) {
            System.out.println(playerB.getUserName() + "获得胜利!");
        }
        if (playerB.getHealth() <= 0 || playerB.isConcede()) {
            System.out.println(playerA.getUserName() + "获得胜利!");
        }
        System.out.println("\n游戏结束!");
        System.out.println("回合数：" + round);
        System.out.println("\n***************************************************\n");
    }

    private void goTurn(Player player) {
        player.drawCard(1);
        for (Card card : player.btField) {
            card.setStatement(1);
        }
        playOption();
    }

    private void playOption() {
        showBoardField(playerA, playerB);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            List<String> choices = new ArrayList<>();
            int i = 1;
            if (player.handKeep.size() > 0) {       //有手牌
                System.out.print(i + ".查看手牌\t");
                choices.add("check");
                i++;
            }
            if (player.btField.size() < 4 && canPlayCard()) {    //战场随从没满
                System.out.print(i + ".打出手牌\t");
                choices.add("play");
                i++;
            }
            if (player.btField.size() > 0 && canAttack()) {    //战场有随从
                System.out.print(i + ".随从攻击\t");
                choices.add("attack");
                i++;
            }
            System.out.print(i + ".结束回合\t");
            choices.add("end");
            System.out.print(i + 1 + ".认输\n");
            choices.add("concede");
            System.out.print(player.getUserName() + ", 请输入你的选择：");
            int option = tools.setRange(1, choices.size());
            switch (choices.get(option - 1)) {
                case "check":
                    player.viewCards(player.handKeep);
                    break;
                case "play":
                    player.playCard();
                    showBoardField(playerA, playerB);
                    break;
                case "attack":
                    if (!doBattle()) {
                        return;
                    }
                    break;
                case "concede":
                    System.out.print("确定认输吗?(y/n) ");
                    Scanner input = new Scanner(System.in);
                    if (input.next().equalsIgnoreCase("y")) {
                        player.setConcede(true);
                    } else {
                        break;
                    }
                case "end":
                    isContinue = false;
            }
        }
        //A的回合结束
        System.out.println(player.getUserName() + "的回合结束");
        System.out.println();
    }

    private boolean canPlayCard() {
        for (Card card : player.handKeep) {
            if (card.getCost() <= player.getMana()) {
                return true;
            }
        }
        return false;
    }

    private boolean canAttack() {
        for (Card card : player.btField) {
            if (card.getStatement() == 1) {
                return true;
            }
        }
        return false;
    }

    private void showBoardField(Player playerA, Player playerB) {
        System.out.println();
        System.out.println("这里是B的手牌, 数量" + playerB.handKeep.size());
        System.out.print(playerB.getUserName());
        System.out.print("\t\t**************" + playerB.getHealth() + "**************\t法力值: " + playerB.getMana());
        System.out.println(" \t牌库: " + playerB.deck.size());
        System.out.println();
        playerB.showBattleField();
        System.out.println();
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
        System.out.println();
        playerA.showBattleField();
        System.out.println();
        System.out.print(playerA.getUserName());
        System.out.print("\t\t**************" + playerA.getHealth() + "**************\t法力值: " + playerA.getMana());
        System.out.println(" \t牌库: " + playerA.deck.size());
        System.out.println("这里是A的手牌, 数量" + playerA.handKeep.size());
        System.out.println();
    }

    private boolean doBattle() {
        showBoardField(playerA, playerB);
        System.out.print("请选择要进行攻击的随从(编号): ");
        player.viewCards(player.btField);
        int choice = tools.setRange(1, player.btField.size()) - 1;
        Card atkMinion = player.btField.get(choice);
        if (atkMinion.getStatement() == 1) {
            System.out.print("请选择要攻击的对象(编号): ");
            System.out.println("(攻击对面英雄，请输入“0”)");
            opponent.viewCards(opponent.btField);
            int choice2 = tools.setRange(0, opponent.btField.size()) - 1;
            if (choice2 == -1) {
                //对面英雄减血
                opponent.setHealth(opponent.getHealth() - atkMinion.getAttack());
                if (opponent.getHealth() <= 0) {
                    return false;
                }
            } else {
                //两个随从互相攻击
                Card dfdMinion = opponent.btField.get(choice2);
                dfdMinion.setDefence(dfdMinion.getDefence() - atkMinion.getAttack());
                atkMinion.setDefence(atkMinion.getDefence() - dfdMinion.getAttack());
                if (dfdMinion.getDefence() <= 0) {
                    opponent.btField.remove(dfdMinion);
                }
                if (atkMinion.getDefence() <= 0) {
                    player.btField.remove(atkMinion);
                }
            }
            atkMinion.setStatement(0);
        } else {
            System.out.println("该随从处于召唤失调，无法攻击");
        }
        return true;
    }
}
