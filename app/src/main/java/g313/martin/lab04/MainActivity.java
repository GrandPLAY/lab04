package g313.martin.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] price = new EditText[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk[0] = findViewById(R.id.cb_apple);
        chk[1] = findViewById(R.id.cb_strawberry);
        chk[2] = findViewById(R.id.cb_blueberry);
        chk[3] = findViewById(R.id.cb_potatoes);

        num[0] = findViewById(R.id.et_apple);
        num[1] = findViewById(R.id.et_strawberry);
        num[2] = findViewById(R.id.et_blueberry);
        num[3] = findViewById(R.id.et_potatoes);

        price[0] = findViewById(R.id.et_appleprice);
        price[1] = findViewById(R.id.et_strawberryprice);
        price[2] = findViewById(R.id.et_blueberryprice);
        price[3] = findViewById(R.id.et_potatoesprice);
    }

    public void onCalc(View v) {
        float sum = 0.0f;
        for (int i = 0; i < 4; i++)
        {
            if (chk[i].isChecked())
            {
                try
                {
                    int q = Integer.parseInt(num[i].getText().toString());
                    float p = Float.parseFloat(price[i].getText().toString());
                    if (q == 0 || p == 0)
                    {
                        Toast.makeText(this, "Ошибка в ячейке " +  chk[i].getText().toString() + ": нулевые значения", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (q < 0 || p < 0)
                    {
                        Toast.makeText(this, "Ошибка в ячейке " +  chk[i].getText().toString() + ": отрицательные значения", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    float val = q * p;
                    sum += val;
                    Toast.makeText(this,chk[i].getText().toString() + ": " + q + " шт. * "+ p + " $ = " + val + " $", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(this, "Ошибка в ячейке " +  chk[i].getText().toString() + ": неверные данные", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        Toast.makeText(this,"Итого: " + sum + " $", Toast.LENGTH_SHORT).show();
    }
}