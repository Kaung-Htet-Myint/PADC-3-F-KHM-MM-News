package khm.kaunghtetmyint.news.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    public NewsActionDelegate mNewsActionDelegate;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBreif;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationmLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view){
//        Toast.makeText(view.getContext(), "News Item Clicked",Toast.LENGTH_LONG).show();
        mNewsActionDelegate.onTapNewsItem();
    }

    public void setNews(NewsVO news){
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsBreif.setText(news.getBrief());

        Glide.with(ivPublicationmLogo.getContext())
                        .load(news.getPublication().getLogo())
                        .into(ivPublicationmLogo);
        if(news.getImages() != null) {
            Glide.with((ivNews.getContext()))
                    .load(news.getImages().get(0))
                    .into(ivNews);
        }
        else
            ivNews.setVisibility(View.GONE);

    }

}
