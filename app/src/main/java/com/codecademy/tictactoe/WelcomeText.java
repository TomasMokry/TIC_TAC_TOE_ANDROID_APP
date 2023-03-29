package com.codecademy.tictactoe;



public class WelcomeText {
    public static String text1 = "Welcome to Tic Tac Toe";
    public static String text2 = "GAME RULES:";
    public static String text3 = "Each player can place one mark (or stone)\n" +
            "per turn on the 3x3 grid. The WINNER is\n" +
            "who succeeds in placing three of their\n" +
            "marks in a:";
    public static String text4 = "* horizontal,\n" +
            "* vertical or\n" +
            "* diagonal row";

    public static String text5 = "Let's start the game";
    public static String divider = "=========================================";

    @Override
    public String toString() {
        return text1 +"\n"
                + divider + "\n"
                + text2 + "\n"
                + text3 + "\n"
                + text4 + "\n"
                + divider + "\n"
                + text5;
    }

    public static String getText(){
        return text2 + "\n"
                + text3 + "\n"
                + text4;
    }
}
