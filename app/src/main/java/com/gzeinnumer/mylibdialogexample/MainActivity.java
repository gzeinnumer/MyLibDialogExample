package com.gzeinnumer.mylibdialogexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.gzeinnumer.mylibdialog.constant.DateScreenStyle;
import com.gzeinnumer.mylibdialog.constant.DialogType;
import com.gzeinnumer.mylibdialog.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.mylibdialog.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.mylibdialog.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.mylibdialog.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.mylibdialog.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.mylibdialog.dialog.numberPicker.NumberPickerDialog;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6;

    private void initView(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initOnClick();
    }

    private void initOnClick() {
        btn1.setOnClickListener(v -> {
            initConfirmDialog();
        });
        btn2.setOnClickListener(v -> {
            initInfoDialog();
        });
        btn3.setOnClickListener(v -> {
            initNumberPickerDialog();
        });
        btn4.setOnClickListener(v -> {
            initLoadingDialog();
        });
        btn5.setOnClickListener(v -> {
            initSingleDatePickerDialog();
        });
        btn6.setOnClickListener(v -> {
            initMultiDatePickerDialog();
        });
    }

    private void initConfirmDialog() {
        new ConfirmDialog(getSupportFragmentManager())
//                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner))
//                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))
//                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_layer))
                .setDialogCanvas(getResources().getDrawable(R.drawable.dialog_shadow))
                .setTitle("ini title")
                .setContent("ini content")
                .onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed() {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initInfoDialog() {
        new InfoDialog(getSupportFragmentManager())
                .setDialogType(DialogType.DialogSuccess)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBack(new InfoDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed() {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initNumberPickerDialog() {
        new NumberPickerDialog(getSupportFragmentManager())
                .setLastValue(12)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBack(new NumberPickerDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed(int value) {
                        Toast.makeText(MainActivity.this, "Nilai nya " + value, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new NumberPickerDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initLoadingDialog() {
        LoadingDialog loadingDialog = new LoadingDialog(getSupportFragmentManager())
                .setContent("ini content");

        loadingDialog.show();

//        loadingDialog.dismis();

    }

    private void initSingleDatePickerDialog() {
        new SingleDatePickerDialog(getSupportFragmentManager())
                .setDialogScreen(DateScreenStyle.DialogScreen)
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setSelectedToday(true)
                .setTimeFormat("dd/MM/yyyy") //pastikan polanya sama
                .setStartDate("1/08/2020") //pastikan polanya sama
                .setEndDate("31/12/2020") //pastikan polanya sama
                .onOkPressedCallBack(new SingleDatePickerDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed(String value) {
                        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }

    private void initMultiDatePickerDialog() {
        new MultiDatePickerDialog(getSupportFragmentManager())
                .setDialogScreen(DateScreenStyle.DialogScreen)
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setTimeFormat("dd/MM/yyyy") //pastikan 3 pola ini sama
                .setStartDate("1/08/2020") //pastikan 3 pola ini sama
                .setEndDate("31/12/2020") //pastikan 3 pola ini sama
                .onOkPressedCallBack(new MultiDatePickerDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed(String firstDate, String secondDate) {
                        Toast.makeText(MainActivity.this, firstDate + " - " + secondDate, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }
}