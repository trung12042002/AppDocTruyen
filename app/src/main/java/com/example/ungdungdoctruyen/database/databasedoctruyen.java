package com.example.ungdungdoctruyen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.ungdungdoctruyen.model.TaiKhoan;

public class databasedoctruyen extends SQLiteOpenHelper {

    //cơ sở dữ liệu

    //Tên datebase
    private static String DATABASE_NAME = "doctruyen";

    //biến Bảng tài khoản
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    //version
    private static int VERSION = 1;

    //biến Bảng truyện
    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";

    //context
    private Context context;

    //biến lưu câu lệnh tạo bảng tài khoản
    private String SQLQuery = "CREATE TABLE " + TABLE_TAIKHOAN + "(" + ID_TAI_KHOAN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TEN_TAI_KHOAN + " TEXT UNIQUE,"
            + MAT_KHAU + " TEXT,"
            + EMAIL + " TEXT,"
            + PHAN_QUYEN + " INTEGER)";

    //biến lưu câu lệnh tạo bảng truyện
    private String SQLQuery1 = "CREATE TABLE " + TABLE_TRUYEN + " (" + ID_TRUYEN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TEN_TRUYEN + " TEXT UNIQUE, "
            + NOI_DUNG + " TEXT, "
            + IMAGE + " TEXT, " + ID_TAI_KHOAN + " INTEGER , FOREIGN KEY (" + ID_TAI_KHOAN + ") REFERENCES " + TABLE_TAIKHOAN + "(" + ID_TAI_KHOAN + "))";


    private String SQLQuery2 = "INSERT INTO TaiKhoan VALUES (null,'trinh','trinh','trinh@gmail.com',1)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VALUES (null,'trung','trung','trung@gmail.com',2)";



    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TAIKHOAN, null);
        return res;
    }

    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);

        db.close();
        Log.e("ADD TK","TC");
    }

}
