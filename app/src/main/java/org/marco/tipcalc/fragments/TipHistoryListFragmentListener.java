package org.marco.tipcalc.fragments;

/**
 * Created by Angel on 05/06/16.
 */
import org.marco.tipcalc.model.TipRecord;

public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
