package com.example.alexa.appdaw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alexa on 05/07/2018.
 */

public class AdapterUnits extends RecyclerView.Adapter<AdapterUnits.ThemesViewHolder> implements View.OnClickListener {
    ArrayList<ThemesUnits> listThemes;
    private View.OnClickListener listener;

    public AdapterUnits(ArrayList<ThemesUnits> listThemes) {
        this.listThemes = listThemes;

    }

    public ThemesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(layParams);

        view.setOnClickListener(this);

        return new ThemesViewHolder(view);
    }

    public void onBindViewHolder(ThemesViewHolder holder, int position) {
        holder.tex_name_theme.setText(listThemes.get(position).getNameTheme());
        if (UtilitiesUnits.PORTRAIT == true) {
            holder.tex_information_theme.setText(listThemes.get(position).getInfoTheme());
        }
        holder.ima_theme.setImageResource(listThemes.get(position).getImageThema());
    }

    @Override
    public int getItemCount() {
        return listThemes.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }

    }

    public class ThemesViewHolder extends RecyclerView.ViewHolder {
        TextView tex_name_theme, tex_information_theme;
        ImageView ima_theme;

        public ThemesViewHolder(View itemView) {
            super(itemView);
            tex_name_theme = (TextView) itemView.findViewById(R.id.tex_name_theme);
            if (UtilitiesUnits.PORTRAIT == true) {
                tex_information_theme = (TextView) itemView.findViewById(R.id.tex_info_theme);
            }

            ima_theme = (ImageView) itemView.findViewById(R.id.ima_theme);
        }

    }
}


