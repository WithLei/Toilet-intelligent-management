package com.android.renly.toilet.api.api;

import com.android.renly.toilet.api.bean.Cleaner;
import com.android.renly.toilet.api.bean.Position;
import com.android.renly.toilet.api.bean.Toilet;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ToiletApi {
    // 获取厕位
    @GET("getPosition")
    Observable<Position>getPosition(@Query("id")int id);

    // 获取保洁员信息
    @GET("getCleaner")
    Observable<Cleaner>getCleaner(@Query("id")int id);

    // 按照厕所查询厕位
    @GET("getPositionByToilet")
    Observable<List<Position>>getPositionByToilet(@Query("id")int id);

    // 获取厕所信息
    @GET("getToilet")
    Observable<Toilet>getToilet(@Query("id")int id);

    // 按照楼层铲鲟厕所
    @GET("getToiletByFloor")
    Observable<List<Toilet>>getToiletByFloor(@Query("id")int id);

}
