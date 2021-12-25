public class student {
    String name;
    int rollno;

    public student(String name, int rollno) {
        this.name = name;
        this.rollno = rollno;
    }
}

public class arrayobjects{
    public static void main(String[] args) {
        student[] arr =new student[5];
        arr[0]=new student("bhavani",1);
        arr[1]=new student("mukesh",2);
        arr[2]=new student("pranathi",3);
        arr[3]=new student("vishwa",4);
        arr[4]=new student("harish",5);
        for (student st:arr) {
            System.out.println(st.name+" "+st.rollno);

        }
    }
}
