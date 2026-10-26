package vn.edu.vhu.ltdd.a8fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "A8_231A290127";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        // Kiểm tra xem thiết bị hiện tại có ở bố cục tablet (sw600dp) hay không
        boolean isTablet = findViewById(R.id.detailContainer) != null;
        Log.d(TAG, "Chế độ bố cục: " + (isTablet ? "Tablet (Master-Detail)" : "Điện thoại (Đơn)"));

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.tab_home) {
                doiTab(new HomeFragment());
            } else if (id == R.id.tab_news) {
                doiTab(new NewsListFragment());
            } else if (id == R.id.tab_profile) {
                doiTab(ProfileFragment.newInstance("Bùi Quang Duy", "231A290127"));
            }
            return true;
        });

        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.tab_home);
        } else {
            Fragment current = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
            if (current != null) {
                capNhatGiaoDienTablet(current);
            }
        }
    }

    private void doiTab(Fragment f) {
        Log.d(TAG, "Chuyển tab sang: " + f.getClass().getSimpleName());
        getSupportFragmentManager()
                .beginTransaction()
                // NC4: Thêm hiệu ứng chuyển Fragment mượt mà giữa các tab (Fade In / Fade Out)
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragmentContainer, f)
                .setReorderingAllowed(true)
                .commit();

        capNhatGiaoDienTablet(f);
    }

    private void capNhatGiaoDienTablet(Fragment f) {
        View detail = findViewById(R.id.detailContainer);
        View divider = findViewById(R.id.divider);
        if (detail != null) {
            if (f instanceof NewsListFragment) {
                detail.setVisibility(View.VISIBLE);
                if (divider != null) divider.setVisibility(View.VISIBLE);
            } else {
                detail.setVisibility(View.GONE);
                if (divider != null) divider.setVisibility(View.GONE);
                Fragment detailFrag = getSupportFragmentManager().findFragmentById(R.id.detailContainer);
                if (detailFrag != null) {
                    getSupportFragmentManager().beginTransaction().remove(detailFrag).commit();
                }
            }
        }
    }
}
