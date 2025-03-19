abstract class User implements HasMenu, Serializable

    string userName
    string PIN

    boolean login()
    boolean login(userName, PIN)
    void setUserName(userName)
    string getUserName()
    void setPIN(PIN)
    string getPIN()
    abstract string getReport()