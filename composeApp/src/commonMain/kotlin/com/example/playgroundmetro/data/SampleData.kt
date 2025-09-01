package com.example.playgroundmetro.data

data class ListItem(
    val id: Int,
    val title: String,
    val description: String
)

val sampleItems = listOf(
    ListItem(1, "アイテム 1", "これは最初のアイテムの説明です。"),
    ListItem(2, "アイテム 2", "これは二番目のアイテムの説明です。"),
    ListItem(3, "アイテム 3", "これは三番目のアイテムの説明です。"),
    ListItem(4, "アイテム 4", "これは四番目のアイテムの説明です。"),
    ListItem(5, "アイテム 5", "これは五番目のアイテムの説明です。"),
    ListItem(6, "アイテム 6", "これは六番目のアイテムの説明です。"),
    ListItem(7, "アイテム 7", "これは七番目のアイテムの説明です。"),
    ListItem(8, "アイテム 8", "これは八番目のアイテムの説明です。"),
)