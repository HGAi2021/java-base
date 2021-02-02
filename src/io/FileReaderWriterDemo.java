package io;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterDemo {
    @Test
    public void t1(){
        File  file = new File("dbcp.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char c [] = new char[24];
            int read = fr.read(c);
            while (read!=-1){
                String string = new String(c,0,read);
                System.out.println(string);
                read =  fr.read(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void t2(){
        File file = new File("dbcp.txt");
        File file1 = new File("hello4.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            char c[] = new char[24];
            int read = fr.read(c);
            while (read!=-1){
                fw.write(c,0,read);
                read = fr.read(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
