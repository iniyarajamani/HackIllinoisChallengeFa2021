package com.example.hackillinoischallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Mentor> mentors;

    public Adapter(Context ctx, List<Mentor> mentors){
        this.inflater = LayoutInflater.from(ctx);
        this.mentors = mentors;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameText, descriptionText;
        ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name);
            descriptionText = itemView.findViewById(R.id.description);
            profileImageView = itemView.findViewById(R.id.profile);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nameString = mentors.get(position).getFirstName() + " " + mentors.get(position).getLastName();

        holder.nameText.setText(nameString.toUpperCase());
        holder.descriptionText.setText(mentors.get(position).getDescription());
        Picasso.get().load(mentors.get(position).getProfile()).into(holder.profileImageView);
    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }
}
