
public class NumUsers implements Visitor {
    int count =0;
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User){
            count++;
        }
        
    }
    public int getCount(){
        return count; 
    }
    
}
