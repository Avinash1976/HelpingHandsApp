package android.example.helpinghands;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.helpinghands.Adapter.TeachingAdapter;
import android.example.helpinghands.Adapter.novelAdapter;
import android.example.helpinghands.Domain.TeachingDomain;
import android.example.helpinghands.Domain.novelDomain;
import android.os.Bundle;

import java.util.ArrayList;

public class TeachingActivity extends AppCompatActivity {

    private RecyclerView viewTeacherList;
    private RecyclerView.Adapter teacheradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaching);

        recyclerviewTeacherList();
    }

    private void recyclerviewTeacherList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        viewTeacherList=findViewById(R.id.teaching_rcl);
        viewTeacherList.setLayoutManager(linearLayoutManager);

        ArrayList<TeachingDomain> teacherList=new ArrayList<>();
        teacherList.add(new TeachingDomain("Tim Burn","t1","Technology","Free","Java Tutorial Beginners"));
        teacherList.add(new TeachingDomain("Max Wayfield","t2","Buisness","$10","Grow Your Buisness Idea"));
        teacherList.add(new TeachingDomain("Sahil Musk","t3","Develop Yourself","Free","Stand in New World"));
        teacherList.add(new TeachingDomain("Finn Balor","t4","Technology","$50","Machine Leaning Developement"));
        teacherList.add(new TeachingDomain("Mini Swift","t5","Technology","Free","Data Structures And Algorithm"));

        teacheradapter=new TeachingAdapter(teacherList);
        viewTeacherList.setAdapter(teacheradapter);
    }
}