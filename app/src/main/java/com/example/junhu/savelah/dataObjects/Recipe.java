package com.example.junhu.savelah.dataObjects;
import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.EventLog;
import android.util.Log;

import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recipe implements Parcelable {
    private String title;
    private String image;
    private String instructions;
    private int id;
    private List<Ingredient> extendedIngredients;
    public static final Parcelable.Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public Recipe(String title, String image, int id) {
        this.title = title;
        this.image = image;
        this.id = id;
    }

    private Recipe(Parcel in) {
        title = in.readString();
        image = in.readString();
        id = in.readInt();
    }

    public String getTitle() {
        return this.title.replaceAll("\\p{Pd}", "-");
    }

    public String getImage() {
        return this.image;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getId() {
        return id;
    }

    public String getIdString() {
        return String.valueOf(id);
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
        dest.writeInt(id);
    }
}

