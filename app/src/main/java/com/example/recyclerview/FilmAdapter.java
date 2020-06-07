package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Film> data;


    public FilmAdapter(Context context, ArrayList<Film> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Film p = data.get(position);
        holder.nama.setText(p.getNama());
        holder.desc.setText(p.getDesc());
        holder.photo.setImageResource(p.getPhoto());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail_activity = new Intent(context,DetailsActivity.class);
                detail_activity.putExtra("image_detail",p.getPhoto());
                detail_activity.putExtra("judulFilm",p.getNama());
                detail_activity.putExtra("deskripsi",p.getDesc());
                context.startActivity(detail_activity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, desc;
        private ImageView photo;
        LinearLayout linearLayout;
        private Button Bdelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.text_nama);
            desc = itemView.findViewById(R.id.text_desc);
            photo = itemView.findViewById(R.id.img_photo);
            linearLayout=itemView.findViewById(R.id.list);
//            Bdelete = itemView.findViewById(R.id.btn_hapus);

//           Bdelete.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   if (listener !=null){
//                       int position = getAdapterPosition();
//                       if (position != RecyclerView.NO_POSITION){
//                           listener.onD
//                       }
//                   }
//               }
//           });
        }
    }
}
