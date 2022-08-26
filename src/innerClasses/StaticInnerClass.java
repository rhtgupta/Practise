package innerClasses;

public class StaticInnerClass {

    static class InnerClass {
        public void innerClassMethod() {
            System.out.println("Inner class method called....!!!");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.InnerClass obj = new StaticInnerClass.InnerClass();
        obj.innerClassMethod();
    }

}
