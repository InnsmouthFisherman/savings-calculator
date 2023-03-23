package com.example.telescope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
/// Имеется отличный астрономический телескоп стоимостью 14 000 серебряных
//монет (далее монет)
//На счету имеется 1 000 монет и ежемесячно поступает стипендия в размере
//2 500 монет из которых все средства можно отложить на телескоп
//Ваши накопления хранятся в банке под 5 % годовых
//Необходимо рассчитать, за сколько времени при данных условиях можно
//накопить на телескоп, ответ необходимо вывести на экран приложения
// На начальном этапе приложение ждет ввода всех данных и нажатия на кнопку
// после нажатия и вызова метода onClick из необходимой суммы денег вычитаются имеющиеся средства
// разность делится на ежемесячный доход, и если необходимое время превышает 12 месяцев в расчет
// идут проценты годовые

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText account = findViewById(R.id.account);
            EditText goal = findViewById(R.id.goal);
            EditText income = findViewById(R.id.income);
            EditText percent = findViewById(R.id.percent);
            int g = Integer.parseInt(goal.getText().toString());
            int a = Integer.parseInt(account.getText().toString());
            int i = Integer.parseInt(income.getText().toString());
            int p = Integer.parseInt(percent.getText().toString());
            int month = 0;
            while(a < g){
                a += i;
                if(month % 12 == 0 && month != 0) {
                    month = 1;
                    a = a + a * p;
                }
                month += 1;
            }
            TextView text = findViewById(R.id.textView);
            text.setText("Потребуется: " + month + " месяцев");
        }
    };
}