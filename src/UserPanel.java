
public interface UserPanel {
    public boolean alreadyFollowingUser(TwitterUser user);
    public boolean followingOwn(TwitterUser user);
    public void follow(User userToFollow);
    public void tweet(String msg);
}
