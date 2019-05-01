import java.util.Date;
import java.util.ArrayList;

public class User {
    private GroupManager groupManager;
    private String userName;
    private String password;
    private boolean admin;
    private boolean ban;
    private ArrayList<Post> userPosts = new ArrayList<>();
    private ArrayList<Group> joinedGroups = new ArrayList<>();



    public User(String userName, String password, boolean admin, boolean ban, GroupManager groupManager ) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.ban = ban;
        this.groupManager = groupManager;
    }

    public User(String userName, String password, boolean admin, boolean ban) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.ban = ban;
    }

   public User(String userName, String password, boolean admin) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }
    public void makePost(String title, String body, Group g)
    {
        Post newPost = new Post(this, title, body);
        userPosts.add(newPost);
        groupManager.makePost(g, newPost);
    }

    public void makeComment(Post post, String comment)
    {
        post.postComment(this, comment);
    }

    public void pickBestAnswer(int userPostId, int commentId)
    {
        // TODO: Needs to get only the post made by this user JCJ

        Post post = userPosts.get(userPostId);
        Comment bestAnswer = post.getComments().get(commentId);
        post.serBestAnswer(bestAnswer);

    }

    public void joinGroup(Integer groupId)
    {
        Group g = groupManager.getGroup(groupId);
        joinedGroups.add(g);
    }

    // Returns all of the users posts.
    ArrayList<Post> getPost()
    {
        return userPosts;
    }

    public ArrayList<Group> getJoinedGroups() {
        return joinedGroups;
    }

    public String getUserName()
    {
        return userName;
    }

    @Override
    public String toString()
    {
        return getUserName();
    }

    public String getPassword()
    {
        return password;
    }
    
    public boolean getAdmin(){
      return admin;
    }
    
    public boolean getBan(){
      return ban;
    }
    
    public void setBan(boolean ban){
      this.ban = ban;
    }
}
