package com.example.javamenu.Activity;

import android.os.Bundle;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamenu.Adapter.ButtonsListAdapter;
import com.example.javamenu.R;
import com.example.javamenu.domain.FoodDomain;

import java.util.ArrayList;

public class FirstListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodListFirst;
    private RecyclerView recyclerViewFood;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstblyd_list);

        initView();
        setVariable();
        initRecyclerView();
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }
    private void initRecyclerView() {
        ArrayList<FoodDomain> itemsFirst = new ArrayList<>();

        recyclerViewFood = findViewById(R.id.cart_viewFirstblyd);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        itemsFirst.add(new FoodDomain(
                "Крем Суп",
                "Cуп-пюре из тыквы со сливочным сыром и сухариками, это очень вкусно! \n",
                "тыква (очищенная) 600 г\n" +
                        "лук 1 шт. (150 - 200 г)\n" +
                        "морковь 1 - 2 шт. (200 - 250 г)\n" +
                        "корень имбиря 30 г\n" +
                        "масло сливочное 70 г\n" +
                        "кокосовое молоко (можно заменить сливками 10%) 200 г\n" +
                        "соевый соус 3 ст. ложки\n" +
                        "вода 800 мл\n" +
                        "мускатный орех 1 ч. ложка\n" +
                        "перец чёрный\n" +
                        "соль\n" +
                        "Дополнительно\n" +
                        "хлеб белый 3 - 4 ломтика\n" +
                        "сыр сливочный 150 г\n",
                "pumpkin_soup",
                9,
                30,
                200));
        itemsFirst.add(new FoodDomain(
                "Cуп из кабачков",
                "Лёгкий и нежный овощной суп с красной рыбой — что ещё лучше можно предложить на званный обед в качестве первого блюда?! \n",
                "лосось 300-400 г\n" +
                        "вода 1 л\n" +
                        "кабачки 700 г\n" +
                        "картофель 200 г\n" +
                        "лук 150 г\n" +
                        "сливки 10-20% 200 мл\n" +
                        "соль 1 ч.\n" +
                        "перец чёрный молотый по вкусу\n" +
                        "масло растительное для обжарки\n",
                "krem_sup_iz_kabachka_s_lososem\n",
                10,
                45,
                150));
        itemsFirst.add(new FoodDomain(
                "Грибной крем-суп",
                "В некотором смысле этот суп будет «лёгкой прогулкой» для вашего желудка, который, быть может, скажет вам спасибо за эту лёгкость и питательность. \n",
                "картофель 500 г\n" +
                        "вода 600 мл\n" +
                        "грибы шампиньоны 250 г\n" +
                        "лук 150 г\n" +
                        "сливки 10-20% 200 г\n" +
                        "соль по вкусу\n",
                "mushroom_cream_soup",
                8,
                25,
                180));
        itemsFirst.add(new FoodDomain(
                "Куриный крем-суп",
                "Очень вкусный и нежный куриный крем-суп с правильной фактурой по оригинальному рецепту, который довольно сильно отличается от традиционных. \n",
                "куриное филе 300 г\n" +
                        "картофель 250 г\n" +
                        "лук 150 г\n" +
                        "морковь 100 г\n" +
                        "чеснок 2 зубчика\n" +
                        "вода 800 мл\n" +
                        "сливки 10-20% 200 мл\n" +
                        "соль ~1/2 ч. ложки\n",
                "chicken_soup",
                4,
                20,
                100));
        itemsFirst.add(new FoodDomain(
                "Сырный крем-суп",
                "Крем-суп из кабачка с лососем — лёгкий и нежный овощной суп с красной рыбой — что ещё лучше можно предложить на званный обед в качестве первого блюда?! \n",
                "овощной бульон 1 л\n" +
                        "лук-порей 100 г\n" +
                        "цветная капуста 250 г\n" +
                        "морепродукты 250 г\n" +
                        "сыр плавленый 330 г\n" +
                        "масло оливковое 2 ст. ложки\n" +
                        "куркума 1/2 ч. ложки\n" +
                        "мускатный орех 1/3 ч. ложки\n" +
                        "соль\n" +
                        "перец чёрный\n",
                "sirnij_sup_s_moreproduktami",
                10,
                50,
                50));

        adapterFoodListFirst = new ButtonsListAdapter(itemsFirst);
        recyclerViewFood.setAdapter(adapterFoodListFirst);
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
    }
}
