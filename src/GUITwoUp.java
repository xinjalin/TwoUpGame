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
    private final GridBagLayout gridBag;
    private final JLabel gameResult;
    private final JLabel coinOneLabel, coinTwoLabel;
    private final JLabel playerNameLabel;
    private final JTextField playerNameTextField;
    private final GridBagConstraints c;
    private final JPanel buttonPanel;
    private final JButton coinFlipButton;
    private final JRadioButton HEADS_HEADS, TAILS_TAILS;
    private final ButtonGroup radioGroup;
    private final Coin coinOne = new Coin(), coinTwo = new Coin();
    private final ImageIcon popperImg;
    private final JLabel popperLabel;

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
        gridBag = new GridBagLayout();
        c = new GridBagConstraints();

        gameResult = new JLabel("Result of Game", SwingConstants.CENTER);

        playerNameLabel = new JLabel("Enter Players Name");
        playerNameTextField = new JTextField(15);

        coinOneLabel = new JLabel(coinOne.toString());
        coinTwoLabel = new JLabel(coinTwo.toString());

        coinFlipButton = new JButton("Flip Coins");
        buttonPanel = new JPanel();

        HEADS_HEADS = new JRadioButton("2x HEADS");
        TAILS_TAILS = new JRadioButton("2x TAILS");

        radioGroup = new ButtonGroup();

        width = w;
        height = h;

        popperImg = new ImageIcon(new ImageIcon("images\\popper.gif").getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT));
        popperLabel = new JLabel();
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

        submenu.add(i4);
        i4.addActionListener(e -> setFontSize(9));
        // return font to default size
        submenu.add(i5);
        i5.addActionListener(e -> setFontSize(12));
        // set font to larger size
        submenu.add(i6);
        i6.addActionListener(e -> setFontSize(15));
        menu.add(submenu);
        mb.add(menu);

        // main content layout
        cp.setLayout(gridBag);
        //////////////////// current working on is in grid bag layout
        c.insets = new Insets(5,0,5,0);

        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 20;
        c.ipady = 5;
        cp.add(playerNameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        cp.add(playerNameTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        coinOneLabel.setPreferredSize(new Dimension(100,20));
        coinOneLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        coinOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coinOneLabel.setVerticalAlignment(SwingConstants.CENTER);
        cp.add(coinOneLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        coinTwoLabel.setPreferredSize(new Dimension(100,20));
        coinTwoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        coinTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coinTwoLabel.setVerticalAlignment(SwingConstants.CENTER);
        cp.add(coinTwoLabel, c);

        radioGroup.add(HEADS_HEADS);
        radioGroup.add(TAILS_TAILS);

        c.gridx = 0;
        c.gridy = 2;
        cp.add(HEADS_HEADS, c);

        c.gridx = 1;
        c.gridy = 2;
        cp.add(TAILS_TAILS, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        cp.add(gameResult, c);

        // button press call method to flip coins & updates labels with new coin values
        // check radioButton is click or not
        buttonPanel.add(coinFlipButton);
        coinFlipButton.addActionListener(e -> {
            coinOne.flip();
            coinTwo.flip();
            coinOneLabel.setText(coinOne.toString());
            coinTwoLabel.setText(coinTwo.toString());

            if (HEADS_HEADS.isSelected()) {
                String selected = "HEADS_HEADS";
                Game g = new Game();
                gameResult.setText(g.gameOfTwoUp(coinOne.isHeads(), coinTwo.isHeads(), selected, playerNameTextField.getText()));
            } else if (TAILS_TAILS.isSelected()) {
                String selected = "TAILS_TAILS";
                Game g = new Game();
                gameResult.setText(g.gameOfTwoUp(coinOne.isHeads(), coinTwo.isHeads(), selected, playerNameTextField.getText()));
            }
        });


        popperLabel.setIcon(popperImg);
        mainDisplay.getContentPane().add(BorderLayout.WEST, popperLabel);
        // puts menu bar to top of the screen
        mainDisplay.getContentPane().add(BorderLayout.NORTH, mb);
        // puts content to screen
        mainDisplay.getContentPane().add(BorderLayout.CENTER, cp);
        mainDisplay.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        // sets content visible
        mainDisplay.setVisible(true);
    }
    private void setFontSize(int size) {
        coinOneLabel.setFont(new Font("Dialog", Font.BOLD, size));
        coinTwoLabel.setFont(new Font("Dialog", Font.BOLD, size));
        coinFlipButton.setFont(new Font("Dialog", Font.BOLD, size));
        playerNameLabel.setFont(new Font("Dialog", Font.BOLD, size));
        HEADS_HEADS.setFont(new Font("Dialog", Font.BOLD, size));
        TAILS_TAILS.setFont(new Font("Dialog", Font.BOLD, size));
        gameResult.setFont(new Font("Dialog", Font.BOLD, size));
    }
}
