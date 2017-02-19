package com.example.dotykacka.football;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int goles_a = 0;
    private int goles_b = 0;


    private int shots_a = 0;
    private int shots_b = 0;

    private int chance_a = 50;
    private int chance_b = 50;

    boolean addpercentageA = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addgoaltoa(View view) {
        goles_a += 1;
        TextView score_text_a = (TextView) findViewById(R.id.score_a);
        score_text_a.setText(String.valueOf(goles_a));
        TextView getTeamName = (TextView) findViewById(R.id.teamAname);

    }

    public void addgoaltob(View view) {
        goles_b += 1;
        TextView score_text_b = (TextView) findViewById(R.id.score_b);
        score_text_b.setText(String.valueOf(goles_b));
        TextView getTeamName = (TextView) findViewById(R.id.teamBname);
    
    }


    public void addshottoa(View view) {
        shots_a += 1;
        TextView add_shot_to_a = (TextView) findViewById(R.id.shots_a);
        add_shot_to_a.setText(String.valueOf(shots_a));
    }

    public void addshottob(View view) {
        shots_b += 1;
        TextView add_shot_to_b = (TextView) findViewById(R.id.shots_b);
        add_shot_to_b.setText(String.valueOf(shots_b));
    }

    public void reset(View view) {
        goles_a = -1;
        goles_b = -1;


        shots_a = -1;
        shots_b = -1;

        chance_a = 40;
        chance_b = 40;


        View thisView = new View(this);

        addgoaltoa(thisView);
        addgoaltob(thisView);

        addshottoa(thisView);
        addshottob(thisView);


        addpercentageA = true;
        plusChanceToA(thisView);
        plusChanceToB(thisView);


    }

    public void plusChanceToA(View view) {
        if (chance_a != 90) {
            chance_a += 10;
            if (addpercentageA == false) {
                View v = new View(this);
                minusChanceToB(v);
            } else {

                addpercentageA = false;
            }

        } else {
            Toast.makeText(this, "There s always chance !!", Toast.LENGTH_SHORT).show();
        }

        TextView plus_chance_to_a = (TextView) findViewById(R.id.teamAchances);
        plus_chance_to_a.setText(String.valueOf(chance_a) + "%");


    }

    public void minusChanceToA(View view) {
        if (chance_a >= 20) {
            chance_a -= 10;
            View v = new View(this);
            plusChanceToB(v);
        } else {
            Toast.makeText(this, "Chance can't be lower than 10% ", Toast.LENGTH_SHORT).show();

        }
        TextView plus_chance_to_a = (TextView) findViewById(R.id.teamAchances);
        plus_chance_to_a.setText(String.valueOf(chance_a) + "%");


    }

    public void plusChanceToB(View view) {
        if (chance_b != 90) {
            chance_b += 10;
            View v = new View(this);

        } else {
            Toast.makeText(this, "Chance can't be higher then 100 ", Toast.LENGTH_SHORT).show();
        }

        TextView plus_chance_to_a = (TextView) findViewById(R.id.teamBchances);
        plus_chance_to_a.setText(String.valueOf(chance_b) + "%");


    }

    public void minusChanceToB(View view) {
        if (chance_b >= 20) {
            chance_b -= 10;
            View v = new View(this);

        } else {
            Toast.makeText(this, "Chance can't be lower than 10% ", Toast.LENGTH_SHORT).show();
        }

        TextView plus_chance_to_a = (TextView) findViewById(R.id.teamBchances);
        plus_chance_to_a.setText(String.valueOf(chance_b) + "%");


    }

}
