package com.example.thelendinghub.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thelendinghub.R;

public class LargeButton extends RelativeLayout {

    public LargeButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray tarry = context.obtainStyledAttributes(attrs,R.styleable.LargeButtonView);
        View v=null;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(!TextUtils.isEmpty(tarry.getString(R.styleable.LargeButtonView_setDirection))) {
            if (tarry.getString(R.styleable.LargeButtonView_setDirection).equalsIgnoreCase("ltr")) {
                v = inflater.inflate(R.layout.large_button_ltr,null,true);
            } else if (tarry.getString(R.styleable.LargeButtonView_setDirection).equalsIgnoreCase("rtl")) {
                v = inflater.inflate(R.layout.large_button_rtl,null,true);
            }
        }


        RelativeLayout btn_seco=v.findViewById(R.id.button_seco);
        TextView tvContinue=v.findViewById(R.id.tvContinue);
        ImageView imageViewArrow=v.findViewById(R.id.imageViewArrow);

        tvContinue.setText(tarry.getString(R.styleable.LargeButtonView_setTitle));
        tvContinue.setTextColor(Color.parseColor(tarry.getString(R.styleable.LargeButtonView_setTitleColor)));
        btn_seco.setBackground(tarry.getDrawable(R.styleable.LargeButtonView_setBackground));
        imageViewArrow.setImageDrawable(tarry.getDrawable(R.styleable.LargeButtonView_setArrow));
        imageViewArrow.setColorFilter(Color.parseColor(tarry.getString(R.styleable.LargeButtonView_setArrowColor)));
        addView(v);
        tarry.recycle();
    }


}
