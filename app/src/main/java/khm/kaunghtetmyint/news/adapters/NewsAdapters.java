package khm.kaunghtetmyint.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;
import khm.kaunghtetmyint.news.viewholders.ItemNewsViewHolder;

/**
 * Created by User on 12/3/2017.
 */

public class NewsAdapters extends RecyclerView.Adapter {

    private  NewsActionDelegate mNewActionDelegate;

    public NewsAdapters(NewsActionDelegate newsActionDelegate){
            mNewActionDelegate = newsActionDelegate;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView=  inflater.inflate(R.layout.item_news, parent,false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView,mNewActionDelegate);
        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
