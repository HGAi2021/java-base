package io;

import entiy.Person;
import org.junit.Test;

import java.io.*;


public class OtherStreamDemo {
    /**
     * 转换流:InputStreamReader、OutputStream
     * 编码：字符串->字节数组
     * 解码：字节数组->字符串
     */
    @Test
    public void t1(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        //解码的过程
        try {
            File file = new File("dbcp.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            br =new BufferedReader(isr);
            //编码的过程
            File file1 = new File("dbcp2.txt");
            FileOutputStream fos = new FileOutputStream(file1);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            bw = new BufferedWriter(osw);

            java.lang.String s = br.readLine();
            while (s!=null){
                System.out.println(s);
                bw.write(s);
                bw.newLine();
                bw.flush();
                s = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }   catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
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

    /**
     * 从键盘输入字符串，要求将读取道德整行字符串转换成为大写输出，然后继续进行输入操作，直到输入“e”或者“exit”时，退出程序。
     */
    @Test
    public void t2(){
        BufferedReader br = null;
        try {
            InputStream is = System.in;
            InputStreamReader isr = new InputStreamReader(is);
            br  = new BufferedReader(isr);
            System.out.println("清输入字符串：");
            String str;
            while(true){
                str = br.readLine();
                if(str.equalsIgnoreCase("exit")){
                    break;
                }
                String s1 = str.toUpperCase();
                System.out.println(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("hello5.txt"));
            //创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时，都会刷新输出缓冲区）
            PrintStream ps = new PrintStream(fos,true);
            if(ps != null){
                //把标准输出流（控制台输出）改成文件
                System.setOut(ps);
            }
            for(int i =0 ;i<=255 ;i++){
                //输出ASCII字符
                System.out.println((char)i);
                //每50个数据一行
                if((i%50)==0){
                    System.out.println();//换行
                }
            }
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t4(){
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        DataInputStream  dis = null;
        try {
            fos = new FileOutputStream("data.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("我爱你你却不知道");
            dos.writeBoolean(true);
            dis = new DataInputStream(new FileInputStream("data.txt"));
            String s = dis.readUTF();
            System.out.println("s>>"+s);
            boolean b1 = dis.readBoolean();
            System.out.println("bool>>>"+b1);
            byte b[] = new byte[20];
            int read = dis.read(b);
            while (read!=-1){
                System.out.println(new java.lang.String(b,0,read));
                read = dis.read(b);
            }
            dos.close();
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t5(){
        Person p = new Person("小米",23);
        Person p1 = new Person("红米",21);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
            oos.writeObject(p);
            oos.flush();
            oos.writeObject(p1);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将
     */
    @Test
    public void t6(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("person.txt"));
            Person p = (Person)ois.readObject();
            System.out.println(p);
            Person p1 = (Person)ois.readObject();
            System.out.println(p1);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
