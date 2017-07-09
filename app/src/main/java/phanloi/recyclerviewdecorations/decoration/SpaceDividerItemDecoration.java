package phanloi.recyclerviewdecorations.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Copyright (c) 2017, VNG Corp. All rights reserved.
 *
 * @author Lio <loipn@vng.com.vn>
 * @version 1.0
 * @since June 24, 2017
 */

public class SpaceDividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int mSpaceHeight;
    private boolean mShowLastDivider;

    public SpaceDividerItemDecoration(int spaceHeight, boolean showLastDivider) {
        this.mSpaceHeight = spaceHeight;
        mShowLastDivider = showLastDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        boolean isLastItem = parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1;
        if (!isLastItem || mShowLastDivider) {
            outRect.bottom = mSpaceHeight;
        }
    }
}
