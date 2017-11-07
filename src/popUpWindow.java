import javax.swing.JOptionPane;


public class popUpWindow {
    
    public void infoBox(double d, String titleBar)
    {
        JOptionPane.showMessageDialog(null, d, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void infoBox(String string, String titleBar) {
        JOptionPane.showMessageDialog(null, string, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
