package com.example.pupil.retrofit;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DataModel> {
    private RecyclerView list;
    private TextView title;
    private TextView url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= findViewById(R.id.list);
        title=findViewById(R.id.title);
        url=findViewById(R.id.url);
        getRecipe();

    }

    private void getRecipe() {
        Call<DataModel> call = Service.getApi().getRecipe();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call call, Response response) {
        DataModel dataModel= (DataModel) response.body();//получаем даа мдел, котрорая имеет титл и тд, нам нужно вывести ссылкуу, тайтл
        url.setText((dataModel)!=null?dataModel.getHref():null);
        list.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        title.setText((dataModel)!=null?dataModel.getTitle():null);
        list.setAdapter(new RecipeAdapter(dataModel.getResults()));
        list.getAdapter().notifyDataSetChanged();
    }//хооший ответ код 200

    @Override
    public void onFailure(Call call, Throwable t) {//

    }
}