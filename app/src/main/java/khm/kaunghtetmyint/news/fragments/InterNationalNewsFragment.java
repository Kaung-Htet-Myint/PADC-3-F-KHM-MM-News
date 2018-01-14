package khm.kaunghtetmyint.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import khm.kaunghtetmyint.news.R;
import khm.kaunghtetmyint.news.adapters.InternationalNewsAdapters;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.delegates.NewsActionDelegate;

/**
 * Created by User on 1/7/2018.
 */

public class InterNationalNewsFragment extends Fragment implements NewsActionDelegate{

    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    InternationalNewsAdapters mInternationalNewsAdpaters;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_international_news, container, false);
        ButterKnife.bind(this,view);

        mInternationalNewsAdpaters = new InternationalNewsAdapters(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                true);
        rvNewsByCategory.setLayoutManager(linearLayoutManager);

        rvNewsByCategory.setAdapter(mInternationalNewsAdpaters);

        return view;
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
}
