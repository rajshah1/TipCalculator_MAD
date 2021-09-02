package io.rajshah.tipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG = "TipCalculator";

    EditText billAmount;
    RadioGroup radioGroup_tip,radioGroup_split;
    TextView textView_tip_val,textView_total_val,textView_split_val,textView_customProgressBar;
    SeekBar seekBar;
    double totalValueInDouble,totalTip=10.0,currentProgressInbar;
    int divideBetweenPerson=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setActionBarConfig();
        billAmount = findViewById(R.id.editText_billAmount);
        textView_tip_val = findViewById(R.id.textView_tip_val);
        textView_total_val = findViewById(R.id.textView_total_val);
        textView_split_val = findViewById(R.id.textView_split_val);
        textView_customProgressBar= findViewById(R.id.textView_customProgressBar);
        radioGroup_tip=findViewById(R.id.radioGroup_tip);
        radioGroup_split=findViewById(R.id.radioGroup_split);
        seekBar=findViewById(R.id.seekBar);


        this.billAmountValidator(billAmount);
        this.resetCustomSeekBarToInit();

        billAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().matches(""))
                    setValuesIfAmountIsNull();
            }

            @Override
            public void afterTextChanged(Editable editable) {
               if(editable.toString().matches(""))
                   setValuesIfAmountIsNull();
               else{
                   setFinalValueInDouble(Double.parseDouble(editable.toString()));
                   updateFinalDisplay();
               }
            }
        });
        radioGroup_tip.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton5) {
                    resetCustomSeekBarToInit();
                    setTotalTip(10.0);
                    updateFinalDisplay();
                } else if (i == R.id.radioButton6) {
                    resetCustomSeekBarToInit();
                    setTotalTip(15.0);
                    updateFinalDisplay();
                } else if (i == R.id.radioButton7) {
                    resetCustomSeekBarToInit();
                    setTotalTip(18.0);
                    updateFinalDisplay();
                } else if (i == R.id.radioButton8) {
                    seekBar.setEnabled(true);
                    setTotalTip(40.0);
                    updateFinalDisplay();
                }

            }
        });

        radioGroup_split.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButton_one){
                    divideBetweenPerson=1;
                    updateFinalDisplay();
                }else if(i == R.id.radioButton_two){
                    divideBetweenPerson=2;
                    updateFinalDisplay();
                }else if(i == R.id.radioButton_three){
                    divideBetweenPerson=3;
                    updateFinalDisplay();
                }else if(i == R.id.radioButton_four){
                    divideBetweenPerson=4;
                    updateFinalDisplay();
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 currentProgressInbar = Double.parseDouble(String.valueOf(i));
                 textView_customProgressBar.setText(i+"%");
                 setTotalTip(currentProgressInbar);
                 updateFinalDisplay();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    /*
        Sets ActionBar Color to Black For Activity
     */
    private void setActionBarConfig() {
        ActionBar aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#000000"));
        assert aBar != null;
        aBar.setBackgroundDrawable(cd);
    }

    /*
         EditText Validator to allow Decimal and Positive Numbers
     */
    private void billAmountValidator(@NonNull EditText editor) {
        editor.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        editor.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
    }

}