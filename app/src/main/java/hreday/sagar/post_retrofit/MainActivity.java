package hreday.sagar.post_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText editText, editText2;
    //private ApiInterface apiInterface;
    private TextView textView;

    LoginInterface loginInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView=findViewById(R.id.textId);


        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://httpbin.org/").addConverterFactory(GsonConverterFactory.create())
                .build();
        loginInterface = retrofit.create(LoginInterface.class);


    }

    public void onclick(View view) {

        String user = editText.getText().toString();
        String pass = editText2.getText().toString();


        LoginModel loginModel = new LoginModel(user, pass);

        final Call<LoginPojo> loginPojo = loginInterface.loginData(loginModel);

        loginPojo.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                textView.setText(response.body().getJson().getUsername()+"\n"+response.body().getJson().getPassword());

            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

            }
        });


    }
}
