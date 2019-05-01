import java.util.Hashtable;

public class UserManager {
    private GroupManager g;
    private Hashtable<String, User>  signedUpUsers = new Hashtable<>();
    // Using a hashtable due to it's fast lookup speed.
    private Hashtable<String, User>  kickedUsers = new Hashtable<>();

    UserManager(GroupManager g)
    {
        this.g = g;
    }

    public User signUp(String userName, String password, boolean admin, boolean ban)
    {
        if(signedUpUsers.containsKey(userName))
        {
            System.out.println("This username has been taken");
            return null;
        }

        User newUser = new User(userName, password, admin, ban, g);
        signedUpUsers.put(newUser.getUserName(), newUser);

        System.out.println("Successfully signed up");

        return signedUpUsers.get(userName);
    }

    public User logIn(String userName, String password)
    {
        if (signedUpUsers.containsKey(userName)
                && signedUpUsers.get(userName).getPassword().equals(password))
        {
            return signedUpUsers.get(userName);
        }

        //else if(kickedUsers.containsKey(userName))
        //{
        else if (signedUpUsers.get(userName).getBan() == true){
            System.out.println("You have been kicked.");
        } else
        {
            System.out.println("There is no account with this user name. ");
        }
        return null;

    }
    
    public Hashtable<String, User> getSignedUpUsers(){
      return signedUpUsers;
    }     
    
    public Hashtable<String, User> getKickedUsers(){
      return kickedUsers;
    }
    
    public void setKickedUsers(String username, User user){
      kickedUsers.put(username, user);
      
    }
}
