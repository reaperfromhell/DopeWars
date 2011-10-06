package com.android.dopewars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.games.dopewars.R;

public class Jet extends Activity implements View.OnClickListener{
	
	private Button btBronx, btGhetto, btCentralPark, btManhattan, btConeyIsland, btBrooklyn; 

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jetlayout);
				
		btBronx = (Button)findViewById(R.id.btBronx);
		btGhetto = (Button)findViewById(R.id.btGhetto);
		btCentralPark = (Button)findViewById(R.id.btCentralPark);
		btManhattan = (Button)findViewById(R.id.btManhattan);
		btConeyIsland = (Button)findViewById(R.id.btConeyIsland);
		btBrooklyn = (Button)findViewById(R.id.btBrooklyn);
		
		btBronx.setOnClickListener(this);
		btGhetto.setOnClickListener(this);
		btCentralPark.setOnClickListener(this);
		btManhattan.setOnClickListener(this);
		btConeyIsland.setOnClickListener(this);
		btBrooklyn.setOnClickListener(this);		

	}

	@Override
	public void onBackPressed() {  							//fix backpress on start
		Intent intent = getIntent();
		int zoneint = intent.getExtras().getInt("zoneint");
		if(zoneint == 0)									//check that zone has value. as 0 is nowhere, so... do nothing
			return;
		else
			super.onBackPressed();
	}


	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		Intent myIntent = new Intent();
		switch(v.getId()){
		case R.id.btBronx:
			bundle.putString("zone", "Bronx");
			bundle.putInt("zoneint", 1);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
			
		case R.id.btGhetto:
			bundle.putString("zone", "Ghetto");
			bundle.putInt("zoneint", 2);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
			
		case R.id.btCentralPark:
			bundle.putString("zone", "Central Park");
			bundle.putInt("zoneint", 3);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
			
		case R.id.btManhattan:
			bundle.putString("zone", "Manhattan");
			bundle.putInt("zoneint", 4);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
			
		case R.id.btConeyIsland:
			bundle.putString("zone", "Coney Island");
			bundle.putInt("zoneint", 5);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
			
		case R.id.btBrooklyn:
			bundle.putString("zone", "Brooklyn");
			bundle.putInt("zoneint", 6);
			myIntent.putExtras(bundle);
			setResult(RESULT_OK, myIntent);
			finish();
			break;
		
		}
		
	}

}
