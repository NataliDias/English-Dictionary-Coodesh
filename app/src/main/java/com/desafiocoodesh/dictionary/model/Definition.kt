package com.desafiocoodesh.dictionary.model

data class Definition(
    val word: String,
    val phonetic: String,
    val phonetics: List<Phonetics>,
    val origin: String,
    val meanings: List<Meaning>
)

data class Phonetics(
    val text: String,
    val audio: String?
)

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<DefinitionDetails>
)

data class DefinitionDetails(
    val definition: String,
    val example: String,
    val synonyms: List<String>,
    val antonyms: List<String>
)