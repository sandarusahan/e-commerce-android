package com.example.babycareapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.babycareapp.Models.Product;

public class Product_adapter extends RecyclerView.Adapter<Product_adapter.ProductViewHolder> {

    Product product;
    Product[] products;
    Context con;

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        final TextView product_name;
        final TextView product_price;
        final Button add_to_cart_btn;
        final ImageView product_image;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_price = (TextView) itemView.findViewById(R.id.product_price);
            add_to_cart_btn = (Button) itemView.findViewById(R.id.add_to_cart_btn);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);
        }
    }

    public Product_adapter(Product[] arr, Context context){
        this.products = arr;
        this.con = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_card, viewGroup, false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        this.product = this.products[i];
        productViewHolder.product_name.setText(product.getPname());
        productViewHolder.product_price.setText(Double.toString(product.getPprice()));
        Glide.with(con).load(product.getPimage()).into(productViewHolder.product_image);
    }

    @Override
    public int getItemCount() {
        return products.length;
    }
}
