package Harzard_1_1.dao.impl;

import Harzard_1_1.dao.BaseDao;
import Harzard_1_1.dao.CardDao;
import Harzard_1_1.entity.Card;

public class CardDaoImpl extends BaseDao implements CardDao {

    @Override
    public void addCard(Card card, String deckName) {
        int rs = executeUpdate("insert into " + deckName +
                        "  values(default,?,?,?,?,?,?,?)",
                card.getName(), card.getType(),
                card.getCost(), card.getDescription(), card.getAttack(),
                card.getDefence(), card.getComment());
        if (rs != 0) {
            System.out.println("添加成功. ");
        }
    }
}
