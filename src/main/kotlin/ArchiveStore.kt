import java.util.Scanner

class ArchiveStore(val archiveList: MutableList<Archive> = mutableListOf()) {

    fun createArchive(scanner: Scanner) {
        var archiveName: String
        while (true) {
            println("Введите название архива: ")
            archiveName = scanner.nextLine()
            if (archiveName.isNotBlank()) {
                break
            } else {
                println("Название архива не может быть пустым")
            }
        }
        archiveList.add(Archive(archiveName))
        println("Архив $archiveName создан!")
    }
}