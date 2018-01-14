package khm.kaunghtetmyint.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.news.MMNewsApp;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.adapters.NewsAdapters;
import khm.kaunghtetmyint.news.adapters.NewsByCategoryAdapter;
import khm.kaunghtetmyint.news.data.models.NewsModel;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;
import khm.kaunghtetmyint.news.event.LoadedNewsEvent;

/**
 * Created by User on 1/7/2018.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegate{

    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    private NewsAdapters mNewsByCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);
        ButterKnife.bind(this,view);

        mNewsByCategoryAdapter = new NewsAdapters(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,
                                                                            true);
        rvNewsByCategory.setLayoutManager(linearLayoutManager);

        rvNewsByCategory.setAdapter(mNewsByCategoryAdapter);
        NewsModel.getsObjInstance().loadNews();


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onTapNewsItem(NewsVO nvVO) {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event){
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded :"+event.getNewsList().size());
        mNewsByCategoryAdapter.setNews(event.getNewsList());
    }
}

