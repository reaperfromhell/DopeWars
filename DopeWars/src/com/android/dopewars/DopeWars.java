package com.android.dopewars;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.android.games.dopewars.R;

public class DopeWars extends Activity implements View.OnTouchListener {
	private TextView tvAcidDrugs, tvCocaineDrugs, tvEcstasyDrugs, tvPCPDrugs,
					 tvHeroinDrugs, tvWeedDrugs, tvShroomsDrugs, tvSpeedDrugs;
	private TextView tvAcidPrice, tvCocainePrice, tvEcstasyPrice, tvPCPPrice,
					 tvHeroinPrice, tvWeedPrice, tvShroomsPrice, tvSpeedPrice;
	private TextView tvZone, tvCash, tvDebt, tvSavings, tvCoat, tvDays;
	private Button btLoanShark, btBank;
	private User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		user = new User();
		
		Jet(this.findViewById(R.id.btJet));
		
		//String zone = getIntent().getExtras().getString("zone");
		//int zoneint = getIntent().getExtras().getInt("zoneint");
		
		tvAcidDrugs = (TextView)findViewById(R.id.tvAcidDrugs);
		tvCocaineDrugs = (TextView)findViewById(R.id.tvCocaineDrugs);
		tvEcstasyDrugs = (TextView)findViewById(R.id.tvEcstasyDrugs);
		tvPCPDrugs = (TextView)findViewById(R.id.tvPCPDrugs);
		tvHeroinDrugs = (TextView)findViewById(R.id.tvHeroinDrugs);
		tvWeedDrugs = (TextView)findViewById(R.id.tvWeedDrugs);
		tvShroomsDrugs = (TextView)findViewById(R.id.tvShroomsDrugs);
		tvSpeedDrugs = (TextView)findViewById(R.id.tvSpeedDrugs);
		
		tvAcidPrice = (TextView)findViewById(R.id.tvAcidPrice);
		tvCocainePrice = (TextView)findViewById(R.id.tvCocainePrice);
		tvEcstasyPrice = (TextView)findViewById(R.id.tvEcstasyPrice);
		tvPCPPrice = (TextView)findViewById(R.id.tvPCPPrice);
		tvHeroinPrice = (TextView)findViewById(R.id.tvHeroinPrice);
		tvWeedPrice = (TextView)findViewById(R.id.tvWeedPrice);
		tvShroomsPrice = (TextView)findViewById(R.id.tvShroomsPrice);
		tvSpeedPrice = (TextView)findViewById(R.id.tvSpeedPrice);
		
		tvZone = (TextView)findViewById(R.id.tvZone);
		tvCash = (TextView)findViewById(R.id.tvCash);
		tvDebt = (TextView)findViewById(R.id.tvDebt);
		tvSavings = (TextView)findViewById(R.id.tvSavings);
		tvCoat = (TextView)findViewById(R.id.tvCoat);
		tvDays = (TextView)findViewById(R.id.tvDays);
		
		btLoanShark = (Button)findViewById(R.id.btLoanShark);
		btBank = (Button)findViewById(R.id.btBank);
		
		//calculatePrices(user);
		
		tvAcidDrugs.setOnTouchListener(this);
		tvCocaineDrugs.setOnTouchListener(this);
		tvEcstasyDrugs.setOnTouchListener(this);
		tvPCPDrugs.setOnTouchListener(this);
		tvHeroinDrugs.setOnTouchListener(this);
		tvWeedDrugs.setOnTouchListener(this);
		tvShroomsDrugs.setOnTouchListener(this);
		tvSpeedDrugs.setOnTouchListener(this);
		
