package com.example.user.androidfcmdemo.Service;

import com.example.user.androidfcmdemo.Common;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();/*取一段文字給refreshedToken*/
        Common.token=refreshedToken;/*再給Common String結構的token*/

    }
}
