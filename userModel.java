import java.util.List;

public class userModel{
    String userName;
    List<String> userRole;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<String> getUserRole() {
        return userRole;
    }
    public void setUserRole(List<String> userRole) {
        this.userRole = userRole;
    }

}