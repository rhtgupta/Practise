package innerClasses;

public class MemberInnerClass {

    class InnerClass {

        public void innerClassMethod() {
            System.out.println("Inner Class method....!!!!");
        }
    }

    public static void main(String[] args) {
        MemberInnerClass obj = new MemberInnerClass();
        MemberInnerClass.InnerClass innerClassObj = obj.new InnerClass();
        innerClassObj.innerClassMethod();
    }

}
