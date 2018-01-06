package khm.kaunghtetmyint.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;
import khm.kaunghtetmyint.news.viewholders.ItemNewsViewHolder;

/**
 * Created by User on 12/3/2017.
 */

public class NewsAdapters extends RecyclerView.Adapter<ItemNewsViewHolder> {

    private  NewsActionDelegate mNewActionDelegate;
    private  List<NewsVO> mNewsList;

    public NewsAdapters(NewsActionDelegate newsActionDelegate){
            mNewActionDelegate = newsActionDelegate;
            mNewsList = new ArrayList<>();
    }
    @Override
    public ItemNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView=  inflater.inflate(R.layout.item_news, parent,false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView,mNewActionDelegate);
        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewHolder holder, int position) {
            holder.setNews(mNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList){
        mNewsList = newsList;
        notifyDataSetChanged();
        // to notify the data collection attribute get new data.
    }
}
