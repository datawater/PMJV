package consolejv;

import java.io.IOException;

public class ConsoleJV {
    public static int red    =   91; public static int darkRed    =   31; 
    public static int green  =   92; public static int darkGreen  =   32;
    public static int yellow =   93; public static int darkYellow =   33;
    public static int blue   =   94; public static int darkBlue   =   34;
    public static int pink   =   95; public static int darkPink   =   35;
    public static int cyan   =   96; public static int darkCyan   =   36;
    public static int grey   =   97; public static int darkGrey   =   37;

    public static int backgroundRed    =   101; public static int backgroundDarkRed    =   41; 
    public static int backgroundGreen  =   102; public static int backgroundDarkGreen  =   42;
    public static int backgroundYellow =   103; public static int backgroundDarkYellow =   43;
    public static int backgroundBlue   =   104; public static int backgroundDarkBlue   =   44;
    public static int backgroundPink   =   105; public static int backgroundDarkPink   =   45;
    public static int backgroundCyan   =   106; public static int backgroundDarkCyan   =   46;
    public static int backgroundGrey   =   107; public static int backgroundDarkGrey   =   47;

    public static int bold    =   1; public static int italic  =   3;

    public static void reset() {
        System.out.print(String.format("\033[0m"));
    }

    public static void clear() {
        System.out.print(String.format("\033[2J"));
    }

    public static void printc(String string, int color, boolean resetOrNot) {
        System.out.print(String.format("\033[0;%dm", color));
        System.out.print(string);
        if (resetOrNot) {reset();}
    }

    public static void printlnc(String string, int color, boolean resetOrNot) {
        System.out.print(String.format("\033[0;%dm", color));
        System.out.println(string);
        if (resetOrNot) {reset();}
    }

    public static char getChar() {
        try {
            return (char) System.in.read();
        } catch (IOException exception) {
            exception.printStackTrace();
            return '\0';
        }
    }

    public static String userInput() {
        String string = "";
        char Char = getChar();
        while (Char != '\n') {
            string += Char;
            Char = getChar();
        }
        return string;
    }
}