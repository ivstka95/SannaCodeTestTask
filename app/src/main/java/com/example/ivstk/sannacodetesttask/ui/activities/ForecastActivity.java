package com.example.ivstk.sannacodetesttask.ui.activities;

import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ivstk.sannacodetesttask.presentation.ForecastContract;
import com.example.ivstk.sannacodetesttask.presentation.presenter.ForecastPresenter;
import com.example.ivstk.sannacodetesttask.utils.view.AppBarStateChangeListener;
import com.example.ivstk.sannacodetesttask.ui.fragments.DaysFragment;
import com.example.ivstk.sannacodetesttask.ui.fragments.HoursFragment;
import com.example.ivstk.sannacodetesttask.ui.fragments.ItemFragment;
import com.example.ivstk.sannacodetesttask.ui.adapters.SimplePagerAdapter;
import com.example.ivstk.sannacodetesttask.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastActivity extends MvpAppCompatActivity implements ForecastContract.ForecastView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.app_bar)
    AppBarLayout app_bar;

    @InjectPresenter
    ForecastPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        app_bar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED)
                    srl.setEnabled(true);
                else srl.setEnabled(false);
            }
        });
        setupTabsNPages();
    }

    private void setupTabsNPages() {
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        List<Fragment> pages = new ArrayList<>();
        pages.add(ItemFragment.newInstance(3));
        pages.add(HoursFragment.newInstance());
        pages.add(DaysFragment.newInstance());
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(R.string.hours);
        tabLayout.getTabAt(1).setText(R.string.days);
    }
}
