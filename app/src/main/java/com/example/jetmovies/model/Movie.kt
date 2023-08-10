package com.example.jetmovies.model

data class Movie(val id: String,
                 val category: Int,
                 val title: String,
                 val date: String,
                 val duration: Int,
                 val genre: String,
                 val director: String,
                 val actors: String,
                 val plot: String,
                 val coverPoster: String,
                 val profilePoster: String,
                 val rating: String,
                 val actorProfiles: List<Actor>
                )

fun getMovies(): List<Movie> {
    return listOf(
        Movie(id = "1",
            category = 0,
            title = "Shershaah",
            date = "12 August 2021",
            genre = "Action, Adventure, Fantasy",
            director = "Vishnuvardhan",
            actors = "Sidharth Malhotra, Kiara Advani, Shiv Pandit, Nikitin Dheer",
            plot = "Vikram Batra, a young man, dreams of becoming a soldier and falls in love with Dimple. Soon after his training, he climbs the military ranks and contributes to India's victory in the Kargil war.",
            profilePoster = "https://m.media-amazon.com/images/M/MV5BMjk1NzcwMDUtNDU4ZC00MzlhLTkzZjAtM2MxMTRjZGE0ODdhXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_FMjpg_UX1000_.jpg",
            coverPoster = "https://cafechills.com/wp-content/uploads/2021/08/shershaah_movie_review.jpg",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Sidharth Malhotra",
                    imageUrl = "https://fabceleby.in/wp-content/uploads/2023/02/Sidharth-Malhotra-Net-Worth.jpg"
                ),
                Actor(
                    name = "Kiara Advani",
                    imageUrl = "https://in.bmscdn.com/iedb/artist/images/website/poster/large/kiara-advani-1043272-1655467015.jpg"
                ),
                Actor(
                    name = "Shiv Pandit",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcR9XWnBbByMxbVzRRdfH8egMEtG4NxRjudcx5zQzm_c9-pvc_OuIwltV0AFlilTf41NQ2U_HgGWdHWuADs"
                ),
                Actor(
                    name = "Nikitin Dheer",
                    imageUrl = "https://im.rediff.com/movies/2016/may/26nikitin-dheer.jpg?w=670&h=900"
                )
            )
        ),

        Movie(id = "2",
            category = 0,
            title = "Guardians of the Galaxy Vol. 3",
            date = "5 May 2023",
            genre = "Action, Sci-Fi",
            director = "James Gunn",
            actors = "Chris Pratt, Zoe Saldana, Will Poulter, Karen Gillan, Vin Diesel, Dave Bautista",
            plot = "Still reeling from the loss of Gamora, Peter Quill must rally his team to defend the universe and protect one of their own. If the mission is not completely successful, it could possibly lead to the end of the Guardians as we know them.",
            profilePoster = "https://www.themoviedb.org/t/p/w500/r2J02Z2OpNTctfOSN1Ydgii51I3.jpg",
            coverPoster = "https://assets.telegraphindia.com/telegraph/2023/May/1683173444_guardians.jpg",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Chris Pratt",
                    imageUrl = "https://mario.wiki.gallery/images/9/9b/Chris_Pratt.jpg"
                ),
                Actor(
                    name = "Zoe Saldana",
                    imageUrl = "https://ntvb.tmsimg.com/assets/assets/194024_v9_bb.jpg?w=270&h=360"
                ),
                Actor(
                    name = "Will Poulter",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcQ3nqpSlm9shhWlvYuRTAx2JT7yku39HvJnuwAtQ6tzwdRNCGQh2hpk_xXkZ_XGvMs2VCdOPSvDXx2AQJs"
                ),
                Actor(
                    name = "Karen Gillan",
                    imageUrl = "https://www.looper.com/img/gallery/the-transformation-of-karen-gillan-from-childhood-to-doctor-who/intro-1620572026.jpg"
                ),
                Actor(
                    name = "Vin Diesel",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcTztj-DMySeILvxWzKlMzg8XOQh7XifGc5ktMh4g38TaDTPL5mZqUjdA-Xfv9fxHhHkpV6u3ivaxdsn1DM"
                ),
                Actor(
                    name = "Dave Bautista",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRZgymlFjwD1uohF8aH9SAU_cVf6gmIMEDd-Xui9bq7D7V_kd4niupS7ZtjrqDsuY8GbKuvF5OqipPis8w"
                )
            )
        ),

        Movie(id = "3",
            category = 0,
            title = "John Wick: Chapter 4",
            date = "24 March 2023",
            genre = "Action, Neo-noir",
            director = "Chad Stahelski",
            actors = "Keanu Reeves, Scott Adkins, Bill Skarsgard, Donnie Yen",
            plot = "With the price on his head ever increasing, legendary hit man John Wick takes his fight against the High Table global as he seeks out the most powerful players in the underworld, from New York to Paris to Japan to Berlin.",
            profilePoster = "https://m.media-amazon.com/images/I/81fk-N7tvbL._AC_UF1000,1000_QL80_.jpg",
            coverPoster = "https://cdn.theplaylist.net/wp-content/uploads/2023/02/16101411/John-Wick-4.jpg",
            rating = "5.9",
            duration = 140,
            actorProfiles = listOf(
                Actor(
                    name = "Keanu Reeves",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRecnZ2uWc-_hLL8l8_1fh3vonLpUWrCSY7Q5KhiIU2bpgsXQpf245H5jjDAEgW4rLOlczk7aYTlU_hAi8"
                ),
                Actor(
                    name = "Scott Adkins",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSMjGXiaQjpgZEZUAtCwTe0RIXgSJrK_ec-1HtDkaP5Gv6GhOBb_nmQ6OYkGRVL9E0PxYz5dBYWRY6rnDg"
                ),
                Actor(
                    name = "Bill Skarsgard",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSdeG7nbMhSiaLwMSmI28FPt_YVZLifJU3peok2y3wNENxVROnCpH59d0T3_Sp3CQhkk7AmayS86HbKtYw"
                ),
                Actor(
                    name = "Donnie Yen",
                    imageUrl = "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcR8wJrtpXCGzqooyG39eRKcuQ3DEHXwgf3UMKUNsxeoJo9wvcPRiledjPnd7MUWjtWrbERwgm9lqv_erq4"
                )
            )
        ),

        Movie(id = "4",
            category = 0,
            title = "Transformers: Rise of the Beasts",
            date = "9 June 2023",
            genre = "Action, Sci-Fi",
            director = "Steven Caple Jr.",
            actors = "Anthony Ramos, Liza Koshy",
            plot = "Optimus Prime and the Autobots take on their biggest challenge yet. When a new threat capable of destroying the entire planet emerges, they must team up with a powerful faction of Transformers known as the Maximals to save Earth.",
            profilePoster = "https://flxt.tmsimg.com/assets/p20201199_v_v13_am.jpg",
            coverPoster = "https://www.hollywoodreporter.com/wp-content/uploads/2023/05/tfrobonlinepayoff1shtunitefin2101-H-2023.jpg?w=1296",
            rating = "5.9",
            duration = 140,
            actorProfiles = listOf(
                Actor(
                    name = "Anthony Ramos",
                    imageUrl = "https://static.wikia.nocookie.net/disneyfanon/images/7/7e/Anthony_Ramos.jpg/revision/latest?cb=20210716202749"
                ),
                Actor(
                    name = "Liza Koshy",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcRZys6Zn6exxcqIABsjPIccG43NdloLXQpmHD7w-gdqPJtSjJFXXR6ChrzoWTDNZRdDmtukjmgGdU0yPpM"
                ),
            )
        ),

        Movie(id = "5",
            category = 0,
            title = "Fast X",
            date = "19 May 2023",
            genre = "Action, Adventure",
            director = "Louis Leterrier",
            actors = "Vin Diesel, Jason Momoa, Michelle Rodriguez, Sung Kang",
            plot = "Over many missions and against impossible odds, Dom Toretto and his family have outsmarted and outdriven every foe in their path. Now, they must confront the most lethal opponent they've ever faced. Fueled by revenge, a terrifying threat emerges from the shadows of the past to shatter Dom's world and destroy everything -- and everyone -- he loves.",
            profilePoster = "https://m.media-amazon.com/images/M/MV5BNzZmOTU1ZTEtYzVhNi00NzQxLWI5ZjAtNWNhNjEwY2E3YmZjXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_FMjpg_UX1000_.jpg",
            coverPoster = "https://cdn.zeebiz.com/sites/default/files/2023/05/22/243470-fast-x-twitter.jpg",
            rating = "5.9",
            duration = 140,
            actorProfiles = listOf(
                Actor(
                    name = "Vin Diesel",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcTztj-DMySeILvxWzKlMzg8XOQh7XifGc5ktMh4g38TaDTPL5mZqUjdA-Xfv9fxHhHkpV6u3ivaxdsn1DM"
                ),
                Actor(
                    name = "Jason Momoa",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcR8hr5qj9FaIwvJDC3pqIwmGyiuV01iu5kLV-LjjqvRMqkXUYsPNPLmcR_45fZkjz0Byoqme2W5XPZLvns"
                ),
                Actor(
                    name = "Michelle Rodriguez",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcS-dJmiDOhYX-hzj-wVr9z849uZrGr--Re4BL4wpRBsJmST336h46XAzmD0ArMm-YR3PSXzA6OVue-7-wo"
                ),
                Actor(
                    name = "Sung Kang",
                    imageUrl = "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTBg4K1WobLMqqR6cwV_ykFyCb-CwizreoNcEbMOwpv7TpAR-ekRo-_GIBbw747VPosnbQUzxCkpH7mU8A"
                ),
            )
        ),

        Movie(id = "6",
            category = 0,
            title = "Pathaan",
            date = "25 January 2023",
            genre = "Action, Thriller",
            director = "Siddharth Anand",
            actors = "Shah Rukh Khan, Deepika Padukone, John Abraham, Salman Khan",
            plot = "A Pakistani general hires a private terror outfit to conduct attacks in India while Pathaan, an Indian secret agent, is on a mission to form a special unit.",
            profilePoster = "https://m.media-amazon.com/images/M/MV5BM2QzM2JiNTMtYjU4Ny00MDZkLTk3MmUtYTRjMzVkZGJlNmYyXkEyXkFqcGdeQXVyMTUzNTgzNzM0._V1_.jpg",
            coverPoster = "https://images.hindustantimes.com/img/2023/01/25/1600x900/pathaan_movie_review_1674631292696_1674631292838_1674631292838.jpeg",
            rating = "5.9",
            duration = 140,
            actorProfiles = listOf(
                Actor(
                    name = "Shah Rukh Khan",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTK7Os2YW_6OfJJGh9rvPUSbNYqUwQXZce6mMIrqMasLen8sg4BDbHwN-UMOAV6Q_lXdvqdhbY-NqCTcGA"
                ),
                Actor(
                    name = "Deepika Padukone",
                    imageUrl = "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcRbTBoFGrg08APZDSY-U_Pbpd5PSr_IkL4v9yQWH3lPrmNosNy-P796yr_Jqjh40ABeRCCfd0mkyyoR_GI"
                ),
                Actor(
                    name = "John Abraham",
                    imageUrl = "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcTLSNe39wIqy29h-fs7IbxcMd-50amJ83_fq5WxGRzIn4o2yKSCivTSaB8RhphKZ610E2Mrju47IuSG0CY"
                ),
                Actor(
                    name = "Salman Khan",
                    imageUrl = "https://im.rediff.com/movies/2016/may/26nikitin-dheer.jpg?w=670&h=900"
                )
            )
        ),

        Movie(id = "7",
            category = 0,
            title = "Chor Nikal Ke Bhaaga",
            date = "24 March 2023",
            genre = "Drama, Thriller",
            director = "Ajay Singh",
            actors = "Yami Gautam, Sunny Kaushal, Sharad Kelkar",
            plot = "A flight attendant and her boyfriend plan to steal a cache of diamonds to clear an old debt. But 40,000 feet above the ground, their heist goes horribly wrong and turns into a hostage situation.",
            profilePoster = "https://assets.gadgets360cdn.com/pricee/assets/product/202303/Chor-Nikal-Ke-Bhaga_1677749883.jpg",
            coverPoster = "https://images.hindustantimes.com/tech/img/2023/03/01/960x540/Screenshot_2023-03-01_165200_1677669733915_1677669744289_1677669744289.png",
            rating = "7.5",
            duration = 110,
            actorProfiles = listOf(
                Actor(
                    name = "Yami Gautam",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcREREz4HREv7SByLLkzAVK7UTyZey5UHHvOdFWwv4brdzB5r_-p4zbzGQq-aI9S1vPEhmoBPm2JVTMSaf0"
                ),
                Actor(
                    name = "Sunny Kaushal",
                    imageUrl = "https://m.media-amazon.com/images/M/MV5BMDI4OTEwNGItZjg5Ni00OWZlLTkwZmQtNzg4YTE3YzcxNWQ1XkEyXkFqcGdeQXVyNDAzNDk0MTQ@._V1_FMjpg_UX1000_.jpg"
                ),
                Actor(
                    name = "Sharad Kelkar",
                    imageUrl = "https://indianewengland.com/wp-content/uploads/2021/01/Sharad-Kelkar.jpg"
                )
            )
        ),

        Movie(id = "8",
            category = 0,
            title = "Shehzada",
            date = "17 February 2023",
            genre = "Action, Drama",
            director = "Rohit Dhawan",
            actors = "Kartik Aaryan, Kriti Sanon, Manisha Koirala, Sunny Hinduja, Ankur Rathee, Paresh Rawal",
            plot = "The life of the nonchalant Bantu is turned upside down when he discovers that a dastardly father switched him at birth and that he is actually the heir to a billionaire.",
            profilePoster = "https://m.media-amazon.com/images/M/MV5BMjQzYjE0NGEtZjBkOS00NjUzLWIwOWQtOWYyYjZjNjI1MzQyXkEyXkFqcGdeQXVyMTA1OTk1MjY3._V1_FMjpg_UX1000_.jpg",
            coverPoster = "https://www.hindustantimes.com/ht-img/img/2023/02/17/1600x900/Shehzada_review_1676629034361_1676629046144_1676629046144.jpg",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Kartik Aaryan",
                    imageUrl = "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202211/kartik_aaryan_and_pashmina_roshan_more_than_good_friends_-three_four.jpg?VersionId=BDa3t4ZcLSmRxYgcGxuq35cM3E4wAiE0"
                ),
                Actor(
                    name = "Kirti Sanon",
                    imageUrl = "https://assets.vogue.in/photos/5ed0c523b107db5a4f641181/2:3/w_2560%2Cc_limit/kriti%2520sanon%2520makeup%2520hairstyle%2520best%2520beauty%2520instagrams.jpg"
                ),
                Actor(
                    name = "Manisha Koirala",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQqbQp87Y3uZbm7LDWmOp4FSFfpqrAaFo3PNQqyJrhlobS5lbcOurhu5VJIh6fr5T5JShCinG4VAWeMdWY"
                ),
                Actor(
                    name = "Sunny Hinduja",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST5YO90pQVm5XiEFoI0yY9uRHH0b1DHIIFV7Fn9F_0qXI7zDrc"
                ),
                Actor(
                    name = "Ankur Rathee",
                    imageUrl = "https://static.toiimg.com/photo/msid-90205076/90205076.jpg"
                ),
                Actor(
                    name = "Paresh Rawal",
                    imageUrl = "https://static.toiimg.com/thumb/61470676.cms?width=170&height=240"
                )
            )
        ),
        Movie(id = "9",
            category = 0,
            title = "Avengers: Endgame",
            date = "26 April 2019",
            genre = "Action, Sci-Fi",
            director = "Anthony Russo, Joss Whedon, Joe Russo",
            actors = "Robert Downey Jr., Scarlett Johansson, Chris Evans, Chris Hemsworth, Mark Ruffalo, Jeremy Renner",
            plot = "TAfter Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
            profilePoster = "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg?region=0%2C0%2C540%2C810",
            coverPoster = "https://cdn.mos.cms.futurecdn.net/PBpaPfht3TSS2rSg5ezHE-1200-80.jpg",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Robert Downey Jr.",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQKYAUWeYWBCdny8x_iGHRKSB_dQ68R9QX0d40f2Cc0jWk0GW0IpQWgn2zrOfOP5R9pIrEFjvCl35ENEqc"
                ),
                Actor(
                    name = "Scarlett Johansson",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTizmtErjwXQq8OOuyKYrZWt-u94mc8z1jhBaNi0LzmUWVROxtW_2_ZotVBTuYsLjTXh5bgrVqIgYLEg1A"
                ),
                Actor(
                    name = "Chris Evans",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTshqw8Nus0YWn7xgvHdnwhTcYcSV2JEKf6tzYxoAkZUEk4Dclx6FgBivEnf_zZfxuZi-bFJcCtj2EO3cs"
                ),
                Actor(
                    name = "Chris Hemsworth",
                    imageUrl = "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcSt4qqHEubkpY3Xm0awJMjYEDkr4ScMn1ltHtiOpSuInJq3jbyf5oyz5sA8x-_rugk8f_nj9TpVCRYNr_c"
                ),
                Actor(
                    name = "Mark Ruffalo",
                    imageUrl = "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcSE6HV7vR_ZmFQiEUuZ1SCVNsejm5YuRFoLH-4Sos5pjf87J2XRFytqPjpr-aHI4V1LTs1SmQK4-cjeAZs"
                ),
                Actor(
                    name = "Jeremy Renner",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcRUtzuijhAZeJprCvmlCsu5zSl3licaPrkYZQaloNDQorw1unHMbQHHlikzQBdO5iJn0dIH-b9WhflEEnE"
                )
            )
        )
    )
}

