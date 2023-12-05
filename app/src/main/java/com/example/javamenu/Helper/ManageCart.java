package com.example.javamenu.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.javamenu.domain.FoodDomain;

import java.util.ArrayList;

public class ManageCart {

    private Context context;
    private TinyDB tinyDB;


    public ManageCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void clearCart() {
        ArrayList<FoodDomain> emptyList = new ArrayList<>();
        tinyDB.putListObject("CartList", emptyList);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listfood = getlistCart();
         boolean existAlready = false;
         int n = 0;
         for (int y = 0; y < listfood.size(); y++) {
            if (listfood.get(y).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = y;
                break;
            }
        }
         if (existAlready) {
             listfood.get(n).setNumberinCart(item.getNumberinCart());
         } else {
             listfood.add(item);
         }
         tinyDB.putListObject("CartList", listfood);
         Toast.makeText(context, "Заказ добавлен в корзину", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getlistCart() {
        return tinyDB.getListObject("CartList");
    }

    public void minusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemListener changeNumberItemListener) {
        if (listfood.get(position).getNumberinCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberinCart(listfood.get(position).getNumberinCart() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemListener.changed();
    }
    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemListener changeNumberItemListener) {
        listfood.get(position).setNumberinCart(listfood.get(position).getNumberinCart() + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemListener.changed();
    }



    public Double getTotalFee() {
        ArrayList<FoodDomain> listfood2 = getlistCart();
        double fee = 0;
        for (int i = 0; i < listfood2.size(); i++) {
            fee = fee + (listfood2.get(i).getPrice() * listfood2.get(i).getNumberinCart());
        }
        return fee;
    }

}
