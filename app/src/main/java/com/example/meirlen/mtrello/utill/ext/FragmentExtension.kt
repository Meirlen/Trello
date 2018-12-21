package com.example.meirlen.mtrello.utill.ext

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline fun FragmentManager.replaceOnce(@IdRes containerViewId: Int, fragmentTag: String,
                                       body: () -> Fragment, withBackStack: Boolean = true): FragmentTransaction {
    val transaction = this.beginTransaction()
    val fragment = this.findFragmentByTag(fragmentTag)
    if (fragment == null) {
        transaction.replace(containerViewId, body(), fragmentTag)
        if (withBackStack) {
            transaction.addToBackStack(fragmentTag)
        }
    }
    return transaction
}

inline fun FragmentManager.replaceByTag(@IdRes containerViewId: Int, fragmentTag: String,
                                        body: () -> Fragment, withBackStack: Boolean = true): FragmentTransaction {
    val transaction = this.beginTransaction()
    val fragment = this.findFragmentByTag(fragmentTag)
    if (fragment != null) {
        transaction.replace(containerViewId, fragment, fragmentTag)
    } else {
        transaction.replace(containerViewId, body(), fragmentTag)
    }
    if (withBackStack) {
        transaction.addToBackStack(fragmentTag)
    }
    return transaction
}