package com.example.javamenu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.javamenu.Adapter.FoodListAdapter;
import com.example.javamenu.R;
import com.example.javamenu.domain.FoodDomain;


import java.util.ArrayList;

public class MenuListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        initRecyclerView();
        bottomNavigationBar();
        navigationButtons();
    }
    public void navigationButtons() {
        LinearLayout first_btn = findViewById(R.id.first_btn);
        LinearLayout second_btn = findViewById(R.id.second_btn);
        LinearLayout third_btn = findViewById(R.id.third_btn);
        LinearLayout call_btn = findViewById(R.id.call_us);
        TextView goListSeason = findViewById(R.id.goSeasonList);
        TextView tellBtn = findViewById(R.id.tellBtn);

        first_btn.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this,  FirstListActivity.class)));
        second_btn.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this,  SecondListActivity.class)));
        third_btn.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this,  ThirdListActivity.class)));
        goListSeason.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this, SeasonActivity.class)));

        tellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+375 25 793 67 07";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "+375 25 780 24 74";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });
    }

    private void bottomNavigationBar() {
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout settBtn = findViewById(R.id.settings_btn);

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this, CartActivity.class)));
        settBtn.setOnClickListener(v -> startActivity(new Intent(MenuListActivity.this, SettingsActivity.class)));
    }
    private void initRecyclerView(){
        ArrayList<FoodDomain> items = new ArrayList<>();

        recyclerViewFood = findViewById(R.id.food_view_first);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        items.add(new FoodDomain(
                "Рататуй",
                "Очень вкусно, очень сочно и ярко - праздник каждый день! \n" +
                "Рататуй классический в духовке овощной запекается в томатном соусе. \n" +
                "Готовить его необычайно просто, любой новичок справится с первого раза. \n" +
                "На выходе вы получите красивое блюдо, которое можно подавать и на торжество! ",
                "Помидоры 300гр \n" +
                        "Кабачки 300гр \n" +
                        "Баклажаны 300гр \n" +
                        "Чеснок 2 зубчика \n" +
                        "Растительное масло 5 ст.л \n" +
                        "Смесь трав 3гр \n" +
                        "Перец черный 1гр \n" +
                        "Соль 1гр \n","ratatui",
                15,
                50,
                300));
        items.add(new FoodDomain("Карбонара",
                "Паста Карбонара — очень популярное блюдо итальянской кухни. \n" +
                "Это спагетти с кусочками гуанчиале (сыровяленые свиные щёки), смешанные с соусом из яиц, сыра пармезан, соли и свежемолотого черного перца. \n" +
                "Гуанчиале нередко заменяется панче́ттой (с итальянского pancetta — «грудинка» — разновидность бекона), \n" +
                " поэтому пусть вас не пугают названия незнакомых мясных продуктов итальянской кухни, \n" +
                "берите известные вам грудинку или бекон, только не копчённые. ",
                "спагетти 200 г \n" +
                        "бекон 150 г \n" +
                        "сливки 20% 150 мл \n" +
                        "сыр пармезан 50 г \n" +
                        "яичный желток 3 шт \n" +
                        "чеснок 2-3 зубчика \n" +
                        "масло растительное для жарки \n" +
                        "соль \n" +
                        "перец чёрный \n","karbonara",
                12,
                25,
                180));
        items.add(new FoodDomain("Панкейки",
                "Панкейки — это небольшие американские блинчики, но по форме и размеру они скорее напоминают наши оладьи. \n" +
                "Как правило, панкейки подаются на завтрак с различными сладкими соусами, шоколадом, ягодами, кленовым сиропом. \n" +
                "Раньше эти блинчики были очень популярным завтраком только в США и Канаде, \n " +
                "теперь же панкейками с удовольствием завтракают во всём мире, в том числе и в нашей стране. ",
                "молоко 210 г (мл) \n" +
                        "яйцо 1 шт. \n" +
                        "мука 200 г \n" +
                        "разрыхлитель 5 г (1 ч. ложка) \n" +
                        "масло растительное 25 г (2 ст. ложки) \n" +
                        "сахар 30 г (2 ст. ложки) \n" +
                        "соль 1/2 ч. ложки \n",
                "blinchiki",
                8,
                20,
                150));

        adapterFoodList = new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }
}