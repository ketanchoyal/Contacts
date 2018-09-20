package com.ketanchoyal.contacts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context con;
    static Bitmap image;
    List<ContactModel> contactModels;

    public MyAdapter(List<ContactModel> contactModels) {
        this.contactModels = contactModels;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,number;
        CircleImageView call,contact_image,sms;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            call = itemView.findViewById(R.id.call);
            sms = itemView.findViewById(R.id.sms);
            contact_image = itemView.findViewById(R.id.contact_image);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        con = parent.getContext();

        View itemview = LayoutInflater.from(con).inflate(R.layout.single_contacts_layout,parent,false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final ContactModel model = contactModels.get(position);

        holder.name.setText(model.Cname);
        holder.number.setText(model.Cnumber);
        if(model.Cimage != null)
        {
            holder.contact_image.setImageBitmap(model.Cimage);
        }

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.makeCall(con,model.Cnumber);

            }
        });

        holder.sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent smsIntent = new Intent(con,Main2Activity.class);
                smsIntent.putExtra("number",model.Cnumber);
                smsIntent.putExtra("name",model.Cname);
                image = model.Cimage;
                con.startActivity(smsIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

}
