package phanloi.recyclerviewdecorations;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import phanloi.recyclerviewdecorations.adapter.MyAdapter;
import phanloi.recyclerviewdecorations.decoration.DrawOverDividerItemDecoration;
import phanloi.recyclerviewdecorations.decoration.PaddingDividerItemDecoration;
import phanloi.recyclerviewdecorations.decoration.SimpleDividerItemDecoration;
import phanloi.recyclerviewdecorations.decoration.SpaceDividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private List<RecyclerView.ItemDecoration> mItemDecorationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mItemDecorationList.add(new SpaceDividerItemDecoration(getResources().getDimensionPixelOffset(R.dimen.dividerHeight), false));
        mItemDecorationList.add(new SimpleDividerItemDecoration(this, R.drawable.divider_simple, getResources().getDimensionPixelOffset(R.dimen.dividerHeight), false));
        mItemDecorationList.add(new DrawOverDividerItemDecoration(this, R.drawable.divider_draw_over));
        mItemDecorationList.add(new PaddingDividerItemDecoration(this, R.drawable.divider_padding, getResources().getDimensionPixelOffset(R.dimen.dividerPaddingHeight), getResources().getDimensionPixelOffset(R.dimen.dividerPadding), false));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setItemList(ItemBuilder.randomList(this));

        changeItemDecoration(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_space) {
            changeItemDecoration(0);
            return true;
        } else if (id == R.id.action_simple) {
            changeItemDecoration(1);
            return true;
        } else if (id == R.id.action_draw_over) {
            changeItemDecoration(2);
            return true;
        } else if (id == R.id.action_padding) {
            changeItemDecoration(3);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeItemDecoration(int index) {
        for (RecyclerView.ItemDecoration itemDecoration : mItemDecorationList) {
            mRecyclerView.removeItemDecoration(itemDecoration);
        }

        mRecyclerView.addItemDecoration(mItemDecorationList.get(index));

        if (index == 3) {
            mRecyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.bgItem));
        } else {
            mRecyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.bgRecyclerView));
        }
    }
}
