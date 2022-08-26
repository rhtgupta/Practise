package dp_prototype;

public class PrototypeExample implements Cloneable {
    private int age;
    private String name;

    PrototypeExample(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PrototypeExample{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeExample originalObj = new PrototypeExample(32, "Rohit");
        System.out.println(originalObj);
        PrototypeExample clonedObj = (PrototypeExample) originalObj.clone();
        System.out.println(clonedObj);
    }
}
