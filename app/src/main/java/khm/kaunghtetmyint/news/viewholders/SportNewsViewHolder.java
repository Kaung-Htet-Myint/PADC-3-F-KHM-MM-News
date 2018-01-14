package khm.kaunghtetmyint.news.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 1/12/2018.
 */

public class SportNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewActionDelegate;

    public SportNewsViewHolder(View itemView, NewsActionDelegate mNewActionDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mNewActionDelegate = mNewActionDelegate;
    }

    @OnClick(R.id.sv_sport_news)
    public void onSportItemTap(View view){
     //   mNewActionDelegate.onTapNewsItem();
    }





}
