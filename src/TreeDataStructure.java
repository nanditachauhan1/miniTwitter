import javax.swing.tree.DefaultTreeModel;

public interface TreeDataStructure {

    public  boolean addNode(TwitterUser parent, TwitterUser child);
    public  boolean contains(String userID);

    public  TwitterUser getTwitterUser(String userID);
    public DefaultTreeModel getModel();
    
}
