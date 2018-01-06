package khm.kaunghtetmyint.news.data.models;

import khm.kaunghtetmyint.news.network.HttpUrlConnectionDataAgent;
import khm.kaunghtetmyint.news.network.NewsDataAgent;
import khm.kaunghtetmyint.news.network.response.OKHttpDataAgent;
import okhttp3.OkHttpClient;

/**
 * Created by User on 12/23/2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;
    private NewsDataAgent mDataAgent;

   /* private NewsModel(){
        mDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();
    }   */

   private NewsModel(){
       mDataAgent = OKHttpDataAgent.getsObjInstance();
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
}
