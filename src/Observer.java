/*
 * This is the interface to implement the Observer Pattern
 */

public interface Observer {
   
    public void setSubject(Subject s);
   
    public void update(Subject s);
    
}
