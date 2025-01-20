package task2;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(42, "Decebal", "Popescu");

        Student student2 = new Student(student1);

        student2.setName("Cezar");
        student2.setSurname("Ghiu");

        student1.show(); 
        student2.show(); 
    }
}
