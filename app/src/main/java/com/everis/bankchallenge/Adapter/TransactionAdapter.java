package com.everis.bankchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.everis.bankchallenge.Model.Transaction;
import com.everis.bankchallenge.R;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private OnItemClickListener listener;
    private Context context;
    private ArrayList<Transaction> transactions;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.transaction_item, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction currentItem = transactions.get(position);

        holder.textViewTransactionNature.setText(currentItem.getTitle());
        holder.textViewTransactionName.setText(currentItem.getDesc());
        holder.textViewBalance.setText(NumberFormat.getCurrencyInstance().format(currentItem.getValue()));

        String dataTest = DateFormat.getDateInstance(DateFormat.SHORT).format(currentItem.getDate());
        int i = 10;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = dateFormat.parse(currentItem.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFormat.applyPattern("dd/MM/yyyy");

        holder.textViewDate.setText(dateFormat.format(data));

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTransactionNature;
        public TextView textViewTransactionName;
        public TextView textViewDate;
        public TextView textViewBalance;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTransactionNature = itemView.findViewById(R.id.transaction_nature);
            textViewTransactionName = itemView.findViewById(R.id.transaction_name);
            textViewDate = itemView.findViewById(R.id.transaction_date);
            textViewBalance = itemView.findViewById(R.id.transaction_balance);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
