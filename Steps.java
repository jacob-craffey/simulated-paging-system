package simulated.paging.system;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Steps {
    public String name;
    public String procID;
    public String textSize;
    public String dataSize;

    private LinkedList<String> list = new LinkedList<>();
    private Iterator i;

    public Steps(File file) {
        this.name = file.getName();

        String content;
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while(sc.hasNextLine()) {
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated safely...");
        }
        this.i = list.iterator();
    }
    
    public void readNext() {
        if(this.i.hasNext()) {
            try {
                String current = this.i.next().toString();
                String[] elements = current.split("\\s+");
                if(elements.length > 2) {
                    this.procID = elements[0];
                    this.textSize = elements[1];
                    this.dataSize = elements[2];
                } else {
                    this.procID = elements[0];
                }
            } catch(PatternSyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
