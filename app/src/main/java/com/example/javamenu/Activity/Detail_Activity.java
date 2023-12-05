package com.example.javamenu.Activity;

//пофиксить кнопки плюс и минус чтобы не было меньше нуля и нельзя было заказть 0

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.javamenu.Helper.ManageCart;
import com.example.javamenu.R;
import com.example.javamenu.domain.FoodDomain;

public class Detail_Activity extends AppCompatActivity {
    private Button addCartBtn;
    private TextView plusBtn, minusBtn, titleTxt, feeTxt, descriptionTxt, numberOrderTxt, caloryTxt, timeTxt, ingred;
    private int  numberOrder = 1;
    private ManageCart manageCart;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        manageCart = new ManageCart(Detail_Activity.this);
        setVariable();
        getBundle();
    }
    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void getBundle() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            FoodDomain foodDomain = (FoodDomain) bundle.getSerializable("object");

            if (foodDomain != null) {
                String picUrl = foodDomain.getPicUrl();

                ImageView imageView = findViewById(R.id.food_pic);
                if (imageView != null && picUrl != null) {
                    int drawableResourceId = getResources().getIdentifier(picUrl, "drawable", getPackageName());

                    Glide.with(this)
                            .load(drawableResourceId)
                            .transform(new GranularRoundedCorners(30, 30, 0, 0))
                            .into(imageView);

                    titleTxt.setText(foodDomain.getTitle());
                    feeTxt.setText("$" + foodDomain.getPrice());
                    ingred.setText(foodDomain.getIngredients());
                    descriptionTxt.setText(foodDomain.getDescription());
                    numberOrderTxt.setText("" + numberOrder);
                    caloryTxt.setText(foodDomain.getEnergy() + " Калл");
                    timeTxt.setText(foodDomain.getTime() + " мин");
                    addCartBtn.setText("Добавить в корзину - $" + Math.round(numberOrder * foodDomain.getPrice()));

                    plusBtn.setOnClickListener(v -> {
                        numberOrder = numberOrder + 1;
                        numberOrderTxt.setText("" + numberOrder);
                        addCartBtn.setText("Добавить в корзину - $" + Math.round(numberOrder * foodDomain.getPrice()));
                    });

                    minusBtn.setOnClickListener(v -> {
                        if (numberOrder > 1) {
                            numberOrder = numberOrder - 1;
                            numberOrderTxt.setText("" + numberOrder);
                            addCartBtn.setText("Добавить в корзину - $" + Math.round(numberOrder * foodDomain.getPrice()));
                        }
                    });

                    addCartBtn.setOnClickListener(v -> {
                        foodDomain.setNumberinCart(numberOrder);
                        manageCart.insertFood(foodDomain);

                    });
                }
            }
        }
    }
    private void initView() {
        ingred = findViewById(R.id.ingredients_txt);
        addCartBtn = findViewById(R.id.add_toCartBtn);
        titleTxt = findViewById(R.id.title_Txt);
        feeTxt = findViewById(R.id.price_Txt);
        descriptionTxt = findViewById(R.id.description_txt);
        numberOrderTxt = findViewById(R.id.number_itemTxt);
        plusBtn = findViewById(R.id.plus_cardBtn);
        minusBtn = findViewById(R.id.minus_cardBtn);
        caloryTxt = findViewById(R.id.cal_txt);
        timeTxt = findViewById(R.id.time_txt);
        backBtn = findViewById(R.id.backBtn);

    }
}

