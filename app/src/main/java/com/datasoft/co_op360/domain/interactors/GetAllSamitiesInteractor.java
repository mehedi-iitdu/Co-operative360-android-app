package com.datasoft.co_op360.domain.interactors;

import com.datasoft.co_op360.domain.model.Samity;

import java.util.List;

/**
 * Created by mehedi on 6/18/17.
 */

public interface GetAllSamitiesInteractor {

    interface Callback {

        void onSamitiesRetrieved(List<Samity> samityList);
    }
}
