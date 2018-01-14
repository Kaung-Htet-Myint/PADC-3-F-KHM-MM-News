package khm.kaunghtetmyint.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.adapters.ImagesInNewsDetailsAdapter;
import khm.kaunghtetmyint.news.data.models.NewsModel;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.viewitems.ImageInNewsDetailsViewItem;

/**
 * Created by User on 12/9/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicLogo;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicTitle;

    @BindView(R.id.tv_news_details)
    TextView tvDetail;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    private List<String> imgUrlList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        ButterKnife.bind(this,this);
        /*
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);    */

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter(imgUrlList);
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetailsAdapter);

        String newsId = getIntent().getStringExtra("news_id");
        NewsVO news = NewsModel.getsObjInstance().getNewsById(newsId);

        bindData(news);
    }

    private void bindData(NewsVO news){
        mImagesInNewsDetailsAdapter.setImages(news.getImages());
        Glide.with(ivPublicLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicLogo);
        tvPublicTitle.setText(news.getPublication().getTitle());
        tvDetail.setText(news.getDetails());
        tvPostedDate.setText(news.getPostedDate());
    }




}
