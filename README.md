# TODO

* [] Go over Project Design
* [] Go over Project Plan

# Use case 
--------------

   * [X] use case diagram
       * [X] Sighn up
       * [X] Login
       * [X] see posts
       * [X] join group
       * [X] post q
       * [X] del post
       * [X] make a group
       * [X] leave a group

   * Admin can
       * Login
       * See posts
       * Del * posts
       * Make a group
       * Remove members from a group

   * User can
       * login
       * See posts
       * Join group
       * Post Q
       * Del post
       * Leave group

   * Non sighned in user can
       * Sign up
       * see posts
# User Story 
--------------
  + US ID

    1. Sighnup
        * A. have a email field where users can add valid email
        * B. Have a password feild where users can add password
        * C. Have a 3rd feild where users have to add email 2 time to make sure its correct
        * Non-Functional Requirements
            * It should only take 1-2 minutes to sighn up

    2. Login
        * A. have a reqired feild to enter email
        * B. Have a requred field to enter password
        * C. If the password or email isnt valid infrom the user

    3. View feed
        * A. Users have the ability to see all the the posts from their subed groups
    
    4. See post
        * A. A user can see all threads posted by groups he follows
        * B. Then is able to selected the thread and view more detials on the thread

    5. Join group 
        * A. User can go to a sub tab that has all groups.
        * B. User has ability to add groups to his favorites
        * C. Have a list of favorite groups
        * D. If already in group tell user

    6. Make a thread
        * A. User can make a thread with a title and body
        * B. If the user is not sighned up then they can't make a post

    7. Make comment
        * A. If user is not signed up can't make a comment
        * B. If user is sighned up then they have the ability to comment on thread

    8. del a post
        * A. Admin can del * posts
        * B. User can only del post that was made my them
    
    9. Make a group
        * A. Admin has the ability to make groups
        * B. Users have the ability to add a group make request to the admin
        
    10. Leave a group
        * A. Admin has the ability to remove any member from a group
        * B. User can leave a group in any time
    11. Ban user 
        * A. If user is breaking rules of the group admin has the ability to remove them from the site with a ban function where the admin put the user ID into the function
        * Non-Functional Requirements
          * It should tell the user they have been banded
          
    12. Unban a user
        * A. If the admin wants to unban a user after some lentgh of them the admin can add their user ID to the unband fucntion to add the back to the site.
        * Non-Functional Requirements
          * The user should be informed that they are able to logback in
