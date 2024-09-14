package com.besome.sketch.editor.view.item;

import a.a.a.sy;
import a.a.a.wB;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.appcompat.widget.AppCompatEditText;
import com.besome.sketch.beans.ViewBean;

public class ItemEditText extends AppCompatEditText implements sy {

    public ViewBean viewBean;

    public boolean selected;

    public boolean fixed;

    public Paint paint;

    public float oneDp;

    public Drawable background;

    public ItemEditText(Context context) {
        super(context);
        initialize(context);
    }

    public void initialize(Context context) {
        this.oneDp = wB.a(context, 1.0f);
        this.paint = new Paint(1);
        this.paint.setColor(-1785080368);
        setDrawingCacheEnabled(true);
        setFocusable(false);
        this.background = getBackground();
    }

    @Override
    public ViewBean getBean() {
        return this.viewBean;
    }

    @Override
    public boolean getFixed() {
        return this.fixed;
    }

    public boolean getSelection() {
        return this.selected;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (this.selected) {
            canvas.drawRect(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), this.paint);
        }
        super.onDraw(canvas);
    }

    @Override
    public void setBackgroundColor(int color) {
        if (color == 16777215) {
            setBackground(this.background);
        } else {
            super.setBackgroundColor(color);
        }
    }

    @Override
    public void setBean(ViewBean viewBean) {
        this.viewBean = viewBean;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        float oneDp = this.oneDp;
        super.setPadding((int) (left * oneDp), (int) (top * oneDp), (int) (right * oneDp), (int) (bottom * oneDp));
    }

    @Override
    public void setSelection(boolean selected) {
        this.selected = selected;
        invalidate();
    }
}