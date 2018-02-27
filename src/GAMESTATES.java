public class GAMESTATES {

    private static boolean play = true;
    private static boolean menu = false;
    private static boolean end = false;
    private static boolean pause = false;

    public static void End(){
        play = false;
        end = true;
    }

    public static boolean isPlay() {
        return play;
    }

    public static boolean isMenu() {
        return menu;
    }

    public static boolean isEnd() {
        return end;
    }

    public static boolean isPause() {
        return pause;
    }
}
