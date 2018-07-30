package com.example.ivstk.sannacodetesttask.ui.activities;

import android.content.Intent;
import android.os.PersistableBundle;
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
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Currently;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;
import com.example.ivstk.sannacodetesttask.presentation.presenter.ForecastPresenter;
import com.example.ivstk.sannacodetesttask.presentation.view.ForecastView;
import com.example.ivstk.sannacodetesttask.ui.fragments.ForecastFragment;
import com.example.ivstk.sannacodetesttask.utils.view.AppBarStateChangeListener;
import com.example.ivstk.sannacodetesttask.ui.adapters.SimplePagerAdapter;
import com.example.ivstk.sannacodetesttask.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastActivity extends MvpAppCompatActivity implements ForecastView,
        ForecastFragment.IFragmentReadyListener {
    private static final String KEY_SRL_ENABLED = "KEY_SRL_ENABLED";
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
    @BindView(R.id.tvHumidity)
    TextView tvHumidity;
    @BindView(R.id.tvLastSync)
    TextView tvLastSync;
    @BindView(R.id.tvPressure)
    TextView tvPressure;
    @BindView(R.id.tvSummary)
    TextView tvSummary;
    @BindView(R.id.tvTempDegrees)
    TextView tvTempDegrees;
    @BindView(R.id.tvWindSpeed)
    TextView tvWindSpeed;

    private List<Fragment> pages;

    @InjectPresenter
    ForecastPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupTabsNPages();
        setupSwipeRefreshLayout(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    private void setupSwipeRefreshLayout(Bundle savedInstanceState) {
        if (savedInstanceState != null)
            srl.setEnabled(savedInstanceState.getBoolean(KEY_SRL_ENABLED));
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putBoolean(KEY_SRL_ENABLED, srl.isEnabled());
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
        pages = new ArrayList<>();
        pages.add(ForecastFragment.newInstance(0));
        pages.add(ForecastFragment.newInstance(1));
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(R.string.hours);
        tabLayout.getTabAt(1).setText(R.string.days);
    }

    @Override
    public void showForecast(Forecast forecast, int city) {
        collapsingToolbar.setTitle(getString(city));
        fillHeader(forecast.getCurrently(), forecast.getSyncDate());
        ((ForecastFragment) pages.get(0)).showData(forecast.getHurly());
        ((ForecastFragment) pages.get(1)).showData(forecast.getDaily());
    }

    private void fillHeader(Currently currently, String lastSync) {
        tvHumidity.setText(getString(R.string.humidity, currently.getHumidity()));
        tvLastSync.setText(getString(R.string.last_sync, lastSync));
        tvPressure.setText(getString(R.string.pressure, currently.getPressure()));
        tvSummary.setText(getString(R.string.summmary, currently.getSummary()));
        tvTempDegrees.setText(String.valueOf(currently.getTemperature()));
        tvWindSpeed.setText(getString(R.string.wind, currently.getWindSpeed()));
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

    @Override
    public void setForecastFragment(ForecastFragment fragment, int position) {
        pages.set(position, fragment);
    }

    @Override
    public void onFragmentReady() {
        presenter.onCreateViewState();
    }
}
