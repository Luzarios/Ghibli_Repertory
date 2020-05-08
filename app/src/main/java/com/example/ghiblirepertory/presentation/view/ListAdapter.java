package com.example.ghiblirepertory.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ghiblirepertory.R;
import com.example.ghiblirepertory.presentation.model.movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<movies> values;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imageView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            imageView = (ImageView) v.findViewById(R.id.icon);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.parent_layout);
        }
    }

    public void add(int position, movies item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    /* Provide a suitable constructor */
    public ListAdapter(List<movies> myDataset, Context context) {
        values = myDataset;
        this.context = context;
    }

    /* Create new views */
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* create a new view */
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);

        /* set the view's size, margins, padding and layout parameters */
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /* Replace the contents of a view */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final movies current_movie = values.get(position);
        holder.txtHeader.setText(current_movie.getTitle());
        holder.txtFooter.setText(current_movie.getIntro());
        Picasso.with(context).load(current_movie.getMovie_picture()).into(holder.imageView);

        holder.relativeLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,current_movie.getTitle(), Toast.LENGTH_LONG).show();

                /* Enable communication between activities */
                Intent intent = new Intent(context, DescriptionActivity.class);
                intent.putExtra("movie_picture", current_movie.getMovie_picture());
                intent.putExtra("title", current_movie.getTitle());
                intent.putExtra("director", current_movie.getDirector());
                intent.putExtra("producer", current_movie.getProducer());
                intent.putExtra("composer", current_movie.getComposer());
                intent.putExtra("running_time", current_movie.getRunning_time());
                intent.putExtra("rt_score", current_movie.getRt_score());
                intent.putExtra("intro", current_movie.getIntro());
                intent.putExtra("description", current_movie.getDescription());
                context.startActivity(intent);
            }
        }

        );
        }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return values.size();
    }

}