import java.util.ArrayList;
import javax.swing.DefaultListModel;


public class PositiveMessages implements Visitor {
    private int numPositive =0;
  
    private int numWords =0;
    
    String [] positiveWordsList = {"good","great","excellent", "adore", "beautiful", "love", "happy", "nice", "amazing", "together"};
    
    ArrayList <String> words = new ArrayList<>();
    
    @Override
    public void visit(TwitterUser u) {
        if (u instanceof User){
            DefaultListModel<String> news =((User) u).getNewsfeed();
            for (Object s: news.toArray()){
                String[] temp =((String) s).split(" ");
                for (String t:temp){
                    words.add(t.toLowerCase());
                }
                
            }
        }
        numWords= words.size();
        addPositiveCount();
        
    }
   
    private void addPositiveCount(){
        for(String positive: positiveWordsList){
            if (words.contains(positive)){
                words.remove(positive);
                numPositive++;
            }
        }
    }
  
    public double getPercent(){
        if(numWords>0){
            return numPositive*100/numWords;
        }
        popUpWindow p = new popUpWindow();
        
        p.infoBox("Can't get Percentage", "Error");
        return 0;
    }
    
}
