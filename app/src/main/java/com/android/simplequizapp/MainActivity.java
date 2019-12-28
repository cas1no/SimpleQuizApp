package com.android.simplequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	TextView questionTextView;
	Button textButtonAnswer0;
	Button textButtonAnswer1;
	Button textButtonAnswer2;
	Button textButtonAnswer3;

	String[] question;

	String[][] buttonText;

	int[] answer;
	int[] questionAnswer = new int[10];

	int questionNumber = 0;
	int finalScore = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		questionTextView = findViewById(R.id.textViewQuestion);

		findViewById(R.id.buttonAnswer0).setOnClickListener(this);
		findViewById(R.id.buttonAnswer1).setOnClickListener(this);
		findViewById(R.id.buttonAnswer2).setOnClickListener(this);
		findViewById(R.id.buttonAnswer3).setOnClickListener(this);

		textButtonAnswer0 = findViewById(R.id.buttonAnswer0);
		textButtonAnswer1 = findViewById(R.id.buttonAnswer1);
		textButtonAnswer2 = findViewById(R.id.buttonAnswer2);
		textButtonAnswer3 = findViewById(R.id.buttonAnswer3);

		quiz();

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

			case R.id.buttonAnswer0:

				if (questionNumber == 9) {
					questionAnswer[questionNumber] = 0;
					quizResult();
				} else {
					questionAnswer[questionNumber] = 0;
					questionNumber++;
					quiz();
				}

				break;

			case R.id.buttonAnswer1:

				if (questionNumber == 9) {
					questionAnswer[questionNumber] = 1;
					quizResult();
				} else {
					questionAnswer[questionNumber] = 1;
					questionNumber++;
					quiz();
				}

				break;

			case R.id.buttonAnswer2:

				if (questionNumber == 9) {
					questionAnswer[questionNumber] = 2;
					quizResult();
				} else {
					questionAnswer[questionNumber] = 2;
					questionNumber++;
					quiz();
				}

				break;

			case R.id.buttonAnswer3:

				if (questionNumber == 9) {
					questionAnswer[questionNumber] = 3;
					quizResult();
				} else {
					questionAnswer[questionNumber] = 3;
					questionNumber++;
					quiz();
				}

				break;

		}
	}

	public void quiz() {

		question = new String[]{
			"How many states are in the United States of America?",
			"What is the other name of Eire?",
			"A sea separates Scandinavia from Britain. Which sea is this?",
			"Two neighboring countries of Africa received their names from a common river that they share. Which river is this?",
			"Do you know which one is Yugoslavia’s southernmost federal unit?",
			"A big river joins the river, Mississippi and now we call them by just one name. What is that name?",
			"The Straits of Magellan divide which country?",
			"Atlas Mountain is found in which continent?",
			"Do you know the capital of Canada?",
			"Where is the Sonoran desert located?"
		};

		answer = new int[]{3, 0, 3, 2, 1, 2, 3, 1, 0, 3};

		buttonText = new String[][]{
			{"54", "27", "47", "50"},
			{"Ireland", "England", "France", "Russia"},
			{"Labrador Sea", "Baltic Sea", "Irish Sea", "The North Sea"},
			{"Nigger", "Mali", "Niger", "Nigeria"},
			{"Serbia", "Macedonia", "Croatia", "Slovenia"},
			{"Dean", "Alabama", "Mississippi-Missouri", "Niva"},
			{"Peru", "Brazil", "Colombia", "Chile"},
			{"Asia", "Africa", "North America", "South America"},
			{"Ottawa", "Minsk", "Canberra", "London"},
			{"Europe", "Asia", "Africa", "North America"},
		};

		questionTextView.setText(question[questionNumber]);
		textButtonAnswer0.setText(buttonText[questionNumber][0]);
		textButtonAnswer1.setText(buttonText[questionNumber][1]);
		textButtonAnswer2.setText(buttonText[questionNumber][2]);
		textButtonAnswer3.setText(buttonText[questionNumber][3]);

	}

	public void quizResult() {

		findViewById(R.id.buttonAnswer0).setVisibility(View.INVISIBLE);
		findViewById(R.id.buttonAnswer1).setVisibility(View.INVISIBLE);
		findViewById(R.id.buttonAnswer2).setVisibility(View.INVISIBLE);
		findViewById(R.id.buttonAnswer3).setVisibility(View.INVISIBLE);

		for (int i = 0; i <= 9; i++) {

			if (answer[i] == questionAnswer[i])
				finalScore++;

		}

		questionTextView.setText("Your score is " + finalScore + "/10");

	}
}