package com.error41.verror41;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoRefuseCallInvitationButton;
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallActivity extends AppCompatActivity {

     EditText userIDET123;
     TextView heyuserTV;
   ZegoSendCallInvitationButton voicebtn, videobtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        userIDET123=findViewById(R.id.user_ET);
        heyuserTV=findViewById(R.id.hey_user_text_view);
        voicebtn=findViewById(R.id.voice_callbtn);
        videobtn=findViewById(R.id.video_callbtn);


        String userID=getIntent().getStringExtra("userID");
        heyuserTV.setText("hey"+userID);

        userIDET123.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                     String targetUserID= userIDET123.getText().toString().trim();
                     setVideoCall(targetUserID);
                     setVoiceCall(targetUserID);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    void setVoiceCall(String targetUserID){
        voicebtn.setIsVideoCall(false);
        voicebtn.setResourceID("zego_uikit_call");
        voicebtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID)));

    }

    void setVideoCall(String targetUserID){
           videobtn.setIsVideoCall(true);
        videobtn.setResourceID("zego_uikit_call");
      videobtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID)));

    }


}