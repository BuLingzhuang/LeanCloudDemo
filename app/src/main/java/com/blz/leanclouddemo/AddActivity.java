package com.blz.leanclouddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.roger.gifloadinglibrary.GifLoadingView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddActivity extends AppCompatActivity {

    @Bind(R.id.add_etAuthor)
    EditText mEtAuthor;
    @Bind(R.id.add_etMusicName)
    EditText mEtMusicName;
    @Bind(R.id.add_etType)
    EditText mEtType;
    @Bind(R.id.add_etDuration)
    EditText mEtDuration;
    @Bind(R.id.add_btnSubmit)
    Button mBtnSubmit;
    private GifLoadingView mGifLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_btnSubmit)
    public void onClick() {
        btnSubmit();
    }

    public void btnSubmit() {
        String author = mEtAuthor.getText().toString();
        String musicName = mEtMusicName.getText().toString();
        String duration = mEtDuration.getText().toString();
        String type = mEtType.getText().toString();
        if (TextUtils.isEmpty(musicName)) {
            Toast.makeText(this, "歌曲名不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(author)) {
            Toast.makeText(this, "歌手名不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(duration)) {
            Toast.makeText(this, "时长不能为空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(type)) {
            Toast.makeText(this, "类型不能为空", Toast.LENGTH_SHORT).show();
        } else {
            isShowDialog(true);
            AVObject blzObject = new AVObject("MusicEntity");
            blzObject.put("musicName", musicName);
            blzObject.put("author", author);
            blzObject.put("duration", duration);
            blzObject.put("type", type);
            blzObject.saveInBackground(new SaveCallback() {
                @Override
                public void done(AVException e) {
                    if (e == null) {
                        Toast.makeText(AddActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AddActivity.this, String.valueOf(e.getCode()), Toast.LENGTH_SHORT).show();
                    }
                    isShowDialog(false);
                }
            });
        }
    }

    private void isShowDialog(boolean flag) {
        if (flag) {
            if (mGifLoadingView == null) {
                mGifLoadingView = new GifLoadingView();
                mGifLoadingView.setImageResource(R.drawable.num15);
                mGifLoadingView.show(getFragmentManager(),"");
            } else {
                mGifLoadingView.show(getFragmentManager(),"");
            }
        } else {
            mGifLoadingView.dismiss();
        }
    }

}
