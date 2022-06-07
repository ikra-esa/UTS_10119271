package com.example.uts_10119271.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_10119271.R;
import com.example.uts_10119271.model.Notes;
import com.example.uts_10119271.view.SecondFragment;

import java.util.List;

public class SecondFragmentAdapter extends RecyclerView.Adapter<SecondFragmentAdapter.SecondFragmentViewHolder>{

    private List<Notes> notesList;
    private TextView tv_judul, tv_tanggal, tv_kategori, tv_isi;
    private NotesOnClickListener listener;
    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7

    public SecondFragmentAdapter(SecondFragment secondFragment, List<Notes> notesList) {
        this.notesList = notesList;
        try {
            this.listener = ((NotesOnClickListener) secondFragment);
        } catch (ClassCastException e) {
            throw new ClassCastException("fragment must implement AdapterCallback.");
        }
    }

    @NonNull
    @Override
    public SecondFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.items, null, false);
        return new SecondFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondFragmentViewHolder holder, int position) {
        holder.tv_tanggal.setText(notesList.get(position).getTanggal());
        holder.tv_judul.setText(notesList.get(position).getJudul());
        holder.tv_kategori.setText(notesList.get(position).getKategori());
        holder.tv_isi.setText(notesList.get(position).getIsi());
        holder.itemView.setOnClickListener(view -> {
            listener.onCLickItem(position);
        });
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public interface NotesOnClickListener {
        void onCLickItem(int position);
    }

    public class SecondFragmentViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_judul, tv_tanggal, tv_kategori, tv_isi;

        public SecondFragmentViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            tv_kategori = itemView.findViewById(R.id.tv_kategori);
            tv_isi = itemView.findViewById(R.id.tv_isi);
        }
    }
}
