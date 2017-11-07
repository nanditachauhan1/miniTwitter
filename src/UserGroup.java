import java.util.ArrayList;


@SuppressWarnings("serial")
public class UserGroup extends TwitterUser{
    private String id;
    private ArrayList <User> groupUser = new ArrayList<>();
    
    public UserGroup(String id){
        setID(id);
    }
   
    public void addUsers(String id){
        User u = new User(id);
        groupUser.add(u);
        u.addGroup(this);
        
    }
  
    @Override
    public String getID() {
        
        return id;
    }
    
    @Override
    public void setID(String id) {
        this.id=id;
        
    }
    
    @Override
    public String toString() {
        
        return this.getID();
    }
    
    
}
