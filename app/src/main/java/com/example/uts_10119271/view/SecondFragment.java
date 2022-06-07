package com.example.uts_10119271.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_10119271.InputActivity;
import com.example.uts_10119271.R;
import com.example.uts_10119271.adapter.SecondFragmentAdapter;
import com.example.uts_10119271.imp.SecondFragmentImp;
import com.example.uts_10119271.SecondFragmentInterface;
import com.example.uts_10119271.model.Notes;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment implements SecondFragmentAdapter.NotesOnClickListener {

    private RecyclerView add_note;
    private List<Notes> notesList;
    private SecondFragmentInterface notesInterface;
    private SecondFragmentAdapter notesAdapter;
    private View tes;

    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tes = inflater.inflate(R.layout.fragment_second, container, false);
        init();
        return tes;
    }
    private void init(){
        add_note = tes.findViewById(R.id.add_note);
        add_note.setLayoutManager(new LinearLayoutManager(getContext()));
        tes.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InputActivity.class));
            }
        });

//        tes.findViewById(R.id.btnUbah).setOnClickListener(view -> {
//            Intent intent = new Intent(getActivity(),UpdateActivity.class);
//            intent.
//            startActivity(intent);
//        });
    }

    @Override
    public void onStart() {
        super.onStart();
        read();
    }

    private void read(){
        notesList = new ArrayList<>();
        notesInterface = new SecondFragmentImp(getContext());
            Cursor cursor = notesInterface.read();
            if(cursor.moveToFirst()){
                do{
                    Notes notes = new Notes(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    );
                    notesList.add(notes);
                }while (cursor.moveToNext());
            }
        notesAdapter = new SecondFragmentAdapter(this,notesList);
            add_note.setAdapter(notesAdapter);

        }

        @Override
        public void onResume(){
            super.onResume();
            read();
        }
    @Override
    public void onCLickItem(int position){
       final Notes notes = notesList.get(position);
        System.out.println("cek");
        String[] pilihan = {"Ubah", "Hapus"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Pilihan");
        builder.setItems(pilihan, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(getActivity(), InputActivity.class);
                        intent.putExtra("id", notes.getId());
                        intent.putExtra("tanggal", notes.getTanggal());
                        intent.putExtra("judul", notes.getJudul());
                        intent.putExtra("kategori", notes.getKategori());
                        intent.putExtra("isi", notes.getIsi());
                        startActivity(intent);
                        break;
                    case 1:
                        AlertDialog.Builder builderDelete = new AlertDialog.Builder(getContext());
                        builderDelete.setMessage("Yakin Ingin Dihapus ?");
                        builderDelete.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(notesInterface.delete(notes.getId())){
                                    Toast.makeText(getContext(), "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                                read();
                                }
                            }
                        });
                        builderDelete.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builderDelete.show();
                        break;
                }
            }
        });
        builder.show();
    }
}