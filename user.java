import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class user {
    public void viewRoles(String userName) throws IOException{
        userModel user = application.users.get(userName);
        for(int i=0;i<user.userRole.size();i++)
        {
        System.out.println("Your have been assigned role:"+user.userRole.get(i));
        }
        new application().userLogin(userName);
    }
    public void viewResourceAccess(String userName) throws IOException{
        userModel user = application.users.get(userName);
       Map<String,Integer> printResource= new HashMap<String, Integer>();
        for(int i=0;i<user.userRole.size();i++)
        {
            List<accessModel> resources= application.roles.get(user.userRole.get(i));
            for(int j=0;j<resources.size();j++){
                int resourceNewAccessLevel = resources.get(j).getAccessType();
                String resourceName = resources.get(j).resource;
                if(printResource.containsKey(resources.get(j).resource))
                {
                    int resourceExistingAccessLevel = printResource.get(resourceName);
                    
                    if(resourceExistingAccessLevel<resourceNewAccessLevel)
                    {
                        printResource.put(resourceName, resourceNewAccessLevel);
                    }
                }
                else
                {
                    printResource.put(resourceName, resourceNewAccessLevel);
                }
            }
        }
        for (String name : printResource.keySet())
        {
            Integer access = printResource.get(name);
            System.out.println("Your have access to " + name + " with level of access equal to "+access);
        }
        new application().userLogin(userName);
    }    
}