package khm.kaunghtetmyint.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;
import khm.kaunghtetmyint.news.viewholders.InternationlNewsViewHolder;
import khm.kaunghtetmyint.news.viewholders.SportNewsViewHolder;

/**
 * Created by User on 1/12/2018.
 */

public class InternationalNewsAdapters extends RecyclerView.Adapter<InternationlNewsViewHolder>{

    private NewsActionDelegate mNewActionDelegate;

    public InternationalNewsAdapters( NewsActionDelegate newsActionDelegate){
        mNewActionDelegate = newsActionDelegate;
    }
    @Override
    public InternationlNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View newsItemView=  inflater.inflate(R.layout.international_news_item, parent,false);

        InternationlNewsViewHolder internationlNewsViewHolder  = new InternationlNewsViewHolder
                                                                                    (newsItemView,mNewActionDelegate);

        return internationlNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(InternationlNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
