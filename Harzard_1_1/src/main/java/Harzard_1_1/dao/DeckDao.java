package Harzard_1_1.dao;

import Harzard_1_1.entity.Card;

import java.sql.SQLException;
import java.util.List;

public interface DeckDao {
    void addDeck(List<Card> deck, String deckName);      //将deck写入数据库

    List<Card> getDeck() throws SQLException;       //从数据库读取deck
}
