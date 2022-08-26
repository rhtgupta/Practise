package innerClasses;

public class MethodLocalInnerClass {

    public void methodLocal() {

        class InnerClass {
            public void innerClassMethod() {
                System.out.println("Method local inner class....!!!");
            }
        }
        InnerClass obj = new InnerClass();
        obj.innerClassMethod();
    }

    public static void main(String[] args) {
        MethodLocalInnerClass obj = new MethodLocalInnerClass();
        obj.methodLocal();
    }
}
