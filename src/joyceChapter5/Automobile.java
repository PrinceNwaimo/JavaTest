package joyceChapter5;

public class Automobile {
    private int id;
    private String make;
    private String model;
    private String color;
    private int year;
    private int milesPerGallon;

    public Automobile(int id, String make, String model, String color, int year, int milesPerGallon) {
        setId(id);
        setMake(make);
        setModel(model);
        setColor(color);
        setYear(year);
        setMilesPerGallon(milesPerGallon);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0 || id > 9999) {
            this.id = 0;
        } else {
            this.id = id;
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2005 || year > 2019) {
            this.year = 0;
        } else {
            this.year = year;
        }
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        if (milesPerGallon < 10 || milesPerGallon > 60) {
            this.milesPerGallon = 0;
        } else {
            this.milesPerGallon = milesPerGallon;
        }
    }

}
