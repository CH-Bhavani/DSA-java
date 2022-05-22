import java.util.*;
@FunctionalInterface
interface Abc{

    void fun();
}
class A{
    public void showDataInMyPc(){
        System.out.println("in A");
    }
}
class B extends A{
    @Deprecated        // not to use this method
    public void showData(){
        System.out.println("dont use this version of method");
    }
    @Override
    @SuppressWarnings("unchecked")    // warning from ArrayList class to mention generic are supressed.
    public void showDataInMyPc() {
        ArrayList arr=new ArrayList();   //warning 
        System.out.println("in B");
    }
}
public class AnnotaionsDemo {
    public static void main(String[] args) {
        B obj =new B();
        obj.showDataInMyPc();   // in B
        obj.showData();       

    }
}
