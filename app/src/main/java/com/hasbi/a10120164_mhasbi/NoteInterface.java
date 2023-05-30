package com.hasbi.a10120164_mhasbi;

import android.database.Cursor;

import com.hasbi.a10120164_mhasbi.model.Note;

public interface NoteInterface {

    public Cursor read();
    public boolean create(Note note);
    public boolean update(Note note);
    public boolean delete(String id);
}

