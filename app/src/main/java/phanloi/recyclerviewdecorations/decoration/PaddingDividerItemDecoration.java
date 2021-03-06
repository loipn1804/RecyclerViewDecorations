package phanloi.recyclerviewdecorations.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since July 02, 2017
 */

public class PaddingDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int mDividerHeight;
    private int mPadding;
    private boolean mShowLastDivider;

    public PaddingDividerItemDecoration(Context context, int resId, int dividerHeight, int padding, boolean showLastDivider) {
        mDivider = ContextCompat.getDrawable(context, resId);
        mDividerHeight = dividerHeight;
        mPadding = padding;
        mShowLastDivider = showLastDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        boolean isLastItem = parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1;
        if (!isLastItem || mShowLastDivider) {
            outRect.bottom = mDividerHeight;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft() + mPadding;
        int right = parent.getWidth() - parent.getPaddingRight() - mPadding;

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
