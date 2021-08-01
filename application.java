import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class application{
public static Map<String,userModel> users= new HashMap<String, userModel>();
public static Map<String,List<accessModel>> roles= new HashMap<String, List<accessModel>>();

public static void main(String args[]) throws IOException
    {
    userModel admin = new userModel();   
    admin.setUserName("admin");
    admin.setUserRole(new ArrayList<String>(){{
        add("admin");
          }});  
    userModel user1 = new userModel();   
    user1.setUserName("user1");
    user1.setUserRole(new ArrayList<String>(){{
        add("role1");
          }});   
    users.put(admin.userName, admin);
    users.put(user1.userName, user1);
    accessModel resourceA = new accessModel();
    resourceA.setResource("resource A");  
    resourceA.setAccessType(1);
    accessModel resourceB = new accessModel();
    resourceB.setResource("resource B");  
    resourceB.setAccessType(4); 
    accessModel resourceC = new accessModel();
    resourceC.setResource("resource C");  
    resourceC.setAccessType(7);  
    roles.put("role1", new ArrayList<accessModel>(){{
        add(resourceA);
        add(resourceB);
          }});
    roles.put("role2", new ArrayList<accessModel>(){{
      add(resourceB);
      add(resourceC);
        }});
    roles.put("role3", new ArrayList<accessModel>(){{
        add(resourceA);
        add(resourceC);
          }});
    new application().login();        
    }
    public void adminLogin(String userName) throws IOException{
        System.out.println("hi! you are logged in as admin press 1 for login as another user press 2 for create user press 3 for edit role");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Long num= Long.valueOf(name);
        if(num==1){
            loginAsOtheruser();
        }
        if(num==2){
            admin adminobj = new admin();
            adminobj.createUser(userName);
        }
        if(num==3){
            admin adminobj = new admin();
            adminobj.editUserRole(userName);
        }
    }   
    public void userLogin(String userName) throws IOException{
        System.out.println("hi! you are logged in as "+userName+" press 1 for login as another user press 2 for view roles press 3 for access resource");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Long num= Long.valueOf(name);
        if(num==1){
            loginAsOtheruser();
        }
        if(num==2){
            user userobj = new user();
            userobj.viewRoles(userName);
        }
        if(num==3){
            user userobj = new user();
            userobj.viewResourceAccess(userName);
        }
    }

    public void loginAsOtheruser() throws IOException{
        System.out.println("enter the username you want to login as");
        login();
    }
    
    public void login() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
     
            // Reading data using readLine
            String name = reader.readLine();
            if(name.equalsIgnoreCase("admin"))
            {
                adminLogin(name);                
            }
            else
            {
                userLogin(name);
            }
    }
}
