import java.util.Date;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.ArrayList;

public class Admin extends User
{

    private static Scanner key = new Scanner(System.in);
    private static Integer groupID = 0;
    
    public Admin(String userName, String password, boolean admin, boolean ban)
    {
        super(userName, password, admin, ban);
    }
    
    public Group createGroup(String name){
      //String name, Integer id, Date date
      //System.out.println("What do you want to name the group?\t");
      //String name = key.nextLine();
      Date date = new Date();
      groupID++;
      Group group = new Group(name,groupID,date);
      return group;
    }
    
    public void removeUser(UserManager userManager, String username){
      //System.out.print("Type the username to remove user");
      //String username = key.nextLine();
      for (int i = 0; i < userManager.getSignedUpUsers().size(); i++){
         if (userManager.getSignedUpUsers().get(username) != null){
            if(userManager.getSignedUpUsers().get(username).getAdmin() == true){
               System.out.println("Sorry, you can't remove an admin");
            }
            else{
               userManager.getSignedUpUsers().remove(username);
               System.out.println("User: " + username + " has been removed");
            }
         }     
      }      
    }
    
    public void removeUserFromGroup(UserManager userManager, GroupManager t, String username, Integer groupID){
      //System.out.print("Type the username to remove a group");
      //String username = key.nextLine();
      //Integer groupID;
      if (userManager.getSignedUpUsers().get(username) != null){
         User user = userManager.getSignedUpUsers().get(username);
         
         System.out.println("User " + username + " Joined the following group:");
         for (int i = 0; i < user.getJoinedGroups().size(); i++){
            System.out.println(user.getJoinedGroups().get(i).getID() + "\t"  + user.getJoinedGroups().get(i).getName());
            
         }
                  
         //System.out.print("Type the group ID to remove the user from");
         //groupID = key.nextInt();
         ArrayList<User> joinedUsers = t.getGroup(groupID).getJoinedUsers();
         
         for (int k = 0; k < joinedUsers.size(); k++){
            if (joinedUsers.get(k).getUserName().equals(username)){
               joinedUsers.remove(k);
               System.out.println("Removed user from group class");
            }
         }
         ArrayList<Group> joinedGroups = user.getJoinedGroups();
         
         for (int j = 0; j < joinedGroups.size(); j++){
            if (joinedGroups.get(j).getID() == groupID){
               joinedGroups.remove(j);
               System.out.println("Removed user from group " + groupID + " that he is joined");
            }
         }
         
        
      }
      else{
         System.out.println("User doesn't exist");
      }
    }
    
    public void banUser(UserManager userManager, String username){
      //System.out.print("Type the username to ban user");
      //String username = key.nextLine();
      for (int i = 0; i < userManager.getSignedUpUsers().size(); i++){
         if (userManager.getSignedUpUsers().get(username).getBan() != true){
            if(userManager.getSignedUpUsers().get(username).getAdmin() == true){
               System.out.println("Sorry, you can't ban an admin");
            }
            else{
               userManager.getSignedUpUsers().get(username).setBan(true);
               userManager.setKickedUsers(username,userManager.getSignedUpUsers().get(username));
               System.out.println("User: " + username + " has been banned");
               
            }
         }     
      } 
      
    }
    
    public void unbanUser(UserManager userManager, String username){
      //System.out.print("Type the username to unban user");
      //String username = key.nextLine();
      for (int i = 0; i < userManager.getSignedUpUsers().size(); i++){
         if (userManager.getSignedUpUsers().get(username).getBan() != false){
            if(userManager.getSignedUpUsers().get(username).getAdmin() == true){
               System.out.println("Sorry, you can't unban an admin");
            }
            else{
               userManager.getSignedUpUsers().get(username).setBan(false);
               userManager.getKickedUsers().remove(username);
               System.out.println("User: " + username + " has been unbanned");
            }
         }     
      } 
    
    
    }
}