package cn.etiantian.com.coordinatorlay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.etiantian.com.coordinatorlay.R;
import cn.etiantian.com.coordinatorlay.adapter.RvAdapter;

/**
 * @author zhangliang
 * @version 1.0 , 2017/2/7 18:13
 */

public class TwoFragment extends Fragment {

    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        //initData();
        //initView(view);
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("我是猫抱的小行家");
        }
    }

    private void initView(View view) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        RvAdapter rvAdapter = new RvAdapter(getContext(), list);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(rvAdapter);


    }


}
