package com.antew.checkablemenus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main extends Activity {
    public enum Category { HOT, NEW, RISING, CONTROVERSIAL, TOP; }
    private Category mCategory = Category.HOT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
 
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
 
        MenuItem categoryHot = menu.findItem(R.id.category_hot);
        MenuItem categoryControversial = menu.findItem(R.id.category_controversial);
        MenuItem categoryNew = menu.findItem(R.id.category_new);
        MenuItem categoryTop = menu.findItem(R.id.category_top);
 
        switch (mCategory)
        {
            case CONTROVERSIAL: categoryControversial.setChecked(true); break;
            case HOT:           categoryHot.setChecked(true);           break;
            case NEW:           categoryNew.setChecked(true);           break;
            case TOP:           categoryTop.setChecked(true);           break;
        }
 
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        item.setChecked(true);
 
        switch (item.getItemId())
        {
            case R.id.category_controversial: mCategory = Category.CONTROVERSIAL; break;
            case R.id.category_hot:           mCategory = Category.HOT; break;
            case R.id.category_new:           mCategory = Category.NEW; break;
            case R.id.category_top:           mCategory = Category.TOP; break;
        }
 
        return super.onOptionsItemSelected(item);
    }
    
}