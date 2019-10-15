package ansi;

import model.User;

public class ColorServiceImpl implements ColorService  {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\033[1;35m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_ORANGE = "\033[1;91m";
    private static final String ANSI_GREEN = "\033[1;32m";
    private static final String ANSI_CYAN = "\u001b[36;1m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public void setAnsiOrange(){
        System.out.print(ANSI_ORANGE + "ORANGE" + ANSI_RESET);
    }
    public void setAnsiPlay(){
        System.out.print(ANSI_PURPLE + "PLAY" + ANSI_RESET);
    }
    public void setAnsiPlus(){
        System.out.print(ANSI_GREEN + "PLUS" + ANSI_RESET);
    }
    public void setAnsiTmobile(){
        System.out.print(ANSI_CYAN + "T-MOBILE" + ANSI_RESET);
    }
    public void result() {System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK +
            "SUCCESSFULL! YOUR NUMBER HAS BEEN ADDED TO DATABASE" + ANSI_RESET);
    }
    public void getNumber(User user) {
        System.out.println("\nYour number is : " + ANSI_BLUE  + user.getPhoneNumber() + ANSI_RESET);
    }
    public void leaveMessage(User user){
        System.out.println("Thanks for using our services, "
                + ANSI_BLUE + user.getFirstName() + " " + user.getLastName() + ANSI_RESET  + " :)!");
    }
}
