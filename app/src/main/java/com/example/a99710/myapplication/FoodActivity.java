package com.example.a99710.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static com.example.a99710.myapplication.R.id.toolbar;

public class FoodActivity extends AppCompatActivity {

    private List<OrderInfo> mData = null;
    private Context mContext;
    private OrderAdapter mAdapter = null;
    private ListView list_order;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_table);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = FoodActivity.this;
        list_order = (ListView) findViewById(R.id.OrderList);
        mData = new LinkedList<OrderInfo>();
        mData.add(new OrderInfo(100, 20, R.drawable.cat,1,666,"华工生活区北门","华工c11楼下","Tony"));
        mData.add(new OrderInfo(120, 30, R.drawable.head1,(float)1.3,123,"华工生活区北门","华工c10楼下","Lisa"));
        mData.add(new OrderInfo(120, 22, R.drawable.head2,2,23345,"华工生活区西门","华工C14楼下","Jack"));
        mData.add(new OrderInfo(160, 10, R.drawable.head2,(float)0.5,23345,"华工生活区西门","华工C14楼下","Mei"));

        mAdapter = new OrderAdapter((LinkedList<OrderInfo>) mData, mContext);
        list_order.setAdapter(mAdapter);

        list_order.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(0, 0, 0, "接收订单");
            }
        });




        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add_order:
                        Intent intent=new Intent(FoodActivity.this,ReleaseActivity.class);
                        startActivityForResult(intent,1);
                        break;
                    case R.id.back:
                        finish();
                        break;
                    default:
                }
                return true;
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        switch(requestCode)
        {
            case 1:
                if(resultCode==RESULT_OK)
                {
                    OrderInfo order=(OrderInfo) data.getSerializableExtra("order");
                    mData.add(order);
                    mAdapter.notifyDataSetChanged();
                }
        }
    }



    private AdapterView.AdapterContextMenuInfo info;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 0:
                new AlertDialog.Builder(this).setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mData.remove(info.position);
                                mAdapter.notifyDataSetChanged();
                            }
                        }).setMessage("确认接单？").show();

                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
