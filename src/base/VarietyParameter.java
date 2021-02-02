package base;

import org.junit.Test;

import java.util.Arrays;

public class VarietyParameter {
    private Integer id;
    private String name;

/*    public VarietyParameter(Integer id) {
        this.id = id;
    }

    public VarietyParameter(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public VarietyParameter() {

    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "VarietyParameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public  void sayHi(String ...n){
        String s = Arrays.toString(n);
        System.out.println("sayHi[][][][]"+s);
    }
    public  void sayHi(int a,String ...n){
        String s = Arrays.toString(n);
        System.out.println("sayHi>>[][][]"+a+","+s);
    }
}
