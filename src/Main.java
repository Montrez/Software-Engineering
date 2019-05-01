import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Set;
import java.util.Iterator;

public class Main
{
//      TEST MAIN....
   private static final int ADMINCODE = 666;
   private static GroupManager t = new GroupManager();
   private static UserManager userManager = new UserManager(t);
   private static boolean isAdmin;
   private static boolean ban = false;
   private static User cUser;
   private static Admin aUser;
   private static boolean loginStatus = false;

    public static void main(String[] args)
    {
        Boolean QUIT1 = false;
        Boolean QUIT2 = false;
        Boolean QUIT3 = false;
        
        
        Scanner key = new Scanner(System.in);
        
        while(!QUIT1){
          QUIT2 = false;
          QUIT3 = false;
          while(!QUIT2)
          {
              System.out.println("1. Login");
              System.out.println("2. Sign up");
              int choice = key.nextInt();
   
              if(choice == 1)
              {
                  System.out.println("User name: ");
                  String username = key.next();
   
                  System.out.println("Password: ");
                  String password = key.next();
   
                  cUser = userManager.logIn(username, password);
                 
                  if (cUser != null){
                      if (cUser.getUserName().equals(username)){
                         System.out.println("Login Successful");
                         loginStatus = true;
                      }
                      if (cUser.getAdmin() == true){
                         aUser = new Admin(cUser.getUserName(),cUser.getPassword(),cUser.getAdmin(),cUser.getBan());
                         cUser = null;
                         loginStatus = true;
                      }
                      else{
                        aUser = null;
                      }
                      QUIT2 = true;
                  }
                   
              }
         
              else if (choice == 2)
              {
                  System.out.println("User name: ");
                  String username = key.next();
   
                  System.out.println("Password: ");
                  String password = key.next();
                  
                  System.out.println("Admin Code, if no, enter 0");
                  int code = key.nextInt();
                  
                  if (code == ADMINCODE){
                   isAdmin = true;  
                   cUser = userManager.signUp(username, password, isAdmin, ban); 
                                 
                  }
                  else{
                   cUser = userManager.signUp(username, password, isAdmin, ban);   
                  }
             }
          }
          
          
          while(!QUIT3){
          if (aUser != null){//if the user signed in an admin
             System.out.println("1. create Group" + "\n" +
                                "2. Remove User Account" + "\n" +
                                "3. Ban User" + "\n" +
                                "4. Unban User" + "\n" +
                                "5. remove User From a Group;\n" +
                                "6. Log out");
          
             System.out.print("Navigate to ");
             int ans = key.nextInt();
             if (ans == 1){
                 createGroup();
             }
             else if (ans == 2){
                 removeUser();
             }
             else if (ans == 3){
                 banUser();
             }
             else if (ans == 4){
                 unbanUser();
             }
             else if (ans == 5){
                 removeUserFromGroup();
             }
             else{
                 logout(aUser, loginStatus);
                 System.out.print("Quit? y or n\t");
                 key.nextLine();
                 String ifQuit = key.nextLine();
                 if(ifQuit.equals("n")){
                    QUIT1 = false;
                    QUIT2 = false;
                    QUIT3 = true;
                 }
                 else{
                    QUIT1 = true;
                 }   
             }
          }
          else{//if the user is a regular user
             aUser = null;
             System.out.println("1. View Feed" + "\n" +
                                "2. Join Group" + "\n" +
                                "3. Leave Group" + "\n" +
                                "4. Log out");
          
             System.out.print("Navigate to ");
             int ans = key.nextInt();
             if (ans == 1){
                 viewFeed();
             }
             else if (ans == 2){
                 joinGroup();
             }
             else if (ans == 3){
                 leaveGroup();
             }
             else{
                 logout(cUser, loginStatus);
                 System.out.print("Quit? y or n\t");
                 key.nextLine();
                 String ifQuit = key.nextLine();
                 if(ifQuit.equals("n")){
                    QUIT1 = false;
                    QUIT2 = false;
                    QUIT3 = true;
                 }
                 else{
                    QUIT1 = true;
                 }                 
             }
          }
         }
         

        }//end of quit1 while
                           
        

    }
    public static void viewFeed(){
    
    }
    
    public static void createGroup(){
      Group group = aUser.createGroup();
      t.addGroup(group, group.getID());
    }
    public static void joinGroup(){
      Scanner key = new Scanner(System.in);
      Hashtable<Integer, Group> groupList = t.getGroupList();
      Set<Integer> keys = groupList.keySet();
      Iterator<Integer> itr = keys.iterator();
      
      while (itr.hasNext()) { 
       // Getting Key
       int groupID = itr.next();

       System.out.println("Key: "+groupID+" & Value: "+groupList.get(groupID).getName());
      } 
      
      
      System.out.print("Enter the group ID to join the group");
      int groupID = key.nextInt();
      cUser.joinGroup(groupID);
    }
    
    public static void leaveGroup(){
    
    }
    
    
    public static void removeUser(){
      aUser.removeUser(userManager);
    }
    
    public static void removeUserFromGroup(){
      aUser.removeUserFromGroup(userManager,t);    
    }
    
    public static void banUser(){
      aUser.banUser(userManager);
    }
    
    public static void unbanUser(){
     aUser.unbanUser(userManager);
    }
    
    public static void logout(User cUser, boolean loginStatus){
      loginStatus = false;
      cUser = null;
    }
    
    public static void logout(Admin aUser, boolean loginStatus){
      loginStatus = false;
      aUser = null;
    }
}
    
    

/*  //original testting
        Group j = new Group("test", 1);
        t.addGroup(j,1);
        cUser = userManager.signUp("josh", "josh");
        Feed testfeed = new Feed(cUser);
        cUser.joinGroup(1);
        cUser.makePost("test!", "test!", j);
        cUser.makeComment(cUser.getPost().get(0),"hiiiii");
        cUser.pickBestAnswer(0,0);
        cUser.makePost("test!","WOW", j);
        System.out.println(testfeed.toString());
        

*/