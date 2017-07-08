package phanloi.recyclerviewdecorations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import phanloi.recyclerviewdecorations.adapter.MyAdapter;
import phanloi.recyclerviewdecorations.adapter.SpaceDividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new SpaceDividerItemDecoration(getResources().getDimensionPixelOffset(R.dimen.divider)));
        myAdapter.setItemList(ItemBuilder.randomList(this));
    }
}
