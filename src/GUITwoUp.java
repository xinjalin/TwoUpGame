import javax.swing.*;
import java.awt.*;

public class GUITwoUp {
    private final int width;
    private final int height;
    private final JMyFrame mainDisplay;
    private final JMenu menu, submenu;
    private final JMenuItem i1, i2, i3, i4, i5, i6;
    private final JMenuBar mb;
    private final Container cp;
    private final GridLayout grid;
    private final JLabel coinOneLabel, coinTwoLabel;
    private final JTextField playerName;
    private final JPanel playerNamePanel;
    private final JPanel coinPanel;
    private final JPanel buttonPanel;
    private final JButton coinFlipButton;
    private final Coin coinOne = new Coin(), coinTwo = new Coin();

    public GUITwoUp(int w,int h) {
        mainDisplay = new JMyFrame();

        mb = new JMenuBar();
        menu = new JMenu("Menu");
        submenu = new JMenu("Font Size");

        i1 = new JMenuItem("item 1");
        i2 = new JMenuItem("item 2");
        i3 = new JMenuItem("item 3");
        i4 = new JMenuItem("Small");
        i5 = new JMenuItem("Default");
        i6 = new JMenuItem("Large");

        cp = new Container();
        grid = new GridLayout(1,2);

        playerName = new JTextField(15);
        playerNamePanel = new JPanel();

        coinOneLabel = new JLabel(coinOne.toString());
        coinTwoLabel = new JLabel(coinTwo.toString());
        coinPanel = new JPanel();

        coinFlipButton = new JButton("Flip Coins");
        buttonPanel = new JPanel();

        width = w;
        height = h;
    }

    public void setUpGUI() {
        // JFrame set up size & title
        mainDisplay.setSize(width,height);
        mainDisplay.setTitle("Two Up");
        // top nav / menu options
        // adding menuItems to menu and submenu
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        // set font to smaller size
        submenu.add(i4);
        i4.addActionListener(e -> {
            coinOneLabel.setFont(new Font("Dialog", Font.BOLD, 9));
            coinTwoLabel.setFont(new Font("Dialog", Font.BOLD, 9));
            coinFlipButton.setFont(new Font("Dialog", Font.BOLD, 9));
        });
        // return font to default size
        submenu.add(i5);
        i5.addActionListener(e -> {
            coinOneLabel.setFont(new Font("Dialog", Font.BOLD, 12));
            coinTwoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
            coinFlipButton.setFont(new Font("Dialog", Font.BOLD, 12));
        });
        // set font to larger size
        submenu.add(i6);
        i6.addActionListener(e -> {
            coinOneLabel.setFont(new Font("Dialog",Font.BOLD, 15));
            coinTwoLabel.setFont(new Font("Dialog", Font.BOLD, 15));
            coinFlipButton.setFont(new Font("Dialog", Font.BOLD, 15));
        });
        menu.add(submenu);
        mb.add(menu);

        // main content
        // adding coins to coinPanel
        coinPanel.add(coinOneLabel);
        coinPanel.add(coinTwoLabel);
        mainDisplay.getContentPane().add(coinPanel);
        // button press call method to flip coins & updates labels with new coin values
        buttonPanel.add(coinFlipButton);
        coinFlipButton.addActionListener(e -> {
            coinOne.flip();
            coinTwo.flip();
            coinOneLabel.setText(coinOne.toString());
            coinTwoLabel.setText(coinTwo.toString());
        });

        //////////////////// current working on is in grid layout
        cp.setLayout(grid);
        playerName.setBounds(50,100, 200,30);
        playerNamePanel.add(playerName);
        cp.add(playerNamePanel);
        cp.add(coinPanel);

        // puts menu bar to top of the screen
        mainDisplay.getContentPane().add(BorderLayout.NORTH, mb);
        // puts content to screen
        // mainDisplay.getContentPane().add(BorderLayout.CENTER, coinPanel);
        mainDisplay.getContentPane().add(BorderLayout.CENTER, cp);
        mainDisplay.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        // sets content visible
        mainDisplay.setVisible(true);
    }
}
