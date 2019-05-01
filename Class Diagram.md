
   
   
## person Java Interface
-------------------------
    * Login(string,string)
    * logout(): bool
    * makePost(string)
    * delpost(id): bool
  
  
## Admin Java class
    * Master Id : string
 --------------------------
    + Create Group()
    + Del Group()
    + Remove a user from a group()
    + Ban User()
    + unuser()

## User java class
  * is_logged_in: Bool
  * ID (name): String
  * Screen_name: String
  * Password : String
  * email : String
  * LogIn : Bool
  * date_join_group: array
 ------
   + create_post()
   + del_post()
   + comment on a thread()
   + recent_post_comment
   + Join Group()
   + record_date_join_group()
   + Leave Group()
   + setting()// delete a account, change password, ect
   + history()//comment,thread
   + profile()//Join what group, post threads, answer post,favorite group or topic
  
## comment Java class
    * id: int
    * userId: int
    * comment: string
-------------------------
    content(string): void

## Post Java class
    * ID :int
    * category_ID: int
    * top_title: String
    * Post_creator: string
    * Post_date: int
    * num_view: int
    * num_comment: int
    * comment: (obj)
  -------------------------
    + post_update_Content()
    + postUpdate_comment()
    + post_modify()
  
  
  
## Group Java class
    * ID: int
    * Group_Creator: string
    * Group_date: int
    * Group_memeber: array
    * category_id : int
    * title_description: string
 ---------------
    + Group_accept_member()
    + post(): string
    + recent__answer_post()
    + recent_unanswer_post()
 
