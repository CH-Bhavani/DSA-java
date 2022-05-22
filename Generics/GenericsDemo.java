//simple usage of generics 




import java.util.ArrayList;

class container<T extends Number>{
    T value;

    public container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void show(){
        System.out.println(value.getClass().getName());
    }
    public  void demo(ArrayList<? extends T> obj ){   //"?" can be anything that extends "T" .like Integer extends Number

    }
//    public  void demo(ArrayList<? super  T> obj ){   //can also use super "?" can be anything that is super class of  "T" .like  number is super class of Integer.
//
//    }
}


public class GenerisDemo {
    public static void main(String[] args) {
        //container<Number> obj=new container<>(9.09); gives java.lang.Double
        container<Number> obj=new container<>(9); //gives java.lang.Integer

        obj.show();
        obj.demo(new ArrayList<Integer>());
    }
}
