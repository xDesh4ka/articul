import java.io.BufferedReader
import java.io.File

class FileReader(val filename: String)
{
    var bufferedReader: BufferedReader =
        File(this.javaClass.getResource("/$filename")
            .toURI())
            .bufferedReader()
    //Разбирает файл examples на массив пар
    val names = bufferedReader
        .readLines()
        .map { it.split(" ", limit=2) }
        .associate { Pair(it.first(), it.last()) }
        .toList()
        .toMutableList()
}