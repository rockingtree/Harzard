package Harzard_1_1.test;

import Harzard_1_1.service.CardService;
import Harzard_1_1.service.DeckService;
import Harzard_1_1.service.impl.CardServiceImpl;
import Harzard_1_1.service.impl.DeckServiceImpl;
import Harzard_1_1.util.PlayGame;
import Harzard_1_1.util.Tools;

/**
 * 炉石VS万智牌
 *
 * @author chansr
 * @version 1.1
 * 未标注日期，表示没有进行编写
 * 11/4     完成将工程搬入D.E.S.T模式
 */
public class Harzard {
    public static void main(String[] args) {
        Tools tools = new Tools();
        //显示欢迎信息
        System.out.println("欢迎来到炉石VS万智牌");

        boolean isContinue = true;
        while (isContinue) {
            //选择进行的操作
            //1.开始游戏    2.管理卡组      3.管理卡牌
            //2.1查看卡组   2.2创建卡组     2.0返回
            //2.1.1修改卡组     2.1.2卡组重命名      2.1.3删除卡组
            //3.1创建卡牌   3.2修改卡牌     3.0返回
            System.out.println("1.开始游戏\t2.管理卡组\t3.管理卡牌\t0.退出游戏");
            System.out.print("请输入选择: ");

            int mChoice = tools.setRange(0, 3);
            switch (mChoice) {
                case 1:     //开始游戏
                    PlayGame playGame = new PlayGame();
                    playGame.play();
                    playGame.announceResult();
                    break;
                case 2:     //管理卡组
                    DeckService deckService = new DeckServiceImpl();
                    deckService.manageDeck();
                    break;
                case 3:     //管理卡牌,将来会添加登录验证
                    CardService cardService = new CardServiceImpl();
                    cardService.manageCard();
                    break;
                default:
                    isContinue = false;
            }
        }
        System.out.println("游戏已退出");
    }
}
