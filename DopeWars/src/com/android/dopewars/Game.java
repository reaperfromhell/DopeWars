package com.android.dopewars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Game extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamelayout);
	}
	
	public void Cenas(View view) {
		Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
		return;

	}
	

}
