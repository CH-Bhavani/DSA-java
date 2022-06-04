public class SingleTonClassDemo {
    public static void main(String[] args) {
        abc obj= abc.getInstance();
        abc obj2=abc.getInstance(); // returns same instance of obj
    }

}
class abc {
    static abc obj=new abc();
    private abc(){
        System.out.println("singleton class");
    }
    public static abc getInstance(){
        return obj;
    }
}





output:

singleton class
