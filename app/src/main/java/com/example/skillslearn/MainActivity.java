package com.example.skillslearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.skillslearn.Pdf.PDFmain;
import com.example.skillslearn.authentication.LoginActivity;
import com.example.skillslearn.authentication.ProfileActivity;
import com.example.skillslearn.authentication.RegisterActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DrawerLayout
        DrawerLayout drawerLayout = findViewById(R.id.my_drawer);
        //navigation layout
        navigationView=findViewById(R.id.navigation_view);

        //Slider code
        toggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        //slider End

        //bottom navigation access
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        NavController navController = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        //bottom nav end
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        user= FirebaseAuth.getInstance().getCurrentUser();
    }

    //the slider toogle button func
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId() == R.id.profile){
            if(user != null) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
            else
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    //func end

    // slider Item Onclick function
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.pdf:
                startActivity(new Intent(MainActivity.this, PDFmain.class));
                break;
            case R.id.Video:
                Toast.makeText(this,"Video",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rate:
                Toast.makeText(this,"Rate US",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(this,"About US",Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }
    // function end
}