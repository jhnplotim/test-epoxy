package io.github.jhnplotim.test.testepoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView(getTaskList(), getCarouselItems())
    }

    // TODO: Load from ViewModel / Repo
    private fun getTaskList(): List<Task> {
        return listOf(
            Task(
                1,
                "Go shopping",
                5,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge, theme)
            ),
            Task(
                2,
                "Skiing",
                15,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge_blue, theme)
            ),
            Task(
                3,
                "Studying",
                3,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge_green, theme)
            ),
            Task(
                4,
                "Running",
                4,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge, theme)
            ),
            Task(
                5,
                "Working",
                4,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge_blue, theme)
            ),
            Task(
                6,
                "Brainstorming",
                7,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge_green, theme)
            ),
            Task(
                7,
                "Reading",
                3,
                ResourcesCompat.getDrawable(resources, R.drawable.bg_badge_blue, theme)
            ),
        )
    }

    // TODO: Load from ViewModel / Repo
    private fun getCarouselItems(): List<CarouselItem> {
        return listOf(
            CarouselItem(1, "Problem?", "Call the rescue center", ResourcesCompat.getDrawable(resources, R.drawable.bg_image, theme)),
            CarouselItem(2, "Emergency", "Call the police", ResourcesCompat.getDrawable(resources, R.drawable.bg_image_black, theme)),
            CarouselItem(3, "Lost", "Call the finders", ResourcesCompat.getDrawable(resources, R.drawable.bg_image_purple, theme)),
            CarouselItem(4, "Want to have fun?", "See party recommendations", ResourcesCompat.getDrawable(resources, R.drawable.bg_image, theme))
        )
    }

    private fun setupRecyclerView(tasks: List<Task>, carouselItems: List<CarouselItem>) {
        val epoxyRv = findViewById<EpoxyRecyclerView>(R.id.epoxyRv)
        epoxyRv.withModels {
            // First title
            title {
                id("assistance-id")
                title("Need assistance?")
            }

            // Carousel Item
            val carouselItemModels = carouselItems.map { currentItem ->
                CarouselBindingModel_()
                    .id(currentItem.id)
                    .carouselItem(currentItem)
                    .clickListener { v ->
                    }
            }

            // Carousel
            // This extension function comes with epoxy
            carousel {
                id("car")
                models(carouselItemModels)
            }

            // Task title
            // item_title.xml
            title {
                id("tasks-id")
                title("Add a new task to")
            }

            // Tasks
            tasks.forEach { currentTask ->
                // item_task.xml
                task {
                    id(currentTask.id)
                    task(currentTask)
                    clickListener { v ->

                    }
                }
            }
        }
    }
}