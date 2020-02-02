package com.example.skyunivercitybulavin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.example.skyunivercitybulavin.R.id.recipe_image
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private val picasso = Picasso.get()

    lateinit var recipeImage: ImageView

    var drawableSelection: Int = 100
    var selector: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        picasso.isLoggingEnabled = false

        val actionBar = supportActionBar

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Все рецепты"
        actionBar.subtitle = "Выберте тип рецепта"
        actionBar.elevation = 4.0F

        recipeImage = findViewById(R.id.recipe_image)
        recipeImage.setOnClickListener { takeRecipe() }
        /*        val random = Random().nextInt(10)
        val imageView = findViewById<ImageView>(R.id.recipe_image)
        loadImage(IMAGE_IDS[0], imageView)
        imageView.setOnClickListener {
            val nextId = Random().nextInt(9)+1
            loadImage(IMAGE_IDS[nextId], imageView)
        }
    }
    private fun loadImage(imageId: Int, imageView: ImageView) {
        Log.i("Tag1", "Load image $imageId")
        picasso.load("https://image.stage.readyforsky.com/i/$imageId/1370x2040.png")
            .into(imageView)//Максимальное разрешение картинок 1370х2040
    }

    companion object {
        val IMAGE_IDS = intArrayOf(100, 200, 300, 400, 500, 600, 700, 800, 801, 1000)
    }
*/
    }
        // 1 Хлеб,
        // 2 Каша,
        // 3 Десерты,
        // 4 Напитки,
        // 5 Варенье,
        // 6 Осн. блюдо,
        // 7 Пицца и пироги,
        // 8 Салаты
        private fun takeRecipe() {
            //Динамическая смена рецептов по клику на картинке внутри каждого раздела.

            val randomInt = Random().nextInt(9)+1
            val recipeName = when (randomInt) {
                0 -> "Название рецепта 1"
                1 -> "Название рецепта 2"
                2 -> "Название рецепта 3"
                3 -> "Название рецепта 4"
                4 -> "Название рецепта 5"
                5 -> "Название рецепта 6"
                6 -> "Название рецепта 7"
                7 -> "Название рецепта 8"
                8 -> "Название рецепта 9"
                9 -> "Название рецепта 10"
                10 -> "Название рецепта 11"

                else -> "Рецепт не найден"
            }
            val RecipeDescriptionSelector = when (randomInt) {
                0 -> getString(R.string.description_0)
                1 -> getString(R.string.description_1)
                2 -> getString(R.string.description_2)
                3 -> getString(R.string.description_3)
                4 -> getString(R.string.description_4)
                5 -> getString(R.string.description_5)
                6 -> getString(R.string.description_6)
                7 -> getString(R.string.description_7)
                8 -> getString(R.string.description_8)
                9 -> getString(R.string.description_9)
                10 -> getString(R.string.description_10)


                else -> "Описание не найдено"
            }
//            recipeImage.setImageDrawable(Drawable.createFromPath(drawableResource))
//        var  resourceId: Int = this.getResources().getIdentifier(drawableResource, "id", this.getPackageName())

                drawableSelection = Random().nextInt(900)+99

            picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                .into(recipeImage)
            //recipeImage.setImageResource(drawableSelection) //(resourceId)
            val recipeNameLocal :String =" img " + drawableSelection
            getSupportActionBar()?.setSubtitle(recipeNameLocal)
            textView.setText(Html.fromHtml(RecipeDescriptionSelector))
        }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.menu_main, menu)
            return super.onCreateOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle presses on the action bar menu items

            when (item.itemId) {
                R.id.action_settings -> {
                    drawableSelection = 100
                    selector = 1000
                    getSupportActionBar()?.setTitle("Все рецепты")
                    getSupportActionBar()?.setSubtitle("Выберте тип рецепта")
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_bread -> {
                    selector = 1
                    getSupportActionBar()?.setTitle("Хлеб")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_cereal_oatmel -> {
                    selector = 2
                    getSupportActionBar()?.setTitle("Каши")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_desserts -> {
                    selector = 3
                    getSupportActionBar()?.setTitle("Десерты")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_drinks -> {
                    selector = 4
                    getSupportActionBar()?.setTitle("Напитки")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_jam -> {
                    selector = 5
                    getSupportActionBar()?.setTitle("Варенье")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_main_course -> {
                    selector = 6
                    getSupportActionBar()?.setTitle("Основное блюдо")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_pie_pizza -> {
                    selector = 7
                    getSupportActionBar()?.setTitle("Пироги и Пицца")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
                R.id.action_select_salads -> {
                    selector = 8
                    getSupportActionBar()?.setTitle("Салаты")
                    drawableSelection=selector*100
                    picasso.load("https://image.stage.readyforsky.com/i/$drawableSelection/1370x2040.png")
                        .into(recipeImage)
                    return true
                }
            }
            return super.onOptionsItemSelected(item)
        }

}