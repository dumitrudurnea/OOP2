package task1;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        this.flavor = "";
        this.origin = "";
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox with flavor: " + flavor + " from origin: " + origin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CandyBox candyBox = (CandyBox) obj;
        return flavor.equals(candyBox.flavor) && origin.equals(candyBox.origin);
    }
}
