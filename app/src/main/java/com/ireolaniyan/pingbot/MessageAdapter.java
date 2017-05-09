package com.ireolaniyan.pingbot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ire Olaniyan on 5/9/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {
    private List<String> mMessages;

    public static class MessageHolder extends RecyclerView.ViewHolder {
        public TextView mMessageTextView;
        public MessageHolder(TextView v){
            super(v);
            mMessageTextView = v;
        }
    }

    public MessageAdapter(List<String> messages){
        mMessages = messages;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
        MessageHolder vH = new MessageHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        holder.mMessageTextView.setText(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

}
