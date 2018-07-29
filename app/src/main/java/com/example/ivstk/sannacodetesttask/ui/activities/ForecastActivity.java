package com.example.ivstk.sannacodetesttask.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;
import com.example.ivstk.sannacodetesttask.presentation.presenter.ForecastPresenter;
import com.example.ivstk.sannacodetesttask.presentation.view.ForecastView;
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

public class ForecastActivity extends MvpAppCompatActivity implements ForecastView {
    private static final String TAG = "ForecastActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

    @InjectPresenter
    ForecastPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupSwipeRefreshLayout();
        setSupportActionBar(toolbar);
        setupTabsNPages();
        presenter.onCreate();
    }

    private void setupSwipeRefreshLayout() {
        srl.setOnRefreshListener(() -> presenter.onRefresh());
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED)
                    srl.setEnabled(true);
                else srl.setEnabled(false);
            }
        });
        srl.setColorSchemeResources(R.color.green, R.color.blue, R.color.red, R.color.yellow);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cities_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.onCitySelected(item.getItemId());
        return true;
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

    @Override
    public void showForecast(Forecast forecast, int city) {
        collapsingToolbar.setTitle(getString(city));
    }

    @Override
    public void showProgress() {
        srl.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        srl.setRefreshing(false);
    }

    @Override
    public void showErrorOccured() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.error_occured)
                .setMessage(R.string.please_try_later)
                .setPositiveButton(R.string.ok, null)
                .create();
        showDialog(dialog);
    }

    @Override
    public void showNetworkSettingsDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.failed_retrieve_data)
                .setMessage(R.string.wanna_go_to_settings)
                .setPositiveButton(R.string.yes, (dialog1, which) -> {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.SETTINGS");
                    startActivity(intent);
                })
                .setNegativeButton(R.string.no, null)
                .create();
        showDialog(dialog);
    }

    private void showDialog(AlertDialog dialog) {
        dialog.show();
    }
}
