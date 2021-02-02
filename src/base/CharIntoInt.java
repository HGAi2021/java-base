package base;

public class CharIntoInt {
    public static void main(String[] args) {
        char a = 97 ;
        System.out.println("a:"+a);

        int b = 'a';
        System.out.println("b:"+b);

        char a1 = 97+1;
        char a2 = 'a'+1;
        int b1 = 'a'+1;
        System.out.println("a1:"+a1);
        System.out.println("a2:"+a2);
        System.out.println("b1:"+b1);

        char a3 = 'a';
        int b2 = a3;
        System.out.println("b2:"+b2);

        int num = 97;
        char a4 = (char) num;
        System.out.println("a4:"+a4);

        char a5 = 'a'+'b';
        System.out.println("a5:"+a5);
        int b3 = a5;
        System.out.println("b3:"+b3);

        int b4 =1;
        char a6 = (char) b4;
        System.out.println("a6:"+a6);
    }
}
