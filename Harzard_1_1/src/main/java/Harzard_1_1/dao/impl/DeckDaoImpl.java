package Harzard_1_1.dao.impl;

import Harzard_1_1.dao.BaseDao;
import Harzard_1_1.dao.CardDao;
import Harzard_1_1.dao.DeckDao;
import Harzard_1_1.entity.Card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeckDaoImpl extends BaseDao implements DeckDao {

    /**
     * 将deck写入数据库
     * @param deck 卡组
     * @param deckName  卡组名
     */
    @Override
    public void addDeck(List<Card> deck, String deckName) {
        String sqlForCreateDeck = "create table " + deckName + " (id smallint not null " +
                " primary key auto_increment comment '卡牌ID'," +
                " name        varchar(20) not null comment '卡牌名称'," +
                " type        varchar(3)  not null comment '卡牌类型'," +
                " cost        int(2)      not null comment '卡牌费用'," +
                " description varchar(50) comment '卡牌描述'," +
                " attack      int(2)      comment '攻击力'," +
                " defence     int(2)      comment '防御力'," +
                " comment     varchar(50) comment '卡牌背景')";
        executeUpdate(sqlForCreateDeck);
        CardDao cardDao = new CardDaoImpl();
        for (Card card : deck) {
            cardDao.addCard(card, deckName);
        }
        closeAll();
    }

    /**
     * 从数据库读取deck
     * @return  读取得到的卡组
     */
    @Override
    public List<Card> getDeck() throws SQLException {
        List<Card> deck = new ArrayList<>();        //创建deck的list集合
        String sql = "select * from card";
        ResultSet rs = executeQuery(sql);
        while (rs.next()) {
            Card card = new Card();     //创建card对象
            card.setId(rs.getInt(1));
            card.setName(rs.getString(2));
            card.setType(rs.getString(3));
            card.setCost(rs.getInt(4));
            card.setDescription(rs.getString(5));
            card.setAttack(rs.getInt(6));
            card.setDefence(rs.getInt(7));
            card.setComment(rs.getString(8));
            deck.add(card);
        }
        closeAll();
        return deck;
    }
}
