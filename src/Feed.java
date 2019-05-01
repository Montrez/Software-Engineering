import java.util.ArrayList;

/*
1. take in a user.
2. get it's groups.
3. Take all the groups and get their posts.
4. loop though all of the group's posts and add push it to the users feed via the toString.
 */

public class Feed
{
    private User user;

    public Feed(User user)
    {
        this.user = user;
    }

    public ArrayList<Post> getFeed()
    {
        ArrayList<Group> groups = user.getJoinedGroups();
        ArrayList<Post> groupPosts = new ArrayList<>();

        for (Group g: groups)
        {
            groupPosts.addAll(g.getPostsInGroup());
        }

        return groupPosts;
    }

    @Override
    public String toString()
    {
        ArrayList<Post> gpost = getFeed();

        StringBuilder feed = new StringBuilder();

        for (Post p: gpost) {
            feed.append("Title: ").append(p.getTitle()).append("\n");
        }

        return feed.toString();
    }
}
