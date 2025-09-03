package liangInterface;

import java.util.Date;

public class House implements Cloneable,Comparable<House>{
    private int id;
    private double area;
    private java.util.Date whenBuilt;

    public House(int id, double area, Date whenBuilt) {
        this.id = id;
        this.area = area;
        this.whenBuilt = whenBuilt;
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public Date getWhenBuilt() {
        return whenBuilt;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public int compareTo(House o){
        if(area > o.area)
            return 1;
        else if (area < o.area)
            return -1;
        else
            return 0;
        }
    }

