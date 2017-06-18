package com.datasoft.co_op360.presentation.fieldofficer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datasoft.co_op360.domain.model.MemberListData;
import com.datasoft.co_op360.presentation.fieldofficer.presenters.FoAutoProcessMemberListPresenter;
import com.datasoft.co_op360.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehedi on 4/3/17.
 */

public class FoAutoProcessMemberListAdapter extends RecyclerView.Adapter<FoAutoProcessMemberListAdapter.CardViewHolder> {

    Context context;
    List<MemberListData> memberListDatas = new ArrayList<>();
    LayoutInflater inflater;

    FoAutoProcessMemberListPresenter foAutoProcessMemberListPresenter;

    public FoAutoProcessMemberListAdapter(Context context, List<MemberListData> memberListDatas, FoAutoProcessMemberListPresenter foAutoProcessMemberListPresenter) {
        this.context = context;
        this.memberListDatas = memberListDatas;
        this.foAutoProcessMemberListPresenter = foAutoProcessMemberListPresenter;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FoAutoProcessMemberListAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.fo_auto_process_member_list_item, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(FoAutoProcessMemberListAdapter.CardViewHolder holder, int position) {
        holder.bind(memberListDatas.get(position), position + 1, foAutoProcessMemberListPresenter);
    }

    @Override
    public int getItemCount() {

        return memberListDatas.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tv_number;
        TextView tv_member_name;
        TextView tv_member_id;
        TextView tv_member_spouse;
        TextView tv_savings;
        TextView tv_share;
        TextView tv_loan;


        public CardViewHolder(View itemView) {
            super(itemView);

            tv_number = (TextView) itemView.findViewById(R.id.tv_number);
            tv_member_name = (TextView) itemView.findViewById(R.id.tv_member_name);
            tv_member_id = (TextView) itemView.findViewById(R.id.tv_member_id);
            tv_member_spouse = (TextView) itemView.findViewById(R.id.tv_member_spouse);
            tv_savings = (TextView) itemView.findViewById(R.id.tv_savings);
            tv_share = (TextView) itemView.findViewById(R.id.tv_share);
            tv_loan = (TextView) itemView.findViewById(R.id.tv_loan);
        }

        public void bind(final MemberListData memberListData, int number, final FoAutoProcessMemberListPresenter foAutoProcessMemberListPresenter) {

            tv_number.setText("" + number);
            tv_member_name.setText(memberListData.getmMemberName());
            tv_member_id.setText(memberListData.getmMemberID());
            tv_member_spouse.setText("Spouse : " + memberListData.getGetmMemberSpouse());
            tv_savings.setText("Savings : " + memberListData.getmSavingsAmount());
            tv_share.setText("Share : " + memberListData.getmShareAmount());
            tv_loan.setText("Loan : " + memberListData.getmLoanAmount());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foAutoProcessMemberListPresenter.itemClick(memberListData);
                }
            });

        }
    }
}
