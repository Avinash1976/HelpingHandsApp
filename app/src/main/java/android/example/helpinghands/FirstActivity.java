package android.example.helpinghands;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.helpinghands.Adapter.courseAdapter;
import android.example.helpinghands.Domain.courseDomain;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView.Adapter courseadpater,noveladapter;
    private RecyclerView viewCoursesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        recyclerViewCourseList();
        bottomNavigation();
    }


    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.home_Btn);
        LinearLayout novelBtn=findViewById(R.id.novel_btn);
        LinearLayout teachingBtn=findViewById(R.id.teaching_btn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this,FirstActivity.class));
            }
        });
        novelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this,NovelActivity.class));
            }
        });
        teachingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this,TeachingActivity.class));
            }
        });
    }

    private void recyclerViewCourseList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        viewCoursesList=findViewById(R.id.course_rcl);
        viewCoursesList.setLayoutManager(linearLayoutManager);

        ArrayList<courseDomain> categoryList=new ArrayList<>();
        categoryList.add(new courseDomain("Android Development","android","Technology","Free","learn android development"));
        categoryList.add(new courseDomain("Web Development","coding","Technology","$10","learn Web Development"));
        categoryList.add(new courseDomain("Artifical Intelligence","ai","Technology","Free","learn Artifical Intelligence"));
        categoryList.add(new courseDomain("Personality Dvelopment","personal","Self-Improvement","$50","Stand up in World"));
        categoryList.add(new courseDomain("Java Tutorial","java","Technology","Free","java technology"));

        courseadpater=new courseAdapter(categoryList);
        viewCoursesList.setAdapter(courseadpater);
    }
}