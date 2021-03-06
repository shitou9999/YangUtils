package com.ymz.baselibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ymz.baselibrary.R;


/**
 * @author: gyymz1993
 * 创建时间：2017/4/26 16:54
 **/
public class NavigationBarView extends RelativeLayout {

    private String letfText;
    private String rightText;
    private int letfTextColor;
    private int rightTextColor;
    private Drawable leftIcon;
    private Drawable rightIcon;
    private int bgColor;
    public String titleText;
    public View mView;

    public NavigationBarView(Context context) {
        this(context, null);
    }

    public NavigationBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public NavigationBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {// 得到自定义属性
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBarItem);
            leftIcon = ta.getDrawable(R.styleable.TopBarItem_leftIcon);
            rightIcon = ta.getDrawable(R.styleable.TopBarItem_rgihtIcon);
            titleText = ta.getString(R.styleable.TopBarItem_titles);
            letfText = ta.getString(R.styleable.TopBarItem_leftText);
            rightText = ta.getString(R.styleable.TopBarItem_rightText);
            bgColor = ta.getColor(R.styleable.TopBarItem_backgrounds, Color.parseColor("#000000"));
            letfTextColor = ta.getColor(R.styleable.TopBarItem_leftColor, Color.parseColor("#ffffff"));
            rightTextColor = ta.getColor(R.styleable.TopBarItem_rightColor, Color.parseColor("#ffffff"));
            ta.recycle();
        }
        mView = View.inflate(context, R.layout.navigation_default, this);// 将view添加。
        if (letfText != null) {
            setLeftText(letfText);
        }
        if (rightText != null) {
            setRightText(rightText);
        }
        if (leftIcon != null) {
            setleftImageResource(leftIcon);
        }
        if (rightIcon != null) {
            setleftImageResource(rightIcon);
        }
        if (titleText != null) {
            setTitleText(titleText);
        }
        setBackgroundColor(bgColor);
        setLeftTextColor(letfTextColor);
        setRightTextColor(rightTextColor);
    }

    public ImageView getLeftimageView(){
        return viewFindById(R.id.iv_left);
    }

    public <T extends View> T viewFindById(int id) {
        return (T) mView.findViewById(id);
    }

    public void setTitleText(String text) {
        TextView textView = viewFindById(R.id.title_tv);
        if (textView != null && text != null) {
            textView.setText(text);
        }
    }

    public void setLeftText(CharSequence text) {
        TextView textView = viewFindById(R.id.tv_left);
        if (textView != null && text != null) {
            textView.setText(text);
        }
    }

    public void setRightText(CharSequence text) {
        TextView textView = viewFindById(R.id.tv_right);
        if (textView != null && text != null) {
            textView.setText(text);
        }
    }

    public void setBackgroundColor(int color) {
        View view = viewFindById(R.id.title_bar);
        if (view != null && color != 0) {
            view.setBackgroundColor(color);
        }
    }

    public void setLeftTextColor(int color) {
        TextView view = viewFindById(R.id.tv_left);
        if (view != null && color != 0) {
            view.setTextColor(color);
        }
    }

    public void setRightTextColor(int color) {
        TextView view = viewFindById(R.id.tv_right);
        if (view != null && color != 0) {
            view.setTextColor(color);
        }
    }

    public void setLetfIocnOnClickListener(View.OnClickListener listener) {
        View view = viewFindById(R.id.iv_left);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    public void setLetfTextOnClickListener(View.OnClickListener listener) {
        View view = viewFindById(R.id.tv_left);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    public void setRightTextOnClickListener(View.OnClickListener listener) {
        View view = viewFindById(R.id.tv_left);
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    /**
     * 设置背景资源
     *
     * @param resourceId
     */
    public void setleftImageResource(Drawable resourceId) {
        ImageView imageView = viewFindById(R.id.iv_left);
        if (imageView != null) {
            imageView.setImageDrawable(resourceId);
        }
    }

    /**
     * 设置背景资源
     *
     * @param resourceId
     */
    public void setRightImageResource(Drawable resourceId) {
        ImageView imageView = viewFindById(R.id.iv_right);
        if (imageView != null) {
            imageView.setImageDrawable(resourceId);
        }
    }

}
