package com.android.dopewars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DopeWars extends Activity {
	/** Called when the activity is first created. */
	   
	/*private Button BtBronx;
	private Button BtGhetto;
	private Button BtCentalPark;
	private Button BtManhattan;
	private Button BtConeyIslad;
	private Button BtBrooklyn;*/
	
	
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.main);
	       
	      /* BtBronx = (Button) findViewById(R.id.button1);
	       BtGhetto = (Button) findViewById(R.id.button2);
	       BtCentPark = (Button) findViewById(R.id.button3);
	       BtManhattan = (Button) findViewById(R.id.button4);
	       BtConeyIslad = (Button) findViewById(R.id.button5);
	       BtBrooklyn = (Button) findViewById(R.id.button6);*/

	   }
	   
	   public void ClickBronx(View view) {
		   Intent myIntent = new Intent(view.getContext(), Game.class);
           startActivityForResult(myIntent, 0);
		   return;
	   }
	   public void ClickGhetto(View view) {
		   Toast.makeText(this, "Ghetto",Toast.LENGTH_LONG).show();
		   return;
	   }
	   public void ClickCentalPark(View view) {
		   Toast.makeText(this, "Central Park",Toast.LENGTH_LONG).show();
		   return;
	   }
	   public void ClickManhattan(View view) {
		   Toast.makeText(this, "Manhattan",Toast.LENGTH_LONG).show();
		   return;
	   }
	   public void ClickConeyIsland(View view) {
		   Toast.makeText(this, "Coney Island",Toast.LENGTH_LONG).show();
		   return;
	   }
	   public void ClickBrooklyn(View view) {
		   Toast.makeText(this, "Brooklyn",Toast.LENGTH_LONG).show();
		   return;
	   }
}