package Harzard_1_1.test;

import Harzard_1_1.dao.DeckDao;
import Harzard_1_1.dao.impl.DeckDaoImpl;
import Harzard_1_1.entity.Player;

import java.sql.SQLException;

public class TestPrintDeck {
    public static void main(String[] args) throws SQLException {
        Player player=new Player();
        DeckDao deckDao=new DeckDaoImpl();
        player.deck=deckDao.getDeck();
        deckDao.addDeck(player.deck,"testDeck");
    }
}
