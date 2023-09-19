package com.example.crossbillchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText originalValueEditText, enterAmountEditText;
    private TextView updAddnumTextView, setResultTextView;
    private Button setButton, addButton;

    private int originalValue = 0;
    private int enteredAmount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
//        }
        setContentView(R.layout.activity_main);


        originalValueEditText = findViewById(R.id.original_value);
        enterAmountEditText = findViewById(R.id.enter_amount);
        updAddnumTextView = findViewById(R.id.upd_addnum);
        setResultTextView = findViewById(R.id.set_result);
        setButton = findViewById(R.id.bt_set);
        addButton = findViewById(R.id.bt_add);
        TextView lastEnteredAmount = findViewById(R.id.last_entered_amount);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalValueString = originalValueEditText.getText().toString();
                if (!originalValueString.isEmpty()) {
                    originalValue = Integer.parseInt(originalValueString);
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    originalValueEditText.setText("");
                    enteredAmount = 0;
                    enterAmountEditText.setText("");
                    updAddnumTextView.setText("");
                    lastEnteredAmount.setText("");
                }
        });

        Button resetButton = findViewById(R.id.bt_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            String enterAmountString = enterAmountEditText.getText().toString();
            if (!enterAmountString.isEmpty()) {
                int amount = Integer.parseInt(enterAmountString);
                enteredAmount += amount;
                updAddnumTextView.setText("Updated numbers: " + enteredAmount);
                if (enteredAmount == originalValue) {
                    setResultTextView.setText("Matched");
                    setResultTextView.setTextColor(getResources().getColor(R.color.green));
                } else {
                    setResultTextView.setText("Not Matched");
                    setResultTextView.setTextColor(getResources().getColor(R.color.red));
                }

                String enteredAmount = enterAmountEditText.getText().toString();
                lastEnteredAmount.setText("Last entered amount: " + enteredAmount);

            }
            enterAmountEditText.setText("");
        }
        });

    }

}