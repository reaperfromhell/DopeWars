package com.android.dopewars;

import java.util.Random;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.games.dopewars.R;

@SuppressLint("CutPasteId")
public class DopeWars extends Activity implements View.OnTouchListener {
	private TextView tvAcidDrugs, tvCocaineDrugs, tvEcstasyDrugs, tvPCPDrugs,
					 tvHeroinDrugs, tvWeedDrugs, tvShroomsDrugs, tvSpeedDrugs;
	private TextView tvAcidPrice, tvCocainePrice, tvEcstasyPrice, tvPCPPrice,
					 tvHeroinPrice, tvWeedPrice, tvShroomsPrice, tvSpeedPrice;
	private TextView tvZone, tvCash, tvDebt, tvSavings, tvCoat, tvDays, tvGun;
	private Button btLoanShark, btBank;
	private User user;
	
	private class RandMessages{
		public int freq;
		public String msg;
		public int drug;
		public int plus;
		public int minus;
		public int add;
		public RandMessages(int freq, String msg, int drug, int plus, int minus, int add) {
			super();
			this.freq = freq;
			this.msg = msg;
			this.drug = drug;
			this.plus = plus;
			this.minus = minus;
			this.add = add;
		}
	}
	
	private RandMessages gameMessages[] = new RandMessages[17];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		user = new User();
		
		Jet(this.findViewById(R.id.btJet));
		
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
		tvGun = (TextView)findViewById(R.id.tvGun);
		
		btLoanShark = (Button)findViewById(R.id.btLoanShark);
		btBank = (Button)findViewById(R.id.btBank);
		
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
		
