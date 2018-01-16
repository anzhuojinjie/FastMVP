package com.joey.loanmarket.ui.loan.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.joey.loanmarket.R;
import com.joey.loanmarket.base.BaseFragment;
import com.joey.loanmarket.util.Tool;
import com.joey.loanmarket.widget.RotateImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class LoanFragment extends BaseFragment {
    private static final String MENU_DATA_KEY = "name";
    private List<Map<String, String>> mMenuData1;
    private List<Map<String, String>> mMenuData2;
    private List<Map<String, String>> mMenuData3;
    private ListView mPopListView;
    private PopupWindow mPopupWindow;
    private SimpleAdapter mMenuAdapter1;
    private SimpleAdapter mMenuAdapter2;
    private SimpleAdapter mMenuAdapter3;
    private int supplierMenuIndex = 0;

    @BindView(R.id.around_supplier_list_tv_product)
    TextView mSupplierListTvProduct;
    @BindView(R.id.around_supplier_list_tv_sort)
    TextView mSupplierListTvSort;
    @BindView(R.id.around_supplier_list_tv_activity)
    TextView mSupplierListTvActivity;
    @BindView(R.id.around_supplier_list_iv_product)
    RotateImageView mSupplierListIvProduct;
    @BindView(R.id.around_supplier_list_iv_sort)
    RotateImageView mSupplierListIvSort;
    @BindView(R.id.around_supplier_list_iv_activity)
    RotateImageView mSupplierListIvActivity;
    @BindView(R.id.around_supplier_list_product)
    LinearLayout mSupplierListProduct;
    @BindView(R.id.around_supplier_list_sort)
    LinearLayout mSupplierListSort;
    @BindView(R.id.around_supplier_list_activity)
    LinearLayout mSupplierListActivity;

    public LoanFragment() {
        // Required empty public constructor
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_loan;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        initData();
        initPopMenu();
    }
    @OnClick({R.id.around_supplier_list_product,R.id.around_supplier_list_sort,R.id.around_supplier_list_activity})
    public void onClick(View view) {
        if (Tool.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.around_supplier_list_product:
                mSupplierListTvProduct.setTextColor(getResources().getColor(R.color.around_supplier_title_selected_color));
                mSupplierListIvProduct.doRotate(0,180,500);
                mPopListView.setAdapter(mMenuAdapter1);
                mPopupWindow.showAsDropDown(mSupplierListProduct, 0, 2);
                supplierMenuIndex = 0;
                break;
            case R.id.around_supplier_list_sort:
                mSupplierListTvSort.setTextColor(getResources().getColor(R.color.around_supplier_title_selected_color));
                mSupplierListIvSort.doRotate(0,180,500);
                mPopListView.setAdapter(mMenuAdapter2);
                mPopupWindow.showAsDropDown(mSupplierListSort, 0, 2);
                supplierMenuIndex = 1;
                break;
            case R.id.around_supplier_list_activity:
                mSupplierListTvActivity.setTextColor(getResources().getColor(R.color.around_supplier_title_selected_color));
                mSupplierListIvActivity.doRotate(0,180,500);
                mPopListView.setAdapter(mMenuAdapter3);
                mPopupWindow.showAsDropDown(mSupplierListActivity, 0, 2);
                supplierMenuIndex = 2;
                break;
            default:
                break;
        }
    }

    private void initData() {
        mMenuData1 = new ArrayList<>();
        String[] products = getResources().getStringArray(R.array.supplier_product);
        for (int i = 0; i < products.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(MENU_DATA_KEY, products[i]);
            mMenuData1.add(map);
        }
        mMenuData2 = new ArrayList<>();
        String[] sorts = getResources().getStringArray(R.array.supplier_sort);
        for (int i = 0; i < sorts.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(MENU_DATA_KEY, sorts[i]);
            mMenuData2.add(map);
        }
        mMenuData3 = new ArrayList<>();
        String[] activitys = getResources().getStringArray(R.array.supplier_activity);
        for (int i = 0; i < activitys.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(MENU_DATA_KEY, activitys[i]);
            mMenuData3.add(map);
        }
    }
    private void initPopMenu() {
        View popView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_popwin_supplier_list, null);
        mPopListView = (ListView) popView.findViewById(R.id.popwin_list_view);
        mPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setFocusable(true);
        mPopupWindow.setAnimationStyle(R.style.popwin_anim_style);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mSupplierListTvProduct.setTextColor(getResources().getColor(R.color.around_supplier_title_color));
                mSupplierListTvSort.setTextColor(getResources().getColor(R.color.around_supplier_title_color));
                mSupplierListTvActivity.setTextColor(getResources().getColor(R.color.around_supplier_title_color));
            }
        });

        popView.findViewById(R.id.popwin_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.dismiss();
                switch (supplierMenuIndex) {
                    case 0:
                        mSupplierListIvProduct.doRotate(180,0,500);
                        break;
                    case 1:
                        mSupplierListIvSort.doRotate(180,0,500);
                        break;
                    case 2:
                        mSupplierListIvActivity.doRotate(180,0,500);
                        break;
                    default:
                        break;
                }
            }
        });

        mMenuAdapter1 = new SimpleAdapter(getActivity(), mMenuData1, R.layout.item_popwin_list,
                new String[]{"name"}, new int[]{R.id.item_popwin_tv});
        mMenuAdapter2 = new SimpleAdapter(getActivity(), mMenuData2, R.layout.item_popwin_list,
                new String[]{"name"}, new int[]{R.id.item_popwin_tv});
        mMenuAdapter3 = new SimpleAdapter(getActivity(), mMenuData3, R.layout.item_popwin_list,
                new String[]{"name"}, new int[]{R.id.item_popwin_tv});
        mPopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (supplierMenuIndex) {
                    case 0:
                        mSupplierListTvProduct.setText(mMenuData1.get(i).get(MENU_DATA_KEY));
                        mSupplierListIvProduct.doRotate(180,0,500);
                        break;
                    case 1:
                        mSupplierListTvSort.setText(mMenuData2.get(i).get(MENU_DATA_KEY));
                        mSupplierListIvSort.doRotate(180,0,500);
                        break;
                    case 2:
                        mSupplierListTvActivity.setText(mMenuData3.get(i).get(MENU_DATA_KEY));
                        mSupplierListIvActivity.doRotate(180,0,500);
                        break;
                    default:
                        break;
                }
                mPopupWindow.dismiss();
            }
        });
    }


}
