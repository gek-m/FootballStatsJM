package com.example.footballstatsjm

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Looper
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import kotlin.math.roundToInt
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun View.click(click: () -> Unit) = setOnClickListener {
    click()
}

fun Int.dp(context: Context): Int =
    TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        )
        .roundToInt()

@Suppress("IMPLICIT_CAST_TO_ANY")
fun TextView.setStartDrawableCircleImageFromUri(uri: String, placeholder: Int = 0) {
    val glideUrl = if (uri.isEmpty()) placeholder else GlideUrl(uri)

    Glide.with(context)
        .load(glideUrl)
        .placeholder(placeholder)
        .apply(
            RequestOptions
                .circleCropTransform()
                .override(50.dp(this.context))
        )
        .into(object : CustomViewTarget<TextView, Drawable>(this) {

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                view.setCompoundDrawable(resource, null, null, null)
            }

            override fun onResourceCleared(placeholder: Drawable?) {
                view.setCompoundDrawable(placeholder, null, null, null)
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                view.setCompoundDrawable(errorDrawable, null, null, null)
            }

        })
}

fun TextView.setCompoundDrawable(
    left: Drawable? = null,
    top: Drawable? = null,
    right: Drawable? = null,
    bottom: Drawable? = null
) {
    setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
}

fun <V : ViewBinding> Fragment.viewBinding(bind: (view: View) -> V) =
    ViewBindingDelegate(this, bind)

class ViewBindingDelegate<V : ViewBinding>(
    fragment: Fragment,
    private val bind: (view: View) -> V
) :
    ReadOnlyProperty<Fragment, V> {

    private var viewBinding: V? = null

    private val mainThreadHandler = android.os.Handler(Looper.getMainLooper())

    init {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) {
            it.lifecycle.addObserver(object : LifecycleObserver {

                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun destroyed() {
                    mainThreadHandler.post {
                        viewBinding = null
                    }
                }
            })
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): V {

        return viewBinding ?: run {

            val view = thisRef.requireView()

            bind.invoke(view).also {
                viewBinding = it
            }
        }
    }
}