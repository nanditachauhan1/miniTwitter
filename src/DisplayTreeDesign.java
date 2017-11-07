import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;


@SuppressWarnings("serial")
public class DisplayTreeDesign extends DefaultTreeCellRenderer{
    Icon leafIcon;
    Icon nonLeafIcon;
    public DisplayTreeDesign(Icon leafIcon, Icon nonLeafIcon) {
        this.leafIcon = leafIcon;
        this.nonLeafIcon=nonLeafIcon;
    }
    
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row,
                                           hasFocus);
        
        if (value instanceof TwitterUser) {
            setIcon(leafIcon);
        } else {
            setIcon(nonLeafIcon);
        }
        return this;
    }
    
}
