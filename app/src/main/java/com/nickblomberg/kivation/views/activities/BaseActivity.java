package com.nickblomberg.kivation.views.activities;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.nickblomberg.kivation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A base activity to provide consistent components between different activities.
 */
public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.content) FrameLayout contentFrame;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mDrawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        super.setContentView(mDrawerLayout);
        ButterKnife.bind(this);

        getLayoutInflater().inflate(layoutResID, contentFrame, true);

        initNavView();
    }

    private void initNavView() {
        mNavigationView.setNavigationItemSelectedListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mDrawerLayout.closeDrawers();
        return onOptionsItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        mNavigationView.setCheckedItem(itemId);

        switch (itemId) {

            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.recent:
                startActivity(new Intent(this, NewestLoansActivity.class));
                break;

            case R.id.account:
                startActivity(new Intent(this, AccountActivity.class));
                break;

            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }

        mNavigationView.setCheckedItem(itemId);
        return super.onOptionsItemSelected(item);
    }
}
