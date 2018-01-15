package khm.kaunghtetmyint.news.data.models;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import khm.kaunghtetmyint.news.MMNewsApp;
import khm.kaunghtetmyint.news.adapters.NewsAdapters;
import khm.kaunghtetmyint.news.data.vo.NewsVO;
import khm.kaunghtetmyint.news.event.LoadedNewsEvent;
import khm.kaunghtetmyint.news.network.HttpUrlConnectionDataAgent;
import khm.kaunghtetmyint.news.network.NewsDataAgent;
import khm.kaunghtetmyint.news.network.RetrofitDataAgent;
import khm.kaunghtetmyint.news.network.response.OKHttpDataAgent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by User on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;
    private NewsDataAgent mDataAgent;
    private Map<String , NewsVO> mNews;
    private NewsAdapters mNewAdapter;

   /* private NewsModel(){
        mDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();
    }   */

   /*
   private NewsModel(){
       mDataAgent = OKHttpDataAgent.getsObjInstance();
   }    */

   private NewsModel(){

       mDataAgent = RetrofitDataAgent.getsObjectInstance();
       mNews = new HashMap<>();

       EventBus.getDefault().register(this);
   }

    public static NewsModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * Load news from network api.
     */
    public void loadNews(){
        mDataAgent.loadNews();
    }

    /**
     * Get news object by id.
     * @param newsId
     * @return
     */
    public NewsVO getNewsById(String newsId){
        return mNews.get(newsId);

    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event){
        for(NewsVO news : event.getNewsList()){
            mNews.put(news.getNewsID(),news);
        }
    }
}
