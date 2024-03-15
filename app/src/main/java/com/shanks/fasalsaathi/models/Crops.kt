package com.shanks.fasalsaathi.models

data class Crops(
    val cropsList : List<Crop>
)

data class Crop(
    val id : Int,
    val crop_image: String? = "",
    val medicines_pesticides: String,
    val month_of_harvest: String,
    val name: String,
    val season: String,
    val soil: String,
    val type: String
)

val indianCrops = listOf(
    Crop(1, "https://res.cloudinary.com/dowpys11p/image/upload/v1/media/images/watermelon_ktnq0f",  "placeholder", "placeholder", "Rice", "Kharif ( खरीफ)", "Well-drained Loam", "Cereal"),
    Crop(2, "placeholder.jpg",  "placeholder", "placeholder", "Wheat", "Rabi (रबी)", "Well-drained Loam", "Cereal"),
    Crop(3, "placeholder.jpg",  "placeholder", "placeholder", "Maize (Corn)", "Kharif ( खरीफ)", "Well-drained Sandy Loam", "Cereal"),
    Crop(4, "placeholder.jpg",  "placeholder", "placeholder", "Pulses", "Kharif & Rabi", "Well-drained Sandy Loam", "Legume"),
    Crop(5 ,"placeholder.jpg",  "placeholder", "placeholder", "Cotton", "Kharif ( खरीफ)", "Black or Alluvial", "Fiber"),
    Crop(6, "placeholder.jpg",  "placeholder", "placeholder", "Jute", "Kharif ( खरीफ)", "Well-drained Alluvial", "Fiber"),
    Crop(7, "placeholder.jpg",  "placeholder", "placeholder", "Sugarcane", "Kharif ( खरीफ)", "Well-drained Clayey Loam", "Cash Crop"),
    Crop(8, "placeholder.jpg",  "placeholder", "placeholder", "Groundnut", "Kharif ( खरीफ)", "Well-drained Sandy Loam", "Oilseed"),
    Crop(9, "placeholder.jpg", "placeholder", "placeholder", "Mustard", "Rabi (रबी)", "Well-drained Sandy Loam", "Oilseed"),
    Crop(10, "placeholder.jpg",  "placeholder", "placeholder", "Sunflower", "Kharif ( खरीफ)", "Well-drained Loam", "Oilseed"),
    Crop(11, "placeholder.jpg",  "placeholder", "placeholder", "Mango", "Summer", "Well-drained Sandy Loam", "Fruit"),
    Crop(12, "placeholder.jpg",  "placeholder", "placeholder", "Banana", "Throughout the year", "Well-drained Loam", "Fruit"),
    Crop(13, "placeholder.jpg", "placeholder", "placeholder", "Apple", "Temperate (Winter)", "Well-drained Sandy Loam", "Fruit"),
    Crop(14, "placeholder.jpg", "placeholder", "placeholder", "Grapes", "Summer", "Well-drained Sandy Loam", "Fruit"),
    Crop(15, "placeholder.jpg", "placeholder", "placeholder", "Orange", "Winter", "Well-drained Loam", "Fruit"),
    Crop(16, "placeholder.jpg",  "placeholder", "placeholder", "Tomato", "Throughout the year (controlled)", "Well-drained Loam", "Vegetable"),
    Crop(17, "placeholder.jpg",  "placeholder", "placeholder", "Potato", "Winter", "Well-drained Loam", "Vegetable"),
    Crop(18, "placeholder.jpg",  "placeholder", "placeholder", "Onion", "Rabi (रबी)", "Well-drained Sandy Loam", "Vegetable"),
    Crop(19, "placeholder.jpg",  "placeholder", "placeholder", "Brinjal (Eggplant)", "Kharif ( खरीफ)", "Well-drained Loam", "Vegetable"),
    Crop(20, "placeholder.jpg",  "placeholder", "placeholder", "Cauliflower", "Winter", "Well-drained Loam", "Vegetable")
)