package simulated.paging.system;

import javax.swing.*;
import java.awt.*;

public class Simulate extends JFrame{

    JPanel panel = new JPanel();
    JPanel nextPanel = new JPanel();
    JPanel filePanel = new JPanel();

    JLabel lblFrame0 = new JLabel("Frame0", SwingConstants.CENTER);
    JLabel lblFrame1 = new JLabel("Frame1", SwingConstants.CENTER);
    JLabel lblFrame2 = new JLabel("Frame2", SwingConstants.CENTER);
    JLabel lblFrame3 = new JLabel("Frame3", SwingConstants.CENTER);
    JLabel lblFrame4 = new JLabel("Frame4", SwingConstants.CENTER);
    JLabel lblFrame5 = new JLabel("Frame5", SwingConstants.CENTER);
    JLabel lblFrame6 = new JLabel("Frame6", SwingConstants.CENTER);
    JLabel lblFrame7 = new JLabel("Frame7", SwingConstants.CENTER);

    JLabel lblFile = new JLabel();

    JTextField txtFrame0 = new JTextField();
    JTextField txtFrame1 = new JTextField();
    JTextField txtFrame2 = new JTextField();
    JTextField txtFrame3 = new JTextField();
    JTextField txtFrame4 = new JTextField();
    JTextField txtFrame5 = new JTextField();
    JTextField txtFrame6 = new JTextField();
    JTextField txtFrame7 = new JTextField();

    JButton btnNext = new JButton("Next");

    public Simulate() {
        super("Simulate");

        Steps steps = new Steps(Menu.getFile());

        lblFile.setText(steps.name);
        filePanel.add(lblFile);

        panel.setLayout(new GridLayout(8,2));

        panel.add(lblFrame0);
        panel.add(txtFrame0);
        panel.add(lblFrame1);
        panel.add(txtFrame1);
        panel.add(lblFrame2);
        panel.add(txtFrame2);
        panel.add(lblFrame3);
        panel.add(txtFrame3);
        panel.add(lblFrame4);
        panel.add(txtFrame4);
        panel.add(lblFrame5);
        panel.add(txtFrame5);
        panel.add(lblFrame6);
        panel.add(txtFrame6);
        panel.add(lblFrame7);
        panel.add(txtFrame7);

        txtFrame0.setEnabled(false);
        txtFrame1.setEnabled(false);
        txtFrame2.setEnabled(false);
        txtFrame3.setEnabled(false);
        txtFrame4.setEnabled(false);
        txtFrame5.setEnabled(false);
        txtFrame6.setEnabled(false);
        txtFrame7.setEnabled(false);

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
