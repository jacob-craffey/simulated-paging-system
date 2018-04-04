package simulated.paging.system;

import javax.swing.*;
import java.awt.*;

public class Simulate extends JFrame {

    static JTextField[] txtFrame = new JTextField[8];

    static JButton btnNext = new JButton("Next");

    Simulate() {
        super("Simulate");

        JPanel panel = new JPanel();
        JPanel nextPanel = new JPanel();
        JPanel filePanel = new JPanel();
        JLabel[] lblFrame = new JLabel[8];
        JLabel lblFile = new JLabel();

        panel.setLayout(new GridLayout(8, 2));

        for (int i = 0; i < lblFrame.length; i++) {
            lblFrame[i] = new JLabel("Frame " + Integer.toString(i), SwingConstants.CENTER);
            txtFrame[i] = new JTextField();
            panel.add(lblFrame[i]);
            panel.add(txtFrame[i]);
            txtFrame[i].setEnabled(false);
        }

        Steps steps = new Steps(Menu.getFile());

        lblFile.setText(steps.name);
        filePanel.add(lblFile);

        btnNext.addActionListener(e -> steps.readNext());

        nextPanel.add(btnNext);

        add(filePanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(nextPanel, BorderLayout.SOUTH);

        setSize(300, 500);
        setResizable(true);
        setVisible(true);
    }
}
