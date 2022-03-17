package net.marcelektro;

import javax.swing.*;
import java.awt.*;

public class CounterGui extends JFrame {
    private final JPanel textPanel;
    private final JLabel text;

    public CounterGui() {
        this.setTitle("CPS Counter");
        this.setBounds(new Rectangle(230, 80));

        textPanel = new JPanel();
        textPanel.setBackground(new Color(40, 40, 40));

        text = new JLabel();
        text.setFont(new Font("Consolas", Font.BOLD, 30));
        text.setForeground(new Color(69, 200, 255));
        textPanel.add(text);

        this.add(textPanel);

        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
    }


    public void update() {
        text.setText(Main.leftClickCounter.getCPS() + "  |  " + Main.rightClickCounter.getCPS());

        textPanel.updateUI();
    }

}
