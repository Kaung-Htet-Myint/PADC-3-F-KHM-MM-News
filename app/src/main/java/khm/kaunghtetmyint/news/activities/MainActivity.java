package khm.kaunghtetmyint.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.adapters.NewsAdapters;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 12/2/2017.
 */

public class MainActivity extends AppCompatActivity implements NewsActionDelegate{

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolBar;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    private NewsAdapters mNewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolBar);

        mNewAdapter = new NewsAdapters(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL ,false);
        rvNews.setLayoutManager(linearLayoutManager);

        rvNews.setAdapter(mNewAdapter);

    /*    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        rvNews.setLayoutManager(gridLayoutManager);

        rvNews.setAdapter(mNewAdapter); */

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTapFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapNewsItem() {
        Intent intent = new Intent(getApplication(),NewsDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }
}
