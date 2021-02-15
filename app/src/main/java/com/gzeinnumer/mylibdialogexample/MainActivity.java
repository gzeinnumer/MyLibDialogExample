package com.gzeinnumer.mylibdialogexample;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.da.constant.DialogType;
import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.da.dialog.numberPicker.NumberPickerDialog;
import com.gzeinnumer.mylibdialogexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClick();
    }

    private void initOnClick() {
        binding.btnConfirmDialog.setOnClickListener(v -> {
            dialogConfirm();
        });

        binding.btnInfoDialog.setOnClickListener(v -> {
            dialogInfo();
        });

        binding.btnNumberPickerDialog.setOnClickListener(v -> {
            dialogNumberPicker();
        });

        binding.btnLoadingDialog.setOnClickListener(v -> {
            dialogLoading();
        });

        binding.btnSingleDateDialog.setOnClickListener(v -> {
            dialogSingleDate();
        });

        binding.btnMultiDateDialog.setOnClickListener(v -> {
            dialogMultiDate();
        });
    }

    private void dialogConfirm() {
        new ConfirmDialog(getSupportFragmentManager())
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

    private void dialogInfo() {
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

    private void dialogNumberPicker() {
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

    private void dialogLoading() {
        LoadingDialog loadingDialog = new LoadingDialog(getSupportFragmentManager())
                .setContent("ini content");

        loadingDialog.show();

        //5 second 4 Second ...... 1 Second
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                int progress = (int) millisUntilFinished / 1000;
            }

            public void onFinish() {
                loadingDialog.dismis();
            }
        }.start();
    }

    private void dialogSingleDate() {
        new SingleDatePickerDialog(getSupportFragmentManager())
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

    private void dialogMultiDate() {
        new MultiDatePickerDialog(getSupportFragmentManager())
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