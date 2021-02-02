package collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("jdbc.properties")));
            //获取具体属性
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println(user);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
