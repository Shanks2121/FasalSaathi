package com.shanks.fasalsaathi.models

import com.google.gson.Gson

data class CropPriceItem(
    val Arrival_Date: String,
    val Commodity: String,
    val District: String,
    val Grade: String,
    val Market: String,
    val Max_x0020_Price: Int,
    val Min_x0020_Price: Int,
    val Modal_x0020_Price: Int,
    val State: String,
    val Variety: String
)

fun getCropPriceItemList() : List<CropPriceItem>{
    val json = """
            [
  {
    "State": "Uttar Pradesh",
    "District": "Baghpat",
    "Market": "Baraut",
    "Commodity": "Cauliflower",
    "Variety": "Cauliflower",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 500,
    "Max_x0020_Price": 600,
    "Modal_x0020_Price": 550
  },
  {
    "State": "Uttar Pradesh",
    "District": "Baghpat",
    "Market": "Baraut",
    "Commodity": "Green Chilli",
    "Variety": "Green Chilly",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 3500,
    "Max_x0020_Price": 3600,
    "Modal_x0020_Price": 3550
  },
  {
    "State": "Uttar Pradesh",
    "District": "Baghpat",
    "Market": "Baraut",
    "Commodity": "Gur(Jaggery)",
    "Variety": "Other",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 3200,
    "Max_x0020_Price": 3300,
    "Modal_x0020_Price": 3250
  },
  {
    "State": "Uttar Pradesh",
    "District": "Baghpat",
    "Market": "Baraut",
    "Commodity": "Tomato",
    "Variety": "Deshi",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1500,
    "Max_x0020_Price": 1600,
    "Modal_x0020_Price": 1550
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Green Chilli",
    "Variety": "Green Chilly",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1500,
    "Max_x0020_Price": 1700,
    "Modal_x0020_Price": 1600
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Raddish",
    "Variety": "Other",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 850,
    "Max_x0020_Price": 950,
    "Modal_x0020_Price": 900
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Bottle gourd",
    "Variety": "Bottle Gourd",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2200,
    "Max_x0020_Price": 2400,
    "Modal_x0020_Price": 2330
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Papaya",
    "Variety": "Papaya",
    "Grade": "Medium",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2260,
    "Max_x0020_Price": 2460,
    "Modal_x0020_Price": 2370
  },
  {
    "State": "Uttar Pradesh",
    "District": "Baghpat",
    "Market": "Baraut",
    "Commodity": "Potato",
    "Variety": "Chips",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 900,
    "Max_x0020_Price": 1000,
    "Modal_x0020_Price": 950
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Lemon",
    "Variety": "Other",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 6100,
    "Max_x0020_Price": 6300,
    "Modal_x0020_Price": 6200
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Carrot",
    "Variety": "Carrot",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1050,
    "Max_x0020_Price": 1250,
    "Modal_x0020_Price": 1180
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Mousambi(Sweet Lime)",
    "Variety": "Mousambi",
    "Grade": "Medium",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 3050,
    "Max_x0020_Price": 3250,
    "Modal_x0020_Price": 3180
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Tomato",
    "Variety": "Deshi",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1700,
    "Max_x0020_Price": 1900,
    "Modal_x0020_Price": 1800
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Shadabad",
    "Commodity": "Potato",
    "Variety": "Desi",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 800,
    "Max_x0020_Price": 900,
    "Modal_x0020_Price": 850
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Carrot",
    "Variety": "Carrot",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1500,
    "Max_x0020_Price": 1700,
    "Modal_x0020_Price": 1600
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Cauliflower",
    "Variety": "Cauliflower",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 1000,
    "Max_x0020_Price": 1200,
    "Modal_x0020_Price": 1100
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Ginger(Green)",
    "Variety": "Green Ginger",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 7100,
    "Max_x0020_Price": 7300,
    "Modal_x0020_Price": 7200
  },
  {
    "State": "Uttar Pradesh",
    "District": "Bulandshahar",
    "Market": "Gulavati",
    "Commodity": "Potato",
    "Variety": "Desi",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 700,
    "Max_x0020_Price": 900,
    "Modal_x0020_Price": 800
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Banana",
    "Variety": "Banana - Ripe",
    "Grade": "Medium",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2300,
    "Max_x0020_Price": 2500,
    "Modal_x0020_Price": 2430
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Brinjal",
    "Variety": "Round",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2060,
    "Max_x0020_Price": 2280,
    "Modal_x0020_Price": 2180
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Cauliflower",
    "Variety": "Cauliflower",
    "Grade": "FAQ",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2150,
    "Max_x0020_Price": 2350,
    "Modal_x0020_Price": 2280
  },
  {
    "State": "Uttar Pradesh",
    "District": "Hathras",
    "Market": "Haathras",
    "Commodity": "Orange",
    "Variety": "Orange",
    "Grade": "Medium",
    "Arrival_Date": "15-03-2024",
    "Min_x0020_Price": 2800,
    "Max_x0020_Price": 3000,
    "Modal_x0020_Price": 2930
  }
]
        """.trimIndent()

    val cropPriceItems = Gson().fromJson(json, Array<CropPriceItem>::class.java)

    return cropPriceItems.toList()
}

