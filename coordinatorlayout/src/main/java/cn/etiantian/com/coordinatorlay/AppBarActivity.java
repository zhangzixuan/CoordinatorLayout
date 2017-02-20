package cn.etiantian.com.coordinatorlay;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cn.etiantian.com.coordinatorlay.adapter.ViewPagerAdapter;
import cn.etiantian.com.coordinatorlay.fragment.OneFragment;
import cn.etiantian.com.coordinatorlay.fragment.ThreeFragment;
import cn.etiantian.com.coordinatorlay.fragment.TwoFragment;
import cn.etiantian.com.coordinatorlay.view.PopupMenu;

/**
 * @author zhangliang
 * @version 1.0 , 2017/2/7 15:14
 */

public class AppBarActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> titleList = new ArrayList<>();
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_appbar);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("hello world"); //放在下一句前，否则无效
        setSupportActionBar(toolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //处理toolbar右侧的菜单事件
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item:
                        showDialog();
                        break;
                    case R.id.item1:
                        showPopupWindow();
                        break;

                }
                return true;
            }
        });

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();

        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        fragmentList.add(threeFragment);

        titleList.add("tab1");
        titleList.add("tab2");
        titleList.add("tab3");

        ViewPagerAdapter ad = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        vp.setAdapter(ad);
        tabs.setupWithViewPager(vp);


    }

    /**
     *  底部弹出框的实现 （2）popupWindow的实现
     */
    private void showPopupWindow() {
        PopupMenu popupMenu = new PopupMenu(this,this);
        popupMenu.showPopupWindow();
    }

    /**
     * 底部弹出框的实现 （1）dialog 实现
     */
    private void showDialog() {
        dialog = new Dialog(this, R.style.my_dialog);
        View view = View.inflate(this, R.layout.dialog_layout, null);

        Button btn_open_camera = (Button) view.findViewById(R.id.btn_open_camera);
        Button btn_chose_img = (Button) view.findViewById(R.id.btn_chose_img);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(this);
        btn_chose_img.setOnClickListener(this);
        btn_open_camera.setOnClickListener(this);

        dialog.setContentView(view);

        Window dialogWindow = dialog.getWindow();
        assert dialogWindow != null;
        dialogWindow.setWindowAnimations(R.style.dialog_style);  //animation

        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0; //x 新坐标   以(Gravity.BOTTOM)
        lp.y = -20; //y新坐标
        lp.width = getResources().getDisplayMetrics().widthPixels; //宽度

        view.measure(0,0);
        lp.height = view.getMeasuredHeight();
        lp.alpha = 9f;

        dialogWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(true);

        dialog.show();


    }

    /**
     * @param menu  创建toolbar的右侧菜单选择
     *              （1）menu.xml数据填充
     *              （2）对于toolbar上的ui元素也完全可以在toolbar标签里进行页面布局
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_open_camera:
                Toast.makeText(this, "相机", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_chose_img:
                Toast.makeText(this, "相册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                if (dialog != null && dialog.isShowing()){
                    dialog.dismiss();
                }
                break;
        }
    }
}
