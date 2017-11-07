import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class UserWindow extends JFrame implements UserPanel{
	private User currentUser; 
	private TreeImplementation treeImplement;
	private popUpWindow window = new popUpWindow();
	private JTextArea id;
	private JTextArea tweet; 
	private JList<Subject> followingsList;
	private JList<String> newsFeedList;
	private JButton follow; 
	private JButton addTweet;
	private DefaultListModel<Subject> modelFollowings;
	private JPanel following;
	private JPanel tweetPanel;
	private JPanel idPanel;
	private JPanel newsFeedPanel;
	private JPanel contentPane;
	private	UserHandler handler=new UserHandler();

	public UserWindow(User node, TreeImplementation treeImplementation) {
		this.currentUser=node;
		this.treeImplement=treeImplementation;
		currentUser.getNewsfeed();
		this.modelFollowings=currentUser.getFollowing();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initializeWindow();
		showFollowing();
		showNewsFeed();
		createTweetPanel();
		createIDPanel();
		createButtons();
		this.setVisible(true);

	}
	private void initializeWindow(){
		
		setTitle(currentUser.getID()+"'s "+"User View");
		setBounds(100, 100, 477, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void showFollowing(){
		following = new JPanel();
		following.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Following:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		following.setBounds(0, 56, 469, 119);
		contentPane.add(following);
		following.setLayout(null);
		followingsList=new JList<Subject>((ListModel<Subject>) modelFollowings);
		JScrollPane scrollPane = new JScrollPane(followingsList);
		scrollPane.setBounds(10, 16, 449, 92);
		following.add(scrollPane);
	}
	private void showNewsFeed(){
		newsFeedPanel = new JPanel();
		newsFeedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "News Feed", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		newsFeedPanel.setBounds(0, 235, 465, 170);
		contentPane.add(newsFeedPanel);
		newsFeedPanel.setLayout(null);
		newsFeedList=new JList<String>((ListModel<String>) currentUser.getNewsfeed());
		JScrollPane scrollPane_1 = new JScrollPane(newsFeedList);
		scrollPane_1.setBounds(10, 21, 445, 139);
		newsFeedPanel.add(scrollPane_1);
	}
	private void createTweetPanel(){
		tweetPanel = new JPanel();
		tweetPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tweetPanel.setBounds(10, 179, 290, 59);
		contentPane.add(tweetPanel);
		tweetPanel.setLayout(null);
		tweet = new JTextArea();
		tweet.setBounds(6, 16, 274, 32);
		tweetPanel.add(tweet);
	}
	private void createIDPanel(){
		/*
		 * border for text box
		 */
		idPanel = new JPanel();
		idPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "User ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		idPanel.setBounds(0, 0, 290, 59);
		contentPane.add(idPanel);
		idPanel.setLayout(null);

		/*
		 * text box
		 */
		id = new JTextArea();
		id.setBounds(6, 16, 274, 36);
		idPanel.add(id);
	}
	
	private void createButtons(){
		/*
		 * buttons 
		 */
		addTweet = new JButton("Post Tweet");
		addTweet.setBounds(322, 188, 125, 36);
		addTweet.addActionListener((ActionListener) handler);
		getContentPane().add(addTweet);


		follow = new JButton("Follow User");
		follow.setBounds(322, 10, 125, 35);
		follow.addActionListener(handler);
		getContentPane().add(follow);
	}
	

	@Override
	public boolean alreadyFollowingUser(TwitterUser user) {
		DefaultListModel<Subject> array= currentUser.getFollowing();
		for(Object check:array.toArray()){
			if(check.equals(user))
				return true;
		}
		 return false;
	}
	@Override
	public boolean followingOwn(TwitterUser user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void follow(User userToFollow) {
		this.currentUser.follow((User) userToFollow);
		window.infoBox(userToFollow.getID(),"Now following User:");
	}
	@Override
	public void tweet(String msg) {
		this.currentUser.tweet(msg);
	}
	private class UserHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==follow){
				String userId=id.getText().trim();
				TwitterUser node=null;
				
				if(treeImplement.getTwitterUser(userId)!=null){
					node=treeImplement.getTwitterUser(userId);
				}
				else {
					window.infoBox("User not found!","ERROR!");
					return;
				}
				if(alreadyFollowingUser(node)){
					return;
				}
				else if(!(node instanceof User)){
					window.infoBox("Operation not supported. Only follow Individual Users can be followed!","ERROR!");
				}
				else{
					follow((User)node);
				}
			}
			
			if(e.getSource()==addTweet){
				String msg=tweet.getText().trim();
				tweet(msg);
			}
		}
		
	}

}

