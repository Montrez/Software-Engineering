/*
    Takes in a user(A post has a user) Title and a body
    Post has an Arraylist for its comments made by users
 */
import java.util.ArrayList;

public class Post
{
    private User user;
    private String title;
    private String body;
    private ArrayList<Comment> comments = new ArrayList<>();
    private Comment bestAnswer = null;

    public Post(User user, String title, String body)
    {
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public void postComment(User user, String comment)
    {
        Comment userComment = new Comment(user, comment);
        comments.add(userComment);
    }

    public String getTitle()
    {
        return title;
    }

    public Comment getBestAnswer() {
        return bestAnswer;
    }

    public boolean hasBestAnswer() {
        return bestAnswer != null;
    }

    public void serBestAnswer(Comment bestA)
    {
        bestAnswer = bestA;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public String getUserName()
    {
        return user.getUserName();
    }

    public ArrayList<Comment> getComments()
    {
        return comments;
    }

    @Override
    public String toString()
    {
        return "Title: " + getTitle() + "\n" + "Body: " + getBody();
    }
}
