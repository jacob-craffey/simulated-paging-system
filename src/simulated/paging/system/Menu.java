package simulated.paging.system;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class Menu extends JFrame {
    private static File file;

    private Menu() {
        super("Simulated Paging System");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initializing Components
        JPanel panel = new JPanel();
        JPanel simulatePanel = new JPanel();
        JButton btnImport = new JButton("Import Trace Tape");
        JButton btnSimulate = new JButton("Simulate");
        JLabel lblTraceTape = new JLabel("No trace tape selected...");

        setSize(300, 100);
        setResizable(true);

        /* Triggers when user clicks 'btnImport'
         *  Prompts user to select file and saves to 'this.file' */
        btnImport.addActionListener(e -> {
            JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = fc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                lblTraceTape.setText(file.getName());
                btnSimulate.setEnabled(true);
            }
        });

        /* Triggers when user clicks 'btnSimulate'
         * Opens new window with simulation of file */
        btnSimulate.addActionListener(e -> {
            new Simulate();
        });

        panel.add(btnImport);
        panel.add(lblTraceTape);

        simulatePanel.add(btnSimulate);
        btnSimulate.setEnabled(false);

        add(panel, BorderLayout.CENTER);
        add(simulatePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    static public File getFile() {
        return file;
    }

    public static void main(String[] args) {
        new Menu();
    }

}
