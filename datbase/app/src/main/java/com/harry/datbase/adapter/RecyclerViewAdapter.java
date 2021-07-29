package com.harry.datbase.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harry.datbase.R;
import com.harry.datbase.model.contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<contact> contactList;

    public RecyclerViewAdapter(Context context, List<contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    // Where to get the single card as viewholder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        Log.d("dbharry", "getting loaded");

        return new ViewHolder(view);
    }

    // What will happen after we create the viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        contact contact = contactList.get(position);
        holder.contactName.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhone_number());

    }

    // How many items?
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phone);
            iconButton = itemView.findViewById(R.id.pic);

            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Log.d("ClickFromViewHolder", "Clicked");
            int pos=this.getAdapterPosition();// position of this item which I click;
            contact contact = contactList.get(pos);// this contact we have;
            String name=contact.getName();
            String phone=contact.getPhone_number();
            Toast.makeText(context,"Position is : "+pos+ " Name : "+name+" Phone :"+phone,Toast.LENGTH_SHORT).show();

            // kisi dusri activity;
            Intent i= new Intent(context,display.class);
            i.putExtra("first",name);
            i.putExtra("second",phone);
            context.startActivity(i);// we use context. startactivity  becuase we are not, in main acitivit,

        }
    }
}

