package com.stevenjkennedy.hotpotatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CategoryMenu extends AppCompatActivity {

    public static final String WORDS = "com.stevenjkennedy.hotpotatapp.words";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryselect);
    }

    public static final HashMap<String, String[]> CATEGORIES = new HashMap<>();

    public void selectCategory(View view){
        Button b = (Button)view;
        String buttonText = b.getText().toString();

        String[] selectedCategory;
        if (CATEGORIES.containsKey(buttonText)){
            selectedCategory = CATEGORIES.get(buttonText);
        } else {
            Collection<String[]> allCategories = CATEGORIES.values();
            Random rand = new Random();
            selectedCategory = (String[])allCategories.toArray()[rand.nextInt(allCategories.size())];
        }
        Intent intent = new Intent(this, CoopGame.class);
        intent.putExtra(WORDS,selectedCategory);
        startActivity(intent);
    }

    static {
        String[] potatoes = {
            "Russet",
                "Potato",
                "Baked",
                "Mashed"
        };
        CATEGORIES.put("Potato", potatoes);

        String[] cartoons = {
          "Looney Tunes",
          "The Simpsons",
          "Tom and Jerry",
          "SpongeBob SquarePants",
          "Futurama",
          "South Park",
        "Family Guy",
                "Teen Titans",
                "Rugrats"
        };

        CATEGORIES.put("Cartoons", cartoons);
    }
}
