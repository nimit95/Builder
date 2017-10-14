package com.uhack.builder.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nimit on 14/10/17.
 */

public class InventoryListAdapter extends RecyclerView.Adapter<InventoryListAdapter.InventoryListViewHolder> {

    @Override
    public InventoryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(InventoryListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class InventoryListViewHolder extends RecyclerView.ViewHolder{

        public InventoryListViewHolder(View itemView) {
            super(itemView);
        }
    }
}
