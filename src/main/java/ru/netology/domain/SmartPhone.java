package ru.netology.domain;

public class SmartPhone extends Product{
    private String manufacturer;

    public SmartPhone() {
        super();
    }

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search){
        if (super.matches(search)){
            return true;
        }else {
            return manufacturer.contains(search);
        }
    }
}
