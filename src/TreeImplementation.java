import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultTreeModel;


public class TreeImplementation implements Host, TreeDataStructure{
    private DefaultTreeModel tree;
    private Map <String, TwitterUser> data;
    private TwitterUser root;
    
    /**
     * constructor creates a tree with the root node
     */
    public TreeImplementation(){
        root = new UserGroup("Root");
        this.data= new HashMap<String, TwitterUser>();
        this.tree=new DefaultTreeModel(root);
    }
    public TwitterUser getTreeRoot(){
        return root;
    }
    
    @Override
    public boolean addNode(TwitterUser parent, TwitterUser child) {
        if (contains(child.getID())){
            System.out.println("already exists, error");
            return false;
        }
        if (parent instanceof User){
            System.out.println("User can't have other TwitterUsers in them");
            return false;
        }
        data.put(child.getID(), child);
        tree.insertNodeInto(child, parent, parent.getChildCount());
        return true;
    }
    
    @Override
    public boolean contains(String userID) {
        // TODO Auto-generated method stub
        return data.containsKey(userID);
    }
    
    @Override
    public TwitterUser getTwitterUser(String userID) {
        if (contains(userID)){
            return data.get(userID);
        }
        return null;
    }
    
    @Override
    public void invite(Visitor v) {
        for(Map.Entry<String, TwitterUser> d: data.entrySet()){
            v.visit(d.getValue());
        }
    }
    @Override 
    public  DefaultTreeModel getModel(){
        return tree;
    }
    
    
}
