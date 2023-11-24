package com.example.loginfrd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption) //Setting activity layout

        val imageView = findViewById<ImageView>(R.id.imageViewInAdoption)
        val imageDescription = findViewById<TextView>(R.id.imageDescription)

        val imageResourceId = intent.getIntExtra("imageResourceId", 0)
        if (imageResourceId != 0) {
            imageView.setImageResource(imageResourceId)
            //Set description based on the displayed image
            val description = getImageDescription(imageResourceId)
            imageDescription.text = description
        } else {
            Toast.makeText(this@AdoptionActivity, "Not available.", Toast.LENGTH_SHORT).show()
        }

        //Listener for catalog button
        val catalogButton = findViewById<Button>(R.id.catalogButton)
        catalogButton.setOnClickListener {
            startActivity(Intent(this@AdoptionActivity, CatalogActivity::class.java))
            finish()
        }

        //Listener for adopt button
        val adoptButton = findViewById<Button>(R.id.adoptButton)
        adoptButton.setOnClickListener {
            val imageResourceId = intent.getIntExtra("imageResourceId", 0)
            val url = getAdoptionLink(imageResourceId)
            if (url.isNotEmpty()) {
                //Open link in a browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } else {
                //Handle case when URL is not found for the selected pet
                Toast.makeText(this@AdoptionActivity, "Not available.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getImageDescription(imageResourceId: Int): String {
        //Return the description based on the imageResourceId
        return when (imageResourceId) {
            //Cat descriptions
            R.drawable.cat1 -> "Name: Nelson" +
                    "\n\nBreed: Tabby (Brown/Chocolate)" +
                    "\n\nAge: Young" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Affectionate, Playful, Athletic, Funny, Curious, Brave"
            R.drawable.cat2 -> "Name: Cara" +
                    "\n\nBreed: Tuxedo" +
                    "\n\nAge: Young" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Gentle, Quiet, Curious"
            R.drawable.cat3 -> "Name: Erin" +
                    "\n\nBreed: Tabby (Gray)" +
                    "\n\nAge: Adult" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Quiet, Independent, Curious"
            R.drawable.cat4 -> "Name: Bailey" +
                    "\n\nBreed: Tabby (Tan)" +
                    "\n\nAge: Young" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Protective, Smart, Quiet, Curious, Brave, Independent"
            R.drawable.cat5 -> "Name: Harmony" +
                    "\n\nBreed: Tuxedo" +
                    "\n\nAge: Adult" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Affectionate, Playful, Curious"

            //Dog descriptions
            R.drawable.dog1 -> "Name: Root Beer" +
                    "\n\nBreed:  Chihuahua Mix" +
                    "\n\nAge: Puppy" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Affectionate, Loyal, Gentle, Playful, Smart, Brave, Curious, Independent, Funny, Loves kisses"
            R.drawable.dog2 -> "Name: Coca Cola" +
                    "\n\nBreed:  Chihuahua Mix" +
                    "\n\nAge: Puppy" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Friendly, Affectionate, Loyal, Gentle, Playful, Smart, Brave, Curious, Independent, Funny, Loves kisses"
            R.drawable.dog3 -> "Name: Finley" +
                    "\n\nBreed: German Shepherd" +
                    "\n\nAge: Adult" +
                    "\n\nHouse-trained: No" +
                    "\n\nPersonality: Social Butterfly"
            R.drawable.dog4 -> "Name: Daisy" +
                    "\n\nBreed: Siberian Husky Mix" +
                    "\n\nAge: Adult" +
                    "\n\nHouse-trained: Yes" +
                    "\n\nPersonality: Loyal, Smart, Friendly, Athletic"
            R.drawable.dog5 -> "Name: Koda" +
                    "\n\nBreed: Mastiff & Boxer Mix" +
                    "\n\nAge: Adult" +
                    "\n\nHouse-trained: No" +
                    "\n\nPersonality: Friendly, Affectionate, Loyal, Gentle, Playful, Smart, Athletic, Loves kisses, Curious"
            else -> "Error."
        }
    }

    private fun getAdoptionLink(imageResourceId: Int): String {
        //Return the adoption link based on the imageResourceId
        return when (imageResourceId) {
            //URLs for each pet
            R.drawable.cat1 -> "https://www.petfinder.com/cat/nelson-65682594/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.cat2 -> "https://www.petfinder.com/cat/cara-69665175/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.cat3 -> "https://www.petfinder.com/cat/erin-54266595/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.cat4 -> "https://www.petfinder.com/cat/bailey-65682692/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.cat5 -> "https://www.petfinder.com/cat/harmony-54967487/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.dog1 -> "https://www.petfinder.com/dog/root-beer-52751214/ca/pomona/the-ranch-rescue-team-ca2761/"
            R.drawable.dog2 -> "https://www.petfinder.com/dog/coca-cola-52751226/ca/pomona/the-ranch-rescue-team-ca2761/"
            R.drawable.dog3 -> "https://www.petfinder.com/dog/finley-claremont-location-69682878/ca/chino-hills/priceless-pet-rescue-ca1886/"
            R.drawable.dog4 -> "https://www.petfinder.com/dog/daisy-64366563/ca/ontario/west-end-shelter-for-animals-ca163/"
            R.drawable.dog5 -> "https://www.petfinder.com/dog/koda-66213430/ca/ontario/west-end-shelter-for-animals-ca163/#story"
            else -> "Error."
        }
    }
}
