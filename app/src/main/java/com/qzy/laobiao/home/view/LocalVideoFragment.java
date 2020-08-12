package com.qzy.laobiao.home.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.qzy.laobiao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalVideoFragment extends Fragment {

    public LocalVideoFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_video, container, false);
    }
}

    //    @BindView(R.id.local_ref)
//    SwipeRefreshLayout local_ref;
//    @BindView(R.id.local_ry)
//    RecyclerView local_ry;

//    private ViewPagerLayoutManager viewPagerLayoutManager;
//    /** 当前播放视频位置 */
//    private int curPlayPos = -1;
//    private FullScreenVideoView videoView;
//    private ImageView ivCurCover;
//    private int oldPosition;

//    @Override
//    protected int getLayoutRes() {
//        return R.layout.fragment_local_video;
//    }
//
//    @Override
//    protected void initView() {
//        super.initView();
//        adapter = new VideoAdapter(getContext(), DataCreate.datas);
//        local_ry.setAdapter(adapter);
//        videoView = new FullScreenVideoView(getContext());
//        setViewPagerLayoutManager();
//        setRefreshEvent();
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        videoView.start();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        videoView.pause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        videoView.stopPlayback();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (videoView != null) {
//            videoView = null;
//        }
//    }
//
//    private void setRefreshEvent() {
//        local_ref.setColorSchemeResources(R.color.color_link);
//        local_ref.setOnRefreshListener(() -> new CountDownTimer(1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                local_ref.setRefreshing(false);
//            }
//        }.start());
//    }
//
//
//
//    private void setViewPagerLayoutManager() {
//        viewPagerLayoutManager = new ViewPagerLayoutManager(getContext());
//        local_ry.setLayoutManager(viewPagerLayoutManager);
//
//        viewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
//            @Override
//            public void onInitComplete() {
//                Log.e("message","position:" + "进来了onInitComplete");
//                playCurVideo(PlayListActivity.initPos);
//            }
//
//            @Override
//            public void onPageRelease(boolean isNext, int position) {
//                if (position != oldPosition && ivCurCover != null) {
//                    ivCurCover.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position, boolean isBottom) {
//                Log.e("message","position:" + "进来了onPageSelected");
//                oldPosition = position;
//                playCurVideo(position);
//            }
//        });
//    }
//
//    private void playCurVideo(int position) {
//        Log.e("message","position:" + position);
//        Log.e("message","curPlayPos:" + curPlayPos);
//        Log.e("message","oldPosition:" + oldPosition);
//        if (position == curPlayPos) {
//            return;
//        }
//
//        View itemView = viewPagerLayoutManager.findViewByPosition(position);
//        if (itemView == null) {
//            return;
//        }
//
//        ViewGroup rootView = itemView.findViewById(R.id.rl_container);
//        ImageView ivPause = rootView.findViewById(R.id.iv_play);
//        ImageView ivCover = rootView.findViewById(R.id.iv_cover);
//        ivPause.setAlpha(0.4f);
//
//        //评论点赞事件
//
//
//        curPlayPos = position;
//
//        //切换播放器位置
//        dettachParentView(rootView);
//
//        autoPlayVideo(curPlayPos, ivCover);
//    }
//
//
//
//    /**
//     * 移除videoview父view
//     */
//    private void dettachParentView(ViewGroup rootView) {
//        //1.添加videoview到当前需要播放的item中,添加进item之前，保证ijkVideoView没有父view
//        ViewGroup parent = (ViewGroup) videoView.getParent();
//        if (parent != null) {
//            parent.removeView(videoView);
//        }
//        rootView.addView(videoView, 0);
//    }
//
//    /**
//     * 自动播放视频
//     */
//    private void autoPlayVideo(int position, ImageView ivCover) {
//        videoView.start();
//        videoView.setOnPreparedListener(mp -> {
//            mp.setLooping(true);
//            //延迟取消封面，避免加载视频黑屏
//            ivCurCover = ivCover;
//            ivCurCover.setVisibility(View.GONE);
//        });
//    }


//}
