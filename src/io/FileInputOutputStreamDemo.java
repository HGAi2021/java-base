package io;

import org.junit.Test;

import java.io.*;

public class FileInputOutputStreamDemo {
    /**
     * 从硬盘存在的一个文件中，读取其内容到程序中，使用FileInputStream
     */
    @Test
    public void t1(){
        //1、创建一个File类的对象
        File file = new File("hello.txt");
        //2、创建一个FileInputStream类对象
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream(file);
            //3、调用FileInputStream方法，实现File文件的读取
            /**
             * read（）：读取一个文件的字节。当执行到文件结尾的时候返回-1 abcdefg
             */
            int b  = fis.read();
            while (b!=-1){
                System.out.println((char) b);
                b = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、关闭流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void t2(){
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            //读取到的数据要写入的数组
            byte b []= new byte[5];
            //每次读入到byte中的字节的长度
            int read = fis.read(b);
            while (read!=-1){
                System.out.println((char)read);
                read = fis.read();
            }
        } catch (FileNotFoundException e) {

        }catch (IOException e) {

        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void t3(){
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            //读取到的数据要写入的数组
            byte b []= new byte[5];
            //每次读入到byte中的字节的长度
            int read = fis.read(b);
            while (read!=-1){
                System.out.println("read>>"+read);
                String s = new String(b, 0, read);
                System.out.println(s);
                read = fis.read(b);
            }
        } catch (FileNotFoundException e) {

        }catch (IOException e) {

        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void t4(){
        //1、创建一个File对象，表明要写入的文件位置，输出的物理文件可以不存在，当执行过程中若不存在会自动的创建
        File file = new File("hello2.txt");
        //2、创建一个FileOutputStream对象，将file对象作为形参传递给FileOutputStream构造器中
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(file);
            //3、写入的操作
            fos.write(new String("I love china I love the world").getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4、关闭输出流
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void t5(){
        //1、提供读入写出的文件
        File file1 = new File("hello.txt");
        File file2 = new File("hello3.txt");
        //2、提供相应的流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //3、 文件的复制 先读后写
            byte b [] = new byte[20];
            int read = fis.read(b);
            while (read!=-1){
                //fos.write(b); fos.write(b,0,b.length) 错误的写法 两写法一致
                fos.write(b,0,read);
                read = fis.read(b);
            }
        } catch (FileNotFoundException e) {

        }catch (IOException  e ){

        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {

                }finally {
                    if( fis!=null){
                        try {
                            fis.close();
                        } catch (IOException e) {

                        }
                    }
                }
            }
        }
    }

}
