package com.example.cinea.main.data.mappers

import com.example.cinea.main.data.local.MediaEntity
import com.example.cinea.main.data.remote.dto.MediaDto
import com.example.cinea.main.domain.model.Media
import com.example.cinea.util.APIConstants


fun Media.toMediaEntity(): MediaEntity {
    return MediaEntity(
        mediaId = mediaId,

        isLiked = isLiked,
        isBookmarked = isBookmarked,

        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        popularity = popularity,
        voteCount = voteCount,
        genreIds = try {
            genreIds.joinToString(",")
        } catch (e: Exception) {
            ""
        },
        adult = adult,
        mediaType = mediaType,
        originCountry = try {
            originCountry.joinToString(",")
        } catch (e: Exception) {
            ""
        },
        originalTitle = originalTitle,
        category = category,

        runTime = runTime,
        tagLine = tagLine,

        videosIds = try {
            videosIds.joinToString(",")
        } catch (e: Exception) {
            ""
        },
        similarMediaIds = try {
            similarMediaIds.joinToString(",")
        } catch (e: Exception) {
            ""
        }
    )
}

fun MediaEntity.toMedia(): Media {
    return Media(
        mediaId = mediaId,

        isLiked = isLiked,
        isBookmarked = isBookmarked,

        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        popularity = popularity,
        voteCount = voteCount,
        genreIds = try {
            genreIds.split(",").map { it }
        } catch (e: Exception) {
            emptyList()
        },
        adult = adult,
        mediaType = mediaType,
        originCountry = try {
            originCountry.split(",").map { it }
        } catch (e: Exception) {
            emptyList()
        },
        originalTitle = originalTitle,
        category = category,

        runTime = runTime,
        tagLine = tagLine,

        videosIds = if (videosIds.isEmpty()) {
            emptyList()
        } else {
            try {
                videosIds.split(",").map { it }
            } catch (e: Exception) {
                emptyList()
            }
        },
        similarMediaIds = if (similarMediaIds.isEmpty()) {
            emptyList()
        } else {
            try {
                similarMediaIds.split(",").map { it.toInt() }
            } catch (e: Exception) {
                emptyList()
            }
        }

    )

}

fun MediaDto.toMediaEntity(
    type: String,
    category: String,
    isLiked: Boolean,
    isBookmarked: Boolean
): MediaEntity{
    return MediaEntity(

        mediaId = id?: 0,

        isLiked = isLiked,
        isBookmarked = isBookmarked,

        backdropPath = backdropPath ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title ?: "",
        originalTitle = originalTitle ?: "",
        voteAverage = voteAverage ?: 0.0,
        popularity = popularity ?: 0.0,
        voteCount = voteCount ?: 0,

        genreIds = try {
            genreIds?.joinToString(",") ?: ""
        } catch (e: Exception) {
            ""
        },

        adult = adult ?: false,
        mediaType = type,
        category = category,
        originCountry = "",

        runTime = 0,
        tagLine = "",

        videosIds = "",
        similarMediaIds = ""
    )
}

fun MediaDto.toMedia(
    category: String,
    isLiked: Boolean,
    isBookmarked: Boolean
): Media {
    return Media(
        mediaId = id?: 0,

        isLiked = isLiked,
        isBookmarked = isBookmarked,

        backdropPath = backdropPath ?: "",
        originalLanguage = originalLanguage ?: "",
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        releaseDate = releaseDate ?: "",
        title = title ?: "",
        originalTitle = originalTitle ?: "",
        voteAverage = voteAverage ?: 0.0,
        popularity = popularity ?: 0.0,
        voteCount = voteCount ?: 0,

        genreIds = if (genreIds?.isEmpty() == true) {
            emptyList()
        } else {
            try {
                genreIds?.map { it.toString() } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        },

        adult = adult ?: false,
        mediaType = APIConstants.MOVIE,
        category = category,
        originCountry = emptyList(),

        runTime = 0,
        tagLine = "",

        videosIds = emptyList(),
        similarMediaIds = emptyList()


    )
}