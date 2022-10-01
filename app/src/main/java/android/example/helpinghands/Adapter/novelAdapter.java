package android.example.helpinghands.Adapter;

import android.example.helpinghands.Domain.novelDomain;
import android.example.helpinghands.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class novelAdapter extends RecyclerView.Adapter<novelAdapter.ViewHolder> {
    ArrayList<novelDomain> novelDomains;
    public novelAdapter(ArrayList<novelDomain> novelDomains){
        this.novelDomains=novelDomains;
    }

    @NonNull
    @Override
    public novelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_courses,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull novelAdapter.ViewHolder holder, int position) {
        holder.novelName.setText(novelDomains.get(position).getTittle());
        holder.novelPrice.setText(novelDomains.get(position).getPrice());
        holder.novelDescription.setText(novelDomains.get(position).getDescription());
        holder.novelCategory.setText(novelDomains.get(position).getCategory());
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "ikigai";
                break;
            }
            case 1: {
                picUrl = "richdad";
                break;
            }
            case 2: {
                picUrl = "atomichabits";
                break;
            }
        }
        int drawableResorceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResorceId).into(holder.novelImage);
    }

    @Override
    public int getItemCount() {
        return novelDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView novelLayout;
        TextView novelName;
        TextView novelPrice;
        TextView novelCategory;
        TextView novelDescription;
        ImageView novelImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            novelLayout=itemView.findViewById(R.id.course_framelayout);
            novelCategory=itemView.findViewById(R.id.cardview_category);
            novelDescription=itemView.findViewById(R.id.cardeview_descripton);
            novelImage=itemView.findViewById(R.id.cardview_courseimage);
            novelName=itemView.findViewById(R.id.cardview_coursename);
            novelPrice=itemView.findViewById(R.id.cardview_price);
        }
    }
}
