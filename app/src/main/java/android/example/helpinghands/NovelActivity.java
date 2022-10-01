package android.example.helpinghands;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.helpinghands.Adapter.courseAdapter;
import android.example.helpinghands.Adapter.novelAdapter;
import android.example.helpinghands.Domain.courseDomain;
import android.example.helpinghands.Domain.novelDomain;
import android.os.Bundle;

import java.util.ArrayList;

public class NovelActivity extends AppCompatActivity {

    private RecyclerView viewNovelList;
    private RecyclerView.Adapter noveladapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);

        recyclerViewNovelList();
    }

    private void recyclerViewNovelList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        viewNovelList=findViewById(R.id.Novel_rcl);
        viewNovelList.setLayoutManager(linearLayoutManager);

        ArrayList<novelDomain> novelList=new ArrayList<>();
        novelList.add(new novelDomain("IKIGAI","ikigai","Personal Development","Free","Your 'reason for being."));
        novelList.add(new novelDomain("RICH DAD POOR DAD","richdad","Business Growth","$10","Earn a high income to become rich."));
        novelList.add(new novelDomain("THE ATOMIC HABITS","atomichabits","Personal Development","Free","Source of incredible power"));

        noveladapter=new novelAdapter(novelList);
        viewNovelList.setAdapter(noveladapter);

    }
}