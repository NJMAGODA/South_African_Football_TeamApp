package com.example.southafricanfootballapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private EditText cityInput;
private Button searchButton;
private TextView resultTextView;
//Sample data for city-football team mapping
    private String[] cityTeams = {"Johannesburg;Moroka Swallows F.C", "Giyani;Ndengeza F.C", "Durban;Amazulu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          cityInput =findViewById(R.id.cityInput);
          searchButton=findViewById(R.id.searchButton);
          resultTextView=findViewById(R.id.resultTextView);
          searchButton.setOnClickListener(view -> {String selectedCity = cityInput.getText().toString();
              String footballTeam = findFootballTeam(selectedCity);
              resultTextView.setText("Football Team:"+footballTeam);
          });

    }
    private String findFootballTeam(String city) {
        for (String cityTeam : cityTeams) {
            String[] parts = cityTeam.split(";");
            if (parts.length == 2 && parts[0].equalsIgnoreCase(city)) {
                return parts[1];
            }
        }
        return "Team not found";

    }
}