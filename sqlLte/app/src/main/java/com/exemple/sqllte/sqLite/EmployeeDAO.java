package com.exemple.sqllte.sqLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.exemple.sqllte.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private SQLiteDatabase db;

    public EmployeeDAO(Context context) {
        DBHelper helper = new DBHelper(context);

        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Employee> get (String sql, String ...selectArgs){
        List<Employee> list = new ArrayList<>();
        Cursor  cursor = db.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()){
            Employee emp = new Employee();
            emp.setCode(cursor.getString(cursor.getColumnIndex("code")));
            emp.setName(cursor.getString(cursor.getColumnIndex("name")));
            emp.setLHP(cursor.getString(cursor.getColumnIndex("LHP")));

            list.add(emp);
        }
        return list;
    }
    public List<Employee> getAll(){
        String sql = "SELECT * FROM student";

        return get(sql);
    }

    public Employee getById(String code){
        String sql = "SELECT * FROM student WHERE code = ?";

        List<Employee> list = get(sql, code);

        return list.get(0);
    }
    public long insert(Employee emp){
        ContentValues values = new ContentValues();
        values.put("code",emp.getCode());
        values.put("name",emp.getName());
        values.put("LHP",emp.getLHP());

        return db.insert("student",null, values);

    }
    public long update(Employee emp){
        ContentValues values = new ContentValues();
        values.put("name",emp.getName());
        values.put("LHP",emp.getLHP());

        return db.update("student", values,"code=?",new String[]{emp.getCode()});

    }
    public int delete(String code){
        return db.delete("student","code=?",new String[]{code});
    }
}
