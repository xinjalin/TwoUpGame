import javax.swing.*;
import java.awt.*;
public class JMyFrame extends JFrame{
    public JMyFrame(){
        // title, frame size, default close option
        super("Template");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centers frame on screen using .awt
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
    }
}
