package com.example.javamenu.Activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamenu.Adapter.SeasonListAdapter;
import com.example.javamenu.R;
import com.example.javamenu.domain.FoodDomain;

import java.util.ArrayList;

public class SeasonActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodListFirst;
    private RecyclerView recyclerViewFood;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seson_list);

        initView();
        initRecyclerView();
        setVariable();

    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }
    private void initRecyclerView() {
        ArrayList<FoodDomain> itemsFirst = new ArrayList<>();

        recyclerViewFood = findViewById(R.id.cart_seasonView);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        itemsFirst.add(new FoodDomain(
                "Рисовый Пудинг",
                "Если хочется разнообразить свой завтрак и начать утро вкусно, чтобы оно было по-настоящему добрым, значит, \n" +
                        "пора готовить рисовый пудинг с карамельными фруктами. И это не привычная нам рисовая каша. \n" +
                        "Это нечто большее — нежнейший кремовый десерт, оторваться от которого просто невозможно. Хочется съесть всё.\n" +
                        "\n" +
                        "И готовится пудинг из самых простых ингредиентов, которые найдутся на кухне у каждой хозяйки. \n" +
                        "А сколько вариаций этого десерта можно придумать! Добавить в него шоколад, солёную карамель, фруктовый соус или свежие ягоды. \n",
                "Для рисового пудинга:\n" +
                        "рис сорта Арборио 100 г\n" +
                        "вода 200 г\n" +
                        "молоко 200 г\n" +
                        "яичный желток 1 шт.\n" +
                        "масло сливочное 10 г\n" +
                        "цедра лимона 1 лимон\n" +
                        "соль 1 щепотка\n" +
                        "Для карамельных фруктов:\n" +
                        "масло сливочное 40 г\n" +
                        "мёд 2 ч. ложки\n" +
                        "яблоко 1 шт.\n" +
                        "груша 1 шт.\n" +
                        "банан 1 шт.\n" +
                        "изюм 50 г",
                "rice_pudding",
                12,
                60,
                110));

        adapterFoodListFirst = new SeasonListAdapter(itemsFirst);
        recyclerViewFood.setAdapter(adapterFoodListFirst);

    }
    private void initView() {
        backBtn = findViewById(R.id.backBtn);
    }
}

