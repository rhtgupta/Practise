package thread_revision;

public class MainTest implements Int1, Int2 {

    public void method() {
        Int1.super.method();
        Int2.super.method();
        System.out.println("Main Class");
    }

    public static void main(String[] args) {
        MainTest obj = new MainTest();
        obj.method();
    }
}
