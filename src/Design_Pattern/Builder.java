package Design_Pattern;

class Basketball {
    private final String brand;
    private final String size;
    private final String color;

    public Basketball(String brand, String size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return brand + ' ' + size + ' ' + color;
    }
}

class BasketballBuilder {
    private String brand;
    private String size;
    private String color;

    public BasketballBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public BasketballBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public BasketballBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Basketball build() {
        return new Basketball(brand, size, color);
    }
}

class BasketballDirector {
    public Basketball constructBasketball(BasketballBuilder builder, String brand, String size, String color) {
        return builder.setBrand(brand).setSize(size).setColor(color).build();
    }
}

public class Builder {
    public static void main(String[] args) {
        BasketballBuilder builder = new BasketballBuilder();
        BasketballDirector director = new BasketballDirector();

        Basketball basketball = director.constructBasketball(builder, "Nike", "7", "Orange");

        System.out.println(basketball.getBrand() + ' ' + basketball.getSize() + ' ' + basketball.getColor());
        System.out.println(basketball);
    }
}