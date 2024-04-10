package com.jaennova.tecmoviles.a4recyclerview

data class Superhero(
    var superhero: String,
    var publisher: String,
    var realName: String,
    var photo: String
)

fun getSuperheros(): MutableList<Superhero> {
    val superheros: MutableList<Superhero> = ArrayList()
    superheros.add(
        Superhero(
            "Spiderman",
            "Marvel",
            "Peter Parker",
            "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
        )
    )
    superheros.add(
        Superhero(
            "Daredevil",
            "Marvel",
            "Matthew Michael Murdock",
            "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"
        )
    )
    superheros.add(
        Superhero(
            "Wolverine",
            "Marvel",
            "James Howlett",
            "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"
        )
    )
    superheros.add(
        Superhero(
            "Batman",
            "DC",
            "Bruce Wayne",
            "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"
        )
    )
    superheros.add(
        Superhero(
            "Thor",
            "Marvel",
            "Thor Odinson",
            "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"
        )
    )
    superheros.add(
        Superhero(
            "Flash",
            "DC",
            "Jay Garrick",
            "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"
        )
    )
    superheros.add(
        Superhero(
            "Green Lantern",
            "DC",
            "Alan Scott",
            "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"
        )
    )
    superheros.add(
        Superhero(
            "Wonder Woman",
            "DC",
            "Princess Diana",
            "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"
        )
    )
    return superheros
}