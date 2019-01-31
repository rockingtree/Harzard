package Harzard_1_1.test;

import Harzard_1_1.dao.BaseDao;

import java.io.InputStream;

public class PrintProper {
    public static void main(String[] args) {
        InputStream is = BaseDao.class.getResourceAsStream("/database.properties");

    }
}
