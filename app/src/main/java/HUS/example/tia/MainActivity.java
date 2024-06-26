package HUS.example.tia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override//معالجة حدث اختيار عنصر من القائمة
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.itemSettings)
        {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.itemSingOut)
        {
            Toast.makeText(this, "signout", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.itemHistory)
        {
            Toast.makeText(this, "history", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    /**
     *  دالة مساعدة لفتح قائمة تتلقى
     *  برامترا للكائن الذي سبب فتح القائمة
     * @param v
     */
    public void showPopUpMenu(View v)
    {
        //بناء قائمة popup menu
        PopupMenu popup = new PopupMenu(this,v);//لكائن الذي سبب فتح القائمة v
                  //ملف القائمة
        popup.inflate(R.menu.popup_menu);

        popup.show();//فتح وعرض القائمة
    }

}