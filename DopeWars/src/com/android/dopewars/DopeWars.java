package com.android.dopewars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DopeWars extends Activity implements View.OnTouchListener {
	private TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tv1 = (TextView) findViewById(R.id.tv1);

		tv1.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// check which textview it is and do what you need to do
		if (v.getId() == R.id.tv1) {
			Toast.makeText(this, "Clicked TextView", Toast.LENGTH_LONG).show();
		}
		// return true if you don't want it handled by any other touch/click
		// events after this
		return true;
	}

	public void Cenas(View view) {
		Intent myIntent = new Intent(view.getContext(), Jet.class);
		startActivityForResult(myIntent, 0);
		return;
	}
}