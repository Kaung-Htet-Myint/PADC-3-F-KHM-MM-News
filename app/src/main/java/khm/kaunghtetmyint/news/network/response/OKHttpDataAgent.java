package khm.kaunghtetmyint.news.network.response;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import khm.kaunghtetmyint.news.MMNewsApp;
import khm.kaunghtetmyint.news.event.LoadedNewsEvent;
import khm.kaunghtetmyint.news.network.NewsDataAgent;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by User on 1/6/2018.
 */

public class OKHttpDataAgent implements NewsDataAgent {
    private static OKHttpDataAgent sObjInstance;

    private OKHttpDataAgent(){

    }

    public static OKHttpDataAgent getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new OKHttpDataAgent();
        }
        return sObjInstance;
    }

    //call data api from network
    @Override
    public void loadNews() {
        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");
    }

    private static class LoadNewsTask extends AsyncTask<String, Void, String>{

        //1
        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];
            OkHttpClient okHttpClient = new OkHttpClient.Builder().
                                            connectTimeout(15, TimeUnit.SECONDS)
                                            .writeTimeout(15,TimeUnit.SECONDS)
                                            .readTimeout(60,TimeUnit.SECONDS)
                                            .build();

            //2
            RequestBody formbody = new FormBody.Builder()
                                        .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                                        .add("page", "1")
                                        .build();

            //3
            Request request = new Request.Builder()
                                        .url(url)
                                        .post(formbody)
                                        .build();

            //4
            String responseString = null;
            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null){
                   responseString = response.body().string();
                    return responseString;
                }
            }catch (IOException e){
                Log.e(MMNewsApp.LOG_TAG,e.getMessage());
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetNewsResponse getNewsResponse = gson.fromJson(response, GetNewsResponse.class);

            LoadedNewsEvent newsEvent = new LoadedNewsEvent(getNewsResponse.getMmNews());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(newsEvent);
        }
    }
}
