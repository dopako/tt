package com.example.test1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
	@Override
	protected void onStart() {
		Log.i(getText(R.string.tag).toString(), "Proceeded to step 2 successfully!");
		super.onStart();
	}

	@Override
	protected void onPause() {
		super.onPause();

		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();

		EditText inputOwnerName = findViewById(R.id.editOwnerName);
		EditText inputPrice = findViewById(R.id.editPrice);
		EditText inputDescr = findViewById(R.id.editDescr);
		EditText inputPhoneNum = findViewById(R.id.editPhoneNum);
		EditText inputFirmName = findViewById(R.id.editFirmName);

		String ownerName = inputOwnerName.getText().toString();
		String price = inputPrice.getText().toString();
		String descr = inputDescr.getText().toString();
		String phoneNum = inputPhoneNum.getText().toString();
		String firmName = inputFirmName.getText().toString();

		editor.putString("ownerName", ownerName);
		editor.putString("price", price);
		editor.putString("descr", descr);
		editor.putString("phoneNum", phoneNum);
		editor.putString("firmName", firmName);

		editor.commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		String ownerName = preferences.getString("ownerName", null);
		String price = preferences.getString("price", null);
		String descr = preferences.getString("descr", null);
		String phoneNum = preferences.getString("phoneNum", null);
		String firmName = preferences.getString("firmName", null);

		EditText inputOwnerName = findViewById(R.id.editOwnerName);
		EditText inputPrice = findViewById(R.id.editPrice);
		EditText inputDescr = findViewById(R.id.editDescr);
		EditText inputPhoneNum = findViewById(R.id.editPhoneNum);
		EditText inputFirmName = findViewById(R.id.editFirmName);

		inputOwnerName.setText(ownerName);
		inputPrice.setText(price);
		inputDescr.setText(descr);
		inputPhoneNum.setText(phoneNum);
		inputFirmName.setText(firmName);
		SharedPreferences.Editor editor = preferences.edit();
		editor.clear();
		editor.commit();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		EditText inputOwnerName = findViewById(R.id.editOwnerName);
		EditText inputPrice = findViewById(R.id.editPrice);
		EditText inputDescr = findViewById(R.id.editDescr);
		EditText inputPhoneNum = findViewById(R.id.editPhoneNum);
		EditText inputFirmName = findViewById(R.id.editFirmName);
		Button backButton = findViewById(R.id.backButton);
		Button nextButton = findViewById(R.id.nextButton);

		String carNum = getIntent().getStringExtra("carNum");


		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
					onBackPressed();
			}
		});

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				boolean flag1 = false,
						flag2 = false,
						flag3 = false,
						flag4 = false,
						flag5 = false;
				String ownerName = inputOwnerName.getText().toString();
				String price = inputPrice.getText().toString();
				String descr =  inputDescr.getText().toString();
				String phoneNum = inputPhoneNum.getText().toString();
				String firmName = inputFirmName.getText().toString();

				if ((ownerName.length() >= 2 && ownerName.length() <= 100) && !ownerName.isEmpty())
					flag1 = true;
				else
					inputOwnerName.setError(getText(R.string.ownerNameError));
				int integerPlaces = price.indexOf('.');
				int decimalPlaces = price.length() - integerPlaces - 1;
				Log.i(getText(R.string.tag).toString(), String.valueOf(integerPlaces));
				Log.i(getText(R.string.tag).toString(), String.valueOf(decimalPlaces));
				if ((decimalPlaces == 2 && integerPlaces > 0) && !price.isEmpty())
					flag2 = true;
				else
					inputPrice.setError(getText(R.string.priceError));
				if((descr.length() >= 10 && descr.length() <= 100) && !descr.isEmpty())
					flag3 = true;
				else
					inputDescr.setError(getText(R.string.descrError));
				if ((phoneNum.startsWith("08") && phoneNum.length() == 10) && !phoneNum.isEmpty())
					flag4 = true;
				else
					inputPhoneNum.setError(getText(R.string.phoneNumError));
				if ((firmName.length() >= 2 && firmName.length() <= 50) && !firmName.isEmpty())
					flag5 = true;
				else
					inputFirmName.setError(getText(R.string.firmNameError));

				if (flag1 && flag2 && flag3 && flag4 && flag5){
					Model model = new Model(carNum, ownerName, price, descr, phoneNum, firmName);
					Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
					intent1.putExtra("model", model);
					startActivity(intent1);
				}
			}
		});
	}
}
