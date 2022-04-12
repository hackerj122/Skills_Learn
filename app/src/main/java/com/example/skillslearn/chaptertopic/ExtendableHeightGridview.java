package com.example.skillslearn.chaptertopic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;

public class ExtendableHeightGridview extends GridView {

    Boolean expended = false;

    public ExtendableHeightGridview(Context context) {
        super(context);
    }

    public ExtendableHeightGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendableHeightGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Boolean isExpanded(){
        return expended;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isExpanded()){
            int expandSpec = MeasureSpec.makeMeasureSpec(MEASURED_SIZE_MASK,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec,expandSpec);
            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
        }
        else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
         }

    }

    public void setExpended(Boolean expended){
        this.expended = expended;
    }
}
