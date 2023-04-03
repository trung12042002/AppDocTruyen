package com.example.ungdungdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ungdungdoctruyen.database.databasedoctruyen;
import com.example.ungdungdoctruyen.model.TaiKhoan;

public class ManDangKy extends AppCompatActivity {

    EditText edtDKTaiKhoan,edtDKMatKhau,edtDKEmail;
    Button btnDKDangKy,btnDKDangNhap;

    databasedoctruyen databasedoctruyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_dang_ky);

        databasedoctruyen = new databasedoctruyen(this);

        AnhXa();

        btnDKDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtDKTaiKhoan.getText().toString();
                String matkhau = edtDKMatKhau.getText().toString();
                String email = edtDKEmail.getText().toString();

                TaiKhoan taikhoan1 = CreateTaiKhoan();
                if (taikhoan.equals("")|| matkhau.equals("")|| email.equals("")){
                    Log.e("Thông báo :","Chưa nhập đầy đủ thông tin");
                }
                else {
                    databasedoctruyen.AddTaiKhoan(taikhoan1);
                    Toast.makeText(ManDangKy.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDKDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
    private TaiKhoan CreateTaiKhoan(){
        String taikhoan = edtDKTaiKhoan.getText().toString();
        String matkhau = edtDKMatKhau.getText().toString();
        String email = edtDKEmail.getText().toString();
        int phanquyen = 1;

        TaiKhoan tk = new TaiKhoan(taikhoan,matkhau,email,phanquyen);

        return tk;
    }
    private void AnhXa() {
        edtDKEmail = findViewById(R.id.dkmail);
        edtDKMatKhau = findViewById(R.id.dkmatkhau);
        edtDKTaiKhoan = findViewById(R.id.dktaikhoan);
        btnDKDangKy = findViewById(R.id.dkdangky);
        btnDKDangNhap = findViewById(R.id.dkdangnhap);
    }


}

