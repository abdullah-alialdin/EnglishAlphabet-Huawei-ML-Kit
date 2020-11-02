package abdoroid.englishalphabet.model;

import java.util.ArrayList;

public class DataModel {

    private int imageReference;
    private String title;
    private String color;
    private ArrayList<CategoryModel> category;

    public DataModel(int imageReference, String title, String color, ArrayList<CategoryModel> category) {
        this.imageReference = imageReference;
        this.title = title;
        this.color = color;
        this.category = category;
    }

    public int getImageReference() {
        return imageReference;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<CategoryModel> getCategory() {
        return category;
    }
}

