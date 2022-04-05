package techmarket.uno.drawermenu4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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

public class MainActivity extends AppCompatActivity{
    private ImageView imageMenu;
    private DrawerLayout drawerLayout;
    private TextView textTitle;
    private NavigationView navigationView;
    private NavItemSelectedListener onNavItemSelectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        imageMenu = findViewById(R.id.imageMenu);
        textTitle = findViewById(R.id.textTitle);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                item.setChecked(true);
                textTitle.setText(item.getTitle());

                return true;
            }
        });

        imageMenu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
              }
           }
        );
    }
}

//    Menu m = navigationView.getMenu();
//        for(int i=0; i<m.size();i++) {
//        MenuItem mi = m.getItem(i);
//
//        //for aapplying a font to subMenu ...
//        SubMenu subMenu = mi.getSubMenu();
//        if (subMenu!=null && subMenu.size() > 0 ) {
//        for (int j=0; j <subMenu.size();j++) {
//        MenuItem subMenuItem = subMenu.getItem(j);
//        applyFontToMenuItem(subMenuItem);
//        }
//        }
//        //the method we have create in activity
//        applyFontToMenuItem(mi);
//        }

//    private void applyFontToMenuItem(MenuItem mi) {
//        if (MainActivity.this != null) {
//            Typeface font = Typeface.createFromAsset(MainActivity.this.getAssets(), getString(R.string.font3));
//            SpannableString mNewTitle = new SpannableString(mi.getTitle());
//            mNewTitle.setSpan(new CustomTypeFaceSpan("",  font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//            mi.setTitle(mNewTitle);
//        }
//    }

//textTitle.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        drawerLayout.openDrawer(GravityCompat.START);
//        }
//        });
