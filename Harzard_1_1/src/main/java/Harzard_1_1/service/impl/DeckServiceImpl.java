package Harzard_1_1.service.impl;

import Harzard_1_1.dao.DeckDao;
import Harzard_1_1.dao.impl.DeckDaoImpl;
import Harzard_1_1.entity.Card;
import Harzard_1_1.service.DeckService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeckServiceImpl implements DeckService {
    //创建方法,从card.xml中读取数据,创建card对象,并放入deck

    /**
     * 创建deck对应的表
     */
    private void createDeck() {
        DeckDao deckDao=new DeckDaoImpl();
        List<Card> cardPool= null;
        try {
            cardPool = deckDao.getDeck();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Card> deck = new ArrayList<>();

        //从cardPool中进行选择,放入deck
        Scanner input = new Scanner(System.in);
        while (deck.size() < 9) {     //暂时只加随从牌
            System.out.print("请输入要加入的卡牌: ");
            Card card = new Card();
            for (Card card1 : cardPool) {
                if (card1.getName().equals(input.next())) {
                    card = card1;
                    break;
                }
            }
            deck.add(card);
        }

        System.out.println("请输入卡组的名称：");
        String deckName = input.next();
        //将deck写入数据库
        deckDao.addDeck(deck,deckName);
    }

    private void viewDeck() {
        System.out.println("1.修改卡组\t2.卡组重命名\t3.删除卡组\t0.返回");
        System.out.print("请输入选择: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("**修改卡组**");
                break;
            case 2:
                System.out.println("**卡组重命名**");
                break;
            case 3:
                System.out.println("**删除卡组**");
                break;
            default:
                //nothing
        }
    }

    private void showDeck() {
        DeckDao deckDao = new DeckDaoImpl();
        try {
            List<Card> deck = deckDao.getDeck();
            for (int i = 0; i < deck.size(); i++) {
                System.out.println(i + 1 + ".\t" + deck.get(i).getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void manageDeck() {
        System.out.println("1.查看卡组\t2.创建卡组\t0.返回");
        System.out.print("请输入选择: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("**查看卡组**");
                showDeck();
                viewDeck();
                break;
            case 2:
                System.out.println("**创建卡组**");
                createDeck();
                break;
            default:
                //nothing
        }
    }
}
