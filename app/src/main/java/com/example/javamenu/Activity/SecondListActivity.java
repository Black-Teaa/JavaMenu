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

public class SecondListActivity extends AppCompatActivity {
    private ImageView backBtn;
    private RecyclerView.Adapter adapterFoodListSecond;
    private RecyclerView recyclerViewFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_list);

        initView();
        setVariable();
        initRecyclerView();
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }
    private void initRecyclerView() {
        ArrayList<FoodDomain> itemsSecond = new ArrayList<>();

        recyclerViewFood = findViewById(R.id.cart_viewSecondblyd);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        itemsSecond.add(new FoodDomain(
                "Курочка",
                "Бархатная курица по-китайски — волшебное блюдо восточной кухни в авторской интерпретации. \n" +
                " Куриное мясо получается очень нежным и сочным и совершенно не сухим, как это обычно бывает когда готовишь куриное филе в сковороде. \n" +
                " А какой аромат… Это надо видеть, то есть пробовать. \n" +
                " Божественный вкус! \n" +
                " Многие кто не есть курицу вообще после бархатной курицы по-китайски меняли свой кулинарные взгляды на жизнь. \n",
                "куриное филе 400 г\n" +
                        "яичный белок 1 шт.\n" +
                        "крахмал 1 ст. ложка + 1 ч. ложка\n" +
                        "уксус яблочный или винный 1 ч. ложка\n" +
                        "соль 1/2 ч. ложки\n" +
                        "лук 100-120 г\n" +
                        "чеснок 2 зубчика\n" +
                        "соевый соус 50 г\n" +
                        "мёд 50 г\n" +
                        "уксус бальзамический 1 ст. ложка (15 г)\n" +
                        "масло растительное для жарки\n",
                "kurica_po_kitaiski",
                12,
                50,
                120));
        itemsSecond.add(new FoodDomain(
                "Фрикадельки",
                "Фрикадельки в сливочном соусе — великолепное насыщенное вкусами второе блюдо, которое сочетается практически со всеми возможными гарнирами. \n" +
                        "Готовится просто, быстро и без редких ингредиентов. \n" +
                        "Сами фрикадельки получаются очень мягкие и нежными, буквально тающие во рту. \n" +
                        "И всё это благодаря удачному сочетанию входящих продуктов. \n" +
                        "Фрикадельки вкусны сами по себе, но в сочетании со сливочным соусом получается по-настоящему сочно и изысканно.\n",
                "фарш домашний 400 г\n" +
                        "картофель отварной 100 г\n" +
                        "лук 100 г\n" +
                        "чеснок 2 зубчика\n" +
                        "яйцо 1 шт.\n" +
                        "сухари панировочные 50 г\n" +
                        "молоко 20 г\n" +
                        "соль 1 ч. ложка\n" +
                        "перец чёрный молотый по вкусу\n" +
                        "мускатный орех 1/4 ч. ложки\n" +
                        "Сливочный соус: \n" +
                        "сливки 20% 250 г\n" +
                        "вода 250 г\n" +
                        "мука 1,5 ст. ложки\n" +
                        "соль 1/2 ч. ложки\n" +
                        "м",
                "frikadelki_v_slivochnom_souse",
                10,
                45,
                98));
        itemsSecond.add(new FoodDomain(
                "Картошка с грибами",
                "Картошка с лисичками в горшочках, \n" +
                        "приготовленная в духовке, может стать отличным обеденным блюдом для всей семьи.\n" +
                        " Любые лесные грибы, а тем более лисички, идеально сочетаются с картофелем.\n" +
                        " Этот гастрономический дуэт очень удачно оттеняет сметанный соус с чесноком, свежей зеленью и любимыми специями.\n" +
                        "Использование глиняных горшочков для запекания позволяет усилить вкусовые свойства всех составляющих блюда – \n" +
                        "в процессе запекания все ароматы и вкусы смешиваются и насыщаются друг другом, получается не только очень сытно, но и невероятно вкусно!\n",
                "грибы лисички 300 г\n" +
                        "картофель 400-450 г\n" +
                        "морковь 90 г\n" +
                        "сметана 200 г\n" +
                        "лук 75 г\n" +
                        "чеснок 1 зубчик\n" +
                        "петрушка 3-4 веточки\n" +
                        "масло растительное 80 г\n" +
                        "соль 1/2 ч. ложки\n" +
                        "хмели-сунели 1 ст. ложка",
                "kartoshka_s_lisichkami_v_gorshochke",
                13,
                60,
                110));
        itemsSecond.add(new FoodDomain(
                "Куриное рагу",
                "Овощное рагу с курицей — вкусное овощное блюдо с картофелем, кабачками и куриным филе.\n" +
                        " Это довольно простой рецепт, ничего сложного в приготовлении: порезал и добавил вовремя в сковороду. \n" +
                        "К такому блюду не требуется гарнир, что вдвойне удобно. \n" +
                        "Из-за крайне низкой калорийности рецепт подходит всем кто на диете и не хочет напрягать свой организм лишней пищевой нагрузкой.\n",
                "куриное филе 400 г\n" +
                        "картофель 400 г\n" +
                        "кабачки 400 г\n" +
                        "лук 200 г\n" +
                        "чеснок 2-3 зубчика\n" +
                        "морковь 100 г\n" +
                        "соль 1/2 ч. ложки\n" +
                        "перец чёрный молотый по вкусу\n" +
                        "масло растительное для жарки\n",
                "ovoschnoe_ragu_s_kuricej",
                4,
                70,
                80));
        itemsSecond.add(new FoodDomain(
                "Курица с рисом",
                "При современном ритме жизни,\n" +
                        "когда мы все постоянно куда-то спешим, экономия времени на кухне при приготовлении еды очень важна.\n" +
                        " Именно по этой причине блюда «два в одном»: \n" +
                        "гарнир и горячее второе блюдо – набирают популярность.\n",
                "куриные бёдра 700 г\n" +
                        "паприка копчёная 1 ч. ложка\n" +
                        "смесь сухих трав 1 ч. ложка\n" +
                        "куркума 1 ч. ложка\n" +
                        "масло сливочное 50 г\n" +
                        "лук 70 г\n" +
                        "рис 220 г\n" +
                        "вода 400 мл\n" +
                        "соль по вкусу\n",
                "zapechennye_kurinye_bedra_s_risom",
                7,
                120,
                160));


        adapterFoodListSecond = new ButtonsListAdapter(itemsSecond);
        recyclerViewFood.setAdapter(adapterFoodListSecond);
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
    }

}
