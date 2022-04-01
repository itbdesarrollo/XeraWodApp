// Generated by view binder compiler. Do not edit!
package llp.itbdesarrollo.xerawodapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import llp.itbdesarrollo.xerawodapp.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final AppBarMainBinding appPrincipal;

  @NonNull
  public final FragmentBottomMenuBinding barBottom;

  @NonNull
  public final FragmentMenuBinding contenedor;

  @NonNull
  public final DrawerLayout drawerMain;

  @NonNull
  public final LinearLayoutCompat linearPadre;

  @NonNull
  public final NavigationView navView;

  private ActivityMainBinding(@NonNull DrawerLayout rootView,
      @NonNull AppBarMainBinding appPrincipal, @NonNull FragmentBottomMenuBinding barBottom,
      @NonNull FragmentMenuBinding contenedor, @NonNull DrawerLayout drawerMain,
      @NonNull LinearLayoutCompat linearPadre, @NonNull NavigationView navView) {
    this.rootView = rootView;
    this.appPrincipal = appPrincipal;
    this.barBottom = barBottom;
    this.contenedor = contenedor;
    this.drawerMain = drawerMain;
    this.linearPadre = linearPadre;
    this.navView = navView;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_principal;
      View appPrincipal = ViewBindings.findChildViewById(rootView, id);
      if (appPrincipal == null) {
        break missingId;
      }
      AppBarMainBinding binding_appPrincipal = AppBarMainBinding.bind(appPrincipal);

      id = R.id.barBottom;
      View barBottom = ViewBindings.findChildViewById(rootView, id);
      if (barBottom == null) {
        break missingId;
      }
      FragmentBottomMenuBinding binding_barBottom = FragmentBottomMenuBinding.bind(barBottom);

      id = R.id.contenedor;
      View contenedor = ViewBindings.findChildViewById(rootView, id);
      if (contenedor == null) {
        break missingId;
      }
      FragmentMenuBinding binding_contenedor = FragmentMenuBinding.bind(contenedor);

      DrawerLayout drawerMain = (DrawerLayout) rootView;

      id = R.id.linear_padre;
      LinearLayoutCompat linearPadre = ViewBindings.findChildViewById(rootView, id);
      if (linearPadre == null) {
        break missingId;
      }

      id = R.id.nav_view;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      return new ActivityMainBinding((DrawerLayout) rootView, binding_appPrincipal,
          binding_barBottom, binding_contenedor, drawerMain, linearPadre, navView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}