package com.example.myprojectapp.data.mapper

import com.example.myprojectapp.data.model.news.ArticleDTO
import com.example.myprojectapp.data.model.news.ArticleEntity
import com.example.myprojectapp.data.model.news.SourceDTO
import com.example.myprojectapp.data.model.weather.CurrentDTO
import com.example.myprojectapp.data.model.weather.LocationDTO
import com.example.myprojectapp.data.model.weather.RequestDTO
import com.example.myprojectapp.data.model.weather.WeatherResponseDTO
import com.example.myprojectapp.model.news.Article
import com.example.myprojectapp.model.news.Source
import com.example.myprojectapp.model.weather.Current
import com.example.myprojectapp.model.weather.Location
import com.example.myprojectapp.model.weather.Request
import com.example.myprojectapp.model.weather.WeatherResponse

// News Mapper

fun ArticleDTO.toDomainModel(): Article {
    return Article(
        id = id,
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source?.toDomainModel(),
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}

fun ArticleEntity.toDomainModel(): Article {
    return Article(
        id = id,
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = Source(id = "", name = source),
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}

fun Article.toEntityModel(): ArticleEntity {
    return ArticleEntity(
        id = id,
        author = author,
        content = content,
        description = description,
        publishedAt = publishedAt,
        source = source?.name,
        title = title,
        url = url,
        urlToImage = urlToImage
    )
}

fun SourceDTO.toDomainModel(): Source {
    return Source(
        id = id,
        name = name
    )
}

// Weather Mapper

fun WeatherResponseDTO.toDomainModel(): WeatherResponse {
    return WeatherResponse(
        current = current?.toDomainModel(),
        location = location?.toDomainModel(),
        request = request?.toDomainModel()
    )
}

fun CurrentDTO.toDomainModel(): Current {
    return Current(
        cloudCover,
        feelsLike,
        humidity,
        isDay,
        observationTime,
        precipitation,
        pressure,
        temperature,
        uvIndex,
        visibility,
        weatherCode,
        weatherDescriptions,
        weatherIcons,
        windDegree,
        windDir,
        windSpeed
    )
}

fun LocationDTO.toDomainModel(): Location {
    return Location(
        country, lat, localtime, localtimeEpoch, lon, name, region, timezoneId, utcOffset
    )
}

fun RequestDTO.toDomainModel(): Request {
    return Request(
        language, query, type, unit
    )
}