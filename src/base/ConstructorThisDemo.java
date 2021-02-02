package base;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author H_Java
 */
public class ConstructorThisDemo {
    private String id;
    private String name;
    private int age;
    public ConstructorThisDemo(){

    };
    public ConstructorThisDemo(String id ){
        this.id = id;
    }
    public  ConstructorThisDemo(String id,String name,int age){
        this(id);
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "ConstructorThisDemo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


