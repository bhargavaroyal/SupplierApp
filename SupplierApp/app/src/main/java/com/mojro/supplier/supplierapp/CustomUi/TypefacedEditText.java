package com.mojro.supplier.supplierapp.CustomUi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.mojro.supplier.supplierapp.R;


/**
 * Created by bhargavagugamsetty on 1/08/16.
 */
public class TypefacedEditText extends EditText {
    public TypefacedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(attrs != null){
            final TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypefacedEditText);
            final int typefaceCode = styledAttrs.getInt(R.styleable.TypefacedEditText_font, -1);
            styledAttrs.recycle();
            if (isInEditMode()) {
                return;
            }
            if (typefaceCode == -1) {
                setTypeface(Typeface.DEFAULT);
            } else {
                final Typeface typeface = TypefaceCache.get(context.getAssets(), Typefaces.getTypeface(typefaceCode));
                setTypeface(typeface);
            }

        }

    }

    public TypefacedEditText(Context context) {
        super(context);
    }
}
