import java.util.ArrayList;
import java.util.Hashtable;

public class GroupManager
{
    private Hashtable<Integer, Group> groupList = new Hashtable<>();

    public void addGroup(Group newGroup, int id)
    {
        Integer intId = id;
        groupList.put(intId, newGroup);
    }


    public Group getGroup(int id)
    {
        if(!groupList.containsKey(id))
        {
            return null;
        }
        return groupList.get(id);
    }

    public void makePost(Group g, Post p)
    {
        g.addPost(p);
    }
    
    public Hashtable<Integer, Group> getGroupList(){
      return groupList;
    }

}
