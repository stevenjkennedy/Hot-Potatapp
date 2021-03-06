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

    public static final HashMap<String, Category> CATEGORIES = new HashMap<>();

    public void selectCategory(View view){
        Button b = (Button)view;
        String buttonText = b.getText().toString();

        String[] selectedCategory;
        if (CATEGORIES.containsKey(buttonText)){
            selectedCategory = CATEGORIES.get(buttonText).Words;
        } else {
            Collection<Category> allCategories = CATEGORIES.values();
            Random rand = new Random();
            selectedCategory = ((Category)allCategories.toArray()[rand.nextInt(allCategories.size())]).Words;
        }
        Intent intent = new Intent(this, CoopGame.class);
        shuffleArray(selectedCategory);
        intent.putExtra(WORDS,selectedCategory);
        startActivity(intent);
    }

    // Implementing Fisher–Yates shuffle
    private static void shuffleArray(String[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static {

        Category potatoes = new Category();
        potatoes.Name = "Potato";
        String[] potatoWords = {
            "Russet",
                "Potato",
                "Baked",
                "Mashed"
        };
        potatoes.Words = potatoWords;
        CATEGORIES.put(potatoes.Name, potatoes);

        Category cartoons = new Category();
        cartoons.Name = "Cartoons";
        String[] cartoonWords = {
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
        cartoons.Words = cartoonWords;

        CATEGORIES.put(cartoons.Name, cartoons);
    }
}
