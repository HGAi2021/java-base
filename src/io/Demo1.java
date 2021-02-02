package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 从硬盘存在的一个文件中，读取内容到程序中，使用FileInputStream
 */
public class Demo1 {
    public static void main(String[] args) {
        //1、创建一个File类的对象
        File file = new File("hello.txt");
        //2、创建一个FileInputStream类的对象
        FileInputStream fl = null;
        try {
             fl = new FileInputStream(file);
            //3、调用方法，实现file文件的读取
            int read = fl.read();
            if(read!=-1){
                System.out.println((char)read);
                 read = fl.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
