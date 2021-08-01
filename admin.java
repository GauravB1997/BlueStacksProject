import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class admin {
    public void createUser(String userName) throws IOException{
        userModel newUser = new userModel();   
        System.out.println("enter the username you want to add:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        newUser.setUserName(name);
        System.out.println("enter the userroles you want to set:");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String role = reader.readLine();
        List<String> allRoles = Arrays.asList(role.split(","));
        newUser.setUserRole(allRoles);
        application.users.put(newUser.userName,newUser);
        System.out.println("user has been added successfully");
        new application().adminLogin(userName);     
    }
    public void editUserRole(String userName) throws IOException{
        System.out.println("enter the username you want to edit role for:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        userModel user = application.users.get(name);
        System.out.println("the existing role for the user is " + user.getUserRole() + " ,please enter the new roles:");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String role = reader.readLine();
        List<String> allRoles = Arrays.asList(role.split(","));
        user.setUserRole(allRoles);
        application.users.replace(name, user);
        System.out.println("user role has been changed successfully");
        new application().adminLogin(userName); 
    }
}