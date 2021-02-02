package collection;

import java.util.Objects;

public class Person implements Comparable {
    private String name;
    private int age;
    private String province;

    public Person(String name, int age, String province) {
        this.name = name;
        this.age = age;
        this.province = province;
    }
    public Person(){
        super();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(province, person.province);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", province='" + province + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, province);
    }
    //当向TreeSet中添加Person类的对象时，依据此方法，确定按照哪个属性排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person ){
            Person p = (Person) o ;
            int i = this.age - p.age;
            if(i==0){
                return this.name.compareTo(p.name);
            }else{
                return i;
            }
        }
        return 0;
    }
}