		tvAcidPrice.setOnTouchListener(this);
		tvCocainePrice.setOnTouchListener(this);
		tvEcstasyPrice.setOnTouchListener(this);
		tvPCPPrice.setOnTouchListener(this);
		tvHeroinPrice.setOnTouchListener(this);
		tvWeedPrice.setOnTouchListener(this);
		tvShroomsPrice.setOnTouchListener(this);
		tvSpeedPrice.setOnTouchListener(this);
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
			String zone = data.getExtras().getString("zone");
			int zoneint = data.getExtras().getInt("zoneint");
			tvZone.setText(zone);
			user.setLocation(zoneint);
			if(zone.compareTo("Bronx") == 0){
				btLoanShark.setEnabled(true);
				btBank.setEnabled(true);

			}else{
				btLoanShark.setEnabled(false);
				btBank.setEnabled(false);
			}
			user.setTimeLeft(user.getDays() - 1 );
			calculatePrices();
			setText();
        }
        
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// check which textview it is and do what you need to do
		switch(v.getId()){
		case R.id.tvAcidDrugs:
			//set up dialog
            final Dialog dialog = new Dialog(DopeWars.this);
            dialog.setContentView(R.layout.buyselldialog);
            dialog.setTitle("This is my custom dialog box");
            dialog.setCancelable(true);
            //there are a lot of settings, for dialog, check them all out!

            //set up text
            TextView text = (TextView) dialog.findViewById(R.id.TextView01);
            text.setText("Cenas");

            //set up image view
           // ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
            //img.setImageResource(R.drawable.nista_logo);

            //set up button
            Button button = (Button) dialog.findViewById(R.id.Button01);
            button.setOnClickListener(new OnClickListener() {
            @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            //now that the dialog is set up, it's time to show it    
            dialog.show();
			break;
			
		case R.id.tvCocaineDrugs:
			Toast.makeText(this, "Cocaine", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvEcstasyDrugs:
			Toast.makeText(this, "Ecstasy", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvPCPDrugs:
			Toast.makeText(this, "PCP", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvHeroinDrugs:
			Toast.makeText(this, "Heroin", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvWeedDrugs:
			Toast.makeText(this, "Weed", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvShroomsDrugs:
			Toast.makeText(this, "Shrooms", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvSpeedDrugs:
			Toast.makeText(this, "Speed", Toast.LENGTH_SHORT).show();
			break;
		}
		return false;
	}

	public void Jet(View view) {
		Intent myIntent = new Intent(view.getContext(), Jet.class);
		startActivityForResult(myIntent, 0);
	}
	
	public void setText(){
		tvAcidDrugs.setText("" + user.getDrugs()[0]);
		tvCocaineDrugs.setText("" + user.getDrugs()[1]);
		tvEcstasyDrugs.setText("" + user.getDrugs()[2]);
		tvPCPDrugs.setText("" + user.getDrugs()[3]);
		tvHeroinDrugs.setText("" + user.getDrugs()[4]);
		tvWeedDrugs.setText("" + user.getDrugs()[5]);
		tvShroomsDrugs.setText("" + user.getDrugs()[6]);
		tvSpeedDrugs.setText("" + user.getDrugs()[7]);
		
		tvAcidPrice.setText("$" + user.getDrugPrices()[0]);
		tvCocainePrice.setText("$" + user.getDrugPrices()[1]);
		tvEcstasyPrice.setText("$" + user.getDrugPrices()[2]);
		tvPCPPrice.setText("$" + user.getDrugPrices()[3]);
		tvHeroinPrice.setText("$" + user.getDrugPrices()[4]);
		tvWeedPrice.setText("$" + user.getDrugPrices()[5]);
		tvShroomsPrice.setText("$" + user.getDrugPrices()[6]);
		tvSpeedPrice.setText("$" + user.getDrugPrices()[7]);
		
		tvCash.setText("$" + user.getCash());
		tvDebt.setText("$" +  user.getDebt());
		tvSavings.setText("$" + user.getSavings());
		tvCoat.setText(user.getDrugsSum() + "/" + user.getCoat());
		tvDays.setText("" + user.getDays());
	}
	
	private void calculatePrices() {
		int i, j;
		long drugPrices[] = new long[8];
		Random rand = new Random();
		
		drugPrices[0] = 1000 + rand.nextInt(9999999) % 3500;
		drugPrices[1] = 15000 + rand.nextInt(9999999) % 15000;
		drugPrices[2] = 10 + rand.nextInt(9999999) % 50;
		drugPrices[3] = 1000 + rand.nextInt(9999999) % 2500;
		drugPrices[4] = 5000 + rand.nextInt(9999999) % 9000;
		drugPrices[5] = 300 + rand.nextInt(9999999) % 600;
		drugPrices[6] = 600 + rand.nextInt(9999999) % 750;
		drugPrices[7] = 70 + rand.nextInt(9999999) % 180;
		
		for (i = 0; i < 3; i++)
		{
			j = rand.nextInt(8);
			drugPrices [j] = 0;
		}
		
		user.setDrugPrices(drugPrices);
	}
	
	
}