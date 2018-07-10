package demo.xiaxl.com.android_demo.pagersnaphelper;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

import demo.xiaxl.com.android_demo.R;
import demo.xiaxl.com.android_demo.list.MyRecycleListAdapter;

public class PagerSnapHelperActivity extends Activity {

    /**
     * UI
     */
    // recycleView
    private RecyclerView mRecyclerView = null;
    // adapter
    private PagerSnapHelperAdapter mMyadapter = null;
    /**
     * 数据
     */
    //data
    private ArrayList<String> mDataList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_pager_activity);


        // -----------创建数据集-------------
        for (int i = 1; i < 100; i++) {
            mDataList.add("item" + i);
        }

        // 纵向List
        initUI();

    }

    /**
     * 纵向List
     */
    public void initUI() {
        /**
         *RecyclerView
         */
        // ---RecyclerView---
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_vertical);
        mRecyclerView.setNestedScrollingEnabled(false);
        // PagerSnapHelper
        PagerSnapHelper snapHelper = new PagerSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                int targetPos = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
                Log.e("xiaxl: ", "targetPos: " + targetPos);

                return targetPos;
            }

            @Nullable
            @Override
            public View findSnapView(RecyclerView.LayoutManager layoutManager) {
                View view = super.findSnapView(layoutManager);
                Log.e("xiaxl: ", "tag: " + view.getTag());
                return view;
            }
        };
        snapHelper.attachToRecyclerView(mRecyclerView);
        // ---布局管理器---
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // 默认是Vertical (HORIZONTAL则为横向列表)
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //
        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                /**
                 *  这么写是为了获取RecycleView的宽高
                 */
                // 创建Adapter，并指定数据集
                mMyadapter = new PagerSnapHelperAdapter(mDataList, mRecyclerView.getWidth(), mRecyclerView.getHeight());
                // 设置Adapter
                mRecyclerView.setAdapter(mMyadapter);
            }
        });
    }
}
