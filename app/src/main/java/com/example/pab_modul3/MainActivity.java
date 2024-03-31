package com.example.pab_modul3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;


public class MainActivity extends AppCompatActivity  implements TextWatcher{

    AutoCompleteTextView ac;
    public String[] stringdataprodi = {"Teknik Informatika", "Sistem Informasi",
            "Management Informatika","Desain Komunikasi dan Visual","Teknik Sipil"};
            EditText lv;
            @Override
            public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        ac = (AutoCompleteTextView) findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stringdataprodi));
    }
    public void pilihprodi (View v) { lv = (EditText)
            findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Program Studi Fakultas Ilmu Komputer");
        builder.setItems(stringdataprodi, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdataprodi[item]);
                dialog.dismiss();
            }
        }).show();
    }
    public void onResume(){
        super.onResume();
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void onPause(){
        super.onPause();
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.cyan));
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) { }
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
    public void afterTextChanged(Editable s) {

    }
}
