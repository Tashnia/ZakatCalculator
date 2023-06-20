package com.example.zakatcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class nextpage extends AppCompatActivity {

    EditText cash,property,gold,silver;
    TextView calcul,cal;
    TextToSpeech textToSpeech;
    //public static double zakat=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextpage);

        cash = findViewById(R.id.cash);
        property = findViewById(R.id.property);
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        calcul = findViewById(R.id.calcul);
        cal = findViewById(R.id.cal);

        textToSpeech = new TextToSpeech(nextpage.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cash.length() > 0 && property.length() > 0 && gold.length() > 0 && silver.length() > 0) {
                    String ccash = cash.getText().toString();
                    float dcash = Float.parseFloat(ccash);
                    String pproperty = property.getText().toString();
                    float qproperty = Float.parseFloat(pproperty);
                    String ggold = gold.getText().toString();
                    float hgold = Float.parseFloat(ggold);
                    String ssilver = silver.getText().toString();
                    float tsilver = Float.parseFloat(ssilver);
                    float zakat=0;


                    if (dcash >= 605630 && qproperty <= 605630 && hgold <= 605630 && tsilver <= 50740) {
                        zakat = ((float) (dcash * 2.5)/100);
                    }else if (dcash <= 605630 && qproperty >= 605630 && hgold <= 605630 && tsilver <= 50740) {
                        zakat = (float) ((qproperty * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty <= 605630 && hgold >= 605630 && tsilver <= 50740) {
                        zakat = (float) ((hgold * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty <= 605630 && hgold <= 605630 && tsilver >= 50740) {
                        zakat = (float) ((tsilver * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty >= 605630 && hgold <= 605630 && tsilver <= 50740) {
                        zakat = (float) (((dcash + qproperty) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty <= 605630 && hgold >= 605630 && tsilver <= 50740) {
                        zakat = (float) (((dcash + hgold) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty <= 605630 && hgold <= 605630 && tsilver >= 50740) {
                        zakat = (float) (((dcash + tsilver) * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty >= 605630 && hgold >= 605630 && tsilver <= 50740) {
                        zakat = (float) (((qproperty + hgold) * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty >= 605630 && hgold <= 605630 && tsilver >= 50740) {
                        zakat = (float) (((qproperty + tsilver) * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty <= 605630 && hgold >= 605630 && tsilver >= 50740) {
                        zakat = (float) (((hgold + tsilver) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty >= 605630 && hgold >= 605630 && tsilver <= 50740) {
                        zakat = (float) (((dcash + qproperty + hgold) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty >= 605630 && hgold <= 605630 && tsilver >= 50740) {
                        zakat = (float) (((dcash + qproperty + tsilver) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty <= 605630 && hgold >= 605630 && tsilver >= 50740) {
                        zakat = (float) (((dcash + hgold + tsilver) * 2.50) / 100);
                    } else if (dcash <= 605630 && qproperty >= 605630 && hgold >= 605630 && tsilver >= 50740) {
                        zakat = (float) (((qproperty + hgold + tsilver) * 2.50) / 100);
                    } else if (dcash >= 605630 && qproperty >= 605630 && hgold >= 605630 && tsilver >= 50740) {
                        zakat = (float) (((dcash + qproperty + hgold + tsilver) * 2.50) / 100);
                    } else {
                        zakat = 0;
                    }
                    cal.setText("Your Zakat is:" + zakat);
                    textToSpeech.speak("Your Zakat is:" + zakat, TextToSpeech.QUEUE_FLUSH, null, null);



                } else {
                    if (cash.length() <= 0) {
                        cash.setError("Enter cash amount");
                    } else if (property.length() <= 0) {
                        property.setError("Enter property amount");
                    } else if (gold.length() <= 0) {
                        gold.setError("Enter gold amount");
                    } else if (silver.length() <= 0) {
                        silver.setError("Enter silver amount");
                    }
                }
            }
        });

    }
}
