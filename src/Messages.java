
public class Messages implements Visitor {
    int numMessages = 0;
    
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User) {
            numMessages += ((User) u).getNewsfeed().size();
        }
    }
    
    public int getNumMessages() {
        return numMessages;
    }
    
}
