package demo.xiaxl.com.android_demo.multilist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import demo.xiaxl.com.android_demo.R;

/**
 *
 */
public class MyRecycleMultiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 数据集
    private ArrayList<String> mDataList;

    //
    public MyRecycleMultiListAdapter(ArrayList<String> dataset) {
        super();
        this.mDataList = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.d("xiaxl: ", "---onCreateViewHolder---");
        Log.d("xiaxl: ", "viewType: " + viewType);
        //
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case MuliListConstant.TYPE_ONE:
                // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
                View view = View.inflate(viewGroup.getContext(), R.layout.recycle_multilist_type_one, null);
                // 创建一个ViewHolder
                holder = new ViewHolderTypeOne(view);
                break;
            case MuliListConstant.TYPE_TWO:
                // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
                view = View.inflate(viewGroup.getContext(), R.layout.recycle_multilist_type_two, null);
                // 创建一个ViewHolder
                holder = new ViewHolderTypeTwo(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Log.d("xiaxl: ", "---onBindViewHolder---");
        Log.d("xiaxl: ", "position: " + position);
        // 绑定数据到ViewHolder上
        if (viewHolder instanceof ViewHolderTypeOne) {
            ViewHolderTypeOne mViewHolder = (ViewHolderTypeOne) viewHolder;
            mViewHolder.mTextView.setText(mDataList.get(position));
        } else if (viewHolder instanceof ViewHolderTypeTwo) {
            ViewHolderTypeTwo mViewHolder = (ViewHolderTypeTwo) viewHolder;
            mViewHolder.mTextView.setText(mDataList.get(position));
            mViewHolder.mImageView.setImageResource(R.mipmap.ic_launcher);
        }


    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // 双数为ITEM_ONE
        if (position % 2 == 0) {
            return MuliListConstant.TYPE_ONE;
        }
        // 单数为ITEM_TWO
        return MuliListConstant.TYPE_TWO;
    }

    /**
     * Item 1
     */
    public static class ViewHolderTypeOne extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolderTypeOne(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }

    /**
     * Item 2
     */
    public static class ViewHolderTypeTwo extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolderTypeTwo(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
