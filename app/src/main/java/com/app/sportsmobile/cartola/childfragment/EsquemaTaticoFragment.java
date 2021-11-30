package com.app.sportsmobile.cartola.childfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.app.sportsmobile.cartola.R;

/**
 * Created by Edson on 20/01/2017.
 */
public class EsquemaTaticoFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_esquema_tatico, null);

        setHasOptionsMenu(true);

        return view;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_escalar_time, menu);
        menu.findItem(R.id.action_filtro).setVisible(false);
        menu.findItem(R.id.action_esquema_tatico).setVisible(true);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_esquema_tatico:
                MaterialDialog.Builder builder =  new MaterialDialog.Builder(getContext());
                builder.title(R.string.txt_escalar);
                builder.contentColor(Color.WHITE);
                builder.negativeText(R.string.txt_negativo);
                builder.titleGravity(GravityEnum.CENTER);
                builder.titleColorRes(R.color.white);
                builder.widgetColorRes(R.color.white);
                builder.buttonRippleColorRes(R.color.white);
                builder.backgroundColorRes(R.color.grey_hard);
                final CharSequence[] items = {"3-4-3","3-5-2","4-3-3","4-4-2","4-5-1","5-3-2","5-4-1" };
                builder.items(items);
                builder.itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        switch(which)
                        {
                            case 0:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 3-4-3 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 1:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 3-5-2 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 2:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 4-3-3 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 3:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 4-2-2 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 4:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 4-5-1 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 5:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.VISIBLE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.GONE);
                                Snackbar.make(view, "Esquema tático 5-3-2 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                            case 6:
                                view.findViewById(R.id.esquema_tatico_343).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_352).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_433).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_442).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_451).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_532).setVisibility(View.GONE);
                                view.findViewById(R.id.esquema_tatico_541).setVisibility(View.VISIBLE);
                                Snackbar.make(view, "Esquema tático 5-4-1 selecionado", Snackbar.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }

                });
                builder.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}