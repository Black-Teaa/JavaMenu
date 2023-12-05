package com.example.javamenu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javamenu.Adapter.CartListAdapter;
import com.example.javamenu.Helper.ChangeNumberItemListener;
import com.example.javamenu.Helper.ManageCart;
import com.example.javamenu.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private TextView payBtn, feeTxt, totalTxt, emptyTxt;
    private ManageCart manageCart;
    private ScrollView scrollView;
    private ImageView backBtn;
    private Spinner spinBtn;
    private ConstraintLayout cons;
    private EditText cardNumberEditText, expiryDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        initView();
        manageCart = new ManageCart(CartActivity.this);
        initList();
        setVariable();
        Calculate();
        OnPayBtn();
        onCheck();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.pay_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBtn.setAdapter(adapter);
    }

    private void setVariable() {
        backBtn.setOnClickListener(v -> finish());
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(manageCart.getlistCart(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                Calculate();
            }
        });

        recyclerView.setAdapter(adapter);

        if (manageCart.getlistCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void Calculate() {
        double total = Math.round((manageCart.getTotalFee()) * 100.0) / 100;

        totalTxt.setText("$" + total);
    }

    private void OnPayBtn() {
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCurrency = spinBtn.getSelectedItem().toString();

                if (selectedCurrency.equals("Наличными")) {

                    manageCart.clearCart();
                    adapter.notifyDataSetChanged();

                    Toast.makeText(CartActivity.this, "Заказ обрабатывается, ожидайте доставки", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CartActivity.this, MenuListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else if (selectedCurrency.equals("По Карте")) {

                    manageCart.clearCart();
                    adapter.notifyDataSetChanged();

                    Toast.makeText(CartActivity.this, "Заказ обрабатывается, ожидайте доставки", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CartActivity.this, MenuListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void onCheck() {
        spinBtn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedCurrency = spinBtn.getSelectedItem().toString();
                if (selectedCurrency.equals("Наличными")) {
                    hideCreditCardFields();
                } else if (selectedCurrency.equals("По Карте")) {
                    showCreditCardFields();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

    }

    private void showCreditCardFields() {
        cons.setVisibility(View.VISIBLE);
    }

    private void hideCreditCardFields() {
        cons.setVisibility(View.GONE);
    }

    private void initView() {
        cons = findViewById(R.id.hide_constr);
        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        expiryDateEditText = findViewById(R.id.expiryDateEditText);
        spinBtn = findViewById(R.id.spinner_ccy);
        payBtn = findViewById(R.id.payBtn);
        feeTxt = findViewById(R.id.feeEachItem);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerView = findViewById(R.id.cart_view);
        scrollView = findViewById(R.id.scroll_view);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt = findViewById(R.id.Empty_Txt);
    }
}