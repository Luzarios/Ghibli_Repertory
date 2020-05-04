package com.example.ghiblirepertory;

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

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<movies> values;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
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

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<movies> myDataset, Context context) {
        values = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final movies current_movie = values.get(position);
        holder.txtHeader.setText(current_movie.getTitle());
        holder.txtFooter.setText(current_movie.getIntro());
        Picasso.with(context).load(current_movie.getMovie_picture()).into(holder.imageView);

        holder.relativeLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,current_movie.getTitle(), Toast.LENGTH_LONG).show();

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
                intent.putExtra("movie_trailer", current_movie.getMovie_trailer());
                context.startActivity(intent);
            }
        }

        );
        }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}