package khm.kaunghtetmyint.news.network;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import khm.kaunghtetmyint.news.event.LoadedNewsEvent;
import khm.kaunghtetmyint.news.network.response.GetNewsResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 1/6/2018.
 */

public class RetrofitDataAgent implements NewsDataAgent {
    private static RetrofitDataAgent sObjectInstance;

    private NewsApi mNewsApi;

    private RetrofitDataAgent(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mNewsApi = retrofit.create(NewsApi.class);
    }

    public static RetrofitDataAgent getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new RetrofitDataAgent();
        }
        return sObjectInstance;
    }

    @Override
    public void loadNews() {

        Call<GetNewsResponse> getNewsResponseCall = mNewsApi.loadNews(1,"b002c7e1a528b7cb460933fc2875e916");

        getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();
                if(getNewsResponse != null){
                    LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                Log.e("Reftofit:","Retrofit Network Call Failed.");
            }
        });
    }
}
