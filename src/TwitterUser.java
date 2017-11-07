import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public abstract class TwitterUser extends DefaultMutableTreeNode  {
    
    public abstract String getID();
    public abstract void setID(String id);
    public abstract String toString();
    
}
