package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		TextView carNum = findViewById(R.id.viewCarNum);
		TextView ownerName = findViewById(R.id.viewOwnerName);
		TextView price = findViewById(R.id.viewPrice);
		TextView descr = findViewById(R.id.viewDescr);
		TextView phoneNum = findViewById(R.id.viewPhoneNum);
		TextView firmName = findViewById(R.id.viewFirmName);
		Button back = findViewById(R.id.backButton2);

		Model model = getIntent().getParcelableExtra("model");

		carNum.setText(model.getCarNum());
		ownerName.setText(model.getOwnerName());
		price.setText(model.getPrice());
		descr.setText(model.getDescr());
		phoneNum.setText(model.getPhoneNum());
		firmName.setText(model.getFirmName());

		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});
	}
}
