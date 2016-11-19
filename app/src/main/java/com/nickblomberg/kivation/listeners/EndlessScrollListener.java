package com.nickblomberg.kivation.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {
    private int visibleThreshold = 5;
    private int startingPageIndex = 1;
    private int currentPage = 1;
    private int previousTotalItemCount = 0;
    private boolean loading = true;

    RecyclerView.LayoutManager mLayoutManager;

    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int lastVisibleItemPosition = 0;
        int totalItemCount = mLayoutManager.getItemCount();

        lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();

        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex;
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }

        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
            currentPage++;
            onLoadMore(currentPage, totalItemCount);
            loading = true;
        }
    }

    public abstract void onLoadMore(int page, int totalItemsCount);
}
