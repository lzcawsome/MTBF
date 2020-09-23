package com.example.signaldetect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChangeAdapter extends RecyclerView.Adapter<ChangeAdapter.ViewHolder> {

    ArrayList<ChangeBean>arrayList;
    SinalChangeActivity sinalChangeActivity;
    //第一个list用于填充recyclerview, 第二个用来获取上下文
    public ChangeAdapter(ArrayList<ChangeBean> arrayList, SinalChangeActivity sinalChangeActivity) {
        this.arrayList = arrayList;
        this.sinalChangeActivity = sinalChangeActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChangeBean changebean = arrayList.get(position);
        holder.changetime.setText(changebean.getChangetime());
        holder.SIM.setText(changebean.getSIM());
        holder.changetype.setText(changebean.getChangetype());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView changetime;
        TextView SIM;
        TextView changetype;

        public ViewHolder(View view) {
            super(view);
            changetime=view.findViewById(R.id.errotime);
            SIM=view.findViewById(R.id.erroSIM);
            changetype=view.findViewById(R.id.errotype);
        }

    }
}
