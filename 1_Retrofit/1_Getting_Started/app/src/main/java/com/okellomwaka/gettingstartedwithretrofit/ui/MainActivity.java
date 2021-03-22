package com.okellomwaka.gettingstartedwithretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.okellomwaka.gettingstartedwithretrofit.api.ServiceGenerator;
import com.okellomwaka.gettingstartedwithretrofit.ui.adapter.GitHubRepoAdapter;
import com.okellomwaka.gettingstartedwithretrofit.R;
import com.okellomwaka.gettingstartedwithretrofit.api.model.GitHubRepo;
import com.okellomwaka.gettingstartedwithretrofit.api.service.GitHubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.repositoryList);


        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);

        Call<List<GitHubRepo>> call = client.reposForUser("Stallion67");


        call.enqueue(new Callback<List<GitHubRepo>>() {
                         @Override
                         public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                             //Succesfull
                             List<GitHubRepo> repo = response.body();

                             //Attaching the tlist view
                             listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repo));
                         }

                         @Override
                         public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
//Falied
                             Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                         }
                     }
        );

    }
}