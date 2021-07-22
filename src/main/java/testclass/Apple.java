package testclass;

import annotation.FruitColor;
import annotation.FruitColor.Color;
import annotation.FruitName;


public class Apple {

    public int num;

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor=Color.RED)
    private String appleColor;


    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }


    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}