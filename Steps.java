package simulated.paging.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Steps {
    public String name;

    private static final int PAGESIZE = 512;
    private static final int EMPTY = -1;

    private LinkedList<String> list = new LinkedList<>();
    private Iterator i;
    private int[] pageTable = new int[8];

    Steps(File file) {
        this.name = file.getName();

        String content;
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated safely...");
        }
        this.i = list.iterator();
        Arrays.fill(this.pageTable, -1);
    }

    private void mapMemory(String[] elements) {
        int procID = Integer.parseInt(elements[0]);
        int textSize = Integer.parseInt(elements[1]);
        int dataSize = Integer.parseInt(elements[2]);

        int textPages = (int) Math.ceil((double) textSize / PAGESIZE);
        int dataPages = (int) Math.ceil((double) dataSize / PAGESIZE);

        int i = 0;
        int pageCount = 0;
        while (textPages > 0 && i < pageTable.length) {
            if (pageTable[i] == EMPTY) {
                textPages--;
                pageTable[i] = procID;
                Simulate.txtFrame[i].setText("P" + procID + "Text Page" + pageCount++);
            }
            i++;
        }

        i = pageCount = 0;
        while (dataPages > 0 && i < pageTable.length) {
            if (pageTable[i] == EMPTY) {
                dataPages--;
                pageTable[i] = procID;
                Simulate.txtFrame[i].setText("P" + procID + "Data Page" + pageCount++);
            }
            i++;
        }
    }

    private void haltMemory(String haltProc) {

        int id = Integer.parseInt(haltProc);

        for (int i = 0; i < pageTable.length; i++) {
            if (pageTable[i] == id) {
                this.pageTable[i] = EMPTY;
                Simulate.txtFrame[i].setText("");
            }
        }
    }

    // Reads the next item and determines how to handle the next step
    public void readNext() {
        if (this.i.hasNext()) {
            try {
                String current = this.i.next().toString();
                String[] elements = current.split("\\s+");

                // If introduced with new procID with new data
                if (elements.length > 2) {
                    mapMemory(elements);
                    // Next step is a halt with a procID
                } else {
                    haltMemory(elements[0]);
                }
                // If the last step, grey out the next button to indicate no more steps
                if (!this.i.hasNext()) {
                    Simulate.btnNext.setEnabled(false);
                }
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
