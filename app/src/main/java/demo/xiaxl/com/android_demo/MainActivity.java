package demo.xiaxl.com.android_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import demo.xiaxl.com.android_demo.grid.MyReclcyeGridActivity;
import demo.xiaxl.com.android_demo.list.MyReclcyeListActivity;
import demo.xiaxl.com.android_demo.list.MyRecycleListAdapter;
import demo.xiaxl.com.android_demo.multilist.MyReclcyeMultiListActivity;
import demo.xiaxl.com.android_demo.pagersnaphelper.PagerSnapHelperActivity;

/**
 *
 */
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // list
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyReclcyeListActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // grid
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyReclcyeGridActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // multi list
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyReclcyeMultiListActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // multi list
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PagerSnapHelperActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


}
