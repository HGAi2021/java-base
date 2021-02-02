package entiy;

/**
 * @author H_Java
 */

public enum Demo1 {

    VIDEO(1),AUDIO(2),TEXT(3),IMAGE(4),AIGH(1,"nnn");
    int value;
    String name;
    Demo1 (int value){
        this.value = value;
    }
    Demo1 (int value,String name){
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Demo1 getByValue(int value) {
        for(Demo1 typeEnum : Demo1.values()) {
            if(typeEnum.value == value) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

}
