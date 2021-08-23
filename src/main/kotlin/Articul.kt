class Articul(str: String) {
    private val splitedString : MutableList<String> = mutableListOf()

    private var readers : List <FileReader> = listOf(
        FileReader("first.txt"),
        FileReader("second.txt"),
        FileReader("third.txt"),
        FileReader("fourth.txt"),
        FileReader("fifth.txt"),
        FileReader("sixth.txt"),
        FileReader("seventh.txt"),
        FileReader("eighth.txt")
    )

    init {
        str.split(".").forEach{ splitedString.add( it ) }
    }

    fun disassembleString() : String {
//        return first.examples.find{ it.first == splitedString[0]}?.second
        val str = mutableListOf<String>()
        return try {
            for (i in 0 until readers.size) {
                readers[i].names.find{ it.first == splitedString[i]}?.second?.let { str.add(it) }
                //            readers[i].names.find{ it.first == splitedString[i] }
            }
//            for (i in 0 until splitedString.size)
//            {
//                splitedString[i].find { it == readers.names }
//            }

            str.joinToString("\n")
        }
        catch (e : IndexOutOfBoundsException)
        {
            "Данный артикул не существует"
        }
    }

    fun disassembleStringForInterface() : List<String> {
//        return first.examples.find{ it.first == splitedString[0]}?.second
        val str = mutableListOf<String>()
        return try {
            for (i in 0 until readers.size) {
                readers[i].names.find{ it.first == splitedString[i]}?.second?.let { str.add(it) }
                //            readers[i].names.find{ it.first == splitedString[i] }
            }
//            for (i in 0 until splitedString.size)
//            {
//                splitedString[i].find { it == readers.names }
//            }
            return str
        }
        catch (e : IndexOutOfBoundsException)
        {
            return listOf("Данный артикул не существует")
        }
    }
}