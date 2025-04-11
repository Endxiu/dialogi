package com.example.dialogueapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button Button1 = findViewById(R.id.button1);
        Button1.setOnClickListener(view -> showAlertDialogue());
        Button Button2 = findViewById(R.id.button2);
        Button2.setOnClickListener(view -> showListDialogue());
        Button Button3 = findViewById(R.id.button3);
        Button3.setOnClickListener(view -> showCallendarDialogue());
        Button Button4 = findViewById(R.id.button4);
        Button Button5 = findViewById(R.id.button5);

    }

    private void showAlertDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prosty AlertDialog");
        builder.setMessage("To jest wiadomość AlertDialogu");

        builder.setPositiveButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,
                        "Kliknięto Anuluj", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showListDialogue() {
        final String[] items = {"Opcja 1","Opcja 2","Opcja 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz opcję");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Wybrana: "
                        + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showCallendarDialogue() {
        Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Toast.makeText(MainActivity.this, "Wybrana data: "
                                + dayOfMonth + "/" + (month + 1)
                                + "/" + year, Toast.LENGTH_SHORT).show();
                    }
                    }, year, month, day);
        datePickerDialog.show();
    };
}
