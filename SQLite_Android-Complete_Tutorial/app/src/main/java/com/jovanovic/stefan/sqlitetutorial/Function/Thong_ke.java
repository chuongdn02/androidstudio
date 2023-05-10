//package com.jovanovic.stefan.sqlitetutorial.Function;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.CompoundButton;
//import android.widget.ListView;
//import android.widget.RadioButton;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.jovanovic.stefan.sqlitetutorial.Model.report;
//import com.jovanovic.stefan.sqlitetutorial.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Thong_ke extends AppCompatActivity {
//
//    private RadioButton rbLoaiXe, rbLoiVP, rbViTri;
//    private Spinner spnLoaiXe, spnLoiVP, spnViTri;
//    private ListView lvViPham;
//    private TextView tvNoData;
//    private List<report> bienBanList;
//    private BienBanAdapter bienBanAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Ánh xạ view
//        rbLoaiXe = findViewById(R.id.rbLoaiXe);
//        rbLoiVP = findViewById(R.id.rbLoiVP);
//        rbViTri = findViewById(R.id.rbViTri);
//        spnLoaiXe = findViewById(R.id.spnLoaiXe);
//        spnLoiVP = findViewById(R.id.spnLoiVP);
//        spnViTri = findViewById(R.id.spnViTri);
//        lvViPham = findViewById(R.id.lvViPham);
//        tvNoData = findViewById(R.id.tvNoData);
//
//        // Khởi tạo danh sách biên bản và adapter
//        bienBanList = new ArrayList<>();
//        bienBanAdapter = new BienBanAdapter(this, bienBanList);
//
//        // Thiết lập adapter cho listview
//        lvViPham.setAdapter(bienBanAdapter);
//
//        // Lấy dữ liệu ban đầu và hiển thị
//        getAllBienBan();
//
//        // Sự kiện khi chọn radio button
//        rbLoaiXe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    spnLoaiXe.setVisibility(View.VISIBLE);
//                    spnLoiVP.setVisibility(View.GONE);
//                    spnViTri.setVisibility(View.GONE);
//
//                    // Lấy danh sách biên bản theo loại xe và hiển thị
//                    getAllBienBanTheoLoaiXe(spnLoaiXe.getSelectedItem().toString());
//                }
//            }
//        });
//        rbLoiVP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    spnLoaiXe.setVisibility(View.GONE);
//                    spnLoiVP.setVisibility(View.VISIBLE);
//                    spnViTri.setVisibility(View.GONE);
//                    getAllBienBanTheoLoiVP(spnLoiVP.getSelectedItem().toString());
//                }
//            }
//        });
//        rbViTri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    spnLoaiXe.setVisibility(View.GONE);
//                    spnLoiVP.setVisibility(View.GONE);
//                    spnViTri.setVisibility(View.VISIBLE);
//
//                    // Lấy danh sách biên bản theo vị trí và hiển thị
//                    getAllBienBanTheoViTri(spnViTri.getSelectedItem().toString());
//                }
//            }
//        });
//
//        // Sự kiện khi chọn loại xe
//        spnLoaiXe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                // Lấy danh sách biên bản theo lỗi vi phạm và hiển thị
//                getAllBienBanTheoLoiVP(spnLoiVP.getSelectedItem().toString());
//            }
//        }
//    });
//
//    rbViTri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            if (isChecked) {
//                spnLoaiXe.setVisibility(View.GONE);
//                spnLoiVP.setVisibility(View.GONE);
//                spnViTri.setVisibility(View.VISIBLE);
//
//                // Lấy danh sách biên bản theo vị trí và hiển thị
//                getAllBienBanTheoViTri(spnViTri.getSelectedItem().toString());
//            }
//        }
//    });
//
//    // Sự kiện khi chọn loại xe
//    spnLoaiXe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            getAllBienBanTheoLoaiXe(parent.getSelectedItem().toString());
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    });
//
//    // Sự kiện khi chọn lỗi vi phạm
//    spnLoiVP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            getAllBienBanTheoLoiVP(parent.getSelectedItem().toString());
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    });
//
//    // Sự kiện khi chọn vị trí
//    spnViTri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            getAllBienBanTheoViTri(parent.getSelectedItem().toString());
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    });
//}
//
//    // Phương thức lấy tất cả biên bản và hiển thị lên listview
//    private void getAllBienBan() {
//        bienBanList.clear();
//        bienBanList.addAll(BienBanDAO.getAllBienBan());
//        bienBanAdapter.notifyDataSetChanged();
//        if (bienBanList.isEmpty()) {
//            lvViPham.setVisibility(View.GONE);
//            tvNoData.setVisibility(View.VISIBLE);
//        } else {
//            lvViPham.setVisibility(View.VISIBLE);
//            tvNoData.setVisibility(View.GONE);
//        }
//    }
//
//    // Phương thức lấy biên bản theo loại xe và hiển thị lên listview
//    private void getAllBienBanTheoLoaiXe(String loaiXe) {
//        bienBanList.clear();
//        bienBanList.addAll(BienBanDAO.getAllBienBanTheoLoaiXe(loaiXe));
//        bienBanAdapter.notifyDataSetChanged();
//        if (bienBanList.isEmpty()) {
//            lvViPham.setVisibility(View.GONE);
//            tvNoData.setVisibility(View.VISIBLE);
//        } else {
//            lvViPham.setVisibility(View.VISIBLE);
//            tvNoData.setVisibility(View.GONE);
//        }
//    }
//
//// Phương thức lấy biên bản theo lỗi vi phạm và hiển thị lên listview
//private
