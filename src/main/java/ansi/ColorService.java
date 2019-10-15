package ansi;

import model.User;

public interface ColorService {
    void setAnsiOrange();
    void setAnsiPlay();
    void setAnsiPlus();
    void setAnsiTmobile();
    void result();
    void getNumber(User user);
    void leaveMessage(User user);
}
