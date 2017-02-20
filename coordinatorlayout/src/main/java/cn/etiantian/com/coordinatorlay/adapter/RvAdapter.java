package cn.etiantian.com.coordinatorlay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.etiantian.com.coordinatorlay.R;

/**
 * @author zhangliang
 * @version 1.0 , 2017/2/7 18:21
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.VH> {
    private List<String> list;
    private Context context;
    public RvAdapter(Context context, List<String>  list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_item, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class VH extends RecyclerView.ViewHolder{

        private final TextView tv;

        public VH(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.tv);
        }

        private void setData(int position){
            tv.setText(list.get(position));
        }
    }

}
