package io;

import org.junit.Test;

import java.io.*;

public class BufferedIODemo {
    /**
     * 实现非文本文件的复制
     */
    @Test
    public void t1(){
        //1、提供读入、写入的文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("dbcp.txt");
            File file2 = new File("dbcp2.txt");
            //2、提供相应的流 先创建相应的节点流：FileInputStream、FileOutputStream
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file2);
            //3、将创建的节点流作为形参传递给缓冲流的构造器中
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4、具体实现文件复制的操作
            byte b[] = new byte[1024];
            int read = bis.read(b);
            while (read != -1) {
                bos.write(b, 0, read);
                bos.flush();
                read = bis.read(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5、关闭流
            if(bos!=null){
                try {
                    bos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(bis!=null){
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Test
    public void t2(){
        File file = new File("dbcp.txt");
        BufferedReader br = null;
        try {
            FileReader  fr = new FileReader(file);
            br = new BufferedReader(fr);
            char c[]= new char[1024];
            int read = br.read(c);
            while (read!=-1){
                String str = new String(c,0,read);
                System.out.println(str);
                read = br.read();
            }
            String s = br.readLine();
            while (s!=null){
                System.out.println(s);
                s = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void t3(){
        File file = new File("dbcp.txt");
        File file2 = new File("dbcp2.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;

        try{
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file2);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String s = br.readLine();
            while (s!=null){
                bw.write(s);
                //重启一行
                bw.newLine();
                bw.flush();
                System.out.println(s);
                s = br.readLine();
            }
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(br!=null){
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


    }
}
