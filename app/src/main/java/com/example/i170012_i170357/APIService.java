package com.example.i170012_i170357;



import com.example.i170012_i170357.Notification.MyResponse;
import com.example.i170012_i170357.Notification.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAASYREBZw:APA91bGdGKWgQZgRHfR_nVpXfDe9QEimndf-vpy5XNznvx7affy2Lmy0k22FFs6DecwNrLW5uXrxEaxIGHH5-429UM4RN2-skGTm9THqRJ9rMQLQyD9zrpOLHeN6CWLyW6Ca3LusqR-c"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);

}