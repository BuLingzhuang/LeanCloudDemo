package com.blz.leanclouddemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.blz.leanclouddemo.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by BuLingzhuang
 * on 2016/5/20
 * E-mail bulingzhuang@foxmail.com
 */
public class MusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<AVObject> mList;

    public MusicAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<>();
    }

    public void addAll(Collection<? extends AVObject> collection) {
        mList.clear();
        mList.addAll(collection);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_music, parent, false);
        return new MusicAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MusicAdapterViewHolder viewHolder = (MusicAdapterViewHolder) holder;
        AVObject avObject = mList.get(position);
        viewHolder.mTvMusicName.setText("歌曲名：" + avObject.getString("musicName"));
        viewHolder.mTvAuthor.setText("歌手：" + avObject.getString("author"));
        viewHolder.mTvType.setText("类型：" + avObject.getString("type"));
        viewHolder.mTvDuration.setText("时长：" + avObject.getString("duration"));
        if (position + 1 == mList.size()){
            viewHolder.mView.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.mView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private static class MusicAdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvMusicName;
        private final TextView mTvAuthor;
        private final TextView mTvType;
        private final TextView mTvDuration;
        private final View mView;

        public MusicAdapterViewHolder(View itemView) {
            super(itemView);
            mTvMusicName = (TextView) itemView.findViewById(R.id.item_music_musicName);
            mTvAuthor = (TextView) itemView.findViewById(R.id.item_music_author);
            mTvType = (TextView) itemView.findViewById(R.id.item_music_type);
            mTvDuration = (TextView) itemView.findViewById(R.id.item_music_duration);
            mView = itemView.findViewById(R.id.item_music_view);
        }
    }
}
