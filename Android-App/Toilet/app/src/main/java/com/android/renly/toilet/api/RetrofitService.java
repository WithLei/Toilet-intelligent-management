package com.android.renly.toilet.api;

import android.util.Log;
import android.widget.Toast;

import com.android.renly.toilet.App;
import com.android.renly.toilet.Utils.NetConfig;
import com.android.renly.toilet.api.api.ToiletApi;
import com.android.renly.toilet.api.bean.Cleaner;
import com.android.renly.toilet.api.bean.Position;
import com.android.renly.toilet.api.bean.Toilet;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 整个网络通信服务的启动控制，必须先调用初始化函数才能正常使用网络通信接口
 */
public class RetrofitService {
    private static ToiletApi toiletApi;

    private RetrofitService(){
        throw new AssertionError();
    }

    /**
     * 初始化网络通信服务
     */
    public static void init() {
        Cache cache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(NetConfig.BASE_TOILET)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        toiletApi = retrofit.create(ToiletApi.class);
    }

    /**************************************             API             **************************************/

    /**
     * 获取Cleaner信息
     */
    public static Observable<Cleaner> getCleaner(int id) {
        return toiletApi.getCleaner(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取蹲位信息
     */
    public static Observable<Position> getPosition(int id) {
        return toiletApi.getPosition(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取厕所信息
     */
    public static Observable<Toilet> getToilet(int id) {
        return toiletApi.getToilet(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 通过楼层获取厕所
     */
    public static Observable<List<Toilet>> getToiletByFloor (int id) {
        return toiletApi.getToiletByFloor(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 通过厕所查询厕位
     */
    public static Observable<List<Position>> getPositionByToilet (int id) {
        return toiletApi.getPositionByToilet(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
