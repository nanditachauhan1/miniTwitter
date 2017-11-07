
public class Groups implements Visitor{
    int numGroups = 0;
    
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof UserGroup){
            numGroups ++;
        }
    }
    
    public int getNumGroups(){
        return numGroups;
    }
    
    
}
