package org.marco.tipcalc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import org.marco.tipcalc.R;
import  org.marco.tipcalc.activities.TipDetailActivity;
import  org.marco.tipcalc.adapter.CustomRecyclerAdapter;
import  org.marco.tipcalc.adapter.OnItemClickListener;
import  org.marco.tipcalc.model.TipRecord;


public class TipHistoryListFragment extends Fragment implements OnItemClickListener, TipHistoryListFragmentListener {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private CustomRecyclerAdapter adapter;

    public TipHistoryListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new CustomRecyclerAdapter();
            adapter.setOnItemClickListener(this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(TipRecord element) {
        Intent i = new Intent(getActivity(), TipDetailActivity.class);

        i.putExtra(TipDetailActivity.TIP_KEY, element.getTip());
        i.putExtra(TipDetailActivity.BILL_TOTAL_KEY, element.getBill());
        i.putExtra(TipDetailActivity.DATE_KEY, element.getDateFormatted());
        startActivity(i);
    }

    @Override
    public void addToList(TipRecord record) {
        adapter.addElement(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }
}
