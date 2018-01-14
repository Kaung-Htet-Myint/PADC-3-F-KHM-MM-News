package khm.kaunghtetmyint.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;
import khm.kaunghtetmyint.news.viewholders.SportNewsViewHolder;

/**
 * Created by User on 1/10/2018.
 */

public class SportNewsAdapter extends RecyclerView.Adapter<SportNewsViewHolder> {

    private NewsActionDelegate mNewsActionDelegate;


    public SportNewsAdapter(NewsActionDelegate newsActionDelegate) {
        mNewsActionDelegate = newsActionDelegate;
    }

    @Override
    public SportNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsItemView = inflater.inflate(R.layout.sport_news_item, parent, false);

        SportNewsViewHolder itemSportViewHolder = new SportNewsViewHolder(newsItemView, mNewsActionDelegate);
        return itemSportViewHolder;

    }

    @Override
    public void onBindViewHolder(SportNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
