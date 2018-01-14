package khm.kaunghtetmyint.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 1/12/2018.
 */

public class InternationlNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewActionDelegate;

    public InternationlNewsViewHolder(View itemView, NewsActionDelegate mNewActionDelegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mNewActionDelegate = mNewActionDelegate;
    }
}
