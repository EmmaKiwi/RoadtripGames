package com.mercari.roadtripgames.games.numberplate

import com.mercari.roadtripgames.R

enum class NumberPlateType(
        val stateName: String,
        val slogan: String,
        val image: Int? = null
) {
    ALABAMA("Alabama", "God Bless America", R.drawable.alabama),
    ALASKA("Alaska", "The Last Frontier", R.drawable.alaska),
    ARIZONA("Arizona", "Grand Canyon State", R.drawable.arizona),
    ARKANSAS("Arkansas", "", R.drawable.arkansas),
    CALIFORNIA("California", "", R.drawable.california),
    COLORADO("Colorado", "", R.drawable.colorado),
    CONNECTICUT("Connecticut", "Constitution State", R.drawable.connecticut),
    DELAWARE("Delaware", "The First State", R.drawable.delaware),
    DISTRICT_OF_COLUMBIA("District of Columbia", "Taxation Without Representation", R.drawable.district_of_columbia),
    FLORIDA("Florida", "", R.drawable.florida),
    GEORGIA("Georgia", "", R.drawable.georgia),
    HAWAII("Hawaii", "Aloha State", R.drawable.hawaii),
    IDAHO("Idaho", "Famous Potatoes", R.drawable.idaho),
    ILLINOIS("Illinois", "Land of Lincoln", R.drawable.illinois),
    INDIANA("Indiana", "The Crossroads of America", R.drawable.indiana),
    IOWA("Iowa", "Ad Astra per Aspera", R.drawable.iowa),
    KANSAS("Kansas", "", R.drawable.kansas),
    KENTUCKY("Kentucky", "", R.drawable.kentucky),
    LOUISIANA("Louisiana", "Sportsman's Paradise", R.drawable.louisiana),
    MAINE("Maine", "Support Wildlife", R.drawable.maine),
    MARYLAND("Maryland", "", R.drawable.maryland),
    MASSACHUSETTS("Massachusetts", "The Spirit of America", R.drawable.massachusetts),
    MICHIGAN("Michigan", "", R.drawable.michigan),
    MINNESOTA("Minnesota", "10,000 Lakes", R.drawable.minnesota),
    MISSISSIPPI("Mississippi", "", R.drawable.mississippi),
    MISSOURI("Missouri", "Show Me State", R.drawable.missouri),
    MONTANA("Montana", "Treasure State", R.drawable.montana),
    NEBRASKA("Nebraska", "", R.drawable.nebraska),
    NEVADA("Nevada", "", R.drawable.nevada),
    NEW_HAMPSHIRE("New Hampshire", "Live Free or Die", R.drawable.new_hampshire),
    NEW_JERSEY("New Jersey", "Garden State", R.drawable.new_jersey),
    NEW_MEXICO("New Mexico", "Land of Enchantment", R.drawable.new_mexico),
    NEW_YORK("New York", "Empire State", R.drawable.new_york),
    NORTH_CAROLINA("North Carolina", "First in Freedom", R.drawable.north_carolina),
    NORTH_DAKOTA("North Dakota", "Peace Garden State", R.drawable.north_dakota),
    OHIO("Ohio", "", R.drawable.ohio),
    OKLAHOMA("Oklahoma", "", R.drawable.oklahoma),
    OREGON("Oregon", "", R.drawable.oregon),
    PENNSYLVANIA("Pennsylvania", "Keystone State", R.drawable.pennsylvania),
    RHODE_ISLAND("Rhode Island", "Ocean State", R.drawable.rhode_island),
    SOUTH_CAROLINA("South Carolina", "", R.drawable.south_carolina),
    SOUTH_DAKOTA("South Dakota", "Great Faces, Great Places", R.drawable.south_dakota),
    TENNESSEE("Tennessee", "", R.drawable.tennessee),
    TEXAS("Texas", "The Lone Star State", R.drawable.texas),
    UTAH("Utah", "", R.drawable.utah),
    VERMONT("Vermont", "Green Mountain State", R.drawable.vermont),
    VIRGINIA("Virginia", "Virginia is for Lovers", R.drawable.virginia),
    WASHINGTON("Washington", "Evergreen State", R.drawable.washington),
    WEST_VIRGINIA("West Virginia", "Wild, Wonderful", R.drawable.west_virginia),
    WISCONSIN("Wisconsin", "America's Dairyland", R.drawable.wisconsin),
    WYOMING("Wyoming", "", R.drawable.wyoming)
}
