package hreday.sagar.post_retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {

    @POST("post")
    Call<LoginPojo> loginData(@Body LoginModel loginModel);
}
