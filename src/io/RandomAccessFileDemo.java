package io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 */

public class RandomAccessFileDemo {
    /**
     * 进行文件的读、写
     */
    @Test
    public void t1(){
        try {
            RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"r");
            RandomAccessFile raf2 = new RandomAccessFile(new File("hello6.txt"),"rw");
            byte b[] = new byte[5];
            int read = raf1.read(b);
            while (read!=-1){
                for(int i=0;i<read;i++){
                    System.out.println((char)b[i]);
                }
                raf2.write(b,0,read);
                read = raf1.read(b);
            }
            raf2.close();
            raf1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 随机插入数据，实现覆盖操作
     */
    @Test
    public void t2(){

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello6.txt"),"rw");
            /**
             * 0开始,实现插入效果
             */

            raf.seek(4);
            //取出后面的方法
//            String s = raf.readLine();
//            StringBuffer sb = new StringBuffer();
//            while (s!=null){
//                sb.append(s);
//                System.out.println(sb.toString());
//                s = raf.readLine();
//            }
            byte []b = new byte[5];
            int read = raf.read(b);
            StringBuffer sb = new StringBuffer();
            while (read!=-1){
                 sb.append(new String(b,0,read));
                read = raf.read(b);
            }
            System.out.println("sb>>"+sb.toString());
//            long filePointer = raf.getFilePointer();
//            System.out.println(filePointer);
            raf.seek(4);
            raf.write("xy".getBytes());
            raf.write(sb.toString().getBytes());
            raf.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
