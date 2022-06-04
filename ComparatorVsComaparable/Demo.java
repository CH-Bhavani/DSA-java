import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparable{
    public static void main(String[] args) {
        List<Laptop> l = new ArrayList<>();
        l.add(new Laptop("Dell", 16, 800));
        l.add(new Laptop("Apple",8,1200));
       l.add(new Laptop("Acer",12,700));

        System.out.println("Sorting Based on RAM");
        Collections.sort(l);
        for (Laptop lap: l) {
            System.out.println(lap);
        }
        

        System.out.println();


        Comparator<Laptop> obj =new Comparator<>(){
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if(o1.getPrice()>o2.getPrice())
                    return 1;
                else if(o1.getPrice()<o2.getPrice())
                    return -1;
                return 0;
            }
        };
        System.out.println("Sorting Based on Price");
        Collections.sort(l,obj);
        for (Laptop lap: l) {
            System.out.println(lap);
        }


        System.out.println();
//        Collections.sort(l, new Comparator<Laptop>() {
//            @Override
//            public int compare(Laptop o1, Laptop o2) {
//                if(o1.getPrice()>o2.getPrice())
//                    return 1;
//                else if(o1.getPrice()<o2.getPrice())
//                    return -1;
//                return 0;
//            }
//        });


        //Collections.sort(l,(a,b)->a.getRam()-b.getRam());
    }
}
class Laptop implements Comparable<Laptop>{
    private String brand;
    private int ram;
    private int price;

    public Laptop(String brand, int ram, int price) {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Laptop o) {
        if(this.getRam()>o.getRam())
            return 1;
        else if (this.getRam()<o.getRam())
            return -1;
        return 0;
    }

}