		gameMessages[0] = new RandMessages(13, "The cops just did a big Weed bust!\nPrices are sky-high!", 5, 4, 0, 0);
		gameMessages[1] = new RandMessages(20, "The cops just did a big PCP bust!\nPrices are sky-high!", 3, 4, 0, 0);
		gameMessages[2] = new RandMessages(25, "The cops just did a big Heroin bust!\nPrices are sky-high!", 4, 4, 0, 0);
		gameMessages[3] = new RandMessages(13, "The cops just did a big Ecstasy bust!\nPrices are sky-high!", 2, 4, 0, 0);
		gameMessages[4] = new RandMessages(35, "The cops just did a big Cocaine bust!\nPrices are sky-high!", 1, 4, 0, 0);
		gameMessages[5] = new RandMessages(15, "The cops just did a big Speed bust!\nPrices are sky-high!", 7, 4, 0, 0);
		gameMessages[6] = new RandMessages(25, "Addicts are buying Heroin at outrageous prices!", 4, 8, 0, 0);
		gameMessages[7] = new RandMessages(20, "Addicts are buying Speed at outrageous prices!", 7, 8, 0, 0);
		gameMessages[8] = new RandMessages(20, "Addicts are buying PCP at outrageous prices!", 3, 8, 0, 0);
		gameMessages[9] = new RandMessages(17, "Addicts are buying Shrooms at outrageous prices!", 6, 8, 0, 0);
		gameMessages[10] = new RandMessages(35, "Addicts are buying Cocaine at outrageous prices!", 1, 8, 0, 0);
		gameMessages[11] = new RandMessages(17, "The market has been flooded with cheap home-made Acid!", 0, 0, 8, 0);
		gameMessages[12] = new RandMessages(10, "A Columbian freighter dusted the Coast Guard! Weed prices have bottomed out!", 5, 0, 4, 0);
		gameMessages[13] = new RandMessages(11, "A gang raided a local pharmacy and is selling cheap Ecstasy!", 2, 0, 8, 0);
		gameMessages[14] = new RandMessages(55, "You found some Cocaine on a dead dude in the subway!", 1, 0, 0, 3);
		gameMessages[15] = new RandMessages(45, "You found some Acid on a dead dude in the subway!", 0, 0, 0, 6);
		gameMessages[16] = new RandMessages(35, "You found some PCP on a dead dude in the subway!", 3, 0, 0, 4);
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			String zone = data.getExtras().getString("zone");
			int zoneint = data.getExtras().getInt("zoneint");
			if (zoneint == user.getLocation()) {
				//do nothing cause still in same zone
				//else recalculate everything
			} else {
				tvZone.setText(zone); // Set title to current Zone.
				user.setLocation(zoneint);
				if (zone.compareTo("Bronx") == 0) { // Disable LoanShark and
													// Bank Buttons if not in
													// Bronx
					btLoanShark.setEnabled(true);
					btBank.setEnabled(true);

				} else {
					btLoanShark.setEnabled(false);
					btBank.setEnabled(false);
				}
				recalculateStuff();
			}
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}

	private void doRandom() {
		int i;
		int addcount;
		Random rand = new Random();
		
		for (i = 0; i < 17; i++){
			if (( Math.abs(rand.nextInt()) % gameMessages[i].freq) == 0){
				if ( user.getDrugPrices()[gameMessages [i].drug] == 0)
					continue;
				new AlertDialog.Builder( this )
		        .setTitle( "News Flash" )
		        .setMessage(gameMessages[i].msg)
		        .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {}
		        }).show();
				if (gameMessages[i].plus > 0)
					user.getDrugPrices()[gameMessages [i].drug] *= gameMessages[i].plus;
				if (gameMessages[i].minus > 0)
					user.getDrugPrices()[gameMessages [i].drug] /= gameMessages[i].minus;
				if (gameMessages[i].add + user.getDrugsSum() > user.getCoat())
					addcount = user.getCoat() - user.getDrugsSum();
				else
					addcount = gameMessages [i].add;
				user.setDrugs(gameMessages[i].drug, user.getDrugs()[gameMessages[i].drug] + addcount);
				break;
			}
		}
		
		if ( (Math.abs(rand.nextInt()) % 7) == 0 && (user.getDrugsSum() != 0)){
			FuzzEncounter();
			return;
		}
		
		if( Math.abs(rand.nextInt() % 10) == 1){
			RandomCoat();
			return;
		}
		
		if( Math.abs(rand.nextInt() % 10) == 1){
			RandomGun();
		}
		return;
	}
	
	@SuppressWarnings("unused")
	private void FuzzEncounter() {
		// TODO Auto-generated method stub
		int i;
		int result = 3;
		int copCount = user.getCopCount();
		final int resolved = 0;
		String msg = "";

		if (copCount < 1)
			return;

		msg += "Officer Hardass ";
		//while (resolved == 0){
			
			switch (copCount){
			
			case 1:
				msg += "is chasing you!";
				break;
			case 2:
				msg += "and one of his deputies are chasing you!";
				break;
			case 3:
				msg += "and two of his deputies are chasing you!";
				break;
			}
			msg += "\n\nWhat do you do?";
			new AlertDialog.Builder( this )
	        .setTitle( "Police" )
	        .setMessage(msg)
	        .setPositiveButton( "Run", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	//resolved = 1;
	            }
	        })
	        .setNegativeButton( "Fight", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	Toast.makeText(DopeWars.this, "You do not have a gun.", Toast.LENGTH_SHORT).show();
	            	//resolved = 2;
	            }
	        })
	        .show();
		//}
			/* result = FrmCustomAlert (CopForm, s, isare, "");
			if (result == 0)
			{
				if (!(SysRandom (0) % 3))
				{
					if (!(SysRandom (0) % 5))
					{
						resolved = 2;
						FrmAlert (kidCopsCaught);
						continue;
					}
					resolved = 0;
					CopForm = kidCopsRemain;
					continue;
				}
				else
				{
					resolved = 1;
					FrmAlert (kidCopsRan);
					continue;
				}
			}				
			else if (result == 1)
			{
				if (myGuns == 0)
				{
					FrmAlert (kidNoGun);
					continue;
				}
				if (!(SysRandom (0) % 4))
				{
					FrmAlert (kidCopsHit);
					copCount--;
					if (copCount < 1)
					{
						resolved = 1;
						continue;
					}
					CopForm = kidCopsRemain;				
				}
				else
				{
					FrmAlert (kidCopsMiss);
					CopForm = kidCopsRemain;
				}
				if (!(SysRandom (0) % 5))
				{
					if (!(SysRandom (0) % 5))
					{
						FrmAlert (kidCopsKill);
						timeLeft = 0;
						copCount = -1;
						resolved = 1;
						continue;
					}
					FrmAlert (kidCopsWounded);
					resolved = 2;
					continue;
				}
				else
				{
					FrmAlert (kidCopsMissYou);
				}
			}				
		}
		if (resolved == 2)
		{
			FrmAlert (kidCopsSeize);
			for (i = 0; i < 8; i++)
				myDrugs [i] = 0;
			myCash /= 2;
			ProcessForm (kidBuySell);
		}*/
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.newGame:
				new AlertDialog.Builder( this )
		        .setTitle( "New Game" )
		        .setMessage("Are you sure you want to start a new game?\nAll progress will be lost.")
		        .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                Intent intent = getIntent();
		                overridePendingTransition(0, 0);
		                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		                finish();
		                overridePendingTransition(0, 0);
		                startActivity(intent);
		            }

		        })
		        .setNegativeButton( "No", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		            }
		        })
		        .show();
	            break;
	    }
	    return true;
	}
	
	private void RandomCoat(){
		new AlertDialog.Builder( this )
        .setTitle( "Buy a Bigger Coat" )
        .setMessage("Would you like to buy a bigger coat for $200?")
        .setPositiveButton( "Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        })
        .setNegativeButton( "Buy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	if((user.getCash() - 200) < 0)
            		Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
            	else{
            	user.setCash(user.getCash() - 200);
            	user.setCoat(user.getCoat() + 40);
            	setText();
            	}
            }
        })
        .show();
	}

	private void RandomGun() {
		if( user.getGuns() == 0 ){
		new AlertDialog.Builder( this )
        .setTitle( "Buy a Gun" )
        .setMessage("Would you like to buy a gun for $400?")
        .setPositiveButton( "Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        })
        .setNegativeButton( "Buy", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	if((user.getCash() - 400) < 0)
            		Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
            	else{
            	user.setCash(user.getCash() - 400);
            	user.setGuns(1);
            	setText();
            	}
            }
        })
        .show();
		}
		if( user.getGuns() == 1 ){
			new AlertDialog.Builder( this )
	        .setTitle( "Buy a Shotgun" )
	        .setMessage("Would you like to buy a shotgun for $800?")
	        .setPositiveButton( "Cancel", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            }
	        })
	        .setNegativeButton( "Buy", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	if((user.getCash() - 800) < 0)
	            		Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
	            	else{
	            	user.setCash(user.getCash() - 800);
	            	user.setGuns(2);
	            	setText();
	            	}
	            }
	        })
	        .show();
		}
		return;
	}
	
	private void Randomness(){					//cops, busts, cheap drugs, free drugs
		
		return;
	}

	private void recalculateStuff() {
		if(user.getDays() > 0){
			user.setTimeLeft(user.getDays() - 1); // Decrease days by 1
			calculatePrices();
			recalculateSavings();
			recalculateDebt();
			doRandom();
			setText(); // fill TextViews with prices and drug amounts.
		}else{
			long sum = user.getCash() + user.getSavings() - user.getDebt();
			String message;
			if(sum > 0)
				message = "The game has ended.\nYou managed to make $" + sum + ".\n\nStart a new game?"; 
			else
				message = "The game has ended.\nYou managed to make $" + sum + ".\nAs a reward the loan shark got you a shiny new pair of broken legs.\n\nStart a new game?";
			new AlertDialog.Builder( this )
	        .setTitle( "Game Over" )
	        .setMessage(message)
	        .setPositiveButton( "No", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	finish();
	            }

	        })
	        .setNegativeButton( "Yes", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	Intent intent = getIntent();
	                overridePendingTransition(0, 0);
	                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	                finish();

	                overridePendingTransition(0, 0);
	                startActivity(intent);
	            }
	        })
	        .show();
		}
	}

	private void recalculateDebt() {
		long debt = user.getDebt();
		if( user.getDays() < 30 )
			user.setDebt(debt + (debt>>3));			// increase the debt by 1/8 
	}

	private void recalculateSavings() {
		long savings = user.getSavings();
		if( user.getDays() < 30 )
			user.setSavings(savings + (savings>>4)); // increase the savings by 1/10
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// check which textview it is and do what you need to do
		switch(v.getId()){
		case R.id.tvAcidDrugs:
			if(user.getDrugs()[0] > 0)			//check if user has this type of drugs on him.
				showSellDialog(0);				//if so open sell dialog
			else
				Toast.makeText(this, "You have no Acid to sell.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvCocaineDrugs:
			if(user.getDrugs()[1] > 0)
				showSellDialog(1);
			else
				Toast.makeText(this, "You have no Cocaine to sell.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvEcstasyDrugs:
			if(user.getDrugs()[2] > 0)
				showSellDialog(2);
			else
				Toast.makeText(this, "You have no Ecstasy to sell.", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvPCPDrugs:
			if(user.getDrugs()[3] > 0)
				showSellDialog(3);
			else
				Toast.makeText(this, "You have no PCP to sell.", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvHeroinDrugs:
			if(user.getDrugs()[4] > 0)
				showSellDialog(4);
			else
				Toast.makeText(this, "You have no Heroin to sell.", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvWeedDrugs:
			if(user.getDrugs()[5] > 0)
				showSellDialog(5);
			else
				Toast.makeText(this, "You have no Weed to sell.", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvShroomsDrugs:
			if(user.getDrugs()[6] > 0)
				showSellDialog(6);
			else
				Toast.makeText(this, "You have no Shrooms to sell.", Toast.LENGTH_SHORT).show();
			break;

		case R.id.tvSpeedDrugs:
			if(user.getDrugs()[7] > 0)
				showSellDialog(7);
			else
				Toast.makeText(this, "You have no Speed to sell.", Toast.LENGTH_SHORT).show();
			break;
			
			
			
		case R.id.tvAcidPrice:
			if(user.getDrugPrices()[0] > 0)
				showBuyDialog(0);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
		
		case R.id.tvCocainePrice:
			if(user.getDrugPrices()[1] > 0)
				showBuyDialog(1);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvEcstasyPrice:
			if(user.getDrugPrices()[2] > 0)
				showBuyDialog(2);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvPCPPrice:
			if(user.getDrugPrices()[3] > 0)
				showBuyDialog(3);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvHeroinPrice:
			if(user.getDrugPrices()[4] > 0)
				showBuyDialog(4);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvWeedPrice:
			if(user.getDrugPrices()[5] > 0)
				showBuyDialog(5);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvShroomsPrice:
			if(user.getDrugPrices()[6] > 0)
				showBuyDialog(6);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.tvSpeedPrice:
			if(user.getDrugPrices()[7] > 0)
				showBuyDialog(7);
			else
				Toast.makeText(this, "No one is selling this drug.", Toast.LENGTH_SHORT).show();
			break;
		}
		return false;
	}

	private void showSellDialog(final int drug) {
		//set up dialog
        final Dialog dialog = new Dialog(DopeWars.this);
        String message;
        
        dialog.setContentView(R.layout.buyselldialog);
        dialog.setTitle("Sell " + getDrugName(drug));
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "You can sell up to " + user.getDrugs()[drug] + " at $" + user.getDrugPrices()[drug] + " each.\n";
        text.setText(message);
        
        //set numberpicker
        final NumberPicker numbpick = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
        numbpick.setCurrent(user.getDrugs()[drug]);
        numbpick.setmEnd(user.getDrugs()[drug]);

        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancel);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //set Cancel up button
        Button button = (Button) dialog.findViewById(R.id.btCancel);
        button.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
                
            }
        });
        
        //set up sell button
        Button btSell = (Button) dialog.findViewById(R.id.btTransaction);
        btSell.setText("   Sell   ");
        btSell.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user.setDrugs(drug,user.getDrugs()[drug] - numbpick.getCurrent());
				user.setCash(user.getCash() + (numbpick.getCurrent() * user.getDrugPrices()[drug]));
				dialog.dismiss();
				setText();
			}
		});
        
        //now that the dialog is set up, it's time to show it    
        dialog.show();
		
	}
	
	private void showBuyDialog(final int drug) {
		//set up dialog
        final Dialog dialog = new Dialog(DopeWars.this);
        int count, available;
        String message;
        
        dialog.setContentView(R.layout.buyselldialog);
        dialog.setTitle("Buy " + getDrugName(drug));
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "At $" + user.getDrugPrices()[drug] + " each, you can afford ";
        count = (int)(user.getCash() / user.getDrugPrices()[drug]);
        if( count < 1000 )
        	message += count + ".";
        else
        	message += "a lot.";
        available = user.getCoat() - user.getDrugsSum();
        if(count > available)
        	message += "\nBut you only have room for " + available + " more.";
        text.setText(message);
        
        //set numberpicker
        final NumberPicker numbpick = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
        numbpick.setCurrent(Math.min(count, available));
        numbpick.setmEnd(Math.min(count, available));

        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancel);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        //set up buy button
        Button btBuy = (Button) dialog.findViewById(R.id.btTransaction);
        btBuy.setText("   Buy   ");
        btBuy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				user.setDrugs(drug,user.getDrugs()[drug] + numbpick.getCurrent());
				user.setCash(user.getCash() - (numbpick.getCurrent() * user.getDrugPrices()[drug]));
				dialog.dismiss();
				setText();
			}
		});
		
        dialog.show();  //now that the dialog is set up, it's time to show it
	}

	public void Jet(View view) {
		Bundle bundle = new Bundle();
		bundle.putInt("zoneint", user.getLocation());
		Intent myIntent = new Intent(view.getContext(), Jet.class);
		myIntent.putExtras(bundle);
		startActivityForResult(myIntent, 0);
	}
	
	public void Loanshark(View view){
		new AlertDialog.Builder( this )
        .setTitle( "Loan Shark" )
        .setPositiveButton( "Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	
            }
        })
        .setNegativeButton( "Repay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                LoansharkRepay();
            }
        })
        .setNeutralButton( "Borrow", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                LoansharkBorrow();
            }
        })
        .show();		
	}
	
	public void Bank(View view){
		new AlertDialog.Builder( this )
        .setTitle( "Bank" )
        .setPositiveButton( "Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        })
        .setNegativeButton( "Deposit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                BankDeposit();
            }
        })
        .setNeutralButton( "Withdraw", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                BankWithdraw();
            }
        })
        .show();
	}
	
	public void BankWithdraw(){
		final Dialog dialog = new Dialog(DopeWars.this);
        String message;
        
        dialog.setContentView(R.layout.moneydialog);
        dialog.setTitle("Withdaw");
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "Select the amount of cash you wish to withdraw from your savings account.";
        text.setText(message);
        
        //set up edittext
        final EditText edittext = (EditText) dialog.findViewById(R.id.etAmountMoney);
        
        //set up seekbar
        SeekBar seekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
        seekbar.setMax((int)user.getSavings());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        	 @Override
        	 public void onStopTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onStartTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        		 edittext.setText("" + arg1);
        		 edittext.setSelection(edittext.getText().length());
        	 }
        	});
        
        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancelTrans);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        //set up deposit button
        Button btWithdraw = (Button) dialog.findViewById(R.id.btMoneyTransaction);
        btWithdraw.setText("Withdraw");
        btWithdraw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				long amount = Long.parseLong(edittext.getText().toString());
				if((user.getSavings() - amount) < 0)
					Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
				else{
				user.setCash(user.getCash() + amount);
				user.setSavings(user.getSavings() - amount);
				dialog.dismiss();
				setText();
				}
			}
		});
        
        dialog.show();  //now that the dialog is set up, it's time to show it

		
	}
	
	public void BankDeposit(){
		final Dialog dialog = new Dialog(DopeWars.this);
        String message;
        
        dialog.setContentView(R.layout.moneydialog);
        dialog.setTitle("Deposit");
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "Select the amount of cash you wish to deposit into your savings account.";
        text.setText(message);
        
        //set up edittext
        final EditText edittext = (EditText) dialog.findViewById(R.id.etAmountMoney);
        
        //set up seekbar
        SeekBar seekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
        seekbar.setMax((int)user.getCash());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        	 @Override
        	 public void onStopTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onStartTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        		 edittext.setText("" + arg1);
        		 edittext.setSelection(edittext.getText().length());
        	 }
        	});
        
        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancelTrans);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        //set up deposit button
        Button btDeposit = (Button) dialog.findViewById(R.id.btMoneyTransaction);
        btDeposit.setText("Deposit");
        btDeposit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				long amount = Long.parseLong(edittext.getText().toString());
				if((user.getCash() - amount) < 0)
					Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
				else{
				user.setCash(user.getCash() - amount);
				user.setSavings(user.getSavings() + amount);
				dialog.dismiss();
				setText();
				}
			}
		});
        
        dialog.show();  //now that the dialog is set up, it's time to show it

		
	}
	
	public void LoansharkBorrow(){
		final Dialog dialog = new Dialog(DopeWars.this);
        String message;
        
        dialog.setContentView(R.layout.moneydialog);
        dialog.setTitle("Borrow");
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "Select the amount of cash you wish to borrow from the loan shark.";
        text.setText(message);
        
        //set up edittext
        final EditText edittext = (EditText) dialog.findViewById(R.id.etAmountMoney);
        
        
        //set up seekbar
        SeekBar seekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
        seekbar.setMax(10000);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        	 @Override
        	 public void onStopTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onStartTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        		 edittext.setText("" + arg1);
        		 edittext.setSelection(edittext.getText().length());
        	 }
        	});
        
        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancelTrans);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        //set up borrow button
        Button btBorrow = (Button) dialog.findViewById(R.id.btMoneyTransaction);
        btBorrow.setText("Borrow");
        btBorrow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				long amount = Long.parseLong(edittext.getText().toString());
				user.setCash(user.getCash() + amount);
				user.setDebt(user.getDebt() + amount);
				dialog.dismiss();
				setText();
			}
		});
        
        dialog.show();  //now that the dialog is set up, it's time to show it

		
	}
	
	public void LoansharkRepay(){
		final Dialog dialog = new Dialog(DopeWars.this);
        String message;
        
        dialog.setContentView(R.layout.moneydialog);
        dialog.setTitle("Repay");
        dialog.setCancelable(true);
        
        //set up text
        TextView text = (TextView) dialog.findViewById(R.id.TextView01);
        message = "Select the amount of your debt that you wish to repay to the loan shark.";
        text.setText(message);
        
        //set up edittext
        final EditText edittext = (EditText) dialog.findViewById(R.id.etAmountMoney);
        
        //set up seekbar
        SeekBar seekbar = (SeekBar) dialog.findViewById(R.id.seekBar1);
        seekbar.setMax((int)Math.min(user.getDebt(), user.getCash()));
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        	 @Override
        	 public void onStopTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onStartTrackingTouch(SeekBar arg0) {

        	 }

        	 @Override
        	 public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
        		 edittext.setText("" + arg1);
        		 edittext.setSelection(edittext.getText().length());
        	 }
        	});
        
        //set up cancel button
        Button btCancelDialog = (Button) dialog.findViewById(R.id.btCancelTrans);
        btCancelDialog.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        
        //set up borrow button
        Button btRepay = (Button) dialog.findViewById(R.id.btMoneyTransaction);
        btRepay.setText("Repay");
        btRepay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				long amount = Long.parseLong(edittext.getText().toString());
				if((user.getCash() - amount) < 0)
					Toast.makeText(DopeWars.this, "Not enough funds.", Toast.LENGTH_SHORT).show();
				else{
					if(user.getDebt() - amount < 0)
						Toast.makeText(DopeWars.this, "Your debt is really not that big.", Toast.LENGTH_SHORT).show();
					else{
					user.setCash(user.getCash() - amount);
					user.setDebt(user.getDebt() - amount);
					dialog.dismiss();
					setText();
					}
				}
			}
		});
        
        dialog.show();  //now that the dialog is set up, it's time to show it

		
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
		
		
		if(user.getDrugPrices()[0] > 0)
			tvAcidPrice.setText("$" + user.getDrugPrices()[0]);
		else
			tvAcidPrice.setText("-");
		
		if(user.getDrugPrices()[1] > 0)
			tvCocainePrice.setText("$" + user.getDrugPrices()[1]);
		else 
			tvCocainePrice.setText("-");
		
		if(user.getDrugPrices()[2] > 0)
			tvEcstasyPrice.setText("$" + user.getDrugPrices()[2]);
		else
			tvEcstasyPrice.setText("-");
		
		if(user.getDrugPrices()[3] > 0)
			tvPCPPrice.setText("$" + user.getDrugPrices()[3]);
		else
			tvPCPPrice.setText("-");
		
		if(user.getDrugPrices()[4] > 0)
			tvHeroinPrice.setText("$" + user.getDrugPrices()[4]);
		else
			tvHeroinPrice.setText("-");
		
		if(user.getDrugPrices()[5] > 0)
			tvWeedPrice.setText("$" + user.getDrugPrices()[5]);
		else
			tvWeedPrice.setText("-");
		
		if(user.getDrugPrices()[6] > 0 )
			tvShroomsPrice.setText("$" + user.getDrugPrices()[6]);
		else
			tvShroomsPrice.setText("-");
		
		if(user.getDrugPrices()[7] > 0)
			tvSpeedPrice.setText("$" + user.getDrugPrices()[7]);
		else
			tvSpeedPrice.setText("-");
		
		if(user.getGuns() == 1)
			tvGun.setText("Gun");
		if(user.getGuns() == 2)
			tvGun.setText("Shotgun");
		
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
		
		drugPrices[0] = 1000 + Math.abs(rand.nextInt()) % 3500;
		drugPrices[1] = 15000 + Math.abs(rand.nextInt()) % 15000;
		drugPrices[2] = 10 + Math.abs(rand.nextInt()) % 50;
		drugPrices[3] = 1000 + Math.abs(rand.nextInt()) % 2500;
		drugPrices[4] = 5000 + Math.abs(rand.nextInt()) % 9000;
		drugPrices[5] = 300 + Math.abs(rand.nextInt()) % 600;
		drugPrices[6] = 600 + Math.abs(rand.nextInt()) % 750;
		drugPrices[7] = 70 + Math.abs(rand.nextInt()) % 180;
		
		for (i = 0; i < 3; i++){ 		//randomly choose up to three drugs to be zero
			j = rand.nextInt(8);
			drugPrices [j] = 0;
		}
		user.setDrugPrices(drugPrices);
	}
	
	private String getDrugName(int drug){
		switch(drug){
		case 0:
			return "Acid";
		case 1:
			return "Cocaine";
		case 2:
			return "Ecstasy";
		case 3:
			return "PCP";
		case 4:
			return "Heroin";
		case 5:
			return "Weed";
		case 6:
			return "Shrooms";
		case 7:
			return "Speed";
		default:
		return null;
		}
	}
	
	
	
	
}