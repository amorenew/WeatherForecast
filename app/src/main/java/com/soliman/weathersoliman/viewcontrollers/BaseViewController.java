package com.soliman.weathersoliman.viewcontrollers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.soliman.weathersoliman.R;
import com.soliman.weathersoliman.utils.Util;

import java.util.HashMap;

public class BaseViewController extends AppCompatActivity {

    public final String MenuPositionTag = "MenuPosition";
    Toolbar toolbar;
    Drawer drawer;
    HashMap<Integer, Integer> menuMap = new HashMap<>();
    int menuIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_base);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void setTitle(String title) {
        toolbar.setTitle(title);
    }

    public void addNavigationDrawer() {

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (drawer.isDrawerOpen()) {
                            drawer.closeDrawer();
                        } else {
                            drawer.openDrawer();
                        }
                    }
                }
        );

        drawer = new DrawerBuilder().withActivity(this).build();

        drawer.addItem(addMenuItem(R.string.main, MainViewController.class));
        // drawer.addItem(addMenuItem(R.string.education_material, AboutUsViewController.class));
        //__________________________________________________________________________

        drawer.addItem(new DividerDrawerItem());
        drawer.addItem(addChangeLanguageItem());
        // drawer.addItem(new SecondaryDrawerItem().withName(R.string.change_language).withIconColor(Color.BLUE));
        drawer.addItem(addLogOutItem());
        //  drawer.openDrawer();
        drawer.setSelectionAtPosition(0);
    }

    public PrimaryDrawerItem addMenuItem(int name, final Class<?> controller) {
        menuMap.put(name, menuIndex);
        menuIndex++;
        return new PrimaryDrawerItem().withName(name).withIconColor(Color.BLACK).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                if (drawer.getCurrentSelection() != position) {
                    Intent mainIntent = new Intent(BaseViewController.this, controller);
                    startActivity(mainIntent);
                    finish();
                }
                return false;
            }
        });
    }

    public PrimaryDrawerItem addChangeLanguageItem() {
        return new PrimaryDrawerItem().withName(R.string.change_language).withIconColor(Color.BLACK).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                if (drawer.getCurrentSelection() != position) {
                    Util.getInstance().changeLanguage(BaseViewController.this);
                }
                return false;
            }
        });
    }

    public PrimaryDrawerItem addLogOutItem() {
        return new PrimaryDrawerItem().withName(R.string.logout).withIconColor(Color.BLACK).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                if (drawer.getCurrentSelection() != position) {
                    Toast.makeText(getApplicationContext(), getString(R.string.logout), Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

    public void setMenuIndex(int name) {
        drawer.setSelectionAtPosition(menuMap.get(name));
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(BaseViewController.this, MainViewController.class);
        startActivity(mainIntent);
        finish();
    }

}
