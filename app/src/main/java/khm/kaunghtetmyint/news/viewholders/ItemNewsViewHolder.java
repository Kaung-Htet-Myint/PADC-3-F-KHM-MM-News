package khm.kaunghtetmyint.news.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 12/3/2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    public NewsActionDelegate mNewsActionDelegate;

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


}
