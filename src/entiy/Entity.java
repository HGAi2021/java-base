package entiy;

public class Entity {
  private int id;
  Demo1 type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Demo1 getType() {
        return type;
    }

    public void setType(Demo1 type) {
        this.type = type;
    }

    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setType(Demo1.AUDIO);
        System.out.println(entity.toString());
        Demo1 video = Demo1.VIDEO;
        System.out.println("11=="+video.getValue());
        Demo1 aigh = Demo1.AIGH;
        System.out.println("aigh=="+aigh);
        System.out.println("aigh=="+aigh.getValue());
        System.out.println("aigh=="+aigh.getName());
        Demo1 nnn = Demo1.valueOf(Demo1.class,"AIGH");
        Demo1[] values = Demo1.values();
        System.out.println("nnn=="+nnn);
    }
}
