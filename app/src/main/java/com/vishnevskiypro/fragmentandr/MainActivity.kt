package com.vishnevskiypro.fragmentandr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.javafaker.Faker
import com.vishnevskiypro.fragmentandr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val faker = Faker.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null){
            val fragment = CounterFragment.newInstance(
                counterValue = 1,
                quote = createQuote()
            )

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    fun createQuote(): String{
        return faker.harryPotter().quote()
    }

    fun getScreenCount(): Int{
        return supportFragmentManager.backStackEntryCount + 1
    }


}