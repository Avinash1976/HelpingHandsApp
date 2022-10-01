package android.example.helpinghands.Adapter;

import android.example.helpinghands.Domain.courseDomain;
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

import java.text.BreakIterator;
import java.util.ArrayList;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder>{

    ArrayList<courseDomain> courseDomains;
    public courseAdapter(ArrayList<courseDomain> courseDomains){
        this.courseDomains=courseDomains;
    }

    @NonNull
    @Override
    public courseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_courses,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull courseAdapter.ViewHolder holder, int position) {
        holder.courseName.setText(courseDomains.get(position).getTittle());
        holder.coursePrice.setText(courseDomains.get(position).getPrice());
        holder.courseDescription.setText(courseDomains.get(position).getDescription());
        holder.courseCategory.setText(courseDomains.get(position).getCategory());
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "android";
                break;
            }
            case 1: {
                picUrl = "ai";
                break;
            }
            case 2: {
                picUrl = "coding";
                break;
            }
            case 3: {
                picUrl = "personal";
                break;
            }
            case 4: {
                picUrl = "java";
                break;
            }
        }
        int drawableResorceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResorceId).into(holder.courseImage);
    }

    @Override
    public int getItemCount() {
        return courseDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardLayout;
        TextView courseName;
        TextView coursePrice;
        TextView courseCategory;
        TextView courseDescription;
        ImageView courseImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardLayout=itemView.findViewById(R.id.course_framelayout);
            courseCategory=itemView.findViewById(R.id.cardview_category);
            courseDescription=itemView.findViewById(R.id.cardeview_descripton);
            courseImage=itemView.findViewById(R.id.cardview_courseimage);
            courseName=itemView.findViewById(R.id.cardview_coursename);
            coursePrice=itemView.findViewById(R.id.cardview_price);
        }
    }
}
