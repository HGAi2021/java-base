package entiy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Integer age;
    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    @Override
    public String toString(){
        return "PerSon[name>>"+name+",age>>"+age+"]";
    }
}
