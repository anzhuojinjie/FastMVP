package com.joey.fastmvp.app;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import java.util.Stack;
/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述： 应用程序Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {

  private static Stack<FragmentActivity> activityStack;
  private static AppManager instance;

  private AppManager() {
  }

  /**
   * 单一实例
   */
  public static AppManager getInstance() {
    if (instance == null) {
      instance = new AppManager();
    }
    return instance;
  }

  /**
   * 添加Activity到堆栈
   */
  public void addActivity(FragmentActivity activity) {
    if (activityStack == null) {
      activityStack = new Stack<>();
    }
    activityStack.add(activity);
  }

  /**
   * 获取当前Activity（堆栈中最后一个压入的）
   */
  public FragmentActivity currentActivity() {
    FragmentActivity activity = activityStack.lastElement();
    return activity;
  }

  /**
   * 结束当前Activity（堆栈中最后一个压入的）
   */
  public void finishActivity() {
    FragmentActivity activity = activityStack.lastElement();
    finishActivity(activity);
  }

  /**
   * 结束指定的Activity
   */
  public void finishActivity(FragmentActivity activity) {
    if (activity != null && activityStack != null) {
      activityStack.remove(activity);
      activity.finish();
    }
  }

  /**
   * 结束指定类名的Activity
   */
  public void finishActivity(Class<?> cls) {
    for (FragmentActivity activity : activityStack) {
      if (activity.getClass().equals(cls)) {
        finishActivity(activity);
      }
    }
  }

  /**
   * 结束所有Activity
   */
  public void finishAllActivity() {
    for (int i = 0, size = activityStack.size(); i < size; i++) {
      if (null != activityStack.get(i)) {
        activityStack.get(i).finish();
      }
    }
    activityStack.clear();
  }

  /**
   * 退出应用程序
   */
  public void AppExit(Context context) {
    try {
      finishAllActivity();
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean isAppExit() {
    return activityStack == null || activityStack.isEmpty();
  }
}
