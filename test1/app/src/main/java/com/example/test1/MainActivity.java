package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EditText carNum = findViewById(R.id.carNum);
		Button next = findViewById(R.id.nextButtonMain);
		next.setEnabled(false);
		carNum.setText("B");
		Selection.setSelection(carNum.getText(), carNum.getText().length());
		carNum.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				boolean flag1 = false,
						flag2 = false;
				if(!s.toString().startsWith("B")) {
					carNum.setText("B");
					Selection.setSelection(carNum.getText(), carNum.getText().length());
				}
				if (s.toString().length() == 7) {
					if (Character.isDigit(s.toString().charAt(1)) && Character.isDigit(s.toString().charAt(2)) &&
							Character.isDigit(s.toString().charAt(3)) && Character.isDigit(s.toString().charAt(4)))
						flag1 = true;
					else
						flag1 = false;
					if (((s.toString().charAt(5) >= 'A' && s.toString().charAt(5) <= 'Z') ||
							(s.toString().charAt(5) >= 'a' && s.toString().charAt(5) <= 'z')) &&
							(s.toString().charAt(6) >= 'A' && s.toString().charAt(6) <= 'Z') ||
							(s.toString().charAt(6) >= 'a' && s.toString().charAt(6) <= 'z'))
						flag2 = true;
					else
						flag2 = false;
				} else
					flag2 = false;
				if (flag1 && flag2 == true)
					next.setEnabled(true);
				else
					next.setEnabled(false);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
																		int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.i(getText(R.string.tag).toString(), "Proceeding to Step 2");
				Intent intent = new Intent(MainActivity.this, MainActivity2.class);
				intent.putExtra("carNum", carNum.getText().toString());
				startActivity(intent);
			}
		});
	}
}