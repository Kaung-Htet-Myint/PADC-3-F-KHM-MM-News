package khm.kaunghtetmyint.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.adapters.NewsByCategoryAdapter;
import khm.kaunghtetmyint.news.adapters.SportNewsAdapter;
import khm.kaunghtetmyint.news.fragments.InterNationalNewsFragment;
import khm.kaunghtetmyint.news.fragments.NewsByCategoryFragment;
import khm.kaunghtetmyint.news.fragments.SportNewsFragment;

/**
 * Created by User on 1/7/2018.
 */

public class NewsByCategoryActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string.title_news_by_category);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());

        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        mNewsByCategoryAdapter.addTab("Local News",new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News",new InterNationalNewsFragment());
        mNewsByCategoryAdapter.addTab("Sport News",new SportNewsFragment());



        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);

        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());
    }


}
