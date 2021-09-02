package io.rajshah.tipcalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setActionBarConfig();

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

}