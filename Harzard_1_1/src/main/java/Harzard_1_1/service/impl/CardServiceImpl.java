package Harzard_1_1.service.impl;

import Harzard_1_1.dao.CardDao;
import Harzard_1_1.dao.impl.CardDaoImpl;
import Harzard_1_1.entity.Card;
import Harzard_1_1.service.CardService;

import java.util.Scanner;

public class CardServiceImpl implements CardService {

    @Override
    public void manageCard() {
        System.out.println("1.创建卡牌\t2.修改卡牌\t0.返回");
        System.out.print("请输入选择: ");
        Scanner input=new Scanner(System.in);
        int choice=input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("**创建牌**");
                addCard();
                break;
            case 2:
                System.out.println("**修改卡牌**");
                break;
            default:
                //nothing
        }
    }

    private void addCard() {
        System.out.println("卡牌创建界面");
        System.out.print("是否开始创建卡牌(y/n)?");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        if (!choice.equals("n")) {
            do {
                Card card = new Card();
                System.out.println("请输入卡牌名称: ");
                card.setName(input.next());
                System.out.println("请输入卡牌类型: ");
                card.setType(input.next());
                System.out.println("请输入卡牌费用: ");
                card.setCost(input.nextInt());
                if (card.getType().equals("随从")) {
                    System.out.println("请输入卡牌攻击力");
                    try {
                        card.setAttack(input.nextInt());
                    } catch (Exception e) {
                        System.out.println("ERROR! 请正确输入");
                    }
                    System.out.println("请输入卡牌防御力");
                    card.setDefence(input.nextInt());
                }
                System.out.println("请输入牌面描述: ");
                card.setDescription(input.next());
                System.out.println("请输入背景描述: ");
                card.setComment(input.next());
                CardDao cardDao = new CardDaoImpl();
                cardDao.addCard(card,"card");      //将创建的卡牌添加进数据库
                System.out.print("是否继续(y/n)?");
                choice = input.next();
            } while (!choice.equals("n"));
        }
    }
}

