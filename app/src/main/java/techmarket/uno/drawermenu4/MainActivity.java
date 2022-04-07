package techmarket.uno.drawermenu4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import techmarket.uno.drawermenu4.adapter.DataAdapter;
import techmarket.uno.drawermenu4.adapter.ListItem;
import techmarket.uno.drawermenu4.adapter.RecOnClickListenerInterface;

public class MainActivity extends AppCompatActivity{
    private ImageView imageMenu;
    private DrawerLayout drawerLayout;
    private TextView textTitle;
    private TextView textItemText;
    private NavigationView navigationView;
    private NavItemSelectedListener onNavItemSelectedListener;
    private RecOnClickListenerInterface recOnClickListenerInterface;
    private DataAdapter dataAdapter;
    private List<ListItem> listData;
    private List<ListItem> listKeywords;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecOnClickListener();
        init();
        menuListener();

        imageMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
              }
           }
        );
    }

    void menuListener(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.planets:
                            updateMainList(getResources().getStringArray(R.array.planets),
                                    getResources().getStringArray(R.array.keywords));
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.stars:
                        updateMainList(getResources().getStringArray(R.array.stars),
                                getResources().getStringArray(R.array.keywords_stars));
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.travel:

                        break;
                }
                //Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                //item.setChecked(true);
                textTitle.setText(item.getTitle());

                return true;
            }
        });
    }

    private void updateMainList(String[] array, String[] titleArray){
        List<ListItem> list = new ArrayList<>();

         for(int i = 0; i < array.length; i++){
            ListItem item = new ListItem();
            item.setText(array[i]);
            item.setText_title(titleArray[i]);
            item.setFavorite(false);
            list.add(item);
        }
        dataAdapter.updateList(list);
    }
    private void setRecOnClickListener(){
        recOnClickListenerInterface = new RecOnClickListenerInterface() {
            @Override
            public void onItemClicked(int position) {
                Toast.makeText(MainActivity.this, "Postion = " + position, Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void init(){
        drawerLayout = findViewById(R.id.drawerLayout);
        imageMenu = findViewById(R.id.imageMenu);
        textTitle = findViewById(R.id.textTitle);
        textItemText = findViewById(R.id.textItemText);
        navigationView = findViewById(R.id.navigationView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        listData = new ArrayList<>();
        listKeywords = new ArrayList<>();

        String[] mainArray = getResources().getStringArray(R.array.planets);
        String[] titleArray = getResources().getStringArray(R.array.keywords);

        for(int i = 0; i < mainArray.length; i++){
            ListItem item = new ListItem();
            item.setText(mainArray[i]);
            item.setText_title(titleArray[i]);
            item.setFavorite(false);
            listData.add(item);
        }
        dataAdapter = new DataAdapter(this,
                recOnClickListenerInterface,
                listData);
        recyclerView.setAdapter(dataAdapter);
    }
}
