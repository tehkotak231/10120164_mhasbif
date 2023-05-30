package com.hasbi.a10120164_mhasbi.view.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hasbi.a10120164_mhasbi.database.DatabaseHelper;
import com.hasbi.a10120164_mhasbi.NoteInterface;
import com.hasbi.a10120164_mhasbi.R;
import com.hasbi.a10120164_mhasbi.adapter.NoteAdapter;
import com.hasbi.a10120164_mhasbi.model.Note;
import com.hasbi.a10120164_mhasbi.view.activity.AddNoteActivity;
import com.hasbi.a10120164_mhasbi.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class NoteFragment extends Fragment  { //10120164 - M Hasbi Fadilah - IF-4 - May 2023

    private MainActivity mainActivity;
    private List<Note> note;
    private NoteInterface noteInterface;
    private RecyclerView recyclerView;
    private com.hasbi.a10120164_mhasbi.adapter.NoteAdapter noteAdapter;
    private FloatingActionButton addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) { //10120156 - Aditya Mahendra Pamungkas - IF-4 - May 2023
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_note, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().show();

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.mynote);
        addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AddNoteActivity.class));
        });

        read();
    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }

    private void read() {
        note = new ArrayList<Note>();
        noteInterface = new DatabaseHelper(getContext());
        Cursor cursor = noteInterface.read();
        if (cursor.moveToFirst()){
            do {
                Note n = new Note(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                note.add(n);
            } while (cursor.moveToNext());
        }

        noteAdapter = new NoteAdapter(note);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}

