package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

@Composable
fun loadPicture(
    url: String,
    defaultImage: Int,
): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = remember {
        mutableStateOf(null)
    }
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object : Target<Bitmap>{
            override fun onStart() {
            }

            override fun onStop() {
            }

            override fun onDestroy() {
            }

            override fun onLoadStarted(placeholder: Drawable?) {
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun getSize(cb: SizeReadyCallback) {
                cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            }

            override fun removeCallback(cb: SizeReadyCallback) {
            }

            override fun setRequest(request: Request?) {
            }

            override fun getRequest(): Request? {
                return null
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : Target<Bitmap>{
            override fun onStart() {
            }

            override fun onStop() {
            }

            override fun onDestroy() {
            }

            override fun onLoadStarted(placeholder: Drawable?) {
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

            override fun getSize(cb: SizeReadyCallback) {
                cb.onSizeReady(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
            }

            override fun removeCallback(cb: SizeReadyCallback) {
            }

            override fun setRequest(request: Request?) {
            }

            override fun getRequest(): Request? {
                return null
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

        })
    return bitmapState
}