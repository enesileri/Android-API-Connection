package com.beefyazilim.app.canlibilgiyarismasi.data.api;


import com.beefyazilim.app.canlibilgiyarismasi.data.model.AwardUserRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.AwardUserResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.GetUserInfoRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.GetUserInfoResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.GunuOduluResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.InitRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.InitResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.JokerDurumResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.JokerUpdateRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.LeaderBoardResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.LoginRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.LoginResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.MessageResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.ProfileUpdateRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.ProfileUpdateResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.QuestionRequest;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.QuestionResponse;
import com.beefyazilim.app.canlibilgiyarismasi.data.model.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiCall {


    @POST("api/Islemler/Register")
    Call<LoginResponse> callRegister(@Body RegisterRequest registerRequest);


    @POST("api/Islemler/Login")
    Call<LoginResponse> callLogin(@Body LoginRequest loginRequest);


    @POST("api/Islemler/GetUserInfo")
    Call<GetUserInfoResponse> callGetUserInfo(@Body GetUserInfoRequest getUserInfoRequest);


    @POST("api/Islemler/ProfileUpdate")
    Call<ProfileUpdateResponse> callProfileUpdate(@Body ProfileUpdateRequest profileUpdateRequest);


    @POST("api/Islemler/QuestionSend")
    Call<MessageResponse> callQuestionSend(@Body QuestionRequest questionRequest);


    @POST("api/Islemler/AwardUser")
    Call<LoginResponse> callAwardUser(@Body AwardUserRequest awardUserRequest);


    @GET("api/Islemler/GunuOdulu")
    Call<GunuOduluResponse> callGetAward();


    @GET("api/Islemler/GetQuestion")
    Call<ArrayList<QuestionResponse>> callGetQuestion();


    @GET("api/Islemler/GetLeaderBoard")
    Call<List<LeaderBoardResponse>> callGetLeaderBoard();

    @POST("api/Islemler/GetInit")
    Call<LoginResponse> callInit(@Body InitRequest initRequest);

    @POST("api/Islemler/JokerUpdate")
    Call<MessageResponse> callJokerUpdate(@Body JokerUpdateRequest jokerUpdateRequest);

    @GET("api/Islemler/JokerDurum")
    Call<JokerDurumResponse> callJokerDurum();


}
