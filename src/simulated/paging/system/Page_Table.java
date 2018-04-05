package simulated.paging.system;

import javax.swing.*;
import java.awt.*;

class Page_Table extends JFrame {
    private static final int PAGESIZE = 512;

    JLabel lblText = new JLabel("Text");
    JLabel lblData = new JLabel("Data");
    JLabel lblPage = new JLabel("Page    ");
    JLabel lblFrame = new JLabel("Frame");
    JPanel textAndData = new JPanel();
    JPanel pageAndFrame = new JPanel();
    JPanel pnlTextTable = new JPanel();
    JPanel pnlDataTable = new JPanel();
    JPanel container = new JPanel();

    private void textTable(String procID, int textSize) {
        int textPages = (int) Math.ceil((double) textSize / PAGESIZE);
        this.pnlTextTable.setLayout(new GridLayout(textPages,2));
        procID = "P" + procID + "Text";
        for(int i = 0; i < Simulate.txtFrame.length; i++) {
            String info[] = Simulate.txtFrame[i].getText().split(" ");

            if(info[0].equals(procID)) {
                JTextField txtTextPage = new JTextField(info[1].substring(info[1].length() - 1));
                JTextField txtTextFrame = new JTextField(Integer.toString(i));
                txtTextPage.setEnabled(false);
                txtTextFrame.setEnabled(false);
                this.pnlTextTable.add(txtTextPage);
                this.pnlTextTable.add(txtTextFrame);
            }
        }
    }

    private void dataTable(String procID, int dataSize) {
        int dataPages = (int) Math.ceil((double) dataSize / PAGESIZE);
        this.pnlDataTable.setLayout(new GridLayout(dataPages,2));
        procID = "P" + procID + "Data";
        for(int i = 0; i < Simulate.txtFrame.length; i++) {
            String info[] = Simulate.txtFrame[i].getText().split(" ");

            if(info[0].equals(procID)) {
                JTextField txtDataPage = new JTextField(info[1].substring(info[1].length() - 1));
                JTextField txtDataFrame = new JTextField(Integer.toString(i));
                txtDataPage.setEnabled(false);
                txtDataFrame.setEnabled(false);
                this.pnlDataTable.add(txtDataPage);
                this.pnlDataTable.add(txtDataFrame);
            }
        }

    }


    Page_Table(String procID, int textSize, int dataSize) {
        super("Process " + procID);


        this.textAndData.setLayout(new GridLayout(2,1));
        this.container.setLayout(new GridLayout(2,1));

        this.textAndData.add(this.lblText);

        textTable(procID, textSize);
        dataTable(procID, dataSize);

        this.textAndData.add(this.lblData);
        this.pageAndFrame.add(this.lblPage);
        this.pageAndFrame.add(this.lblFrame);

        setSize(200, 300);
        setResizable(true);

        add(this.textAndData, BorderLayout.LINE_START);
        add(this.pageAndFrame, BorderLayout.PAGE_START);
        this.container.add(this.pnlTextTable);
        this.container.add(this.pnlDataTable);
        add(this.container, BorderLayout.CENTER);
        setVisible(true);
    }
}
