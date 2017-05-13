package com.ireolaniyan.pingbot;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class MessageFragment extends android.support.v4.app.DialogFragment {

    public final String LOG_TAG = MessageFragment.class.getSimpleName();

    final ArrayList<String> messages = new ArrayList<>();

    private EditText mComposeMessage;

    public MessageFragment() {
        // Required empty public constructor
    }

/*    public static MessageFragment newinstance(int title){
        MessageFragment m = new MessageFragment();

        Bundle args = new Bundle();
//        Key
        args.putInt("title", title);
        m.setArguments(args);
        return m;
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        int title = getArguments().getInt("title");

        View vw = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog, null);
        mComposeMessage = (EditText) vw.findViewById(R.id.dialog_compose_message);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(R.layout.fragment_dialog)
                .setTitle(R.string.compose_message_title)
                .setPositiveButton(R.string.dialog_send,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                doPositiveClick();
                            }
                        })
                .setNegativeButton(R.string.dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                doNegativeClick();
                            }
                        });
        return builder.create();
    }

    public void doPositiveClick(){
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setAction(Intent.ACTION_SEND);
        final String message = mComposeMessage.getText().toString();
        sendIntent.putExtra(Intent.EXTRA_TEXT, "hello");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
        messages.add(message);
        Log.i(LOG_TAG, "send button clicked");
    }

    public void doNegativeClick(){

        Log.i(LOG_TAG, "cancel button clicked");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }


}
