package com.blz.leanclouddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.blz.leanclouddemo.adapters.MusicAdapter;
import com.blz.leanclouddemo.utils.Tools;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.main_rv)
    RecyclerView mRv;
    @Bind(R.id.main_btnAdd)
    Button mBtnAdd;
    @Bind(R.id.main_refresh)
    SwipeRefreshLayout mRefresh;
    private MusicAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initData();
    }

    private void init() {
        mRefresh.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);
        mRefresh.setOnRefreshListener(this);
        mAdapter = new MusicAdapter(this);
        mRv.setAdapter(mAdapter);
    }

    private void initData() {
        getData();
    }

    private void getData() {
        mRefresh.setRefreshing(true);
        AVQuery<AVObject> query = new AVQuery<>("MusicEntity");
        query.orderByAscending("createdAt");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (mRefresh.isRefreshing()) {
                    mRefresh.setRefreshing(false);
                }
                mAdapter.addAll(list);
            }
        });
    }

    @OnClick(R.id.main_btnAdd)
    public void onClick() {
        startActivity(new Intent(this, AddActivity.class));
    }

    @Override
    public void onRefresh() {
        getData();
    }
}
