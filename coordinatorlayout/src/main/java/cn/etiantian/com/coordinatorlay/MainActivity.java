package cn.etiantian.com.coordinatorlay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fab = (Button) findViewById(R.id.fab);
        Button appBarLayout = (Button) findViewById(R.id.appBarLayout);
        Button collapsing = (Button) findViewById(R.id.collapsing);
        fab.setOnClickListener(this);
        appBarLayout.setOnClickListener(this);
        collapsing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Intent intent = new Intent(MainActivity.this, FabActivity.class);
                startActivity(intent);
                break;
            case R.id.appBarLayout:
                Intent intent1 = new Intent(MainActivity.this, AppBarActivity.class);
                startActivity(intent1);
                break;
            case R.id.collapsing:
                Intent intent2 = new Intent(MainActivity.this, CollapsingToolbarActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
