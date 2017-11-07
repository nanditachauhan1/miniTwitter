import javax.swing.DefaultListModel;


@SuppressWarnings("serial")
public class User extends TwitterUser implements Observer, Subject {
    // all users have an id, a list of followers and following, and a list of newsfeed
    private String id;
    private DefaultListModel<Observer> followers = new DefaultListModel<>();
    private DefaultListModel <Subject> following = new DefaultListModel<>();
    private DefaultListModel <String> newsfeed = new DefaultListModel<>();
    private boolean updatedFeed=false;
    private String message;
    private UserGroup group;
    
 
    public User(String id){
        setID(id);
        updatedFeed=false;
        group=null;
        
        
    }
   
    public void addGroup(UserGroup g){
        if (group ==null){
            group = g;
        }
        else{
            System.out.println("already in group, can't add another group");
        }
    }
    
    public void tweet(String m ){
        this.message= m;
        updatedFeed=true;
        newsfeed.addElement("-me: "+message); // adds to own newsfeed
        notifyObservers();// tell observers to update newsfeed themselves
    }
   
    public DefaultListModel<Observer> getFollowers() {
        return followers;
    }
   
    public DefaultListModel<Subject> getFollowing() {
        return following;
    }
    
    public DefaultListModel<String> getNewsfeed() {
        return newsfeed;
    }
    
    public void follow(User u){
        setSubject(u);
        u.setObserver(this);
    }
    
    @Override
    public String getID() {
        
        return id;
    }
    
    @Override
    public void setID(String id) {
        this.id = id;
        
    }
    
    @Override
    public String toString() {
        return this.getID();
    }
    
    @Override
    public void setSubject(Subject s) {
        following.addElement(s);
        
    }
    
    @Override
    public void update(Subject s) {
        String update = getUpdate(this);
        newsfeed.addElement("-"+s.toString()+": "+update);
        
    }
   
    @Override
    public void setObserver(Observer o) {
        followers.addElement(o);
        
    }
    
    
    @Override
    public void notifyObservers() {
        
        if(updatedFeed){
            updatedFeed=false;
            for (Object o: followers.toArray()){
                this.update((Subject) o);
            }
            
        }
        
        
    }
    
    @Override
    public String getUpdate(Observer o) {
        return this.message;
    }
    
}
