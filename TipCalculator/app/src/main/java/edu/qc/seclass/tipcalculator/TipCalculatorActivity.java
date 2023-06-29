package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private TipCalculation tipCalculation;
    public NumberFormat money = NumberFormat.getCurrencyInstance();
    Button buttonCompute;
    EditText checkAmount;
    EditText partySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCompute = findViewById(R.id.buttonCompute);
        checkAmount = findViewById(R.id.checkAmountValue);
        partySize = findViewById(R.id.partySizeValue);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                if(checkAmount.getText().toString().length() == 0){
                    checkAmount.setError("Invalid check amount input");
                }
                else if(partySize.getText().toString().length() == 0){
                    partySize.setError("Invalid party Size. ");
                }else{
                    calculate();
                }
            }
        });


}
    public void calculate(){
        tipCalculation = new TipCalculation(0,1);
        EditText checkAmountTxt = findViewById(R.id.checkAmountValue);
        String checkString = checkAmountTxt.getText().toString();
        double checkAmount = Double.parseDouble(checkString);

        EditText partySizeTxt = findViewById(R.id.partySizeValue);
        String partyString = partySizeTxt.getText().toString();
        int partySize = Integer.parseInt(partyString);


        TextView fifteentipTextView = findViewById(R.id.fifteenPercentTipValue);
        TextView twentytipTextView = findViewById(R.id.twentyPercentTipValue);
        TextView twentyfivetipTextView = findViewById(R.id.twentyfivePercentTipValue);
        TextView fifteentotalTextView = findViewById(R.id.fifteenPercentTotalValue);
        TextView twentytotalTextView = findViewById(R.id.twentyPercentTotalValue);
        TextView twentyfivetotalTextView = findViewById(R.id.twentyfivePercentTotalValue);

        tipCalculation.setCheckAmount(checkAmount);
        tipCalculation.setPartySize(partySize);
        tipCalculation.calculatefifteenTip();
        tipCalculation.calculatetwentyTip();
        tipCalculation.calculatetwentyfiveTip();
        tipCalculation.calculatefifteenTotal();
        tipCalculation.calculatetwentyTotal();
        tipCalculation.calculatetwentyfiveTotal();

        double fifteenTipEach = tipCalculation.getFifteenTipEach();
        double twentyTipEach = tipCalculation.getTwentyTipEach();
        double twentyfiveTipEach = tipCalculation.getTwentyfiveTipEach();
        double fifteenTotalEach = tipCalculation.getFifteenTotal();
        double twentyTotalEach = tipCalculation.getTwentyTotal();
        double twentyfiveTotalEach = tipCalculation.getTwentyfiveTotal();

        fifteentipTextView.setText(money.format(fifteenTipEach));
        twentytipTextView.setText(money.format(twentyTipEach));
        twentyfivetipTextView.setText(money.format(twentyfiveTipEach));
        fifteentotalTextView.setText(money.format(fifteenTotalEach));
        twentytotalTextView.setText(money.format(twentyTotalEach));
        twentyfivetotalTextView.setText(money.format(twentyfiveTotalEach));

    }
    public void hideKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalculation = new TipCalculation(0,1);
        buttonCompute = findViewById(R.id.buttonCompute);
        checkAmount = findViewById(R.id.checkAmountValue);
        partySize = findViewById(R.id.partySizeValue);
*/




        //Failed Attempt
       /* buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkAmount.getText().toString().isEmpty() && !partySize.getText()
                        .toString().isEmpty()){
                    Toast.makeText(TipCalculatorActivity.this, "Your Tip Values are Down Below", Toast.LENGTH_SHORT).show();

            }else{
                    Toast.makeText(TipCalculatorActivity.this, "One or Both fields are Blank"
                            , Toast.LENGTH_SHORT).show();
                }
        }

        });*/


    }


