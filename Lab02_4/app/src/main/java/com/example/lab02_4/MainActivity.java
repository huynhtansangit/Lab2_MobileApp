package com.example.lab02_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etName;
    private Button btnSubmit;
    private RadioGroup rgType;
    private ListView lvEmployee;
    private ArrayList<Employees> employees = new ArrayList<Employees>();
    private ArrayAdapter<Employees> adapter = null;
    //Khai báo 1 employee object
    private Employees employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = (EditText) findViewById(R.id.et_ma_nv);
        etName = (EditText) findViewById(R.id.et_ten_nv);
        btnSubmit = (Button) findViewById(R.id.btn_nhap);
        rgType = (RadioGroup) findViewById(R.id.rg_loai_nv);
        lvEmployee = (ListView) findViewById(R.id.lv_nv);
        //đưa Data Source là các employee vào Adapter
        adapter = new ArrayAdapter<Employees>(this,
                android.R.layout.simple_list_item_1,employees);
        //đưa adapter vào ListView
        lvEmployee.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                addNewEmployee();
            }
        });
    }

                //Xử lý sự kiện nhập
    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        if (radId == R.id.rd_chinhthuc) {
            //tạo instance là FullTime
            employee = new FullTimeEmployees();
        }
        else
            {
                //Tạo instance là Partime
                employee = new PartTimeEmployees();
            }
        //FullTime hay Partime thì cũng là Employee
        // nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        employees.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
}
