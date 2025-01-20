import task2.Baravelli;
import task2.ChocAmor;
import task2.Lindt;
import task4.CandyBag;

import task6.Area;

public class Main {
    public static void main(String[] args) {
        CandyBag bag = new CandyBag();

        Lindt lindt = new Lindt("Chocolate with Hazelnut", "Germany", 15, 6, 3);  
        Baravelli baravelli = new Baravelli("Milk Chocolate", "Belgium", 5, 9); 
        ChocAmor chocAmor = new ChocAmor("Dark Chocolate", "Spain", 7); 

        bag.addCandy(lindt);
        bag.addCandy(baravelli);
        bag.addCandy(chocAmor);

        Area area = new Area(bag, 50, "Baker Street");  
        area.getBirthdayCard();

        System.out.println("Equality check: " + lindt.equals(new Lindt("Chocolate with Hazelnut", "Germany", 15, 6, 3))); 
    }
}
