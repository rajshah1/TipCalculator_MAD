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
        this.billAmountValidator(billAmount);
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