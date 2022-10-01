package android.example.helpinghands.Adapter;

import android.example.helpinghands.Domain.TeachingDomain;
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

public class TeachingAdapter extends RecyclerView.Adapter<TeachingAdapter.ViewHolder> {
    ArrayList<TeachingDomain> teachingDomains;
    public TeachingAdapter(ArrayList<TeachingDomain> novelDomains){
        this.teachingDomains=novelDomains;
    }

    @NonNull
    @Override
    public TeachingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_courses,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TeachingAdapter.ViewHolder holder, int position) {
        holder.teachingName.setText(teachingDomains.get(position).getTittle());
        holder.teachingPrice.setText(teachingDomains.get(position).getPrice());
        holder.teachingDescription.setText(teachingDomains.get(position).getDescription());
        holder.teachingCategory.setText(teachingDomains.get(position).getCategory());
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "t1";
                break;
            }
            case 1: {
                picUrl = "t2";
                break;
            }
            case 2: {
                picUrl = "t3";
                break;
            }
            case 3: {
                picUrl = "t4";
                break;
            }
            case 4: {
                picUrl = "t5";
                break;
            }
        }
        int drawableResorceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResorceId).into(holder.teachingImage);
    }

    @Override
    public int getItemCount() {
        return teachingDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView teachingLayout;
        TextView teachingName;
        TextView teachingPrice;
        TextView teachingCategory;
        TextView teachingDescription;
        ImageView teachingImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teachingLayout=itemView.findViewById(R.id.course_framelayout);
            teachingCategory=itemView.findViewById(R.id.cardview_category);
            teachingDescription=itemView.findViewById(R.id.cardeview_descripton);
            teachingImage=itemView.findViewById(R.id.cardview_courseimage);
            teachingName=itemView.findViewById(R.id.cardview_coursename);
            teachingPrice=itemView.findViewById(R.id.cardview_price);
        }
    }
}
