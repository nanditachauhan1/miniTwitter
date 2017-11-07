
public interface Subject {
 
    public void setObserver(Observer o);
  
    public void notifyObservers();
    
    public String getUpdate(Observer o);
    
}
