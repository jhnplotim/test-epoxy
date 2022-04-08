package io.github.jhnplotim.test.testepoxy

import android.graphics.drawable.Drawable

/**
 * Created by John Paul Otim on 08.04.22
 **/
data class CarouselItem(
    val id: Int,
    val title: String,
    val description: String,
    val indicatorDrawable: Drawable?
)
