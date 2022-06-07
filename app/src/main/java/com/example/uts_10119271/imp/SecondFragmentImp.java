package com.example.uts_10119271.imp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.uts_10119271.SecondFragmentInterface;
import com.example.uts_10119271.model.Notes;

public class SecondFragmentImp extends SQLiteOpenHelper implements SecondFragmentInterface {

    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7
    public SecondFragmentImp(Context context){
        super(context, "db notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE tbl_notes (id TEXT, tanggal TEXT, judul TEXT, kategori TEXT, isi TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int i, int i1) {
        sql.execSQL("DROP TABLE tbl_notes");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql =getReadableDatabase();
        return sql.rawQuery("SELECT * FROM tbl_notes", null);
    }

    @Override
    public boolean create(Notes notes) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO tbl_notes VALUES ('"+notes.getId()+"','"+notes.getTanggal()+"', '"+notes.getJudul()+"','"+notes.getKategori()+"','"+notes.getIsi()+"')");
        return true;
    }

    @Override
    public boolean update(Notes notes) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE tbl_notes SET  tanggal='"+notes.getTanggal()+"' , judul='"+notes.getJudul()+"', kategori='"+notes.getKategori()+"', isi='"+notes.getIsi()+"' WHERE id='"+notes.getId()+"'");
        return true;
    }

    @Override
    public boolean delete(String id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM tbl_notes WHERE id='"+id+"'");

        return true;
    }


}
