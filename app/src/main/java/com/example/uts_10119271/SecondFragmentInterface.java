package com.example.uts_10119271;

import android.database.Cursor;

import com.example.uts_10119271.model.Notes;

public interface SecondFragmentInterface {

    public Cursor read();
    public boolean create(Notes notes);
    public boolean update(Notes notes);
    public boolean delete(String id);
}
