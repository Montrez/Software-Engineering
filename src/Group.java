import java.util.ArrayList;
import java.util.Date;

/*
    Group: pretty much a post manager that holds dif posts for different topics
 */
public class Group
{
    private ArrayList<Post> postsInGroup = new ArrayList<>();
    private ArrayList<User> joinedUsers = new ArrayList<>();
    private GroupManager groupManager;
    private String name;
    private Integer id;
    private Date date;

    Group(String name, Integer id, Date date)
    {
        this.name = name;
        this.id = id;
        this.date = date;
    }
    public Group(){
    
    }
    public void addPost(Post post)
    {
        postsInGroup.add(post);
    }

    public void joinGroup(User user)
    {
        joinedUsers.add(user);
    }
    
    public String getName(){
        return name;
    }
   
    public Integer getID(){
    
      return id;
    }
    
    public Date getDate(){
      return date;
    }
    
    public ArrayList<User> getJoinedUsers(){
      return joinedUsers;
    }


    public ArrayList<Post> getPostsInGroup() {
        return postsInGroup;
    }
}
