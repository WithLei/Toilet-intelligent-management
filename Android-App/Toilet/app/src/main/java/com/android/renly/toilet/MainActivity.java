package com.android.renly.toilet;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.renly.toilet.Utils.TimeUtils;
import com.android.renly.toilet.api.RetrofitService;
import com.android.renly.toilet.api.bean.Cleaner;
import com.android.renly.toilet.api.bean.Position;
import com.android.renly.toilet.api.bean.Toilet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import devlight.io.library.ntb.NavigationTabBar;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        Observable.timer(30, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(Long aLong) {
                        recreate();
                    }

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onComplete() {}
                });
    }

    private void initView() {
        final ViewPager viewPager = findViewById(R.id.vp_vertical_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 8;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                final View view = LayoutInflater.from(
                        getBaseContext()).inflate(R.layout.item_vp, null, false);

                prepareView(view, position);

                final TextView txtPage = view.findViewById(R.id.floor);
                txtPage.setText(String.format("#%d层", position + 1));

                container.addView(view);
                return view;
            }
        });

        final String[] colors = getResources().getStringArray(R.array.vertical_ntb);

        final NavigationTabBar navigationTabBar = findViewById(R.id.ntb_vertical);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .title("ic_first")
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_second")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_third")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fourth),
                        Color.parseColor(colors[3]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_fourth")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_fifth")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_sixth),
                        Color.parseColor(colors[5]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_sixth")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_seventh),
                        Color.parseColor(colors[6]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_seventh")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_eighth),
                        Color.parseColor(colors[7]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("ic_eighth")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
    }

    private void prepareView(final View view, final int position) {
        Log.e("print", "lalalallala");
        // 获取该楼层所有的厕所
        RetrofitService.getToiletByFloor(position + 1)
                .subscribe(new Observer<List<Toilet>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(final List<Toilet> toilets) {
                        ((TextView) view.findViewById(R.id.toilet_01)).setText(toilets.size()>0?toilets.get(0).getName():"广告位招租");
                        ((TextView) view.findViewById(R.id.toilet_02)).setText(toilets.size()>1?toilets.get(1).getName():"广告位招租");
                        ((TextView) view.findViewById(R.id.toilet_03)).setText(toilets.size()>2?toilets.get(2).getName():"广告位招租");
                        ((TextView) view.findViewById(R.id.toilet_04)).setText(toilets.size()>3?toilets.get(3).getName():"广告位招租");

                        final LinearLayout ll01 = view.findViewById(R.id.ll_01);
                        final LinearLayout ll02 = view.findViewById(R.id.ll_02);
                        final LinearLayout ll03 = view.findViewById(R.id.ll_03);
                        final LinearLayout ll04 = view.findViewById(R.id.ll_04);

                        // 由于前端的问题这里最多只插入四个，否则会出BUG
                        if (toilets.size() > 0)
                            RetrofitService.getPositionByToilet(toilets.get(0).getId())
                                    .subscribe(new Consumer<List<Position>>() {
                                        @Override
                                        public void accept(List<Position> positions) throws Exception {
                                            addPosition(positions, ll01, toilets.get(0));
                                        }
                                    });
                        if (toilets.size() > 1)
                            RetrofitService.getPositionByToilet(toilets.get(1).getId())
                                    .subscribe(new Consumer<List<Position>>() {
                                        @Override
                                        public void accept(List<Position> positions) throws Exception {
                                            addPosition(positions, ll02, toilets.get(1));
                                        }
                                    });
                        if (toilets.size() > 2)
                            RetrofitService.getPositionByToilet(toilets.get(2).getId())
                                    .subscribe(new Consumer<List<Position>>() {
                                        @Override
                                        public void accept(List<Position> positions) throws Exception {
                                            addPosition(positions, ll03, toilets.get(2));
                                        }
                                    });
                        if (toilets.size() > 3)
                            RetrofitService.getPositionByToilet(toilets.get(3).getId())
                                    .subscribe(new Consumer<List<Position>>() {
                                        @Override
                                        public void accept(List<Position> positions) throws Exception {
                                            addPosition(positions, ll04, toilets.get(3));
                                        }
                                    });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("print", "onError " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });


    }

    private void addPosition(List<Position> positions, LinearLayout ll, final Toilet toilet) {
        for (Position position : positions) {
            if (!position.getIsServing()) {
                addImcontactPosition(position, ll, toilet);
                continue;
            }
            if (!position.getIsUsing()) {
                addEmptyPosition(position, ll, toilet);
            } else {
                long usingTime = (new Date()).getTime() - TimeUtils.stringToMiles(position.getStart_time());
                usingTime/=1000;
                if (usingTime < 1800) {
                    addBusyPosition(position, ll, usingTime, toilet);
                } else {
                    addVeryBusyPosition(position, ll, usingTime, toilet);
                }
            }
        }
    }

    private void initData() {
    }

    private void addEmptyPosition(final Position position, LinearLayout ll, final Toilet toilet) {
        final View emptyView = LayoutInflater.from(
                getBaseContext()).inflate(R.layout.item_position, null, false);
        LinearLayout empty = emptyView.findViewById(R.id.emptyView);
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onToiletClick(position, toilet);
            }
        });
        ll.addView(empty);
    }

    private void addBusyPosition(final Position position, LinearLayout ll, long usingTime, final Toilet toilet) {
        final View busyView = LayoutInflater.from(
                getBaseContext()).inflate(R.layout.item_position2, null, false);
        LinearLayout busy = busyView.findViewById(R.id.busyView);
        TextView time = busy.findViewById(R.id.time);
        time.setText(TimeUtils.getFromNowOnTime(TimeUtils.stringToMiles(position.getStart_time())));
        busy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onToiletClick(position, toilet);
            }
        });
        ll.addView(busy);
    }

    private void addVeryBusyPosition(final Position position, LinearLayout ll, long usingTime, final Toilet toilet) {
        final View verybusyView = LayoutInflater.from(
                getBaseContext()).inflate(R.layout.item_position3, null, false);
        LinearLayout verybusy = verybusyView.findViewById(R.id.vertBusyView);
        TextView time = verybusy.findViewById(R.id.time);
        time.setText(TimeUtils.getFromNowOnTime(TimeUtils.stringToMiles(position.getStart_time())));
        verybusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onToiletClick(position, toilet);
            }
        });
        ll.addView(verybusy);
    }

    private void addImcontactPosition(final Position position, LinearLayout ll, final Toilet toilet) {
        final View imcontactView = LayoutInflater.from(
                getBaseContext()).inflate(R.layout.item_position4, null, false);
        LinearLayout view = imcontactView.findViewById(R.id.imcomtactView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onToiletClick(position, toilet);
            }
        });
        ll.addView(view);
    }


    private void onToiletClick(final Position position, final Toilet toilet) {
        View dialogView = View.inflate(MainActivity.this, R.layout.dialog_info, null);
        ((TextView) dialogView.findViewById(R.id.toilet)).setText(toilet.getName());
        ((TextView) dialogView.findViewById(R.id.isusing)).setText(position.getIsUsing() ? "使用中" : "未使用");
        if (position.getIsUsing()) {
            TextView tv = dialogView.findViewById(R.id.using_time);
            tv.setText(position.getStart_time());
            dialogView.findViewById(R.id.startTimeView).setVisibility(View.VISIBLE);
        }
        ((TextView) dialogView.findViewById(R.id.isService)).setText(position.getIsServing() ? "正常服务" : "失联");
        ((TextView) dialogView.findViewById(R.id.last_cleaned_time)).setText(toilet.getLast_cleaned_time());
        ((TextView) dialogView.findViewById(R.id.next_clean_time)).setText(toilet.getNext_clean_time());
        ((TextView) dialogView.findViewById(R.id.cleaner)).setText(toilet.getCleaner().getName());
        new AlertDialog.Builder(MainActivity.this)
                .setView(dialogView)
                .setCancelable(true)
                .setTitle("厕位信息")
                .create()
                .show();


    }
}
