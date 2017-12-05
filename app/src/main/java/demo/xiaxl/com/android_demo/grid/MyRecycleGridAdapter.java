package demo.xiaxl.com.android_demo.grid;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */
public class MyRecycleGridAdapter extends RecyclerView.Adapter<MyRecycleGridAdapter.ViewHolder> {

    // 数据集
    private ArrayList<String> mDataList;

    //
    public MyRecycleGridAdapter(ArrayList<String> dataset) {
        super();
        this.mDataList = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.d("xiaxl: ", "---onCreateViewHolder---");
        Log.d("xiaxl: ", "viewType: " + viewType);
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
        // 创建一个ViewHolder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Log.d("xiaxl: ", "---onBindViewHolder---");
        Log.d("xiaxl: ", "position: " + position);
        // 绑定数据到ViewHolder上
        viewHolder.mTextView.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     *
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