fun getUpComingMovies(): List<Movie> {
    return listOf(
        Movie(id = "1",
            category = 1,
            title = "Jawan",
            date = "7 September 2023",
            genre = "Action, Drama",
            director = "Atlee Kumar",
            actors = "Shah Rukh Khan, Nayanthara, Vijay, Sanya",
            plot = "A man is driven by a personal vendetta to rectify the wrongs in society, while keeping a promise made years ago. He comes up against a monstrous outlaw with no fear, who has caused extreme suffering to many.",
            profilePoster = "https://pbs.twimg.com/media/FqDvt-PaUAAuH4l.jpg:large",
            coverPoster = "https://www.livemint.com/lm-img/img/2023/07/11/1600x900/Jawan_1689069088718_1689069098009.jpg",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Shah Rukh Khan",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcTK7Os2YW_6OfJJGh9rvPUSbNYqUwQXZce6mMIrqMasLen8sg4BDbHwN-UMOAV6Q_lXdvqdhbY-NqCTcGA"
                ),
                Actor(
                    name = "Nayanthara",
                    imageUrl = "https://static.toiimg.com//photo/99355349/99355349.jpg?imgsize=65798"
                ),
                Actor(
                    name = "Vijay",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcSshdG4MNWBpGUBEe9jzqcrg73SsDyj9PReMgDBQVR23j3HZ9b1m7QqZKlyzOvk7aGgIPuPEo-7BZYDxq4"
                ),
                Actor(
                    name = "Sanya",
                    imageUrl = "https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQNL3sPjyQPj4vzlyEatgnblqDjClYMlEB_W4U3PKiJ2Zb7PlKDTCCEE4f_O-d9yRyysAg9iAvMdnn5NlY"
                )
            )
        ),
        Movie(id = "2",
            category = 1,
            title = "OMG 2",
            date = "11 August 2023",
            genre = "Comedy, Drama",
            director = "Amit Rai",
            actors = "Akshay Kumar, Yami Gautam, Pankaj Tripathi",
            plot = "OMG 2, a satirical comedy-drama film, is the story of Kanti Sharan Mudgal, a staunch devotee of Lord Shiva, a simple man, a loving father, and a caring husband. One day his son, Vivek, is blamed for immoral conduct and thrown out of school. Upon confrontation, Kanti realizes that his son has been a victim of misinformation and misguidance. Grief-struck and unable to handle the crisis, Kanti decides to leave the town with his family, until... he has a divine intervention that steers him towards truth. Kanti then decides to take on everyone responsible by dragging them to court to mandate comprehensive education in schools, in a dramatic courtroom drama.",
            profilePoster = "https://feeds.abplive.com/onecms/images/uploaded-images/2023/08/08/c5a737a904986380945b15a74ccab7368e5c5.jpg",
            coverPoster = "https://www.newznew.com/wp-content/uploads/2023/08/OMG-2-Movie-2023.webp",
            rating = "8.3",
            duration = 135,
            actorProfiles = listOf(
                Actor(
                    name = "Akshay Kumar",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSQai2-aeYBez3leR8jJlxvTkpsZ_O9wqRi0RAa2j9o_ioebUjBU2XB3p6NmHh3TkXgBxVZwxrv7kTvbwA"
                ),
                Actor(
                    name = "Yami Gautam",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcREREz4HREv7SByLLkzAVK7UTyZey5UHHvOdFWwv4brdzB5r_-p4zbzGQq-aI9S1vPEhmoBPm2JVTMSaf0"
                ),
                Actor(
                    name = "Pankaj Tripathi",
                    imageUrl = "https://m.media-amazon.com/images/M/MV5BNjdlYjllOGMtYzU1OC00ODZjLWEzOGEtMGViOTYyYjU3YmJiXkEyXkFqcGdeQXVyMTExNDQ2MTI@._V1_.jpg"
                )
            )
        ),
    )
}