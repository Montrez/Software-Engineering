/*
Stright forward class.
takes in a user (since a user has a comment) and a String for the comment
 */
public class Comment
{
    private String comment;
    private User user;


    public Comment(User user, String comment)
    {
        this.user = user;
        this.comment = comment;
    }

    public User getUser()
    {
        return user;
    }

    public String getComment()
    {
        return comment;
    }

    @Override
    public String toString()
    {
        return "User: " + getUser().getUserName() + "\n" + getComment();
    }

}
