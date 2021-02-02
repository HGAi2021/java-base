package io;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        /**
         *
         * 路径：
         * 绝对路径：包括盘符在内的完整的文件路径 eg：D:\FileDemo
         * 相对路径：在当前文件目录下的文件的路径 eg：hello
         */
        File file = new File("d:/FileDemo/helloword.txt");
        File file1 = new File("hello.txt");
        File file2 = new File("d:/FileDemo");
        //访问文件
/*        System.out.println("File:getName>>"+file.getName());
        System.out.println("File:getAbsoluteFile>>"+file.getAbsoluteFile());
        System.out.println("File:getAbsolutePath>>"+file.getAbsolutePath());
        System.out.println("File:getPath>>"+file.getPath());
        System.out.println("File:getParent>>"+file.getParent());

        System.out.println();

        System.out.println("File2:getName>>"+file2.getName());
        System.out.println("File2:getAbsoluteFile>>"+file2.getAbsoluteFile());
        System.out.println("File2:getAbsolutePath>>"+file2.getAbsolutePath());
        System.out.println("File2:getPath>>"+file2.getPath());
        System.out.println("File2:getParent>>"+file2.getParent());*/

/*
        boolean b = file.renameTo(new File("d:/FileDemo/helloword.txt"));
        System.out.println(b);
        File file3 = new File("d:/FileDemo/oo");
        boolean b1 = file3.renameTo(new File("d:/FileDemo/io"));
        System.out.println(b1);
*/
        //文件检测
      /*  boolean exists = file.exists();
        System.out.println("exists>>"+exists);
        boolean b = file.canWrite();
        System.out.println("canWrite>>"+b);
        boolean b1 = file.canRead();
        System.out.println("canRead>>"+b1);
        boolean directory = file.isDirectory();
        System.out.println("isDirectory>>"+directory);
        boolean b3 = file.isFile();
        System.out.println("isFile>>"+b3);
        long l = file.lastModified();
        System.out.println("lastModified>>"+new Date(l));
        long length = file.length();
        System.out.println("length>>"+length);*/
/*
        boolean delete = file.delete();
        boolean delete2 = file2.delete();
        System.out.println("delete>>"+delete);
        System.out.println("delete>>"+delete2);
        try {
            boolean  newFile = file.createNewFile();
            boolean  newFile2 = file2.createNewFile();
            System.out.println("createNewFile>>"+newFile);//文件
            System.out.println("createNewFile>>"+newFile2);//文件夹
            System.out.println("createNewFile>>"+new File("d:/demo").createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        //文件目录操作
/*        boolean mkdir = file2.mkdir();
        System.out.println("mkdir>>"+mkdir);
        File file3 = new File("d:/FileDemo/xxx/xxxx");
        System.out.println(file3.mkdirs());*/

        String[] list = file2.list();
        for (String str : list){
            System.out.println(str);
        }
        File[] files = file2.listFiles();
        System.out.println(files);
        for (File f : files){
            System.out.println(f.getName());
        }
    }
}
