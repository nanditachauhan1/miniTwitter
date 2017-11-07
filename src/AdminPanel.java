import javax.swing.JTree;


public interface AdminPanel {
    public void setIcon();
    public void OpenUserView(TwitterUser user);
    public TwitterUser getUser(JTree tree);
    
}
