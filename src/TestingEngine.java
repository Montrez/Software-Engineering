import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestingEngine {
   private static GroupManager t = new GroupManager();
   private static UserManager userManager = new UserManager(t);
   private static boolean isAdmin;
   private static boolean ban = false;
   private static Admin aUser;
   private static boolean loginStatus = false;
	public static void main(String[] args) {
      test1();
      test2();
   }
   
   
   public static void test1(){
      //***
      //Signup test
      System.out.println("signup test");
      User user = userManager.signUp("111", "111", false, false); 
      User user1 = userManager.signUp("222","222", false, false); 
      User user2 = userManager.signUp("333", "333", false, false); 
      User user3 = userManager.signUp("444", "444", true, false);
      Admin admin = new Admin("444", "444", true, false);
      System.out.println("signed up user number:\t" + userManager.getSignedUpUsers().size());
      
      
      //***
      //Admin test
      //createGroup test
      System.out.println("\n\nCreate Group test");
      Group group = admin.createGroup("Li's group");
      Group group1 = admin.createGroup("Wei's group");
      Group group2 = admin.createGroup("Josh's group");
      Group group3 = admin.createGroup("Monstez's group");
      
      
      t.addGroup(group, group.getID());
      t.addGroup(group1, group1.getID());
      t.addGroup(group2, group2.getID());
      t.addGroup(group3, group3.getID());
      
      System.out.println("# of Groups created:\t" + t.getGroupList().size());
      
      
      
      //***
      //Admin test
      //removeUser(UserManager userManager, String username)
      System.out.println("\n\nremove user test");
      admin.removeUser(userManager, "111");
      admin.removeUser(userManager, "222");
      System.out.println("signed up user number:\t" + userManager.getSignedUpUsers().size());
      user = userManager.signUp("111", "111", false, false); 
      user2 = userManager.signUp("333", "333", false, false); 
      
      
      //***
      //Admin test
      //removeUserFromGroup(UserManager userManager, GroupManager t, String username, Integer groupID)
      System.out.println("\n\nremoveUserFromGroup test");

      user.joinGroup(1);
      user.joinGroup(2);
      user.joinGroup(3);

      admin.removeUserFromGroup(userManager,t,"111",1);
      admin.removeUserFromGroup(userManager,t,"111",2);
      
      
      
      //***
      //Admin test
      //banUser(UserManager userManager, String username)
      System.out.println("\n\nban user test");
      admin.banUser(userManager, "111");
      user = userManager.logIn("111", "111");

      
      
      //***
      //Admin test
      //unbanUser(UserManager userManager, String username)
      System.out.println("\n\nunban user test");
      admin.unbanUser(userManager, "111");
      user = userManager.logIn("111", "111");
   
   }

   
   
   
   
   
   public static void test2(){
		Date date = new Date();
		int i = 7;
		Integer in = new Integer(i);
		User user = new User("Sam", "fire", false);
		User user2 = new User("Alex", "water", false);
		Post post = new Post(user, "React5 help", "Can someone please help me understand controllers in react?");
		Post post2 = new Post(user2, "Nodejs help", "Is there anyway to turn off a node instance on my computer?");
		GroupManager groupM = new GroupManager();
		Group groups = new Group("React", in, date);
		groupM.addGroup(groups, 7);
		groups.addPost(post);
		groups.addPost(post2);
		post.postComment(user, "Why don't you try and create a change?");
		post2.postComment(user2, "There's all types of things to learn on Github!");
		Feed feed = new Feed(user);
		groups.joinGroup(user);
		groups.joinGroup(user2);
		System.out.println("Group Id: " + groups.getID());
		System.out.println("\nCurrent Postings " + showPost(groups));
		System.out.println("Comments:\n" + showComment(post) + "\n" + showComment(post2));
		System.out.println("\nCurrent memembers: "+showUsers(groups));

		System.out.println("" + showFeed());
		System.out.println("\nCurrent user's groups: " + showGroup(user));
      
      searchQuestion();
	}
	
	public static String showPost(Group group){
		String string = "\n{";
		for(Post p : group.getPostsInGroup()){
			string += "\n "+p.toString() + "\n";
		}
		string += "\n}";
		return string;
	}
	public static String showUsers(Group g){
		String string = "";
		for(User u : g.getJoinedUsers()){
			string += u.toString() + ", ";
		}
		return string;
	}
	public static String showGroup(User users){
		String string = "";
		for(Group u : users.getJoinedGroups()){
			string = u + " ";
		}
		return string;
	}
	public static String showFeed(){
		return "";
	}

	public static String showComment(Post p){
		String string = "";
		for(Comment c : p.getComments()){
			string += c + " ";
		}
		return string;
	}
   
   public static void searchQuestion(){
      Scanner key1 = new Scanner(System.in);
      System.out.println("Type a word or phase:");
      String find = key1.next();
      System.out.println("Searching for this word or phase: " + find + " loading .....");
      
      Group searchQ1 = new Group();
      Group searchQ2 = new Group();
      String string = "";
      //create a post and a user
      User user1 = new User("wei", "123", false);
      Post post1 = new Post(user1,"how to commit a file", "I have a error.....");
      Post post2 = new Post(user1,"why do we commit a file", "I have a error.....");
      Post post3 = new Post(user1,"what is commit in git", "I have a error.....");
      Post post4 = new Post(user1,"describe how to revert a commit", "I have a error.....");

      //add post
      searchQ1.addPost(post1);
      searchQ1.addPost(post2);
      searchQ2.addPost(post3);
      searchQ2.addPost(post4);
   
      //add group
      GroupManager insertGroup = new GroupManager();
      insertGroup.addGroup(searchQ1,1);
      insertGroup.addGroup(searchQ2,2);

     for(int i =0; i <insertGroup.getGroupList().size(); i++){
         Group p = insertGroup.getGroupList().get(i+1);
      for (Post u : p.getPostsInGroup()){
         string = u.getTitle();         
         String[] splitTitle = string.split(" ");
         for(String temp: splitTitle){
            if(temp.equals(find))
               System.out.println(string);
         }
      }
   }
}
}
