package cn.etiantian.com.coordinatorlay.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import cn.etiantian.com.coordinatorlay.R;


/**
 * @author zhangliang
 * @version 1.0 , 2017/2/16 15:36
 */

public class PopupMenu  implements View.OnClickListener{
    private Activity context;
    private final PopupWindow popupWindow;
    private View.OnClickListener clickListener;

    public PopupMenu(Activity context, View.OnClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
        final View view = View.inflate(context, R.layout.dialog_layout, null);
        Button btn_open_camera = (Button) view.findViewById(R.id.btn_open_camera);
        Button btn_chose_img = (Button) view.findViewById(R.id.btn_chose_img);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(this);
        btn_chose_img.setOnClickListener(this);
        btn_open_camera.setOnClickListener(this);

        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.style.popup_style);
        ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.popupWindow));
        popupWindow.setBackgroundDrawable(dw);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                break;
            default:
                clickListener.onClick(v);

        }
    }

    public void showPopupWindow(){
        // 得到当前activity的rootView
        View rootView = ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
        popupWindow.showAtLocation(rootView, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0,0);
    }
}
